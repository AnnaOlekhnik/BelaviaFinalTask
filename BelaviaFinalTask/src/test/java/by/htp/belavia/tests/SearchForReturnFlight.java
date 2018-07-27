package by.htp.belavia.tests;

import org.testng.annotations.Test;

import by.htp.belavia.pages.BookingPage;

public class SearchForReturnFlight extends BaseTest {

	@Test
	public void searchReturnTicketToRiga(){
		
		steps.openBelaviaPage();
		steps.setDepatureAndDestination("Minsk", "Riga");
		steps.setOneWayOrReturnTicket("Return");
		steps.searchReturnFlight();
		BookingPage page = steps.getResultsOfReturnTicketSearch();
			
	}
	
}
