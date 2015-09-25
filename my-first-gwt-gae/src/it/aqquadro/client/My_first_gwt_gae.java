package it.aqquadro.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import it.aqquadro.client.accelerometer.Acceleration;
import it.aqquadro.client.accelerometer.AccelerationCallback;
import it.aqquadro.client.accelerometer.AccelerationOptions;
import it.aqquadro.client.accelerometer.Accelerometer;
import thothbot.parallax.core.client.AnimatedScene;
import thothbot.parallax.core.client.RenderingPanel;
import thothbot.parallax.core.client.controls.Controls;
import thothbot.parallax.core.client.textures.Texture;
import thothbot.parallax.core.shared.cameras.PerspectiveCamera;
import thothbot.parallax.core.shared.core.Object3D;
import thothbot.parallax.core.shared.geometries.SphereGeometry;
import thothbot.parallax.core.shared.materials.Material.SIDE;
import thothbot.parallax.core.shared.materials.MeshBasicMaterial;
import thothbot.parallax.core.shared.math.Euler;
import thothbot.parallax.core.shared.math.Mathematics;
import thothbot.parallax.core.shared.math.Quaternion;
import thothbot.parallax.core.shared.math.Vector3;
import thothbot.parallax.core.shared.objects.Mesh;
import thothbot.parallax.plugins.effects.OculusRift;
import thothbot.parallax.plugins.effects.Stereo;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class My_first_gwt_gae implements EntryPoint {

	private Accelerometer accelerometer = GWT.create(Accelerometer.class);

	private Stereo stereo;
	private OculusRift oculus;

	protected double gamma;

	protected double beta;

	protected double alpha;

	protected double orient;

	private MyControls controls;

	private DivElement log_div;

	public static native void fullscreen() /*-{
		var doc = $wnd.document;
		var docEl = doc.documentElement;

		var requestFullScreen = docEl.requestFullscreen
				|| docEl.mozRequestFullScreen || docEl.webkitRequestFullScreen
				|| docEl.msRequestFullscreen;
		var cancelFullScreen = doc.exitFullscreen || doc.mozCancelFullScreen
				|| doc.webkitExitFullscreen || doc.msExitFullscreen;

		if (!doc.fullscreenElement && !doc.mozFullScreenElement
				&& !doc.webkitFullscreenElement && !doc.msFullscreenElement) {
			requestFullScreen.call(docEl);
		} else {
			cancelFullScreen.call(doc);
		}
	}-*/;

	private void divLogger(String message) {
		this.log_div = (DivElement) DOM.getElementById("log").cast();

		ParagraphElement p = ((ParagraphElement) DOM.createElement("p").cast());
		p.setInnerHTML(message);

		this.log_div.appendChild(p);
	}

	public void onModuleLoad() {
		GWT.log("My_first_gwt_gae onModuleLoad");
		divLogger("My_first_gwt_gae onModuleLoad");

		AccelerationOptions options = new AccelerationOptions();
		options.setFrequency(50);
		
		divLogger("Trying to watch acceleremoter...");
		accelerometer.watchAcceleration(options, new AccelerationCallback() {

			@Override
			public void onSuccess(Acceleration acceleration) {
				// X - Axis
				// gamma is the left-to-right tilt in degrees, where right is
				// positive
				My_first_gwt_gae.this.gamma = acceleration.getGamma();
				// GWT.log("X: " + My_first_gwt_gae.this.gamma);
				// Y - Axis
				// beta is the front-to-back tilt in degrees, where front is
				// positive
				My_first_gwt_gae.this.beta = acceleration.getBeta();
				// GWT.log("Y: " + My_first_gwt_gae.this.beta);
				// Z - Axis
				// alpha is the compass direction the device is facing in
				// degrees
				My_first_gwt_gae.this.alpha = acceleration.getAlpha();
				// GWT.log("Z: " + My_first_gwt_gae.this.alpha);

				My_first_gwt_gae.this.orient = acceleration.getOrient();
				;
				// time
				acceleration.getTimeStamp();

				// My_first_gwt_gae.this.controls.update();

			}

			@Override
			public void onFailure() {
				divLogger("Acceleremoter onFailure");
			}
		});

		divLogger("Trying to add body click handler to go fullscreen");
		ClickHandler clickHandler = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("onClick onModuleLoad");
				divLogger("onclick handled, trying to go fullscreen");
				// Window.alert("TextBox/Button clickHandler.");
				event.stopPropagation(); // The important line - We stop the
											// event
											// propagation here so that the
											// FocusPanel
											// doesn't get the event
				fullscreen();
				
				divLogger("Trying to render webgl canvas...");

				RenderingPanel renderingPanel = new RenderingPanel();
				renderingPanel.setBackground(0x111111);
				renderingPanel.setAnimatedScene(new MyScene());

				RootLayoutPanel.get().add(renderingPanel);

			}
		};

		RootLayoutPanel.get().addDomHandler(clickHandler, ClickEvent.getType());

	}

	class MyScene extends AnimatedScene {

		PerspectiveCamera camera;
		private Mesh mesh;

		@Override
		protected void onStart() {
			GWT.log("onStart");

			// camera = new PerspectiveCamera(
			// 70, // field of view
			// getRenderer().getAbsoluteAspectRation(), // aspect ratio
			// 1, // near
			// 1000 // far
			// );

			// BoxGeometry geometry = new BoxGeometry( 200, 200, 200 );
			//
			MeshBasicMaterial material = new MeshBasicMaterial();
			// material.setColor(new Color(0xFF0000));
			// material.setWireframe(true);
			//
			// this.mesh = new Mesh(geometry, material);
			// getScene().add(mesh);

			// Loads default camera for the Animation
			camera = new PerspectiveCamera(45, // field of view
					getRenderer().getAbsoluteAspectRation(), // aspect ratio
					1, // near
					1000 // far
			);
			//
			// camera.getPosition().setZ(400);
			//

			SphereGeometry geometry = new SphereGeometry(220, 20, 20);

			// MeshBasicMaterial material = new MeshBasicMaterial();
			Texture map = new Texture("/photosphere.jpg");
			material.setMap(map);
			material.setSide(SIDE.DOUBLE);

			this.mesh = new Mesh(geometry, material);
			getScene().add(mesh);

			My_first_gwt_gae.this.controls = new MyControls(camera, getCanvas());

			My_first_gwt_gae.this.stereo = new Stereo(getRenderer(), getScene());

			// My_first_gwt_gae.this.oculus = new OculusRift(getRenderer(),
			// getScene());
		}

		@Override
		protected void onUpdate(double duration) {
			// GWT.log("onUpdate");
			My_first_gwt_gae.this.controls.update();

			// this.mesh.getRotation().addX(0.005);
			// this.mesh.getRotation().addY(0.01);

			getRenderer().render(getScene(), camera);
		}
	}

	class MyControls extends Controls {

		private double beta = 0; // Y
		private double alpha = 1.5; // X
		private double gamma = 1.5; // Z
		private Quaternion q0 = new Quaternion();
		private Euler euler = new Euler();
		private Vector3 zee = new Vector3(0, 0, 1);
		private Quaternion q1 = new Quaternion(-Math.sqrt(0.5), 0, 0, Math.sqrt(0.5));
		private double orient = 0;

		public MyControls(Object3D object, Widget widget) {
			super(object, widget);

		}

		public void update() {
			getObject().getRotation().reorder("YXZ");

			this.beta = Mathematics.degToRad(My_first_gwt_gae.this.beta);
			this.alpha = Mathematics.degToRad(My_first_gwt_gae.this.alpha);
			this.gamma = Mathematics.degToRad(My_first_gwt_gae.this.gamma);
			this.orient = Mathematics.degToRad(My_first_gwt_gae.this.orient);

			this.euler.set(beta, alpha, -gamma, "YXZ");

			Quaternion quaternion = new Quaternion();

			quaternion.setFromEuler(euler);

			quaternion.multiply(this.q1);

			quaternion.multiply(this.q0.setFromAxisAngle(zee, -this.orient));

			this.getObject().setQuaternion(quaternion);
		}

	}
}
