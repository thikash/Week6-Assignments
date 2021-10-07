package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepsdefinitionLeadftaps  {
	public ChromeDriver driver;
	@Given ("Open the Chrome Browser")
	public void OpentheChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	@Given ("Load the URL {string}")
public void LoadtheURL(String url) {
	driver.get(url);
	
	}
		@Given ("input the username as {string}")
		public void InputTheUserName(String userName) {
			driver.findElement(By.id("username")).sendKeys(userName);
		}
		@Given ("input the password as {string}")
		public void InputThePassword(String password) {
			driver.findElement(By.id("password")).sendKeys(password);
		}
		@When("Click the Login button")
		public void ClickTheLoginButton() {
			driver.findElement(By.className("decorativeSubmit")).click();

		}
		@When("Click the CRMSFA link")
		public void ClickTheCRMSFALink() {
			driver.findElement(By.linkText("CRM/SFA")).click();

		}
		@When ("Click the Leads link")
		public void ClickTheLeadsLInk() {
			driver.findElement(By.linkText("Leads")).click();
		}
		@When ("Click the CreateLead link")
		public void ClickTheCreateLeadLink() {
			driver.findElement(By.linkText("Create Lead")).click();

		}
		@Then ("CreateLead page will be displayed")
		public void CreateLeadPagedisplayed() {
			String page = driver.getTitle();
		System.out.println("CreateLead page is:"+page);
		if(page.equalsIgnoreCase("Create Lead | opentaps CRM")) {
			System.out.println("Create Lead Page is displayed");
		}
		else {
			System.out.println("ERROR!! Page is not found");
		}
		}
		@Given ("Input the companyname as {string}")
		public void InputTheCompanyName(String companyName) {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		}
		@Given ("Input the FirstName as {string}")
		public void InputTheFirstName(String firstName) {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
}
		@Given ("Input the LastName as {string}")
		public void InputTheLastName(String lastName) {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		}
		@Given ("Input the phonenumber as {string}")
		public void InputThePhoneNumber(String phonenumber) {
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phonenumber);

		}
		@When ("Click the CreateLead button")
		public void ClickTheCreateLeadButton() {
			driver.findElement(By.name("submitButton")).click();

		}
		@Then ("ViewLead should be displayed")
		public void ViewLeadShouldBedisplayed() {
			String viewLeadPage = driver.getTitle();
		System.out.println("View Lead Page is:"+viewLeadPage);
		if(viewLeadPage.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("View Lead page is displayed");
		}
		else {
			System.out.println("ERROR!! check the title");
		}
		}

}
