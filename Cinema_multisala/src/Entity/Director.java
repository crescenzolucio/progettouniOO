package Entity;

import java.util.Date;

public class Director extends Person{
	private Integer id_director;
	public Integer getId_director() {
		return id_director;
	}
	public void setId_director(Integer id_director) {
		this.id_director = id_director;
	}
	public Director(Integer id_director, String name, Integer country, Date dateofbirth) {
		super(name,country,dateofbirth);
		this.id_director = id_director;
	}
	public Director() {
		super();
	}
	@Override
	public String toString() {
		return getName();
	}
}
