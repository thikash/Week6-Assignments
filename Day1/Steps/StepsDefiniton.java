package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefiniton extends BaseClass {
	/*@Given ("input the username as {string}")
	public void enterUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@Given ("input the password as {string}")
public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	@When ("Click the Login button")
	public void clickonLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@When ("Click the CRMSFA link")
	public void clickCrmSfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@When ("Click the Leads link")
	public void clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}*/
	@When ("Click the CreateLead link")
		public void ClickTheCreateLeadLink() {
			driver.findElement(By.linkText("Create Lead")).click();

		}
		@Then ("CreateLead Page will be displayed")
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
		@Given ("Input the CompanyName as {string}")
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
		@Given ("Input the PhoneNumber as {string}")
		public void InputThePhoneNumber(String phonenumber) {
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phonenumber);

		}
		@When ("Click on Submit button")
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

		// *****************Mehods Edid Lead*******************************
		
		@When ("Click the SearchFindLeads link")
		public void ClickFindleads() {
		driver.	findElement(By.xpath("//a[text()='Find Leads']")).click();
		}
		//@Given("Input the firstName as{string}")
		@Given("Input the firstName as{string}")
		public void firstName(String firstName) {
			driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(firstName);
		}
		
		@When ("Click the FindLeads link")
		public void clickonSubmit() {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		}
		@When("click on firstLeads link")
		public void clikfirstLeads() throws InterruptedException {
			driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a").click();
			Thread.sleep(3000);
		}
		
		
		@Then ("ViewLead Page should be displayed")
		public void viewLeadPage() {
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equals("View Lead | opentaps CRM")) {
				System.out.println("Same page");
			}
			else {
				System.out.println("Error Not found");
			}
		}
			@When ("click on EditLead link")
			public void clickEditLead() {
				driver.findElementByXPath("//div[@class='frameSectionExtra']/a[3]").click();
			}
			
			@Given ("update companyName {string}")
			public void updateCompanyName(String updateCompanyName) {
				WebElement ch = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']");
				ch.clear();
				ch.sendKeys(updateCompanyName);
				
			}
			
			@Then ("viewLead CompanyName")
			public void ViewLeadCompanyName() {
				String text = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
				System.out.println("company Name:"+text);
			}
	
	


                 //***************Methods DuplicateLeads**********************
@When ("Click on Duplicate link")
public void clickOnDuplicate() {
	driver.findElement(By.linkText("Duplicate Lead")).click();
}



                

                 //*********************Methods MergeLeads***********************************
@When ("Click On Merge Leads link")
public void clickMergeLead() {
	driver.findElement(By.linkText("Merge Leads")).click();
}
@When ("Click the FromLead {string}")
public void clickFromLead(String fNameofFL) throws IOException   {
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fNameofFL);
driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
String mergeleadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
//String replaceAll = leadID.replaceAll("//D", leadID);


FileOutputStream fos = new FileOutputStream("./src/main/resources/MergeLeadID.properties");
Properties prop = new Properties();
prop.setProperty("LeadID", mergeleadID);
prop.store(fos, null);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles.get(0));
}
@When ("Click the ToLead {string}")
public void clickToLead(String fNameofTL) throws InterruptedException {
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fNameofTL);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles2.get(0));
	
}
@When ("Click On the MergeButton")
public void clickMerge() {
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.linkText("Find Leads")).click();
}
@Given ("Capture the  LeadId enter the LeadId")
public void captureTheLeadId() throws IOException {
FileInputStream fis = new FileInputStream("./src/main/resources/MergeLeadID.properties");
Properties prop = new Properties();
prop.load(fis);


driver.findElement(By.xpath("//input[@name='id']")).sendKeys(prop.getProperty("LeadID"));


}





                           //*************DeleteLead Methods********************
@When ("capture Delete LeadID")
public void CapDelteLeadid() throws IOException {
	String deleteLeadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	FileOutputStream fos = new FileOutputStream("./src/main/resources/DeleteLead.properties");
	Properties prop = new Properties();
	prop.setProperty("leadID", deleteLeadID);
	prop.store(fos, null);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
}
@When ("Click on Delete Lead button")
public void clickDeleteButton() {
driver.findElement(By.linkText("Delete")).click();
}
@Given ("Search The Delete LeadId")
public void srchDeleteLeadId() throws IOException {
	FileInputStream fis = new FileInputStream("./src/main/resources/DeleteLead.properties");
	Properties prop = new Properties();
	prop.load(fis);
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(prop.getProperty("leadID"));
}
	@Then ("No records to display get message")
public void noRecordsTodisplay() {
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}
}