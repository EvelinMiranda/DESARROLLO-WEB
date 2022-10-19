package co.edu.poli.routespoli.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "Drivers")
public class Driver {
	
	@Id
	private int id;
	private String name;
	private String dateIn;
	
	@OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Route> dataRoute;
	
	public Driver () {
		
	}

	public Driver(int id, String name, String dateIn, Set<Route> dataRoute) {
		super();
		this.id = id;
		this.name = name;
		this.dateIn = dateIn;
		this.dataRoute = dataRoute;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateIn() {
		return dateIn;
	}

	public void setDateIn(String dateIn) {
		this.dateIn = dateIn;
	}

	public Set<Route> getDataRoute() {
		return dataRoute;
	}

	public void setDataRoute(Set<Route> dataRoute) {
		this.dataRoute = dataRoute;
	}

}
