package ch.bbzbl.fooddelivery.views.cart;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;

public class CartItemDiv extends HorizontalLayout {

	private static final long serialVersionUID = 5089689114013196082L;
	
	IntegerField nbrAmount;
	HorizontalLayout layRightWrapper;
	H2 txtTitle;
	H2 txtPrice;
	Paragraph lblDetails;

	public CartItemDiv(String id, int amount, String title, String price, ValueChangeListener<? super ComponentValueChangeEvent<IntegerField, Integer>> listener, boolean counterActive) {
		setId(id);
		setWidth("50%");
		setAlignItems(Alignment.CENTER);
		setId(id);
		nbrAmount = new IntegerField();
		nbrAmount.setHasControls(true);
		nbrAmount.setId(id);
		nbrAmount.getStyle().set("margin-right", "40px");
		if (!counterActive) nbrAmount.setVisible(false);
		txtTitle = new H2(title);
		txtTitle.getStyle().set("margin-top", "10px");
		txtTitle.getStyle().set("margin-right", "40px");
		txtTitle.setWidth("150%");
		if (!counterActive)txtTitle.getStyle().set("margin-left", "185px");
		layRightWrapper = new HorizontalLayout();
		layRightWrapper.setWidthFull();
		layRightWrapper.setJustifyContentMode(JustifyContentMode.END);
		txtPrice = new H2(price);
		txtPrice.getStyle().set("margin-top", "10px");
		txtPrice.getStyle().set("margin-right", "40px");
		txtPrice.getStyle().set("color", "hsl(214, 100%, 48%)");
		layRightWrapper.add(txtPrice);
		
		nbrAmount.setValue(amount);
		nbrAmount.addValueChangeListener(listener);
		
		add(nbrAmount, txtTitle, layRightWrapper);
		
		if(counterActive&&!id.equals("1")) getStyle().set("border-top", "4px solid #e8ebef");
		if(!counterActive) getStyle().set("border-top", "4px solid #c4c5c8");
	}
	
	public void setPrice(String price) {
		txtPrice.setText(price);
	}

	
}

