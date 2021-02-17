package Entity;

import java.util.Date;

public class Director {
	private Integer id_director;
	private String Name;
	private Integer Country;
	private Date Dateofbirth;
	public Integer getId_director() {
		return id_director;
	}
	public void setId_director(Integer id_director) {
		this.id_director = id_director;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getCountry() {
		return Country;
	}
	public void setCountry(Integer country) {
		Country = country;
	}
	public Date getDateofbirth() {
		return Dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		Dateofbirth = dateofbirth;
	}
	public Director(Integer id_director, String name, Integer country, Date dateofbirth) {
		super();
		this.id_director = id_director;
		Name = name;
		Country = country;
		Dateofbirth = dateofbirth;
	}
	public Director() {
	}
	@Override
	public String toString() {
		return Name;
	}
	
}
