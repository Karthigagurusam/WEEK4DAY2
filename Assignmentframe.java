package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignmentframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// We have to call WDM for the browser driver !!
		WebDriverManager.chromedriver().setup(); // verify the version, download, set up !

		// Launch the browser (chrome)
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get(" https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//iframe[@id='iframeResult']
		WebElement room=driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		
		//move to frame(room)
		driver.switchTo().frame(room);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//move to alert box and click ok 
		driver.switchTo().alert().accept();
		String text=driver.findElement(By.id("demo")).getText();
		System.out.println(text);
	
		
	}

}
