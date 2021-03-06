package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

	
	HomePage homepage;
	UserRegistrationPage registrationPage;
	
	@Test (priority = 1 , alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		homepage = new HomePage(driver);
		homepage.OpenRegister();
		registrationPage = new UserRegistrationPage(driver);
		registrationPage.userRegistration("mohamed", "emad", "medo2121@gmail.com", "123456");
		Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test (dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void UserLogOut()
	{
		registrationPage.userLogout();
	}
	
	@Test (dependsOnMethods = {"UserLogOut"})
	public void UserCanLoginSuccessfully()
	{
		homepage.OpenLogin();
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.UserLogin("medo2121@gmail.com", "123456");
		Assert.assertTrue(registrationPage.logoutLink.getText().contains("Log out"));
	}
	
}
