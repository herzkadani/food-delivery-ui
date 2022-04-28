package ch.bbzbl.fooddelivery.views.cart;

import java.util.ArrayList;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Cart")
@Route(value = "cart")
public class CartView extends VerticalLayout {

	private static final long serialVersionUID = -8783755238038667202L;

	H1 txtTitle;
	VerticalLayout wrapper;
	ArrayList<CartItemDiv> cartItems;
	HorizontalLayout lblButtons;
	Button btnBack;
	Button btnPay;
	
	public CartView() {
        setSpacing(false);
        setSizeFull();
        
        
        txtTitle = new H1("Warenkorb");
        wrapper = new VerticalLayout();
        wrapper.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        cartItems = new ArrayList<>();
       
        
        CartItemDiv cartItem1 = new CartItemDiv("1", 1, "Spaghetti Bolognese", "17,50 CHF", event-> amountChanged(event), true);
        CartItemDiv cartItem2 = new CartItemDiv("2", 1, "Pizza Funghi", "16,50 CHF", event-> amountChanged(event), true);
        CartItemDiv cartItem3 = new CartItemDiv("3", 1, "Vitello Tonnato", "14,50 CHF", event-> amountChanged(event), true);
        CartItemDiv cartItem4 = new CartItemDiv("4", 1, "Total", "48,50 CHF", event-> amountChanged(event), false);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);
        cartItems.add(cartItem4);
        add(txtTitle, wrapper);
        
        
        btnBack = new Button("Abbrechen");
        btnBack.addClickListener(event -> UI.getCurrent().navigate("menu"));
        btnPay = new Button("Bezahlen");
        btnPay.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        lblButtons = new HorizontalLayout();
        lblButtons.setWidth("60%");
        lblButtons.setJustifyContentMode(JustifyContentMode.END);
        lblButtons.add(btnPay, btnBack);
        
        loadProducts();
    }
	
	private void loadProducts() {
		if(wrapper.getChildren().findAny().isPresent()) wrapper.removeAll();
		for(CartItemDiv item : cartItems) {
			wrapper.add(item);
			
		}
		wrapper.add(lblButtons);
	}

	private void amountChanged(ComponentValueChangeEvent<IntegerField, Integer> event) {
		if(event.getValue()<1) {
			CartItemDiv componentToRemove = null;
			for (CartItemDiv item : cartItems) {
				if(item.getId().equals(event.getSource().getId())) {
					componentToRemove = item;
				}
			}
			if(componentToRemove != null) {
				cartItems.remove(componentToRemove);
			}
		}
		loadProducts();
		
	}

}
