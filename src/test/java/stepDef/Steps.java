package stepDef;

import org.testng.Assert;
import Base.DriverManager;
import Pages.HomePage;
import Pages.SearchPage;
import Utility.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends DriverManager{
	
	HomePage homepage = new HomePage();
	SearchPage searchpage = new SearchPage();

	@Given("User is on the testautomasi homepage")
	public void user_is_on_the_testautomasi_homepage() {
		webDriver.get().get("https://testautomasi.com/Home/");
		Util.sleep(1);
	}

	@When("User clicks on E-learning link")
	public void user_clicks_on_e_learning_link() {
		homepage.clickElearning();
		Util.sleep(1);
	}

	@Then("User is navigated to course page")
	public void user_is_navigated_to_course_page() {
		String title = homepage.verifyPageTitle();
		Assert.assertTrue(title.contains("Software Testing Solution"));
		Util.sleep(2);
	}
	
	@When("User searches a particular course {string}")
	public void user_searches_a_particular_course_jmeter(String course) throws InterruptedException {
	   searchpage.searchCourse(course);
	   Util.sleep(5);;
	}

	@Then("The title of the course should contain {string}")
	public void the_title_of_the_course_should_contain_jmeter(String course) {
		Assert.assertTrue(searchpage.courseTitle().contains(course));
	}
	
	@When("User clicks on viewmore button")
	public void user_clicks_on_viewmore_button() {
	   searchpage.viewmore();
	}
	
	@When("User clicks on Buy Now")
	public void clicks_on_buy_now() {
	   searchpage.buyCourse();
	   Util.sleep(1);;
	}
	
	@Then("User is navigated to checkout page")
	public void user_is_on_checkout_page() {
	    String text = searchpage.verifyCheckout();
	    Assert.assertEquals(text, "Checkout Course");
	    Util.sleep(5);
	}

}