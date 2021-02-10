package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Timestamp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TicketJframe(String price,String film,String room,String projectionstart,String projectionend, Integer seat) {
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
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(109, 232, 89, 23);
		contentPane.add(btnBuy);
		
		JButton btnBack = new JButton("Undo");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectionsJframe frame = new ProjectionsJframe();
				frame.setVisible(true);
				dispose(); 
			}
		});
		btnBack.setBounds(363, 232, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PrinterJob job = PrinterJob.getPrinterJob();
					job.setJobName("Print Ticket");
					
					job.setPrintable(new Printable(){
			            public int print(Graphics pg,PageFormat pf, int pageNum){
			                    pf.setOrientation(PageFormat.PORTRAIT);
			                    if(pageNum>0){
			                    	return Printable.NO_SUCH_PAGE;
			                    }
			                    Graphics2D g2 = (Graphics2D)pg;
			                    g2.translate(pf.getImageableX(), pf.getImageableY());
			                    g2.scale(0.6,0.6);
			                    g2.setBackground(Color.GRAY);
			                    paint(g2);
			                    return Printable.PAGE_EXISTS;
			            }
					});
			        try {
			        	btnBuy.setVisible(false);
			        	btnPrint.setVisible(false);
			        	btnBack.setVisible(false);
						job.print();
			        	btnBuy.setVisible(true);
			        	btnPrint.setVisible(true);
			        	btnBack.setVisible(true);
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		});
		btnPrint.setBounds(236, 232, 89, 23);
		contentPane.add(btnPrint);
		

		
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
		
		JLabel lblProjectionEndEditable = new JLabel("<dynamic>");
		lblProjectionEndEditable.setBounds(347, 183, 212, 14);
		lblProjectionEndEditable.setText(projectionend.toString());
		contentPane.add(lblProjectionEndEditable);
	}
}
