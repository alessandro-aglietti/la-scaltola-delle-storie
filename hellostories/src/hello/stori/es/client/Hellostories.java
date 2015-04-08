package hello.stori.es.client;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialToast;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hellostories implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while " + "attempting to contact the server. Please check your network " + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

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
        final MaterialButton toastButton = new MaterialButton("Send", "blue", "light");
        RootPanel.get().add(toastButton);

        toastButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                // TODO Auto-generated method stub
                MaterialToast.alert("I Love Material Design");
            }
        });

    }
}