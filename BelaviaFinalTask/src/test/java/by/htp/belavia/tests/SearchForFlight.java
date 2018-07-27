package by.htp.belavia.tests;

import org.testng.annotations.Test;

import by.htp.belavia.entity.Flight;


public class SearchForFlight extends BaseTest{

	@Test
	public void searchOneWayTicketToRiga() {
		
		steps.openBelaviaPage();
		steps.setDepatureAndDestination("Minsk", "Riga");
		steps.setOneWayOrReturnTicket("One-way");
		Flight flight = steps.searchFlight();
		System.out.println(flight);
	       
		
	}
	
}
