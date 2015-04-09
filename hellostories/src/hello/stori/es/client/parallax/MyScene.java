package hello.stori.es.client.parallax;

import thothbot.parallax.core.client.AnimatedScene;
import thothbot.parallax.core.client.textures.Texture;
import thothbot.parallax.core.shared.cameras.PerspectiveCamera;
import thothbot.parallax.core.shared.geometries.SphereGeometry;
import thothbot.parallax.core.shared.materials.MeshBasicMaterial;
import thothbot.parallax.core.shared.math.Vector3;
import thothbot.parallax.core.shared.objects.Mesh;

public class MyScene extends AnimatedScene {

    private PerspectiveCamera camera;
    private Mesh mesh;
    private GyroControls gyro;

    @Override
    protected void onStart() {
        // Called before the animation starts. The Scene should be defined here.

        camera = new PerspectiveCamera(45, // field of view
                getRenderer().getAbsoluteAspectRation(), // aspect ratio
                1, // near
                1000 // far
        );

        Vector3 position = new Vector3(0, 0, 300);
        camera.setPosition(position);

        // this.controls = new FirstPersonControls(camera, getCanvas());
        // controls.setMovementSpeed(500);
        // controls.setLookSpeed(0.1);

        // BoxGeometry geometry = new BoxGeometry(200, 200, 200);

        SphereGeometry geometry = new SphereGeometry(100, 20, 20);

        MeshBasicMaterial material = new MeshBasicMaterial();
        // material.setColor(new Color(0xFF0000));
        // material.setWireframe(true);
        // Texture map = new Texture(MaterialResources.INSTANCE.photosphere().getSafeUri().asString());
        Texture map = new Texture("/photosphere.jpg");
        // Texture map = new Texture("/wingsuite-trimmed.mp4");

        material.setMap(map);

        this.mesh = new Mesh(geometry, material);

        getScene().add(mesh);

        // Postprocessing composer = new Postprocessing( getRenderer(), getScene() );

        // this.or = new OculusRift(getRenderer(), getScene());

        // composer.addPass(pass);
        
        gyro = new GyroControls(camera, getCanvas());
        

    }

    @Override
    protected void onUpdate(double duration) {
        // Called when the animation should be updated.
        // this.mesh.getRotation().addX(0.005);
        // this.mesh.getRotation().addY(0.01);

        // this.controls.update((Duration.currentTimeMillis() - this.oldTime) * 0.001);

        // this.oldTime = Duration.currentTimeMillis();
        getRenderer().render(getScene(), camera);

    }
}
