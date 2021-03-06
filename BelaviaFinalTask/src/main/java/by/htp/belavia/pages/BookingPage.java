package by.htp.belavia.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.belavia.entity.Ticket;

public class BookingPage extends AbstractPage {

	@FindBy(linkText = "Fare calendar")
	private WebElement fareCalendar;

	@FindBy(xpath = "//div[@class='price']//input")
	private List<WebElement> availableDates;

	@FindBy(xpath = "//div[@class='price']/div")
	List<WebElement> returnTickets;

	@FindBy(xpath = "//*[@class='button btn btn-b2-green btn-large btn-b2-green-fixed ui-corner-all']")
	private WebElement nextButton;

	private WebDriverWait wait = new WebDriverWait(driver, 10);

	public BookingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
	}

	public List<Ticket> getOneWayTickets() {

		wait.until(ExpectedConditions.visibilityOf(fareCalendar));

		fareCalendar.click();
		List<Ticket> tickets = new ArrayList<>();
		Ticket ticket = null;

		do {
			for (WebElement element : availableDates) {

				WebElement price = element.findElement(By.xpath("following-sibling::label"));
				String date = element.getAttribute("value");

				ticket = new Ticket();
				ticket.setDate(date);
				ticket.setPrice(price.getText());
				tickets.add(ticket);
			}

			WebElement next = driver.findElement(By.xpath("//i[@class='icon-right-open']"));
			wait.until(ExpectedConditions.visibilityOf(next));
			next.click();
		} while (checkLastTicket(tickets, ticket));

		return tickets;
	}

	public Boolean checkLastTicket(List<Ticket> tickets, Ticket ticket) {

		Boolean shouldClickNext = false;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
		LocalDate lastDate = LocalDate.of(2018, 11, 1);
		LocalDate localDate;

		if (ticket != null && tickets.size() > 0) {

			Ticket lastTicket = tickets.get(tickets.size() - 1);

			String flightDate = lastTicket.getDate();
			localDate = LocalDate.parse(flightDate, formatter);
			if (localDate.isBefore(lastDate)) {
				shouldClickNext = true;
			}
		}

		return shouldClickNext;
	}

	public void sortByPrice(List<Ticket> tickets) {
		Collections.sort(tickets);
	}

	public void printListOfReturnTickets(List<Ticket> tickets) {

		for (Ticket ticket : tickets) {
			System.out.println(ticket.toString());
		}
	}

	public void printListOfOneWayTickets(List<Ticket> tickets) {

		for (Ticket ticket : tickets) {
			System.out.println(ticket.toStringOneWay());
		}
	}

	public void sortByFlightDate(List<Ticket> tickets) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
		Collections.sort(tickets, new Comparator<Ticket>() {

			public int compare(Ticket t1, Ticket t2) {
				LocalDate date1 = LocalDate.parse(t1.getDate(), formatter);
				LocalDate date2 = LocalDate.parse(t2.getDate(), formatter);
				if (date1.isAfter(date2)) {
					return 1;
				} else if (date1.isBefore(date2)) {
					return -1;
				} else {
					return 0;
				}
			}
		});

	}

	public List<Ticket> getReturnTickets() {

		Ticket returnTicket = null;
		List<Ticket> tickets = new ArrayList<>();
		do {
			for (WebElement element : returnTickets) {
				returnTicket = new Ticket();

				WebElement date = element.findElement(By.xpath("input"));
				WebElement price = element.findElement(By.xpath("label"));

				String datesString = date.getAttribute("value");
				String[] arr = datesString.split(":");

				returnTicket.setDate(arr[0]);
				returnTicket.setReturnDate(arr[1]);
				returnTicket.setPrice(price.getText());
				tickets.add(returnTicket);
			}

			WebElement next = driver.findElement(By.xpath("//i[@class='icon-right-open']"));
			wait.until(ExpectedConditions.visibilityOf(next));
			next.click();

		} while (checkLastTicket(tickets, returnTicket));

		return tickets;
	}

}
