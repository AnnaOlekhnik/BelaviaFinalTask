package by.htp.belavia.tests;
import org.testng.annotations.Test;
import by.htp.belavia.pages.BookingPage;

public class SearchForFlight extends BaseTest{

	@Test
	public void searchOneWayTicketToRiga() {
		
		steps.openBelaviaPage();
		steps.setDepatureAndDestination("Minsk", "Riga");
		steps.setOneWayOrReturnTicket("One-way");
		steps.searchFlight();
		BookingPage page = steps.getResultsOfOneWayTicketSearch();
	
	}
}
