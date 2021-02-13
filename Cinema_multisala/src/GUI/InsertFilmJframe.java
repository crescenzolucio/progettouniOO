package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldtitle = new JTextField();
		textFieldtitle.setBounds(243, 67, 292, 20);
		contentPane.add(textFieldtitle);
		textFieldtitle.setColumns(10);
		
		JLabel lblTilte = new JLabel("Title");
		lblTilte.setBounds(187, 70, 46, 14);
		contentPane.add(lblTilte);
		
		JLabel lblActors = new JLabel("Actors");
		lblActors.setBounds(104, 172, 46, 14);
		contentPane.add(lblActors);
		
		JLabel lblProducer = new JLabel("Producer");
		lblProducer.setBounds(104, 293, 46, 14);
		contentPane.add(lblProducer);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(397, 174, 89, 14);
		contentPane.add(lblYear);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(397, 293, 89, 14);
		contentPane.add(lblDuration);
		
		JList listProducer = new JList();
		listProducer.setBounds(191, 293, 139, 20);
		contentPane.add(listProducer);
		
		JList listActors = new JList();
		listActors.setBounds(191, 171, 139, 20);
		contentPane.add(listActors);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(187, 371, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmsJframe filmsjf = new FilmsJframe();
				filmsjf.setVisible(true);
				dispose();
			}
		});
		btnUndo.setBounds(397, 371, 89, 23);
		contentPane.add(btnUndo);
		
		JLabel lblInvalidDuration = new JLabel("");
		lblInvalidDuration.setForeground(Color.RED);
		lblInvalidDuration.setBounds(492, 313, 181, 14);
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
		textFieldDuration.setBounds(492, 290, 86, 20);
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
		

	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(728, 516);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Insert Film");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
}
