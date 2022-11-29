package org.demo;

import org.base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pojo.LoginPojo;
import org.testng.annotations.Test;
public class LoginTestCases extends BaseClass {
	@BeforeClass
	private void beforeClass() {
	System.out.println("Starting the execution");	

	}	
	@BeforeMethod
	@Parameters({"url"})
	private void beforeMethod(String url) {
	headlessChrome(url, false);	
	maximise();
	}
@Test (groups = "Smoke")
@Parameters({"url", "UserName", "PassWord"})
public void ValidCredentials(String url, String user ,String pass) throws IOException {
	headlessChrome(url, true);	
	LoginPojo l=new LoginPojo();
	sendKeys(l.getEmail(),user);
sendKeys(l.getPassword(), pass);
click(l.getSubmit());
org.testng.Assert.assertTrue(true, "Validation fail");
quit();
}
@Test (groups = "Sanity")
@Parameters({"url", "ValidUserName", "InValidPassWord"})
public void validUsernameInvalidPassword(String url, String user ,String pass) throws IOException {
	headlessChrome(url, false);	
	LoginPojo l=new LoginPojo();
	sendKeys(l.getEmail(),user);
sendKeys(l.getPassword(), pass);
click(l.getSubmit());
getText(l.getError());
org.testng.Assert.assertTrue(true, "Validation fail");
quit();
}
@Test (groups = "Regression")
@Parameters({"InValidUserName1", "ValidPassWord1"})
public void inValidUsernameValidPassword(String user ,String pass) throws IOException {
	
	LoginPojo l=new LoginPojo();
	sendKeys(l.getEmail(),user);
sendKeys(l.getPassword(), pass);
click(l.getSubmit());
getText(l.getError());
org.testng.Assert.assertTrue(true, "Validation fail");

}
@Test (groups = "Regression")
@Parameters({"InValidUserName2", "InValidPassWord2"})
public void inValidUsernameInvalidPassword(String user ,String pass) throws IOException {

	LoginPojo l=new LoginPojo();
	sendKeys(l.getEmail(),user);
sendKeys(l.getPassword(), pass);
click(l.getSubmit());
getText(l.getError());
org.testng.Assert.assertTrue(true, "Validation fail");
}@AfterMethod
private void afterMethod() {
	quit();

}
@AfterClass
private void afterClass() {
	System.out.println("Sucessfully completed the execution");

}	
}
