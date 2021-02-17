package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import Entity.Audio;
import Entity.Director;
import Entity.Room;
import Entity.Technology;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertRoomJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDescription;
	private JTextField textFieldSeats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertRoomJframe frame = new InsertRoomJframe();
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
	public InsertRoomJframe() {
		Controller controller =  new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    setSize(732, 307);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Rooms add");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				RoomsJframe roomsjf = new RoomsJframe();
				roomsjf.setVisible(true);
				dispose();
			}
		});

		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RoomsJframe roomsjf = new RoomsJframe();
				roomsjf.setVisible(true);
			}
		});
		btnUndo.setBounds(431, 181, 89, 23);
		contentPane.add(btnUndo);
		
		JLabel lblAudio = new JLabel("Audio");
		lblAudio.setBounds(116, 113, 77, 14);
		contentPane.add(lblAudio);
		
		JLabel lblTechProjection = new JLabel("Tech");
		lblTechProjection.setBounds(382, 117, 77, 14);
		contentPane.add(lblTechProjection);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(382, 70, 89, 14);
		contentPane.add(lblDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textFieldDescription.setText(textFieldDescription.getText().toUpperCase());
			}
		});
		textFieldDescription.setBounds(456, 67, 134, 20);
		contentPane.add(textFieldDescription);
		
		
		JLabel lblInvalidSeats = new JLabel("");
		lblInvalidSeats.setForeground(Color.RED);
		lblInvalidSeats.setBounds(172, 88, 181, 14);
		contentPane.add(lblInvalidSeats);
		
		textFieldSeats = new JTextField();
		textFieldSeats.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Integer.parseInt(textFieldSeats.getText());
					lblInvalidSeats.setText("");
				}catch (Exception e1) {
					lblInvalidSeats.setText("Invalid number!");
				}
			}
		});
		textFieldSeats.setColumns(10);
		textFieldSeats.setBounds(172, 65, 71, 20);
		contentPane.add(textFieldSeats);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setBounds(116, 68, 46, 14);
		contentPane.add(lblSeats);
		
		JComboBox<?> comboBoxAudio = new JComboBox<Object>(controller.getAudios().toArray());
		comboBoxAudio.setEditable(false);
		comboBoxAudio.setBounds(172, 109, 134, 22);
		contentPane.add(comboBoxAudio);
		
		JComboBox<?> comboBoxTechProjection = new JComboBox<Object>(controller.getTechnologies().toArray());
		comboBoxTechProjection.setEditable(false);
		comboBoxTechProjection.setBounds(456, 113, 134, 22);
		contentPane.add(comboBoxTechProjection);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldDescription.getText().equals("") && !textFieldSeats.getText().equals("") && lblInvalidSeats.getText().equals("") ) {
					
					Room room = new Room();
					room.setDescrizione(textFieldDescription.getText());
					room.setPosti(Integer.parseInt(textFieldSeats.getText()));
					
					Object itemTechnology = comboBoxTechProjection.getSelectedItem();
					room.setTechproj(((Technology)itemTechnology).getIdtecnology());
					
					Object itemAudio = comboBoxAudio.getSelectedItem();
					room.setTechaudio(((Audio)itemAudio).getIdsound());

					if(controller.insertRoom(room)) {
						JOptionPane.showMessageDialog(null, "Room created!");
						textFieldDescription.setText(""); textFieldSeats.setText("");
						comboBoxTechProjection.setSelectedIndex(0); comboBoxAudio.setSelectedIndex(0);
					}
				}else JOptionPane.showMessageDialog(null, "Enter all parameters correctly!");
			}
		});
		btnInsert.setBounds(221, 181, 89, 23);
		contentPane.add(btnInsert);
	}
}
