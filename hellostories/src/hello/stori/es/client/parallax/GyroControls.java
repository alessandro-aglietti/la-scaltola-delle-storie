package hello.stori.es.client.parallax;

import thothbot.parallax.core.client.controls.Controls;
import thothbot.parallax.core.shared.core.Object3D;
import thothbot.parallax.core.shared.math.Euler;
import thothbot.parallax.core.shared.math.Mathematics;
import thothbot.parallax.core.shared.math.Quaternion;
import thothbot.parallax.core.shared.math.Vector3;

import com.google.gwt.user.client.ui.Widget;

public class GyroControls extends Controls {

    private Object3D object;
    private Widget widget;

    public GyroControls(Object3D object, Widget widget) {
        super(object, widget);

        this.object = object;
        this.widget = widget;
    }

    private void setObjectQuaternion(Quaternion quaternion, double beta, double alpha, double gamma, double orient) {
        Vector3 zee = new Vector3(0, 0, 1);
        Euler euler = new Euler();
        Quaternion q0 = new Quaternion();

        double x = -Math.sqrt(0.5);
        double y = 0;
        double z = 0;
        double w = Math.sqrt(0.5);
        Quaternion q1 = new Quaternion(x, y, z, w); // - PI/2 around the x-axis

        euler.set(beta, alpha, -gamma, "YXZ"); // 'ZXY' for the device, but 'YXZ' for us

        quaternion.setFromEuler(euler); // orient the device

        quaternion.multiply(q1); // camera looks out the back of the device, not the top

        quaternion.multiply(q0.setFromAxisAngle(zee, -orient)); // adjust for screen orientation
    }

    // call this when gyro do callback
    private void updateQuaternion(double alpha, double beta, double gamma, double orient) {
        alpha = Mathematics.degToRad(alpha); // Z
        beta = Mathematics.degToRad(beta); // X
        gamma = Mathematics.degToRad(gamma); // Y
        orient = Mathematics.degToRad(orient); // O

        setObjectQuaternion(this.object.getQuaternion(), alpha, beta, gamma, orient);
    }
}