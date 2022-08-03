package week4;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.sl.usermodel.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArchitectCertification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * Assignments 2. Architect Certifications
		==========================
		1. Launch Salesforce application https://login.salesforce.com/
		2. Login with Provided Credentials
		3. Click on Learn More link in Mobile Publisher
		4. Click  On Resources
		5. Select SalesForce Certification Under Learnings
		6. Choose Your Role as Salesforce Architect
		7. Get the Text(Summary) of Salesforce Architect 
		8. Get the List of Salesforce Architect Certifications Available
		9. Click on Application Architect 
		10.Get the List of Certifications available
		 */
		
		
		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		Object Duration;
		//implicit wait
		driver.manage().timeouts().implicitlyWait(((Object) Duration).ofSeconds(30));
		//explicit wait
		WebDriverWait wait = new  WebDriverWait(driver,((Object) Duration).ofSeconds(5));

		//navigate to website url
		driver.get("https://login.salesforce.com/");

		//maximize
		driver.manage().window().maximize();

		//enter salesforce username
		driver.findElement(By.name("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");		//enter password
		driver.findElement(By.id("Login")).click(); 	//clicks login
		//wait for learn more element to be clicked
				WebElement ele = driver.findElement(By.xpath("//button[@title='Learn More']//span[1]"));  		//clicks learn more button of mobile publisher
				wait.until(ExpectedConditions.visibilityOf(ele));
				ele.click();

				//get window handles
				Set<String> windowHandles = driver.getWindowHandles();
				List winList = new ArrayList<String>(windowHandles);
				String secWin = winList.get(1);
				//driver holds sec window 
				driver.switchTo().window(secWin);

				//clicks confirm button
				driver.findElement(By.xpath("//button[text()='Confirm']")).click();
				System.out.println(driver.getTitle());

				//clicks shadow dom resources
				Shadow dom=new Shadow(driver);
				dom.findElementByXPath("//span[text()='Learning']").click();

				//actions class mouse hover to element
				Actions action = new Actions(driver);
				WebElement trailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
				action.moveToElement(trailHead);
				trailHead.click();

				//wait for element to be clickable
				WebElement element = ((Object) dom).findElementByXPath("//a[text()='Salesforce Certification']");
				driver.executeScript("arguments[0].click();", element);					//JavaScript execution for element to be clicked

				//clicks Role as Salesforce Architect
				String text = driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).getText();
				System.out.println("role as : " + text);
				driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
				
				//get text summary of salesforce architect
				WebElement textSummary=driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']"));
				System.out.println(textSummary.getText());

				//get the certifications list of salesforce architect		
				List<WebElement> certifications = driver.findElements(By.xpath("//div[@class = 'credentials-card_title']"));
				System.out.println("Salesforce architect certifications : " + certifications.size());
				for (WebElement webElement : certifications) {
					String text2 = webElement.getText();
					System.out.println(text2);
				} 
				//get the certifications list of Application architect		
				List<WebElement> cert = driver.findElements(By.xpath("//div[@class = 'credentials-card_title']"));
				System.out.println("Application architect certifications : " +cert.size());
				for (WebElement webElement : cert) {
					String text3 = webElement.getText();
					System.out.println(text3);
				}
	}
}
