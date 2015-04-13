https://code.google.com/p/mgwt/wiki/SetupProject

#1 blocking
https://code.google.com/p/mgwt/issues/detail?id=321 on hellostories.gwt.xml

#2 block
update versionnnnnn in the pom xml
gwt version from 2.5 to 2.7 NOO
mgwt from 1.1.2 to 2.0.0
gwtphonegap from 2.0.0.0 to 3.5.0.0 (extract jar and patch for gwt.logging.popupHandler)
https://github.com/dankurka/gwtphonegap/pull/47/files
and run
mvn war:exploded
and then delete manually old jars from target folder

#3 setup 
https://github.com/mgwt/mgwt/wiki/SuperDevMode-with-PhoneGap