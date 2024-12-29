package DemoAutomation.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DemoAutomation.PageObjects.userRegistrationForm;
import DemoAutomation.TestComponents.BaseTest;
import Utils.ExcelUtils;
import Utils.FileUpload;

public class FileUploadRegisterSubmit extends BaseTest {

	userRegistrationForm cf;
	FileUpload fl;

	@Test(dataProvider = "getFileUploadData")
	public void fileRegister(String email, String password, String filepath) throws IOException, AWTException {
		cf = launchApplication();
		cf.fileuploadSubmit(email, password, filepath);
		String successMessage = cf.getMessage(cf.getSuccess());
		// System.out.println("Success Message for registration" + successMessage);
		Assert.assertEquals(successMessage, "User successfully registere");
	}

	@Test(dependsOnMethods = ("fileRegister"), dataProvider = ("getFileUploadData"))
	public void errorHandling(String email, String password, String filepath) throws IOException, AWTException {
		cf = launchApplication();
		cf.fileUploadDuplicate(email, password, filepath);
		String errorMessage = cf.getMessage(cf.getError());
		// System.out.println("Failure Message for registration" + errorMessage);
		Assert.assertEquals(errorMessage, "Email already exists.");
	}

	@DataProvider
	public Object[][] getFileUploadData() throws IOException {
		String filePath = "I:\\Excel-Automation-main\\Excel-Automation-main\\TestData\\RegistrationData.xlsx";
		return ExcelUtils.getTestData(filePath, "FileData");
	}

}
