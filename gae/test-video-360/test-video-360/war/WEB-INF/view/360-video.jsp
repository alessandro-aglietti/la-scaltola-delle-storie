<?xml version="1.0" encoding="utf-8"?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<script src="/js/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script src="/js/three/three.min.js" type="text/javascript"></script>
	<script src="/js/three/Detector.js" type="text/javascript"></script>
	<script src="/js/three/DeviceOrientationControls.js" type="text/javascript"></script>
	<script src="/js/three/main.js" type="text/javascript"></script>
	
</head>
<body onclick="fullscreen('video')">
	<div id="spheresx"
		style="background-color: blue; width: 50%; position: absolute; height: 100%; left: 0px; top: 0px;"></div>
	<div id="spheredx"
		style="background-color: yellow; width: 50%; position: absolute; height: 100%; right: 0px; top: 0px;"></div>
		
	<div>
		<video id="video" autoplay loop>
			<source src="/videos/wingsuit.mp4" type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"'>
		</video>
	</div>
</body>
</html>