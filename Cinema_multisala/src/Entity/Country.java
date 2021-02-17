package Entity;

public class Country {
	public Integer idcountry;
	public String  country;
	
	public Integer getIdcountry() {
		return idcountry;
	}
	public void setIdcountry(Integer idcountry) {
		this.idcountry = idcountry;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Country(Integer idcountry, String country) {
		super();
		this.idcountry = idcountry;
		this.country = country;
	}
	public Country() {
		
	}
	
	@Override
	public String toString() {
		return country;
	}
	
}
