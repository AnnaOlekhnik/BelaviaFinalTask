package by.htp.belavia.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;

import by.htp.belavia.entity.Ticket;
import by.htp.belavia.pages.BookingPage;
import by.htp.belavia.pages.MainPage;

public class Steps {

	private WebDriver driver;
	private MainPage mainPage;
	private BookingPage bookingPage;
	private Ticket ticket;

	public Steps(WebDriver driver) {
		this.driver = driver;
	}

	public void openBelaviaPage() {

		mainPage = new MainPage(driver);
		mainPage.openPage();

	}

	public void setDepatureAndDestination(String departure, String destination) {
		
		mainPage = new MainPage(driver);
		mainPage.setDeparture(departure);
		mainPage.setDestination(destination);
	}

	public void setOneWayOrReturnTicket(String type) {

		mainPage = new MainPage(driver);

		if (type == "One-way") {
			mainPage.setOneWayTicketType();
		} else if (type == "Return") {
			mainPage.setReturnTicketType();
		} else {
			System.out.println("Incorrect type of ticket");
		}
	}

	public void searchFlight() {

		mainPage = new MainPage(driver);
		mainPage.setDepatureDate();
		mainPage.clickSearch();

		bookingPage = new BookingPage(driver);

	}
	
	public void searchReturnFlight() {

		mainPage = new MainPage(driver);
		mainPage.setDepatureDate();
		mainPage.setReturnDate();
		mainPage.clickSearch();

		bookingPage = new BookingPage(driver);

	}
	
	public BookingPage getResultsOfOneWayTicketSearch() {
		
		BookingPage bookingPage = new BookingPage(driver);
		List<Ticket> tickets = bookingPage.getOneWayTickets();
		bookingPage.sortByPrice(tickets);
		bookingPage.printListOfOneWayTickets(tickets);
		
		return bookingPage;
	}

	public BookingPage getResultsOfReturnTicketSearch() {
		
		BookingPage bookingPage = new BookingPage(driver);
		List<Ticket> tickets = bookingPage.getReturnTickets();
		bookingPage.sortByFlightDate(tickets);
		bookingPage.printListOfReturnTickets(tickets);
		
		return bookingPage;
	}

}
