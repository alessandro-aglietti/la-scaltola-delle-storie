package hello.stori.es.client.ui;

import hello.stori.es.client.parallax.MyScene;
import thothbot.parallax.core.client.RenderingPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class StoryViewImpl extends Composite implements StoryView {
    private static StoryViewImplUiBinder uiBinder = GWT.create(StoryViewImplUiBinder.class);

    interface StoryViewImplUiBinder extends UiBinder<Widget, StoryViewImpl> {}

    @UiField
    SimpleLayoutPanel sphereSX;

    @UiField
    SimpleLayoutPanel sphereDX;

    @UiField
    HTMLPanel sParent;

    private Presenter listener;

    public StoryViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onLoad() {
        // TODO Auto-generated method stub

        RenderingPanel renderingPanelSX = new RenderingPanel();
        renderingPanelSX.setBackground(0x111111);
        renderingPanelSX.setAnimatedScene(new MyScene());

        RenderingPanel renderingPanelDX = new RenderingPanel();
        renderingPanelDX.setBackground(0x111111);
        renderingPanelDX.setAnimatedScene(new MyScene());

        sParent.getParent().getParent().setHeight("100%");

        sphereSX.setWidget(renderingPanelSX);

        sphereDX.setWidget(renderingPanelDX);

    }

    @Override
    public void setName(String name) {
        GWT.log("setName di StoryViewImpl: " + name);
    }

    @Override
    public void setPresenter(Presenter listener) {
        this.listener = listener;
    }
}