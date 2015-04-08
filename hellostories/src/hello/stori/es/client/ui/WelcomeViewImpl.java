package hello.stori.es.client.ui;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialToast;
import hello.stori.es.client.place.StoryPlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class WelcomeViewImpl extends Composite implements WelcomeView {
    private static WelcomeViewImplUiBinder uiBinder = GWT.create(WelcomeViewImplUiBinder.class);

    interface WelcomeViewImplUiBinder extends UiBinder<Widget, WelcomeViewImpl> {}

    @UiField
    MaterialButton newStory;

    @UiField
    MaterialButton startTutaAlare;

    @UiField
    MaterialButton startF1;

    private Presenter listener;
    private String name;

    public WelcomeViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setName(String name) {
        this.name = name;
        GWT.log("setName di WelcomeViewImpl: " + name);
    }

    @UiHandler("newStory")
    void onClickNewStory(ClickEvent e) {
        MaterialToast.alert("Work in progress");
    }

    @UiHandler("startTutaAlare")
    void onClickStartTutaAlare(ClickEvent e) {
        listener.goTo(new StoryPlace(name));
    }
    
    @UiHandler("startF1")
    void onClickStartF1(ClickEvent e) {
        MaterialToast.alert("Work in progress");
    }

    // @UiHandler("goodbyeLink")
    // void onClickGoodbye(ClickEvent e) {
    // listener.goTo(new GoodbyePlace(name));
    // }

    @Override
    public void setPresenter(Presenter listener) {
        this.listener = listener;
    }
}