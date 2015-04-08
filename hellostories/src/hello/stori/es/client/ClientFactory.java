package hello.stori.es.client;

import hello.stori.es.client.ui.StoryView;
import hello.stori.es.client.ui.WelcomeView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory
{
	EventBus getEventBus();
	PlaceController getPlaceController();
	WelcomeView getWelcomeView();
	StoryView getStoryView();
}
