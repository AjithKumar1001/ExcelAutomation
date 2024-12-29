package DemoAutomation.PageObjects;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoAutomation.AbstractComponent.AbstractComponents;

public class userRegistrationForm extends AbstractComponents {

	WebDriver driver;

	public userRegistrationForm(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radio_1569481639_Vendor")
	WebElement vendor;

	@FindBy(id = "radio_1569481639_Supplier")
	WebElement supplier;

	@FindBy(css = "[data-id='phone_1569482700']")
	WebElement phone;

	@FindBy(xpath = "//*[@data-id='user_url']")
	WebElement website;

	@FindBy(xpath = "//*[@data-id='input_box_1569481765']")
	WebElement companyData;

	@FindBy(name = "input_box_1569481771")
	WebElement vatNumber;

	@FindBy(css = "[data-value='Canon']")
	WebElement canon;

	@FindBy(css = "[data-value='Nikon']")
	WebElement nikon;

	@FindBy(css = "[data-value='Brothersoft']")
	WebElement brotherSoft;

	@FindBy(css = "[data-value='Sony']")
	WebElement sony;

	@FindBy(css = "[data-id='user_email']")
	WebElement emailData;

	@FindBy(xpath = "//*[@data-id='user_pass']")
	WebElement pass;

	// dropdown
	@FindBy(xpath = "//*[@data-label='Country']")
	WebElement countrySelect;

	@FindBy(id = "check_box_1569483464_Yes")
	WebElement checkbox;

	@FindBy(xpath = "//*[@data-id='textarea_1569483045']")
	WebElement noteBox;

	@FindBy(xpath = "//button[@class='btn button ur-submit-button ']")
	WebElement submit;

	@FindBy(linkText = "File Upload Form")
	WebElement fileuploadPage;

	@FindBy(xpath = "//*[@class='dz-message ']")
	WebElement upload;

	@FindBy(css = ".dz-preview.dz-file-preview.dz-processing.dz-success.dz-complete")
	WebElement fileUploadComplete;

	By message = By.xpath("//*[@class='ur-message user-registration-message']/ul");
	By error = By.xpath("//*[@class='ur-message user-registration-error']/ul");

	public By getSuccess() {
		return message;
	}

	public By getError() {
		return error;
	}

	public String getMessage(By locator) {
		return driver.findElement(locator).getText();
	}

	public void radioButton(String radio) {
		if (radio.equalsIgnoreCase("Vendor")) {
			vendor.click();
		} else {
			supplier.click();
		}
	}

	public String brands(String brand) {
		if (brand.equalsIgnoreCase("Canon")) {
			canon.click();
		} else if (brand.equalsIgnoreCase("Nikon")) {
			nikon.click();
		} else if (brand.equalsIgnoreCase("Brothersoft")) {
			brotherSoft.click();
		} else {
			sony.click();
		}
		return brand;
	}

	public void submitFormVendor(String radio, String company, String vat, String brand, String email, String password,
			String country, String note) {
		radioButton(radio);
		companyData.sendKeys(company);
		vatNumber.sendKeys(vat);
		brands(brand);
		emailData.sendKeys(email);
		pass.sendKeys(password);
		dropDown(countrySelect, country);
		checkbox.click();
		noteBox.sendKeys(note);
		submit.click();
		waitForElementToAppearBy(message);
		
	}

	public void submitFormSupplier(String radio, String phoneNum, String web, String email, String password,
			String country, String note) {
		radioButton(radio);
		phone.sendKeys(phoneNum);
		website.sendKeys(web);
		emailData.sendKeys(email);
		pass.sendKeys(password);
		dropDown(countrySelect, country);
		checkbox.click();
		noteBox.sendKeys(note);
		scroll();
		submit.click();

	}

	public void fileuploadSubmit(String email, String password, String filePath) throws AWTException {
		fileuploadPage.click();
		emailData.sendKeys(email);
		pass.sendKeys(password);
		scroll();
		upload.click();
		filePath(filePath);
		waitForElementToAppear(fileUploadComplete);
		submit.click();
		waitForElementToAppearBy(message);
	}

	public void fileUploadDuplicate(String email, String password, String filePath) throws AWTException {
		fileuploadPage.click();
		emailData.sendKeys(email);
		pass.sendKeys(password);
		scroll();
		upload.click();
		filePath(filePath);
		waitForElementToAppear(fileUploadComplete);
		submit.click();
		waitForElementToAppearBy(error);
	}

	public void goToConditional() {
		driver.get("https://demo.wpeverest.com/user-registration/conditional-registration-form/");
	}

}
