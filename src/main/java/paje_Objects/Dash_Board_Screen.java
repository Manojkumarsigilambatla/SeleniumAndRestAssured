package paje_Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dash_Board_Screen extends Re_Usabale_Components {
	
	public WebDriver driver;
	
	public Dash_Board_Screen(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".toast-message")
	public WebElement addedMessage;
	
	@FindBy(css= ".ng-animating")
	public WebElement loadingScroll;
	
	@FindBy(css = ".card-body")
	private List<WebElement> list_of_prdoucts;
	
	public List<WebElement> getListOfProducts()
	{
		return list_of_prdoucts;
	}
	
	By addtoCartLocator = By.cssSelector(".card-body>button:nth-of-type(2)");

	
	
	public void addToCart(String productName)
	{
		WebElement product = getListOfProducts().stream().filter(name -> name.getText().contains(productName)).findAny().orElse(null);
		
		move_To_Element_And_Click_ON_Element(product.findElement(addtoCartLocator));
		waitForVisibilityOfElement(addedMessage);
		waitForInvisibilityOfELement(loadingScroll);
		//waitForInvisibilityOfELement(addedMessage);
		
		
	}
	
	
	
	
	
}
	
