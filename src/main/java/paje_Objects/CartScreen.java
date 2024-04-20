package paje_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartScreen extends Re_Usabale_Components {
	
	public WebDriver driver;
	
	public CartScreen(WebDriver driver)
	{
		super(driver);
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".totalRow>button")
    private WebElement checkoutButton;
	
	By checkoutButton_locator = By.cssSelector(".totalRow>button");
	
	public PlaceOrderScreen checkout_Process()
	{
		waitForElementToClickable(checkoutButton_locator);
		checkoutButton.click();
		return new PlaceOrderScreen(driver);
	}

	
}
