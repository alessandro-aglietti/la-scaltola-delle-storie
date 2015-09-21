package hello.stori.es.client.mvp;

import hello.stori.es.client.ClientFactory;
import hello.stori.es.client.activity.StoryActivity;
import hello.stori.es.client.activity.WelcomeActivity;
import hello.stori.es.client.place.StoryPlace;
import hello.stori.es.client.place.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

    private ClientFactory clientFactory;

    /**
     * AppActivityMapper associates each Place with its corresponding {@link Activity}
     * 
     * @param clientFactory
     *            Factory to be passed to activities
     */
    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    /**
     * Map each Place to its corresponding Activity. This would be a great use
     * for GIN.
     */
    @Override
    public Activity getActivity(Place place) {
        // This is begging for GIN
        if (place instanceof WelcomePlace)
            return new WelcomeActivity((WelcomePlace) place, clientFactory);
        else if (place instanceof StoryPlace)
            return new StoryActivity((StoryPlace) place, clientFactory);

        return null;
    }

}
