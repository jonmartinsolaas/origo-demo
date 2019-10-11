package no.martinsolaas.origodemo.ui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

@UIScope
@Route(value = AboutView.ROUTE, layout = MainView.class)
@SpringComponent
public class AboutView extends VerticalLayout {

    public static final String ROUTE = "about";

    @PostConstruct
    private void init() {
        add(new Label("About"));
    }

}
