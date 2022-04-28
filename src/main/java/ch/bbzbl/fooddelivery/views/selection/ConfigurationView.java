package ch.bbzbl.fooddelivery.views.selection;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.WildcardParameter;

@PageTitle("Configuration")
@Route(value = "configuration")
public class ConfigurationView extends HorizontalLayout implements HasUrlParameter<String> {

	private static final long serialVersionUID = -371247784603243151L;
	
	//Components
	VerticalLayout layLeft;
	VerticalLayout layRight;
	H1 title;
	Image productImage;
	RadioButtonGroup<String> rbDiameter;
	CheckboxGroup<String> chkToppings;
	IntegerField nbrAmount;
	H2 lblPrice;
	HorizontalLayout layButtons;
	Button btnAddToCart;
	Button btnCancel;

	public ConfigurationView() {
		layLeft = new VerticalLayout();
		layRight = new VerticalLayout();
		title = new H1();
		productImage = new Image("images/empty-plant.png", "image placeholder");
		rbDiameter = new RadioButtonGroup<>();
		chkToppings = new CheckboxGroup<>();
		nbrAmount = new IntegerField();
		lblPrice = new H2();
		layButtons = new HorizontalLayout();
		btnAddToCart = new Button("In den Warenkorb", new Icon(VaadinIcon.CART));
		btnCancel = new Button("Abbrechen");
    }

	@PostConstruct
	private void initUI() {
		layLeft.setWidth("50%");
		layLeft.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		layRight.setWidth("50%");
		layRight.setJustifyContentMode(JustifyContentMode.CENTER);
		
		layLeft.add(title);
		layLeft.add(productImage);
		
		rbDiameter.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		rbDiameter.setLabel("Grösse");
		rbDiameter.setItems("Klein", "Gross");
		rbDiameter.setValue("Klein");
		
		chkToppings.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		chkToppings.setLabel("Toppings");
		chkToppings.setItems("Oliven", "Artischocken", "Knoblauch");
		
		nbrAmount.setValue(1);
		nbrAmount.setHasControls(true);
		nbrAmount.setStep(1);
		nbrAmount.setMin(1);
		nbrAmount.setMax(20);
		nbrAmount.setLabel("Anzahl");
		
		lblPrice.getStyle().set("color", "hsl(214, 100%, 48%)");
		
		btnAddToCart.addClickListener(event-> UI.getCurrent().navigate("menu"));
		btnAddToCart.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		btnCancel.addClickListener(event -> UI.getCurrent().navigate("menu"));
		layButtons.add(btnAddToCart, btnCancel);
		
		layRight.getStyle().set("padding-top", "8em");
		layRight.add(rbDiameter, chkToppings, nbrAmount, lblPrice, layButtons);
		
	    add(layLeft, layRight);
		
	}


	public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
		List<String> parameters = Arrays.asList(parameter.split("\\s*;\\s*"));
		title.setText(parameters.get(0));
		lblPrice.setText(parameters.get(1)+ " CHF");
		productImage.setSrc("images/empty-plant.png");
		
	}

	
}
