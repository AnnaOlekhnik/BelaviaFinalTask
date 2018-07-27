package by.htp.belavia.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

	private static final String BASE_URL = "https://belavia.by";

	@FindBy(xpath = "//label[@for='OriginLocation_Combobox']")
	private WebElement depatureField;

	@FindBy(xpath = "//label[@for='DestinationLocation_Combobox']")
	private WebElement destinationField;

	@FindBy(xpath = "//*[@class='button btn-large btn btn-b2-green ui-corner-all']")
	private WebElement searchButton;

	@FindBy(xpath = "//i[@class='icon-calendar']")
	private WebElement dateField;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private WebElement depatureDate;

	@FindBy(xpath = "//label[@for='JourneySpan_Ow']")
	private WebElement oneWayTicket;

	@FindBy(xpath = "//label[@for='JourneySpan_Rt']")
	private WebElement returnTicket;

	@FindAll(@FindBy(xpath = "//*[@class='ui-datepicker-group ui-datepicker-group-last']/descendant::*[contains(@class,'ui-state-default')]"))
	private List<WebElement> availableDepatureDates;

	// @FindAll(@FindBy(xpath = "//*[@class='flight
	// inbound']/descendant::*[contains(@class,'day-with-availability')]"))
	// private List<WebElement> availableArrivalDates;

	private Actions actions = new Actions(driver);

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void setDeparture(String depature) {

		actions.moveToElement(depatureField);
		actions.click();
		actions.sendKeys(depature);
		actions.build().perform();
	}

	public void setDestination(String destination) {

		actions.moveToElement(destinationField);
		actions.click();
		actions.sendKeys(destination);
		actions.build().perform();
	}

	public void clickSearch() {

	 searchButton.click();

	}

	public void setOneWayTicketType() {

		oneWayTicket.click();
	}

	public void setReturnTicketType() {
		returnTicket.click();
	}

	public void selectAvailableDepatureDate() {

		dateField.click();

		WebElement dateWidget = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
		dateWidget.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> columns = dateWidget.findElements(By.tagName("a"));

		for (WebElement cell: columns) {
			if(cell.getText().equals("1")) {
				cell.findElement(By.linkText("1")).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				break;
			}
		}
		
		
		// actions.moveToElement(depatureDate);
		// actions.click();
		// actions.build().perform();

	}

}
