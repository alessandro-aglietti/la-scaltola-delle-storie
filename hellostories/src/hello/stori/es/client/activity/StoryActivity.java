package hello.stori.es.client.activity;

import hello.stori.es.client.ClientFactory;
import hello.stori.es.client.place.StoryPlace;
import hello.stori.es.client.ui.StoryView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class StoryActivity extends AbstractActivity implements StoryView.Presenter {
    // Used to obtain views, eventBus, placeController
    // Alternatively, could be injected via GIN
    private ClientFactory clientFactory;
    // Name that will be appended to "Hello,"
    private String name;

    public StoryActivity(StoryPlace place, ClientFactory clientFactory) {
        this.name = place.getHelloName();
        this.clientFactory = clientFactory;
    }

    /**
     * Invoked by the ActivityManager to start a new Activity
     */
    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        StoryView storyView = clientFactory.getStoryView();
        storyView.setName(name);
        storyView.setPresenter(this);
        containerWidget.setWidget(storyView.asWidget());
    }

    /**
     * Ask user before stopping this activity
     */
    // @Override
    // public String mayStop() {
    // return "Please hold on. This activity is stopping.";
    // }

    /**
     * Navigate to a new Place in the browser
     */
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
