package hello.stori.es.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MaterialResources extends ClientBundle {
	public static final MaterialResources INSTANCE = GWT.create(MaterialResources.class);

	ImageResource thumbnail_flgel_web();
	ImageResource f1();
	ImageResource ic_gwt_logo();
	ImageResource photosphere();
}
