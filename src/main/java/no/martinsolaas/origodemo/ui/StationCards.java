package no.martinsolaas.origodemo.ui;

import com.github.appreciated.card.Card;
import com.github.appreciated.card.content.Item;
import com.github.appreciated.css.grid.GridLayoutComponent;
import com.github.appreciated.css.grid.sizes.Flex;
import com.github.appreciated.css.grid.sizes.Length;
import com.github.appreciated.css.grid.sizes.MinMax;
import com.github.appreciated.css.grid.sizes.Repeat;
import com.github.appreciated.layout.FlexibleGridLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import dev.mett.vaadin.tooltip.Tooltips;
import no.martinsolaas.origodemo.domain.Station;
import no.martinsolaas.origodemo.service.StationFacade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringComponent
@UIScope
public class StationCards extends HorizontalLayout {

    private final StationFacade stationFacade;

    public StationCards(@Autowired StationFacade stationFacade) {
        this.stationFacade = stationFacade;
    }

    @PostConstruct
    private void init() {
        FlexibleGridLayout layout = new FlexibleGridLayout()
                .withColumns(Repeat.RepeatMode.AUTO_FILL, new MinMax(new Length("190px"), new Flex(1)))
                .withAutoRows(new Length("120px"))
                .withItems(StationCard.from(stationFacade.getStations()))
                .withPadding(false)
                .withSpacing(false)
                .withAutoFlow(GridLayoutComponent.AutoFlow.ROW_DENSE)
                .withOverflow(GridLayoutComponent.Overflow.AUTO);
        layout.setSizeFull();
        setSizeFull();
        add(layout);
    }

    public static class StationCard extends VerticalLayout {

        public StationCard(String name, String lockCount, String bikeCount) {
            Card card = new Card(
                    new Item(name, "Låser: " + lockCount + " Sykler: " + bikeCount).withWhiteSpaceNoWrap()
            );
            card.setWidth("100%");
            Tooltips.getCurrent().setTooltip(this, name);

            add(card);
        }

        public static StationCard[] from(List<Station> stations) {
            List<StationCard> result = new ArrayList<>();
            for (Station station : stations) {
                result.add(new StationCard(station.getName(),station.getAvailableLocks().toString(), station.getAvailableBikes().toString()));
            }
            return result.toArray(new StationCard[result.size()]);
        }
    }


}



