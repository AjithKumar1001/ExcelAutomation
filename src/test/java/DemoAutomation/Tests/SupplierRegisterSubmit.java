package DemoAutomation.Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DemoAutomation.PageObjects.userRegistrationForm;
import DemoAutomation.TestComponents.BaseTest;
import Utils.ExcelUtils;

public class SupplierRegisterSubmit extends BaseTest {

	userRegistrationForm cf;

	@Test(dataProvider = "getSupplierRegistrationData")
	public void supplierRegister(String radio, String phoneNum, String web, String email, String password,
			String country, String note) throws IOException {
		// initialize driver and browser
		cf = launchApplication();
		cf.submitFormSupplier(radio, phoneNum, web, email, password, country, note);
//		String confirmMessage = cf.getMessage();
//		System.out.println(confirmMessage);
	}

	@DataProvider
	public Object[][] getSupplierRegistrationData() throws IOException {

		String filePath = "I:\\Excel-Automation-main\\Excel-Automation-main\\TestData\\RegistrationData.xlsx";
		return ExcelUtils.getTestData(filePath, "SupplierData");

	}

}