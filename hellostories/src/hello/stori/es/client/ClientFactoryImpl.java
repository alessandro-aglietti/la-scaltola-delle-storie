package hello.stori.es.client;

import hello.stori.es.client.ui.WelcomeView;
import hello.stori.es.client.ui.WelcomeViewImpl;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public class ClientFactoryImpl implements ClientFactory {
    private static final EventBus eventBus = new SimpleEventBus();
    private static final PlaceController placeController = new PlaceController(eventBus);
    private static final WelcomeView welcomeView = new WelcomeViewImpl();

    // private static final GoodbyeView goodbyeView = new GoodbyeViewImpl();

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public WelcomeView getWelcomeView() {
        return welcomeView;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }
}