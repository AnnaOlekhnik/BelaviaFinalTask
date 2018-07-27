package by.htp.belavia.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;

import by.htp.belavia.entity.Flight;
import by.htp.belavia.pages.BookingPage;
import by.htp.belavia.pages.MainPage;

public class Steps {

	private WebDriver driver;
	private MainPage mainPage;
	private BookingPage bookingPage;
	private Flight flight;

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

	public Flight searchFlight() {

		mainPage = new MainPage(driver);
		mainPage.selectAvailableDepatureDate();
		mainPage.clickSearch();

		BookingPage bookingPage = new BookingPage(driver);
		Flight flight = bookingPage.viewFlightInfo();

		return flight;
	}
}
