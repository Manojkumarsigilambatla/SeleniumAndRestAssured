package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paje_Objects.CartScreen;
import paje_Objects.Dash_Board_Screen;
import paje_Objects.OrderConfirmationScreen;
import paje_Objects.PlaceOrderScreen;
import testConfig.BaseTest;

public class End_To_End extends BaseTest{

	
	@Test(dataProvider = "login_details")
	public void end_To_End(String userEmail,String userPassword,String product)
	{
		Dash_Board_Screen dash_board_screen = login_screen.login_To_Application(userEmail, userPassword);
		
					dash_board_screen.addToCart(product);
		
		CartScreen cartScreen =  dash_board_screen.open_Cart_Screen();
					
		PlaceOrderScreen place_order_screen =	cartScreen.checkout_Process();
		
					place_order_screen.enter_country_select_It("Ind");
			
	    OrderConfirmationScreen orderConfirmationScreen = place_order_screen.place_the_order();
	    
	    
	    			String message =orderConfirmationScreen.get_Confirmation_Message();
	    			
	        Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
	       
	}
	
	
	@DataProvider(name = "login_details")
	public String[][] login_details()
	{
		return new String[][]
				{
					{"spyderman@gmail.com","Webshooter@1","ZARA"},
					{"robert@gmail.com","Robert@123","IPHONE"}
				};
	}
}
