package Entity;

public class Ticket {
	Integer id_pj;
	Integer id_ticket;
	Integer discount;
	Integer finalprice;
	public Integer getId_pj() {
		return id_pj;
	}
	public void setId_pj(Integer id_pj) {
		this.id_pj = id_pj;
	}
	public Integer getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(Integer id_ticket) {
		this.id_ticket = id_ticket;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(Integer finalprice) {
		this.finalprice = finalprice;
	}
	public Ticket(Integer id_pj, Integer id_ticket, Integer discount, Integer finalprice) {
		super();
		this.id_pj = id_pj;
		this.id_ticket = id_ticket;
		this.discount = discount;
		this.finalprice = finalprice;
	}
	
}
