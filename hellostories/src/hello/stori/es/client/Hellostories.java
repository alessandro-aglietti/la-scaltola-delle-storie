package hello.stori.es.client;

import hello.stori.es.client.mvp.AppActivityMapper;
import hello.stori.es.client.mvp.AppPlaceHistoryMapper;
import hello.stori.es.client.place.WelcomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hellostories implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    // private static final String SERVER_ERROR = "An error occurred while " + "attempting to contact the server. Please check your network " + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    // private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    private Place defaultPlace = new WelcomePlace("Welcome!");
    private SimplePanel appWidget = new SimplePanel();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        new Timer() {
            @Override
            public void run() {
                start();

            }
        }.schedule(1);

    }

    protected void start() {

        // Create ClientFactory using deferred binding so we can replace with different
        // impls in gwt.xml
        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

         RootPanel.get().add(appWidget);
        // Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();

    }
}