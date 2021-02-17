package Entity;

import java.util.Date;

public class Actor {
	private Integer idactor;
	private String name;
	private Integer idcountry;
	private Date dateofbirth;
	
	public Integer getIdactor() {
		return idactor;
	}
	public void setIdactor(Integer idactor) {
		this.idactor = idactor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCountry() {
		return idcountry;
	}
	public void setCountry(Integer country) {
		this.idcountry = country;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Actor(Integer idactor, String name, Integer idcountry, Date dateofbirth) {
		super();
		this.idactor = idactor;
		this.name = name;
		this.idcountry = idcountry;
		this.dateofbirth = dateofbirth;
	}
	
	public Actor() {};
	
	@Override
	public String toString() {
		return name;
	}
	
}
