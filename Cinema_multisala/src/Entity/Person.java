package Entity;

import java.util.Date;

public class Person {
	private String name;
	private Integer idcountry;
	private Date dateofbirth;
	
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
	public Person(String name, Integer idcountry, Date dateofbirth) {
		super();
		this.name = name;
		this.idcountry = idcountry;
		this.dateofbirth = dateofbirth;
	}
	public Person() {}
}
