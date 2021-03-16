package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Controllers.Controller;
import Entity.Film;
import Entity.Projection;
import Entity.Room;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class InsertProjectionJframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private JPanel contentPane;
	private JTextField textFieldPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertProjectionJframe frame = new InsertProjectionJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertProjectionJframe() {
		Controller controller =  new Controller();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TodayProjectionsJframe projectionsjf = new TodayProjectionsJframe();
				projectionsjf.setVisible(true);
				dispose();
			}
		});
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TodayProjectionsJframe projjf = new TodayProjectionsJframe();
				projjf.setVisible(true);
			}
		});
		btnBack.setBounds(418, 189, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(368, 108, 77, 14);
		contentPane.add(lblPrice);
		
		JComboBox comboBoxFilm = new JComboBox(controller.getFilms().toArray());
		comboBoxFilm.setEditable(false);
		comboBoxFilm.setBounds(123, 105, 219, 22);
		contentPane.add(comboBoxFilm);
		
		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(67, 109, 77, 14);
		contentPane.add(lblFilm);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(67, 64, 46, 14);
		contentPane.add(lblStart);
	
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(368, 66, 89, 14);
		contentPane.add(lblEnd);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(418, 105, 64, 20);
		contentPane.add(textFieldPrice);
		
		JLabel lblInvalidPrice = new JLabel("");
		lblInvalidPrice.setBounds(418, 138, 134, 14);
		lblInvalidPrice.setForeground(Color.RED);
		contentPane.add(lblInvalidPrice);
		
		textFieldPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Integer.parseInt(textFieldPrice.getText());
					lblInvalidPrice.setText("");
				}catch (Exception e1) {
					lblInvalidPrice.setText("Invalid number!");
				}
			}
		});
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(67, 148, 77, 14);
		contentPane.add(lblRoom);
		
		JComboBox comboBoxRoom = new JComboBox(controller.getRooms().toArray());
		comboBoxRoom.setEditable(false);
		comboBoxRoom.setBounds(123, 144, 219, 22);
		contentPane.add(comboBoxRoom);
		
		JDateChooser dateChooserStart = new JDateChooser();
		dateChooserStart.setBounds(123, 64, 100, 20);
		dateChooserStart.getDateEditor().setEnabled(false);
		contentPane.add(dateChooserStart);

		JSpinner spinnerStartHour = new JSpinner();
		spinnerStartHour.setBounds(241, 64, 44, 20);
		spinnerStartHour.setModel(new SpinnerNumberModel(0,0,23,1));
		contentPane.add(spinnerStartHour);
		
		JSpinner spinnerStartMinutes = new JSpinner();
		spinnerStartMinutes.setBounds(298, 64, 44, 20);
		spinnerStartMinutes.setModel(new SpinnerNumberModel(0,0,59,1));
		contentPane.add(spinnerStartMinutes);
		
		JDateChooser dateChooserEnd = new JDateChooser();
		dateChooserEnd.setBounds(418, 64, 100, 20);
		dateChooserEnd.getDateEditor().setEnabled(false);
		contentPane.add(dateChooserEnd);
		
		JSpinner spinnerEndHour = new JSpinner();
		spinnerEndHour.setBounds(535, 64, 44, 20);
		spinnerEndHour.setModel(new SpinnerNumberModel(0,0,23,1));
		contentPane.add(spinnerEndHour);
		
		JSpinner spinnerEndMinutes = new JSpinner();
		spinnerEndMinutes.setBounds(592, 64, 44, 20);
		spinnerEndMinutes.setModel(new SpinnerNumberModel(0,0,59,1));
		contentPane.add(spinnerEndMinutes);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldPrice.getText().equals("") && !dateChooserStart.getDateEditor().getDate().toString().equals("") 
						&& !dateChooserEnd.getDateEditor().getDate().toString().equals("") && lblInvalidPrice.getText().equals("") ) {
				    Calendar calendar = Calendar.getInstance();
					long time,seconds;
					
					//idroom
					Object itemRoom = comboBoxRoom.getSelectedItem();
					Integer idroom = ((Room)itemRoom).getIdroom();
					
					//idfilm
					Object itemFilm = comboBoxFilm.getSelectedItem();
					Integer idfilm = ((Film)itemFilm).getId_film();
					
					//end projection
					calendar.setTime(dateChooserEnd.getDate());
				    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(spinnerEndHour.getValue().toString()));
				    calendar.set(Calendar.MINUTE, Integer.parseInt(spinnerEndMinutes.getValue().toString()));
					time = calendar.getTimeInMillis();
					seconds = time;
					Timestamp timeend = new Timestamp(time);
					
					//start projection
					calendar.setTime(dateChooserStart.getDate());
				    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(spinnerStartHour.getValue().toString()));
				    calendar.set(Calendar.MINUTE, Integer.parseInt(spinnerStartMinutes.getValue().toString()));
					time = calendar.getTimeInMillis();
					seconds = (seconds - time)/1000; 
					Timestamp timestart = new Timestamp(time);
					
					//price
					Integer price = Integer.parseInt(textFieldPrice.getText());
					
					Projection pj = new Projection();
					pj.setIdfilm(idfilm); pj.setIdsala(idroom); pj.setStartpj(timestart); 
					pj.setEndpj(timeend); pj.setPrice(price);
					System.out.println(timestart);
					System.out.println(timeend);
					
					//diff hours between calendars end-start
					int hours = (int) (seconds / 3600);
					System.out.println(hours);
					if(price >=0){
						if(hours <= 24 && hours >= 0){
							if(controller.insertProjection(pj)){
								JOptionPane.showMessageDialog(null, "Projection created!");
								comboBoxRoom.setSelectedIndex(0); comboBoxFilm.setSelectedIndex(0);	textFieldPrice.setText("");
								dateChooserEnd.setDate(new Date()); spinnerStartHour.setValue(0); spinnerEndHour.setValue(0);
								spinnerStartMinutes.setValue(0); spinnerEndMinutes.setValue(0); dateChooserStart.setDate(new Date()); 
							}
						}else JOptionPane.showMessageDialog(null, "The projection hours must be between 0 and 24!");
					}else JOptionPane.showMessageDialog(null, "The price cannot be negative!");
				}else JOptionPane.showMessageDialog(null, "Enter all parameters correctly!");
			}
		});
		btnInsert.setBounds(173, 189, 89, 23);
		contentPane.add(btnInsert);
		
		setSize(732, 307);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Projection add");
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
