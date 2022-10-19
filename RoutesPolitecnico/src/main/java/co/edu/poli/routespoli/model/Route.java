package co.edu.poli.routespoli.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Routes")
public class Route {
	
	@Id
	private int number;
	private String dateOut;
	private String hourOut;
	private int chairNumber;
	
	@ManyToOne
	@JoinColumn (name = "driver_id")
	private Driver driver;
	
	public Route () {
		
	}

	public Route(int number, String dateOut, String hourOut, int chairNumber, Driver driver) {
		super();
		this.number = number;
		this.dateOut = dateOut;
		this.hourOut = hourOut;
		this.chairNumber = chairNumber;
		this.driver = driver;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDateOut() {
		return dateOut;
	}

	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}

	public String getHourOut() {
		return hourOut;
	}

	public void setHourOut(String hourOut) {
		this.hourOut = hourOut;
	}

	public int getChairNumber() {
		return chairNumber;
	}

	public void setChairNumber(int chairNumber) {
		this.chairNumber = chairNumber;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
