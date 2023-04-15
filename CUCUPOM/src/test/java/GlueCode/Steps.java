package GlueCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Homepage;
import Pages.Jobspage;
import Pages.Loginpage;
import Pages.Skillspage;
import io.cucumber.java.en.*;

public class Steps {

	WebDriver driver;
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();  //id123
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().window().maximize() ;
	}
	
	
	@When("User opens URL {string}")
	public void user_opens_url(String TestURL) {
	   
		driver.get(TestURL);
	}
	
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		
		Loginpage L1=new Loginpage();
		L1.passdriver(driver);
	   L1.Login(username, password);
	}
	
	
	@Then("Go to Skill Page")
	public void go_to_skill_page() {
		
		Skillspage S1=new Skillspage();
		S1.passdriver(driver);
		S1.navigateskills();
	  
	}
	
	
	@When("Add skills with skillname as {string} and skilldescription as {string}")
	public void add_skills_with_skillname_as_and_skilldescription_as(String skillname, String skilldesc) throws InterruptedException 
	{
	   Skillspage S2=new Skillspage();
	   S2.passdriver(driver);
	   S2.addskills(skillname, skilldesc);
	}
	
	
	@Then("Enter jobs record with jobtitle as {string} , job decs as {string} and job note as {string}")
	public void enter_jobs_record_with_jobtitle_as_job_decs_as_and_job_note_as(String jobtitle, String jobdesc, String jobnote) throws InterruptedException
	{
		Jobspage J1=new Jobspage();
		J1.passdriver(driver);
		J1.addjobs(jobtitle, jobdesc, jobnote);
		
	}
	
	@When("Click on logout button")
	public void click_on_logout_button() {
	   
		Homepage H1=new Homepage();
		H1.passdriver(driver);
		H1.logout();
	}
	
	
	@Then("Close Browser")
	public void close_browser() {
	   
		driver.close();
	}
}
