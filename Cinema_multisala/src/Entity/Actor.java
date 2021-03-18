package Entity;

import java.util.Date;

public class Actor extends Person{
	private Integer idactor;

	public Integer getIdactor() {
		return idactor;
	}
	public void setIdactor(Integer idactor) {
		this.idactor = idactor;
	}
	public Actor(Integer idactor, String name, Integer idcountry, Date dateofbirth) {
		super(name,idcountry,dateofbirth);
		this.idactor = idactor;
	}
	
	public Actor() {};
	
	@Override
	public String toString() {
		return getName();
	}
	
}
