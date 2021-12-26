package entidades;

public class Dado {
	
	private String date;
	private String state;
	private String city;
	private int confirmed;
	private int deaths;
	
	//Construtores
	
	public Dado() {}
	
	public Dado (String date, String state, String city, int confirmed, int deaths){
		
		this.date = date;
		this.state = state;
		this.city = city;
		this.confirmed = confirmed;
		this.deaths = deaths;
	}
	
	public Dado(String state, String city, int confirmed, int deaths) {
		this.state = state;
		this.city = city;
		this.confirmed = confirmed;
		this.deaths = deaths;
	}
	
	//Getters and setters
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	//Tostring
	@Override
	public String toString() {
		return "[date=" + date + ", state=" + state + ", city=" + city + ", confirmed=" + confirmed
				+ ", deaths=" + deaths + "]";
	}	

}
