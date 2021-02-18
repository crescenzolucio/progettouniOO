package Entity;

public class Genre {
	private Integer idgenre;
	private String genre;
	public Integer getIdgenre() {
		return idgenre;
	}
	public void setIdgenre(Integer idgenre) {
		this.idgenre = idgenre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Genre(Integer idgenre, String genre) {
		super();
		this.idgenre = idgenre;
		this.genre = genre;
	}
	public Genre() {}
	@Override
	public String toString() {
		return genre;
	}
}
