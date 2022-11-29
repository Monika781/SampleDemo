package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass {
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='username']")
	private WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	@FindBy(xpath = "//div[@class='alert alert-error']")
	private WebElement error;
	public WebElement getError() {
		return error;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}
}
