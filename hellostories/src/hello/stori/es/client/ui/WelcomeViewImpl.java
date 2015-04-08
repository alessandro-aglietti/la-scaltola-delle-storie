package hello.stori.es.client.ui;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialToast;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class WelcomeViewImpl extends Composite implements WelcomeView {
    private static WelcomeViewImplUiBinder uiBinder = GWT.create(WelcomeViewImplUiBinder.class);

    interface WelcomeViewImplUiBinder extends UiBinder<Widget, WelcomeViewImpl> {}

    @UiField
    SpanElement nameSpan;
    @UiField
    Anchor goodbyeLink;

    @UiField
    MaterialButton toastButton;

    private Presenter listener;
    private String name;

    public WelcomeViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setName(String name) {
        this.name = name;
        nameSpan.setInnerText(name);
    }

    @UiHandler("toastButton")
    void onClickToast(ClickEvent e) {
        MaterialToast.alert("I Love Material Design");
    }

    @UiHandler("goodbyeLink")
    void onClickGoodbye(ClickEvent e) {
        // listener.goTo(new GoodbyePlace(name));
    }

    @Override
    public void setPresenter(Presenter listener) {
        this.listener = listener;
    }
}