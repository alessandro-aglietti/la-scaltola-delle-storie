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

        SphereGeometry geometry = new SphereGeometry(100, 20, 20);

        MeshBasicMaterial material = new MeshBasicMaterial();
        // Texture map = new Texture(MaterialResources.INSTANCE.photosphere().getSafeUri().asString());
        Texture map = new Texture("/photosphere.jpg");

        material.setMap(map);

        this.mesh = new Mesh(geometry, material);

        getScene().add(mesh);
    }

    @Override
    protected void onUpdate(double duration) {
        getRenderer().render(getScene(), camera);
    }
}