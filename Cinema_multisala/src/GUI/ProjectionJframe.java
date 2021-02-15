package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectionJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldStart;
	private JTextField textFieldEnd;
	private JTextField textFieldPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectionJframe frame = new ProjectionJframe();
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
	public ProjectionJframe() {
		Controller controller =  new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(208, 189, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProjectionsJframe projjf = new ProjectionsJframe();
				projjf.setVisible(true);
			}
		});
		btnUndo.setBounds(418, 189, 89, 23);
		contentPane.add(btnUndo);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(368, 113, 77, 14);
		contentPane.add(lblPrice);
		
		JComboBox comboBoxFilm = new JComboBox(new Object[]{});
		comboBoxFilm.setEditable(false);
		comboBoxFilm.setBounds(158, 105, 134, 22);
		contentPane.add(comboBoxFilm);
		
		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(102, 109, 77, 14);
		contentPane.add(lblFilm);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(102, 64, 46, 14);
		contentPane.add(lblStart);
		
		textFieldStart = new JTextField();
		textFieldStart.setColumns(10);
		textFieldStart.setBounds(158, 61, 134, 20);
		contentPane.add(textFieldStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(368, 66, 89, 14);
		contentPane.add(lblEnd);
		
		textFieldEnd = new JTextField();
		textFieldEnd.setBounds(442, 63, 134, 20);
		contentPane.add(textFieldEnd);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(442, 110, 64, 20);
		contentPane.add(textFieldPrice);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(102, 148, 77, 14);
		contentPane.add(lblRoom);
		
		JComboBox comboBoxRoom = new JComboBox(new Object[]{});
		comboBoxRoom.setEditable(false);
		comboBoxRoom.setBounds(158, 144, 134, 22);
		contentPane.add(comboBoxRoom);
	    setSize(732, 307);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Projection add");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

}
