package sample.jsp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SampleWebJspApplicationTests {

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.closeBrowser();
	}

	@Test(groups = {"1", "pageLoad"})
	public void startLogin() throws Exception {
		loginPage.goTo();
		Assert.assertEquals(driver.getInstance().getTitle(), "Signin Template for Bootstrap");
		Assert.assertTrue(loginPage.findWebElementInLoginPage(By.id("inputEmail")).isDisplayed());
		Assert.assertTrue(loginPage.findWebElementInLoginPage(By.id("inputPassword")).isDisplayed());
		Assert.assertTrue(loginPage.findWebElementInLoginPage(By.xpath("html/body/div[1]/form/div/label")).isDisplayed());
		Assert.assertTrue(loginPage.findWebElementInLoginPage(By.xpath("html/body/div[1]/form/button")).isDisplayed());
		Assert.assertTrue(loginPage.findWebElementInLoginPage(By.xpath("html/body/center/a/button")).isDisplayed());
	}

	@Test(groups = {"1", "registrationLoad"}, dependsOnMethods = "startLogin")
	public void startRegistration() throws Exception {
		registrationPage.goTo();
		Assert.assertTrue(registrationPage.findWebElementInRegistrationPage(By.id("userName")).isDisplayed());
		Assert.assertTrue(registrationPage.findWebElementInRegistrationPage(By.id("userEmail")).isDisplayed());
		Assert.assertTrue(registrationPage.findWebElementInRegistrationPage(By.id("password")).isDisplayed());
	}

	@Test(groups = {"3", "enterMainPage"}, dependsOnGroups = "1")
	public void enterLogin() throws Exception {
		loginPage.enterMainPage();
		Assert.assertEquals(driver.getInstance().getTitle(), "View All Posts");
		Assert.assertTrue(mainForumPage.findWebElementInMainPage(By.id("new_post")).isDisplayed());
		Assert.assertTrue(mainForumPage.findWebElementInMainPage(By.id("info_id")).isDisplayed());
		Assert.assertTrue(mainForumPage.findWebElementInMainPage(By.id("contact_id")).isDisplayed());
		Assert.assertTrue(mainForumPage.findWebElementInMainPage(By.xpath(".//*[@id='navbar']/ul/a")).isDisplayed());

	}

	@Test(groups = {"3", "checkNewPost"}, dependsOnMethods = "enterLogin")
	public void addNewPostCheck() throws Exception {
		mainForumPage.addNewPost().click();
		Assert.assertTrue(addNewPost.findWebElementInAddNewPostPage(By.id("title")).isDisplayed());
		Assert.assertTrue(addNewPost.findWebElementInAddNewPostPage(By.id("message")).isDisplayed());
		Assert.assertTrue(addNewPost.findWebElementInAddNewPostPage(By.id("url")).isDisplayed());
		Assert.assertTrue(addNewPost.findWebElementInAddNewPostPage(By.id("img")).isDisplayed());
		Assert.assertTrue(addNewPost.findWebElementInAddNewPostPage(By.id("add_post")).isDisplayed());
	}

	@Test(groups = {"5", "addNewPost"}, dependsOnGroups = "3")
	public void addNewPostAdd() throws Exception {
		addNewPost.findWebElementInAddNewPostPage(By.id("title")).sendKeys("New title");
		addNewPost.findWebElementInAddNewPostPage(By.id("message")).sendKeys("This is new message for auto test");
		addNewPost.findWebElementInAddNewPostPage(By.id("url")).sendKeys("http://google.com");
		addNewPost.findWebElementInAddNewPostPage(By.id("img")).sendKeys("http://somesite/imgs/123.jpeg");
		addNewPost.findWebElementInAddNewPostPage(By.id("add_post")).click();
		Assert.assertTrue(mainForumPage.findWebElementInMainPage(By.xpath("html/body/input[1]")).isDisplayed());
	}

	@Test(groups = {"6", "checkInfo"}, dependsOnMethods = "addNewPostAdd")
	public void goToAbout() throws Exception {
		mainForumPage.findWebElementInMainPage(By.xpath(".//*[@id='info_id']/a")).click();
		Assert.assertEquals(driver.getInstance().getTitle(), "This is info page");
		mainForumPage.findWebElementInMainPage(By.xpath("html/body/a")).click();
	}

	@Test(groups = {"6", "checkContacts"}, dependsOnMethods = "goToAbout")
	public void goToContacts() throws Exception {
		mainForumPage.findWebElementInMainPage(By.xpath(".//*[@id='contact_id']/a")).click();
		Assert.assertEquals(driver.getInstance().getTitle(), "Contacts");
		mainForumPage.findWebElementInMainPage(By.xpath("html/body/a")).click();
	}

}
