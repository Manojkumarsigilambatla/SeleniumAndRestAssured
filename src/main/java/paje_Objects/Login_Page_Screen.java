package paje_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Screen extends Re_Usabale_Components{
	
	public WebDriver driver;
	
	public Dash_Board_Screen dash_board_Screen;
	
	public Login_Page_Screen(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id ="userEmail")
	private WebElement userEmail;
	
	@FindBy(id="userPassword")
	private WebElement userPassword;
	
	@FindBy(name="login")
	private WebElement submitButton;
	
	
	@FindBy(css=".toast-message")
	public WebElement addedMessage;
	
	public Dash_Board_Screen login_To_Application(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submitButton.click();
		waitForInvisibilityOfELement(addedMessage);
		dash_board_Screen= new Dash_Board_Screen(driver);
		return dash_board_Screen;
	}
}
