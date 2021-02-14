package Entity;

public class Film {
	private Integer id_film;
	private String titolo;
	private Integer anno_produzione;
	private Integer id_registra;
	private String registaname;
	private Integer durata_minuti;
	private String url_poster;
	public Integer getId_film() {
		return id_film;
	}
	public void setId_film(Integer id_film) {
		this.id_film = id_film;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Integer getAnno_produzione() {
		return anno_produzione;
	}
	public void setAnno_produzione(Integer anno_produzione) {
		this.anno_produzione = anno_produzione;
	}
	public Integer getId_registra() {
		return id_registra;
	}
	public void setId_registra(Integer id_registra) {
		this.id_registra = id_registra;
	}
	public Integer getDurata_minuti() {
		return durata_minuti;
	}
	public void setDurata_minuti(Integer durata_minuti) {
		this.durata_minuti = durata_minuti;
	}
	public String getUrl_poster() {
		return url_poster;
	}
	public void setUrl_poster(String url_poster) {
		this.url_poster = url_poster;
	}
	public String getRegistaname() {
		return registaname;
	}
	public void setRegistaname(String registaname) {
		this.registaname = registaname;
	}
	public Film(Integer id_film, String titolo, Integer anno_produzione, Integer id_registra, Integer durata_minuti,
			String url_poster) {
		super();
		this.id_film = id_film;
		this.titolo = titolo;
		this.anno_produzione = anno_produzione;
		this.id_registra = id_registra;
		this.durata_minuti = durata_minuti;
		this.url_poster = url_poster;
	}
	public Film() {}
	
	
}
