package GUI;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterAbortException;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import Entity.Ticket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketJframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TicketJframe(Integer idpj,String price,String film,String room,String projectionstart,String projectionend, Integer seat) {
		Controller contr = new Controller();
		setVisible(true);
		setBounds(100, 100, 600, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		JButton btnPrint = new JButton("Print");
		JButton btnBuy = new JButton("Buy");
		JButton btnBack = new JButton("Undo");
		
		//UNDO
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodayProjectionsJframe frame = new TodayProjectionsJframe();
				frame.setVisible(true);
				dispose(); 
			}
		});
		btnBack.setBounds(363, 232, 89, 23);
		contentPane.add(btnBack);
		//PRINT
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PrinterJob job = PrinterJob.getPrinterJob();
					job.setJobName("Print Ticket ");
					
					job.setPrintable(new Printable(){
			            public int print(Graphics pg,PageFormat pf, int pageNum){
			                    pf.setOrientation(PageFormat.LANDSCAPE);
			                    if(pageNum>0) return Printable.NO_SUCH_PAGE;
			                    Graphics2D g2 = (Graphics2D)pg;
			                    g2.translate(pf.getImageableX(), pf.getImageableY());
			                    g2.scale(0.75,0.75);
			                    paint(g2);
			                    return Printable.PAGE_EXISTS;
			            }
					});
			        try {
			        	btnPrint.setVisible(false);
			        	btnBack.setVisible(false);
						job.print();
			        	btnPrint.setVisible(true);
			        	btnBack.setVisible(true);
					} catch (PrinterAbortException e1) {
			        	btnPrint.setVisible(true);
						JOptionPane.showMessageDialog(null, "Print aborted!");
					} catch (PrinterException e2) {
						e2.printStackTrace();
					}
				}
		});
		btnPrint.setBounds(236, 232, 89, 23);
		btnPrint.setVisible(false);
		contentPane.add(btnPrint);
		
		//BUY
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket ticket = new Ticket(idpj,contr.lastTicket()+1,0,Integer.parseInt(price.replace("€","")));
				if(contr.buyTicket(ticket)) {
					JOptionPane.showMessageDialog(null, "Ticket created!");
					btnPrint.setVisible(true);
				}
				btnBuy.setVisible(false);
			}
		});
		btnBuy.setBounds(109, 232, 89, 23);
		contentPane.add(btnBuy);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(236, 28, 80, 14);
		contentPane.add(lblPrice);
		
		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(236, 70, 80, 14);
		contentPane.add(lblFilm);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(236, 108, 80, 14);
		contentPane.add(lblRoom);
		
		JLabel lblProjectionStart = new JLabel("Projection Start");
		lblProjectionStart.setBounds(236, 148, 101, 14);
		contentPane.add(lblProjectionStart);
		
		JLabel lblPriceEditable = new JLabel("");
		lblPriceEditable.setBounds(347, 28, 105, 14);
		lblPriceEditable.setText(price.toString());
		contentPane.add(lblPriceEditable);
		
		JLabel lblFilmEditable = new JLabel("");
		lblFilmEditable.setBounds(347, 70, 105, 14);
		lblFilmEditable.setText(film);
		contentPane.add(lblFilmEditable);
		
		JLabel lblRoomEditable = new JLabel("");
		lblRoomEditable.setBounds(347, 108, 105, 14);
		lblRoomEditable.setText(room);
		contentPane.add(lblRoomEditable);
		
		JLabel lblProjectionStartEditable = new JLabel("");
		lblProjectionStartEditable.setBounds(347, 148, 212, 14);
		lblProjectionStartEditable.setText(projectionstart.toString());
		contentPane.add(lblProjectionStartEditable);
		
		JLabel lblSeat = new JLabel("Seat");
		lblSeat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeat.setBounds(118, 54, 80, 25);

		contentPane.add(lblSeat);
		
		JLabel lblSeatNumber = new JLabel("");
		lblSeatNumber.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSeatNumber.setBounds(107, 90, 80, 72);
		lblSeatNumber.setText(seat.toString());
		contentPane.add(lblSeatNumber);
		
		JLabel lblProjectionEnd = new JLabel("Projection End");
		lblProjectionEnd.setBounds(236, 183, 101, 14);
		contentPane.add(lblProjectionEnd);
		
		JLabel lblProjectionEndEditable = new JLabel("");
		lblProjectionEndEditable.setBounds(347, 183, 212, 14);
		lblProjectionEndEditable.setText(projectionend.toString());
		contentPane.add(lblProjectionEndEditable);
	}
}
