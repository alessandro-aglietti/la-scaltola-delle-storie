package hello.stori.es.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class WelcomePlace extends Place {
    private String helloName;

    public WelcomePlace(String token) {
        this.helloName = token;
    }

    public String getHelloName() {
        return helloName;
    }

    public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {

        @Override
        public String getToken(WelcomePlace place) {
            return place.getHelloName();
        }

        @Override
        public WelcomePlace getPlace(String token) {
            return new WelcomePlace(token);
        }

    }
}
