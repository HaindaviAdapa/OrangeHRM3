package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Skillspage {

	 WebDriver driver;
	 By Admin=By.xpath("//span[text()='Admin']");
	 By Qualifications=By.xpath("//span[text()='Qualifications ']");
	 By Skills=By.xpath("//a[text()='Skills']");
	 By Addbutton=By.xpath("//button[text()=' Add ']");
	 By skillname=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	 By skilldesc=By.xpath("//textarea[ @placeholder='Type description here']");
	 By savebutton=By.xpath("//button[text()=' Save ']");
	 
	 
	 public void passdriver(WebDriver driver1)
	 {
		 this.driver=driver1;
	 }
	 
	 public void navigateskills()
	 {
		 driver.findElement(Admin).click();
		 driver.findElement(Qualifications).click();
		 driver.findElement(Skills).click();
		 driver.findElement(Addbutton).click();
	 }
	 
	 public void addskills(String Skillname,String Skilldesc) throws InterruptedException
	 {
		 driver.findElement(skillname).sendKeys(Skillname);
			driver.findElement(skilldesc).sendKeys(Skilldesc);
			
			Thread.sleep(5000);
			driver.findElement(savebutton).click();
	 }
}
