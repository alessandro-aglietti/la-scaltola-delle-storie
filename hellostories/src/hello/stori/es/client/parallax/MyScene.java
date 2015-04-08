package hello.stori.es.client.parallax;

import thothbot.parallax.core.client.AnimatedScene;
import thothbot.parallax.core.shared.cameras.PerspectiveCamera;
import thothbot.parallax.core.shared.geometries.BoxGeometry;
import thothbot.parallax.core.shared.materials.MeshBasicMaterial;
import thothbot.parallax.core.shared.math.Color;
import thothbot.parallax.core.shared.objects.Mesh;

public class MyScene extends AnimatedScene {

    private PerspectiveCamera camera;
    private Mesh mesh;

    @Override
    protected void onStart() {
        // Called before the animation starts. The Scene should be defined here.

        camera = new PerspectiveCamera(70, // field of view
                getRenderer().getAbsoluteAspectRation(), // aspect ratio
                1, // near
                1000 // far
        );

        BoxGeometry geometry = new BoxGeometry(200, 200, 200);

        MeshBasicMaterial material = new MeshBasicMaterial();
        material.setColor(new Color(0xFF0000)); 
        material.setWireframe(true);

        this.mesh = new Mesh(geometry, material);
        getScene().add(mesh);
    }

    @Override
    protected void onUpdate(double duration) {
        // Called when the animation should be updated.
        this.mesh.getRotation().addX(0.005);
        this.mesh.getRotation().addY(0.01);

        getRenderer().render(getScene(), camera);
    }
}
