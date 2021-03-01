package Entity;

public class Room {
	private Integer idroom;
	private String  description;
	private Integer seats;
	private Integer techaudio;
	private String  techaudiodesc;
	private Integer techproj;
	private String  techprojdesc;

	public Integer getIdroom() {
		return idroom;
	}
	public void setIdroom(Integer idroom) {
		this.idroom = idroom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String Description) {
		this.description = Description;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer Seats) {
		this.seats = Seats;
	}
	public Integer getTechaudio() {
		return techaudio;
	}
	public void setTechaudio(Integer techaudio) {
		this.techaudio = techaudio;
	}
	public String getTechaudiodesc() {
		return techaudiodesc;
	}
	public void setTechaudiodesc(String techaudiodesc) {
		this.techaudiodesc = techaudiodesc;
	}
	public Integer getTechproj() {
		return techproj;
	}
	public void setTechproj(Integer techproj) {
		this.techproj = techproj;
	}
	public String getTechprojdesc() {
		return techprojdesc;
	}
	public void setTechprojdesc(String techprojdesc) {
		this.techprojdesc = techprojdesc;
	}
	public Room() {}
	@Override
	public String toString() {
		return description;
	}
	public Room(Integer idroom, String description, Integer seats, Integer techaudio,Integer techproj) {
		super();
		this.idroom = idroom;
		this.description = description;
		this.seats = seats;
		this.techaudio = techaudio;
		this.techproj = techproj;
	}
}
