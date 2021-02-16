package GUI;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import Entity.Director;
import Entity.Film;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class InsertFilmJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldtitle;
	private JTextField textFieldDuration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertFilmJframe frame = new InsertFilmJframe();
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
	public InsertFilmJframe() {
		Controller controller =  new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    setSize(729, 420);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Insert Film");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		textFieldtitle = new JTextField();
		textFieldtitle.setBounds(243, 67, 292, 20);
		contentPane.add(textFieldtitle);
		textFieldtitle.setColumns(10);
		
		JLabel lblTilte = new JLabel("Title");
		lblTilte.setBounds(187, 70, 46, 14);
		contentPane.add(lblTilte);
		
		JLabel lblActors = new JLabel("Actors");
		lblActors.setBounds(104, 172, 77, 14);
		contentPane.add(lblActors);
		
		JLabel lblProducer = new JLabel("Producer");
		lblProducer.setBounds(104, 236, 77, 14);
		contentPane.add(lblProducer);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(397, 174, 89, 14);
		contentPane.add(lblYear);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(397, 236, 89, 14);
		contentPane.add(lblDuration);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmsJframe filmsjf = new FilmsJframe();
				filmsjf.setVisible(true);
				dispose();
			}
		});
		btnUndo.setBounds(397, 314, 89, 23);
		contentPane.add(btnUndo);
		
		JLabel lblInvalidDuration = new JLabel("");
		lblInvalidDuration.setForeground(Color.RED);
		lblInvalidDuration.setBounds(492, 256, 181, 14);
		contentPane.add(lblInvalidDuration);
		
		textFieldDuration = new JTextField();
		textFieldDuration.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Integer.parseInt(textFieldDuration.getText());
					lblInvalidDuration.setText("");
				}catch (Exception e1) {
					lblInvalidDuration.setText("Invalid number!");
				}
			}
		});
		textFieldDuration.setColumns(10);
		textFieldDuration.setBounds(492, 233, 86, 20);
		contentPane.add(textFieldDuration);
		
		JLabel lblInvalidNumber = new JLabel("");
		lblInvalidNumber.setForeground(Color.RED);
		lblInvalidNumber.setBounds(492, 193, 181, 14);
		
		contentPane.add(lblInvalidNumber);
		
		JTextField textFieldYear = new JTextField();
		textFieldYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Integer.parseInt(textFieldYear.getText());
					lblInvalidNumber.setText("");
				}catch (Exception e1) {
					lblInvalidNumber.setText("Invalid number!");
				}
			}
		});
		textFieldYear.setBounds(492, 169, 86, 20);
		contentPane.add(textFieldYear);
		
		JComboBox<String> comboBoxDirector = new JComboBox(controller.findDirectors().toArray());
		comboBoxDirector.setBounds(187, 232, 143, 22);
		comboBoxDirector.setEditable(false);
		contentPane.add(comboBoxDirector);
		
		JComboBox<String> comboBoxActors = new JComboBox(controller.findActors().toArray());
		comboBoxActors.setEditable(false);
		comboBoxActors.setBounds(187, 168, 143, 22);
		contentPane.add(comboBoxActors);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldYear.getText().equals("") && !textFieldDuration.getText().equals("")  && !textFieldtitle.getText().equals("") 
						&& lblInvalidNumber.getText().equals("") && lblInvalidDuration.getText().equals("")) {
				Film film = new Film();
				film.setAnno_produzione(Integer.parseInt(textFieldYear.getText()));
				film.setDurata_minuti(Integer.parseInt(textFieldDuration.getText()));
				
				Object itemActor = comboBoxActors.getSelectedItem();
				Object itemDirector = comboBoxDirector.getSelectedItem();
				film.setId_registra(((Director)itemDirector).getId_director());
				
				film.setUrl_poster("");
				film.setTitolo(textFieldtitle.getText());
				if(controller.insertFilm(film)) {
						JOptionPane.showMessageDialog(null, "Film created!");
						textFieldYear.setText(""); textFieldYear.setText(""); textFieldDuration.setText(""); textFieldtitle.setText("");
						comboBoxActors.setSelectedIndex(0); comboBoxDirector.setSelectedIndex(0);
					}
				}else JOptionPane.showMessageDialog(null, "Enter all parameters correctly!");
			}
		});
		btnInsert.setBounds(187, 314, 89, 23);
		contentPane.add(btnInsert);


	}
}
