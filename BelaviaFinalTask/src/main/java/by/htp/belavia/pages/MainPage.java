package by.htp.belavia.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

	private static final String BASE_URL = "https://belavia.by";

	@FindBy(xpath = "//div[@class='wrapper ui-trigger-input']/a[@class='trigger']")
	private List <WebElement> countriesFields;
	
	@FindBy(xpath = "//ul[@id='ui-id-2']/li/a")
	private List <WebElement> depatureCountries;

	@FindBy(xpath = "//ul[@id='ui-id-3']/li/a")
	private List <WebElement> destinationCountries;

	@FindBy(xpath = "//label[@for='JourneySpan_Ow']")
	private WebElement oneWayTicket;

	@FindBy(xpath = "//label[@for='JourneySpan_Rt']")
	private WebElement returnTicket;

	@FindBy(xpath = "//i[@class='icon-calendar']")
	private WebElement dateField;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private WebElement depatureDate;

	@FindBy(xpath = "//td[@data-month='7']/a[(text()='1')]")
	private WebElement firstOfAugust;

	@FindBy(xpath = "//*[@class='button btn-large btn btn-b2-green ui-corner-all']")
	private WebElement searchButton;

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

		WebElement departureArrow = countriesFields.get(0);
		departureArrow.click();

		for (WebElement element : depatureCountries) {
			if (element.getText().contains(depature)) {
				element.click();
			}
		}
	}

	public void setDestination(String destination) {

		WebElement departureArrow = countriesFields.get(1);
		departureArrow.click();

		for (WebElement element : destinationCountries) {
			if (element.getText().contains(destination)) {
				element.click();
			}
		}
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

	public void setDepatureDate() {
		dateField.click();
		firstOfAugust.click();

	}

	public void setReturnDate() {
		firstOfAugust.click();

	}


}
