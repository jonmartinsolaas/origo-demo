package no.martinsolaas.origodemo.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import javax.annotation.PostConstruct;

@UIScope
@Theme(Lumo.class)
@PWA(name = "Oslo Bysykkel API demo", shortName = "Bysykkel demo")
public class MainLayout extends AppLayout {

    private Tabs navbarTabs;

    @PostConstruct
    public void init() {

        Image img = new Image(new StreamResource("logo-image.png", () ->
            MainLayout.class.getClassLoader().getResourceAsStream("META-INF/resources/icons/icon.png")
            ), "Logo");

        img.setHeight("30px");
        addToNavbar(true, img);

        navbarTabs = new Tabs(
                  new NavTab("Stasjoner", StationsView.class)
                , new NavTab("Om",  AboutView.class)
        );

        navbarTabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        navbarTabs.setSizeFull();

        addToNavbar(true, navbarTabs);
        this.setPrimarySection(Section.NAVBAR);

    }

    static class NavTab extends Tab implements AfterNavigationObserver {

        public final RouterLink link;

        public NavTab(String text, Class<? extends Component> navigationTarget) {
            link = new RouterLink(null, navigationTarget);
            link.add(text);
            this.add(link);
        }

        @Override
        public void afterNavigation(AfterNavigationEvent event) {
            if (event.getLocation().getFirstSegment().equals(link.getHref()))
                ((Tabs)this.getParent().get()).setSelectedTab(this);
        }

    }
}
