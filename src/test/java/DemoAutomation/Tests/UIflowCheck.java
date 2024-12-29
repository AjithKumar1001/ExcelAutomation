package DemoAutomation.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIflowCheck {

	public static void main(String[] args) throws FileNotFoundException, AWTException {
		// TODO Auto-generated method stub
		// initialize driver and browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://demo.wpeverest.com/user-registration/conditional-registration-form/");

		// page elements interaction
		driver.findElement(By.id("radio_1569481639_Vendor")).click();
		driver.findElement(By.xpath("//*[@data-id='input_box_1569481765']")).sendKeys("Demo Company");
		driver.findElement(By.name("input_box_1569481771")).sendKeys("78685123");
		driver.findElement(By.cssSelector("[data-value='Canon']")).click();
		driver.findElement(By.cssSelector("[data-id='user_email']")).sendKeys("Winterwein872@gmail.com");
		driver.findElement(By.xpath("//*[@data-id='user_pass']")).sendKeys("N@%$#123509");

		WebElement country = driver.findElement(By.xpath("//*[@data-label='Country']"));
		dropDown(country, "India");
		driver.findElement(By.id("check_box_1569483464_Yes")).click();
		driver.findElement(By.cssSelector("[name='textarea_1569483045']")).sendKeys("Hi there a note");
		driver.findElement(By.cssSelector("[class*='ur-submit-button']")).click();

		// checking
		WebElement submit = driver.findElement(By.xpath("//ul[normalize-space()='User successfully registered.']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(submit));
		System.out.println(submit.getText());

		// File upload after this
		driver.findElement(By.linkText("File Upload Form")).click();
		driver.findElement(By.cssSelector("[data-id='user_email']")).sendKeys("christopernolan976@gmail.com");
		driver.findElement(By.xpath("//*[@data-id='user_pass']")).sendKeys("N@%$#123509");
		// FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
		// "\\TestData\\dummy.pdf");
		WebElement fileUpload = driver.findElement(By.xpath("//*[@class='dz-message ']"));
		UIflowCheck register = new UIflowCheck();
		register.uploadFileusingRobot(fileUpload,
				"C:\\Users\\ajithkumar.r\\Downloads\\Automation\\Excel-Automation-main\\Excel-Automation-main\\TestData\\dummy.pdf");
		driver.findElement(By.cssSelector("[class*='ur-submit-button']")).click();

	}

	public static void dropDown(WebElement ele, String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

	public void uploadFileusingRobot(WebElement file, String filePath) throws AWTException {
		file.click();

		// Copy file path to clipboard
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		// Simulate Ctrl+V and Enter using Robot
		Robot robot = new Robot();
		robot.delay(1000); // Wait for the dialog to appear

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}

//	public static Object[][] userCred()
//	{
//		Object[][] data = new Object[2][2];
//		data[0][0] = "natwein@yahoo.com";
//		data[0][1] = "n@%#^@0912674";
//		
//		data[0][0] = "natchrist@yahoo.com";
//		data[0][1] = "n@%#^@091kiu74";
//		
//		return data;
//	
//	
//	}
