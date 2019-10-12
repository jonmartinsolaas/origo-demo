package no.martinsolaas.origodemo.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@Route(value = StationsView.ROUTE, layout = MainView.class)
@SpringComponent
public class StationsView extends VerticalLayout {

    public static final String ROUTE = "";

    private final StationCards stationCards;

    public StationsView(@Autowired StationCards stationCards) {
        this.stationCards = stationCards;
    }

    @PostConstruct
    private void init() {
        add(stationCards);
    }
}
