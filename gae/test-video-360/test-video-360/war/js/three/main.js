var fullscreen = function(videoID) {
	createRenderer("spheresx", videoID);
	createRenderer("spheredx", videoID);
	SC_WIDGET.play();
}

var createRenderer = function(divID, videoID) {
	
	var video = document.getElementById( videoID );

	var texture = new THREE.VideoTexture( video );
	
	var webglEl = document.getElementById(divID);

	var width = webglEl.offsetHeight, height = webglEl.offsetWidth;

	var scene = new THREE.Scene();

	var camera = new THREE.PerspectiveCamera(45, width / height, 1, 1000);
	camera.position.x = 0.1;

	var renderer = Detector.webgl ? new THREE.WebGLRenderer()
			: new THREE.CanvasRenderer();
	renderer.setSize(width, height);

	var sphere = new THREE.Mesh(new THREE.SphereGeometry(100, 20, 20),
			new THREE.MeshBasicMaterial({
				map : texture
			}));
	sphere.scale.x = -1;
	scene.add(sphere);

	var controls = new THREE.DeviceOrientationControls(camera);

	webglEl.appendChild(renderer.domElement);

	render(controls, renderer, scene, camera);

}

function render(controls, renderer, scene, camera) {

	controls.update();
	requestAnimationFrame(function() {
		render(controls, renderer, scene, camera)
	});
	renderer.render(scene, camera);
}