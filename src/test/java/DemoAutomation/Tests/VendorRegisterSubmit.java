package DemoAutomation.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DemoAutomation.PageObjects.userRegistrationForm;
import DemoAutomation.TestComponents.BaseTest;
import Utils.ExcelUtils;

public class VendorRegisterSubmit extends BaseTest {

	userRegistrationForm cf;

	@Test(dataProvider = "getVendorRegistrationData")
	public void vendorRegister(String radio, String company, String vat, String brand, String email, String password,
			String country, String note) throws IOException {
		// initialize driver and browser
		cf = launchApplication();
		cf.submitFormVendor(radio, company, vat, brand, email, password, country, note);
//		String confirmMessage = cf.getMessage(cf.getSuccess());
//		Assert.assertEquals(confirmMessage, "User successfully registered.");
	}

	@DataProvider
	public Object[][] getVendorRegistrationData() throws IOException {
		String filePath = "I:\\Excel-Automation-main\\Excel-Automation-main\\TestData\\RegistrationData.xlsx";
		return ExcelUtils.getTestData(filePath, "VendorData");

	}

}