package by.htp.belavia.entity;

public class Ticket implements Comparable<Ticket> {

	private String date;
	private String returnDate;
	private String price;
	
	public Ticket() {}

	public Ticket(String date, String returnDate, String price) {
		super();
		this.date = date;
		this.returnDate = returnDate;
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [date=" + date + ", returnDate=" + returnDate + ", price=" + price + "]";
	}

	public String toStringOneWay() {
		return "Ticket [date=" + date +  ", price=" + price + "]";
	}
	
	@Override
	public int compareTo(Ticket t) {
		String thisCostString = this.price.replaceAll("[^0-9]", "");
		int cost = Integer.parseInt(thisCostString);

		String compared = t.getPrice().replaceAll("[^0-9]", "");
		int comparedCost = Integer.parseInt(compared);
		if (cost > comparedCost) {
			return 1;
		} else if (cost < comparedCost) {
			return -1;
		} else {
			return 0;
		}

	}

	
}
