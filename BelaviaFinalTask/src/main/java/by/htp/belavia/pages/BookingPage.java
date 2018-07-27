package by.htp.belavia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.belavia.entity.Flight;

public class BookingPage extends AbstractPage{

	@FindBy(xpath="//*[@id='outbound']/div[1]/div/div[1]/h3")
	private WebElement depatureDay;
	
	
	public BookingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		
	}
	
	public Flight viewFlightInfo() {
		
		Flight flight = new Flight();
//		flight.setDate(depatureDay.getText());
		
		return flight;
		
	}

}
