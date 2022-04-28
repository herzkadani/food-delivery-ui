package ch.bbzbl.fooddelivery.views.menu;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Menu")
@Route(value = "menu")
@RouteAlias(value = "")
public class MenuView extends VerticalLayout {

	private static final long serialVersionUID = -1313517017737079999L;
	//Components
	HorizontalLayout header;
	Tabs tabs;
	VerticalLayout menuFrame;
	Button btnCart;
	

    public MenuView() {
    	header = new HorizontalLayout();
    	btnCart = new Button("Zum Warenkorb (3)", new Icon(VaadinIcon.CART));
    	tabs = new Tabs();
    	menuFrame = new VerticalLayout();
    	
        
    }

    @PostConstruct
    private void initUI() throws FileNotFoundException, IOException {
    	btnCart.addThemeVariants(ButtonVariant.LUMO_LARGE);
    	btnCart.addClickListener(event->UI.getCurrent().navigate("cart"));
    	
    	Tab tabAntipasti = new Tab(IViewConstants.ANTIPASTI);
    	tabAntipasti.getStyle().set("font-size", "1em");
    	Tab tabPizza = new Tab(IViewConstants.PIZZA);
    	tabPizza.getStyle().set("font-size", "1em");
    	Tab tabPasta = new Tab(IViewConstants.PASTA);
    	tabPasta.getStyle().set("font-size", "1em");
    	tabs.add(tabAntipasti, tabPizza, tabPasta);
    	tabs.setWidthFull();
    	tabs.addThemeVariants(TabsVariant.LUMO_CENTERED);
    	tabs.getStyle().set("font-size", "1.4em");
    	//add listener
    	tabs.addSelectedChangeListener(event -> loadMenu(event.getSelectedTab().getLabel()));
    	header.setWidthFull();
    	header. setJustifyContentMode(JustifyContentMode.END);
    	header.add(btnCart);
    	add(header, tabs);
    	menuFrame.setWidthFull();
    	menuFrame.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    	add(menuFrame);
    	// very sussy wussy baka code
    	loadMenu(tabs.getSelectedTab().getLabel());
    	
    	 setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }
    
    private void loadMenu(String menuName) {
    	if(menuFrame.getChildren().findAny().isPresent()) menuFrame.removeAll();
    	
    	if (menuName.equals(IViewConstants.ANTIPASTI)) {
    		menuFrame.add(new MenuItemDiv("Bruschetta al Pomodoro", "Geröstete Brote mit Tomaten, Knoblauch, Basilikum und Olivenöl", "6,50"));
    		menuFrame.add(new MenuItemDiv("Bruschetta con Agilo", "Geröstete Brote mit Knoblauch, Käse und Olivenöl", "7,00"));
    		menuFrame.add(new MenuItemDiv("Antipasto Rustico", "Gemischte italienische Vorspeise", "12,50"));
    		menuFrame.add(new MenuItemDiv("Vitello Tonnato", "in einer Gemüsebrühe und Weißwein gekochtes, dünn aufgeschnittenes Kalbfleisch", "14,50"));
    	}else if(menuName.equals(IViewConstants.PIZZA)) {
    		menuFrame.add(new MenuItemDiv("Pizza Margherita", "Tomaten, Mozzarella, Oregano", "15,50"));
    		menuFrame.add(new MenuItemDiv("Pizza Funghi", "Tomaten, Mozzarella, Champignons, Oregano", "16,50"));
    		menuFrame.add(new MenuItemDiv("Pizza Salami", "Tomaten, Mozzarella, Salami, Zwiebeln, Oregano", "18,50"));
    		menuFrame.add(new MenuItemDiv("Pizza Procsciutto", "Tomaten, Mozzarella, Schinken, Oregano", "17,50"));
    		menuFrame.add(new MenuItemDiv("Pizza Tonno", "Tomaten, Mozzarella, Thunfisch, Zwiebeln, Oregano", "18,50"));
    	}else if(menuName.equals(IViewConstants.PASTA)) {
    		menuFrame.add(new MenuItemDiv("Spaghetti Bolognese", "Teigwaren mit Rindshackfleisch", "17,50"));
    		menuFrame.add(new MenuItemDiv("Spaghetti alla napoletana", "Teigwaren mit Tomatensauce und Basilikum", "16,50"));
    		menuFrame.add(new MenuItemDiv("Gnocchi con gorgonzola", "Teigwaren mit Blauschimmelkäse", "18,00"));
    		menuFrame.add(new MenuItemDiv("Gnocchi con funghi", "Teigwaren mit Steinpilzen", "18,50"));
    	}
    	
    	
    	
    }
}
