package by.htp.belavia.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.belavia.entity.Ticket;

public class BookingPage extends AbstractPage{

	
	@FindBy(linkText = "Fare calendar")
	private WebElement fareCalendar;
	
	public BookingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {		
	}

	public List<Ticket> getOneWayTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sortByPrice(List<Ticket> tickets) {
		// TODO Auto-generated method stub
		
	}

	public void printListOfTickets(List<Ticket> tickets) {
		// TODO Auto-generated method stub
		
	}

	public void sortByFlightDate(List<Ticket> tickets) {
		// TODO Auto-generated method stub
		
	}

	public List<Ticket> getReturnTickets() {
		// TODO Auto-generated method stub
		return null;
	}

}
