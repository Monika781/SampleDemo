package org.base;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static WebDriver driver;
		public static void browserLaunch(String URL) {
		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(URL);
		}
		public static void headlessChrome(String URL,boolean headless) {
		if(headless==true) {	 
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
				driver = new ChromeDriver(options);
				driver.get(URL);
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(URL);
		}
		
		}

	

		public static void printURL() {
			System.out.println(driver.getCurrentUrl());
		}

		public static void maximise() {
			driver.manage().window().maximize();
		}

		public static void close() {
			driver.close();
		}

		public static void quit() {
			driver.quit();
		}

		public static void click(WebElement element) {
			element.click();
		}

		public static void sendKeys(WebElement element, String keys) {
			element.sendKeys(keys);
		}

		public static void getText(WebElement element) {
			System.out.println(element.getText());
		}

		public static void getAttributevalue(WebElement element, String attributeName) {
			element.getAttribute(attributeName);
		}

		public static void getAttributeUserInput(WebElement element) {
			System.out.println(element.getAttribute("value"));
		}

		public static void unConditionalWait(int ms) throws InterruptedException {
			Thread.sleep(ms);
		}

		static Actions act;

		public static void moveToElement(WebElement target) {
			act = new Actions(driver);
			act.moveToElement(target);
		}

		public static void dragAndDrop(WebElement source, WebElement target) {
			act = new Actions(driver);
			act.dragAndDrop(source, target);
		}

		public static void actionsClick(WebElement target) {
			act = new Actions(driver);
			act.click(target).perform();
		}

		public static void upArrow() {
			act = new Actions(driver);
			act.keyDown(Keys.UP).perform();
			act.keyUp(Keys.UP).perform();
		}

		public static void downArrow() {
			act = new Actions(driver);
			act.keyDown(Keys.DOWN).perform();
			act.keyUp(Keys.DOWN).perform();
		}

		public static void doubleClick(WebElement target) {
			act = new Actions(driver);
			act.doubleClick(target).perform();
		}

		public static void contextClick(WebElement target) {
			act = new Actions(driver);
			act.contextClick(target).perform();
		}

		static Robot rob;

		public static void enter(WebElement element) throws AWTException {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
		}

		public static void escape() throws AWTException {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_ESCAPE);
			rob.keyRelease(KeyEvent.VK_ESCAPE);
		}

		public static void selectAll(WebElement element) throws AWTException {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_A);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_A);
		}

		public static void cut(WebElement element) throws AWTException {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_X);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_X);
		}

		public static void copy(WebElement element) throws AWTException {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_C);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_C);
		}

		public static void paste(WebElement element) throws AWTException {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
		}

		static TakesScreenshot tsc;

		public static void getScreenshotAs(String fileName) throws IOException {
			tsc = (TakesScreenshot) driver;
			File src = tsc.getScreenshotAs(OutputType.FILE);
			File dst = new File(
					"/home/monika/eclipse-workspace/NewUpdate/src/test/java/excelsheets/Login" + fileName + ".png");
			//fileUtils.copyFile(src, dst);
		}

		// js.executeScript("arguments[0].setAttribute('value','string')",web ref);
		static JavascriptExecutor jse;

		public static void setAttribute_jse(WebElement element, String input) {
			jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('value','" + input + "')", element);
		}

		public static void click_jse(WebElement element) {
			jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", element);
		}

		public static void scrollIntoViewDown(WebElement element) {
			jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true)", element);
		}

		public static void scrollIntoViewUp(WebElement element) {
			jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(false)", element);
		}

		public static void getAttributeUserInput_jse(WebElement element) {
			jse = (JavascriptExecutor) driver;
			jse.executeScript("return arguments[0].getAttribute('value')", element);
		}

		public static void highlightWebelement(WebElement element, String css) {
			jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style','" + css + "')", element);
		}

		static Alert alt;

		public static void switchToAlert() {
			alt = driver.switchTo().alert();
		}

		public static void acceptAlert() {
			alt = driver.switchTo().alert();
			alt.accept();
		}

		public static void dismissAlert() {
			alt = driver.switchTo().alert();
			alt.dismiss();
		}

		public static void sendKeysForAlert(String arg) {
			alt = driver.switchTo().alert();
			alt.sendKeys(arg);
		}

		public static void getTextFromAlert() {
			alt = driver.switchTo().alert();
			System.out.println(alt.getText());
		}

		public static void switchToFrameByIndex(int index) {
			driver.switchTo().frame(index);
		}

		public static void switchToFrameByWebElement(WebElement element) {
			driver.switchTo().frame(element);
		}

		public static void switchToFrameByWebElement(String id_name) {
			driver.switchTo().frame(id_name);
		}
		public static void switchToParentFrame(String id_name) {
			driver.switchTo().parentFrame();
		}

		public static void switchToDOM(String id_name) {
			driver.switchTo().defaultContent();
		}

		public static void switchToWindow(String URL_WindowID_Title) {
			driver.switchTo().window(URL_WindowID_Title);
		}

		public static void switchToWindowById() {
			String handle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			System.out.println(handles);

			for (String windows : handles) {
				if (windows != handle) {
					driver.switchTo().window(windows);
				}
				System.out.println(windows);
			}
		}

		static Select s;

		public static void selectByIndex(WebElement element, int index) {
			s = new Select(element);
			s.selectByIndex(index);
		}

		public static void selectByValue(WebElement element, String value) {
			s = new Select(element);
			s.selectByValue(value);
		}

		public static void selectByVisibletext(WebElement element, String text) {
			s = new Select(element);
			s.selectByValue(text);
		}

		public static void isMultiple(WebElement element) {
			s = new Select(element);
			System.out.println(s.isMultiple());
		}

		public static void getFirstSelectedOption(WebElement element) {
			s = new Select(element);
			System.out.println(s.getFirstSelectedOption());
		}

		public static void getAllSelectedOptions(WebElement element) {
			s = new Select(element);
			System.out.println(s.getAllSelectedOptions());
		}

		public static void getOptions(WebElement element) {
			s = new Select(element);
			System.out.println(s.getOptions());
		}

		public static void deselectByIndex(WebElement element, int index) {
			s = new Select(element);
			s.deselectByIndex(index);
		}

		public static void deselectByValue(WebElement element, String value) {
			s = new Select(element);
			s.deselectByValue(value);
		}

		public static void deselectByVisibleText(WebElement element, String text) {
			s = new Select(element);
			s.deselectByVisibleText(text);
		}

		public static void deselectAll(WebElement element) {
			s = new Select(element);
			s.deselectAll();
		}

		public static void selectEvenOptions(WebElement element) {
			s = new Select(element);
			List<WebElement> allOptions = s.getOptions();
			for (int i = 0; i < allOptions.size(); i++) {
				if (i % 2 != 0) {
					WebElement options = allOptions.get(i);
					s.selectByIndex(i);
					System.out.println(options.getAttribute("value"));
				}
			}
		}

		public static void selectOddOptions(WebElement element) {
			s = new Select(element);
			List<WebElement> allOptions = s.getOptions();
			for (int i = 0; i < allOptions.size(); i++) {
				if (i % 2 == 0) {
					WebElement options = allOptions.get(i);
					s.selectByIndex(i);
					System.out.println(options.getAttribute("value"));
				}
			}
		}

		public static void navigateToURL(String URL) {
			driver.navigate().to(URL);
		}

		public static void navigateForward(String URL) {
			driver.navigate().forward();
		}

		public static void navigateBackward(String URL) {
			driver.navigate().back();
		}

		public static void refreshWebPage() {
			driver.navigate().refresh();
		}

		public static void isDisplayed(WebElement element) {
			boolean check = element.isDisplayed();
			System.out.println("Is the element displayed: " + check);
		}

		public static void isEnabled(WebElement element) {
			boolean check = element.isEnabled();
			System.out.println("Is the element enabled: " + check);
		}

		public static void isSelected(WebElement element) {
			boolean check = element.isSelected();
			System.out.println("Is the element selected: " + check);
		}

		static WebElement table;

		public static void printTable(WebElement table) {
			System.out.println(table.getText());
		}

		public static void iterateTableElements(WebElement table) {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			for (int i = 0; i < rows.size(); i++) {
				WebElement allRows = rows.get(i);

				List<WebElement> tableHead = allRows.findElements(By.tagName("th"));
				for (int j = 0; j < tableHead.size(); j++) {
					WebElement head = tableHead.get(j);
					System.out.println(head.getText());
				}

				List<WebElement> tableData = allRows.findElements(By.tagName("td"));
				for (int k = 0; k < tableData.size(); k++) {
					WebElement data = tableData.get(k);
					System.out.println(data.getText());
				}
			}
		}

		public static void implicitlyWait(int time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}

		static WebDriverWait w;

		public static void webdriverWaitUntilElementLocated(int timeOutInSeconds, String xpathExpression) {
			w = new WebDriverWait(driver, timeOutInSeconds);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
		}

		static FluentWait<WebDriver> f;

		public static void fluentWaitUntilElementLocated(int seconds, int ms, String xpathExpression) {
			f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofSeconds(ms)).ignoring(Exception.class);
			f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
		}

		public static String excelRead(String fileName, String sheetName, int rowIndex, int cellIndex,
				String simpleDateFormat) throws IOException {

			File f = new File(""
					+ "\\home\\monika\\eclipse-workspace\\NewUpdate\\src\\test\\java\\excelsheets\\Login" + fileName + ".xlsx");

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = wbook.getSheet(sheetName);

			Row rows = sheet.getRow(rowIndex);

			org.apache.poi.ss.usermodel.Cell cells = rows.getCell(cellIndex);

			String value;

			int cellType = cells.getCellType();

			if (cellType == 1) {
				value = cells.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cells)) {
				Date dateCellValue = cells.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
				value = sdf.format(dateCellValue);
			} else {
				double numericCellValue = cells.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}
			return value;
		}

		public static void iterateExcelData(String fileName, String sheetName, String simpleDateFormat) throws IOException {

			File f = new File("C:\\Users\\sudhakar_g\\eclipse-workspace\\MavenFramework\\Excel\\" + fileName + ".xlsx");

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = wbook.getSheet(sheetName);

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow rows = sheet.getRow(i);

				for (int j = 0; j < rows.getPhysicalNumberOfCells(); j++) {
					XSSFCell cells = rows.getCell(j);

					String value;

					int cellType = cells.getCellType();

					if (cellType == 1) {
						value = cells.getStringCellValue();
					} else if (DateUtil.isCellDateFormatted(cells)) {
						Date dateCellValue = cells.getDateCellValue();
						SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
						value = sdf.format(dateCellValue);
					} else {
						double numericCellValue = cells.getNumericCellValue();
						long l = (long) numericCellValue;
						value = String.valueOf(l);
					}
					System.out.println(value);
				}
			}
		}

		public static void excelWrite(String fileName, String sheetName, int rowIndex, int cellIndex, String cellData)
				throws IOException {

			File f = new File("C:\\Users\\sudhakar_g\\eclipse-workspace\\MavenFramework\\Excel\\" + fileName + ".xlsx");

			FileOutputStream fos = new FileOutputStream(f);

			XSSFWorkbook wbook = new XSSFWorkbook();

			XSSFSheet sheet = wbook.createSheet(sheetName);

			XSSFRow row = sheet.createRow(rowIndex);

			XSSFCell cell = row.createCell(cellIndex);

			cell.setCellValue(cellData);

			wbook.write(fos);
		}

		public static void createCell(String fileName, String sheetName, int rowIndex, int cellIndex, String cellData)
				throws IOException {

			File f = new File("C:\\Users\\sudhakar_g\\eclipse-workspace\\MavenFramework\\Excel\\" + fileName + ".xlsx");

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = wbook.getSheet(sheetName);

			XSSFRow row = sheet.getRow(rowIndex);

			XSSFCell cell = row.createCell(cellIndex);

			cell.setCellValue(cellData);

			FileOutputStream fos = new FileOutputStream(f);

			wbook.write(fos);
		}

		public static void createRow(String fileName, String sheetName, int rowIndex, int cellIndex, String cellData)
				throws IOException {

			File f = new File("C:\\Users\\sudhakar_g\\eclipse-workspace\\MavenFramework\\Excel\\" + fileName + ".xlsx");

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = wbook.getSheet(sheetName);

			XSSFRow row = sheet.createRow(rowIndex);

			XSSFCell cell = row.createCell(cellIndex);

			cell.setCellValue(cellData);

			FileOutputStream fos = new FileOutputStream(f);

			wbook.write(fos);
		}

		public static void updateCellData(String fileName, String sheetName, int rowIndex, int cellIndex,
				String existingCellData, String newCellData) throws IOException {

			File f = new File("C:\\Users\\sudhakar_g\\eclipse-workspace\\MavenFramework\\Excel\\" + fileName + ".xlsx");

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = wbook.getSheet(sheetName);

			XSSFRow row = sheet.getRow(rowIndex);

			XSSFCell cell = row.getCell(cellIndex);

			if (cell.getStringCellValue() == existingCellData) {
				cell.setCellValue(newCellData);

			}

			FileOutputStream fos = new FileOutputStream(f);

			wbook.write(fos);
		}
}
