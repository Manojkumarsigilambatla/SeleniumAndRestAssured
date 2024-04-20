package paje_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationScreen extends Re_Usabale_Components {
	
    public WebDriver driver;
	
	public OrderConfirmationScreen(WebDriver driver)
	{
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	private WebElement order_Confirm_Message;
	
	public String get_Confirmation_Message()
	{
		return order_Confirm_Message.getText();
	}

}
