package ch.bbzbl.fooddelivery.views.menu;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MenuItemDiv extends VerticalLayout {
	 
	
	private static final long serialVersionUID = -4125231155854741468L;

	public MenuItemDiv(String title, String description, String price) {
		setWidth("90%");
		getStyle().set("border", "4px solid #e8ebef");
		getStyle().set("padding-top", "0");
		getStyle().set("padding-right", "0");
		
		H2 lblTitle = new H2(title);
		lblTitle.getStyle().set("margin", "0");
		lblTitle.getStyle().set("margin-top", "10px");
		
		
		Div addBtnFrame = new Div();
		Button btnAddToCart = new Button("Auswählen", new Icon(VaadinIcon.PLUS));
		btnAddToCart.addThemeVariants(ButtonVariant.LUMO_LARGE);
		btnAddToCart.getStyle().set("margin", "0");
		btnAddToCart.addClickListener(event->UI.getCurrent().navigate("configuration/"+title+";"+price));
	
		addBtnFrame.add(btnAddToCart);
		addBtnFrame.getStyle().set("border", "4px solid #e8ebef");
		addBtnFrame.getStyle().set("border-right", "0");
		addBtnFrame.getStyle().set("border-top", "0");
		
		HorizontalLayout layTop = new HorizontalLayout();
		layTop.add(lblTitle, addBtnFrame);
		layTop.setWidthFull();
		layTop.setJustifyContentMode(JustifyContentMode.BETWEEN);
		
		Paragraph lblDescription = new Paragraph(description);
		
		H2 lblPrice = new H2(price + " CHF");
		lblPrice.getStyle().set("margin", "0");
		lblPrice.getStyle().set("color", "hsl(214, 100%, 48%)");
		add(layTop, lblDescription, lblPrice);
	}

}
