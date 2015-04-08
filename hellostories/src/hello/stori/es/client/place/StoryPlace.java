package hello.stori.es.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class StoryPlace extends Place {
    private String helloName;

    public StoryPlace(String token) {
        this.helloName = token;
    }

    public String getHelloName() {
        return helloName;
    }

    public static class Tokenizer implements PlaceTokenizer<StoryPlace> {

        @Override
        public String getToken(StoryPlace place) {
            return place.getHelloName();
        }

        @Override
        public StoryPlace getPlace(String token) {
            return new StoryPlace(token);
        }

    }
}
