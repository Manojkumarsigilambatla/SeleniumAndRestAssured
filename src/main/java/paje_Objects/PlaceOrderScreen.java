package paje_Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderScreen extends Re_Usabale_Components{
	
	public WebDriver driver;

	public PlaceOrderScreen(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	private WebElement enterCountry;
	
	
	@FindBy(css = ".btnn")
	private WebElement place_Order_Button;
	
	public OrderConfirmationScreen place_the_order()
	{
		move_To_Element_And_Click_ON_Element(place_Order_Button);
		
		return new OrderConfirmationScreen(driver);
	}
	
	
	@FindBy(css = "span.ng-star-inserted")
	private List<WebElement> list_of_countires;
	
	public void enter_country_select_It(String country)
	{
		enterCountry.sendKeys(country);
		
		list_of_countires.stream().filter(element -> element.getText().equals("India")).findFirst().get().click();
		
	}

}
