package paje_Objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Re_Usabale_Components {
	
	
	public WebDriver driver;
	
	
	
	public Re_Usabale_Components(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath ="(//li/child::button)[3]")
	private WebElement cartScreenButton;
	
	@FindBy(css=".toast-message")
	public WebElement addedMessage;
	
	public CartScreen open_Cart_Screen()
	{
		move_To_Element_And_Click_ON_Element(cartScreenButton);
		waitForInvisibilityOfELement(addedMessage);
		return new CartScreen(driver);
	}

	
	public void move_To_Element_And_Click_ON_Element(WebElement button)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(button).click().perform();
	}
	
	public void waitForVisibilityOfElement(WebElement addedMessage)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addedMessage));
	}
	
	public void waitForInvisibilityOfELement(WebElement loadingScroll)
	{
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.invisibilityOf(loadingScroll));
	}
	
	public void waitForElementToClickable(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
