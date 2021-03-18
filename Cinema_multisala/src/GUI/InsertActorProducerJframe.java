package GUI;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import Entity.Actor;
import Entity.Country;
import Entity.Director;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;

public class InsertActorProducerJframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private JPanel contentPane;
	private JTextField textFieldname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertActorProducerJframe frame = new InsertActorProducerJframe();
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
	public InsertActorProducerJframe() {
		Controller controller =  new Controller();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    setSize(730, 290);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TodayProjectionsJframe.class.getResource("/Images/logo.png")));
		setTitle("Insert Actor/Producer");
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FilmsJframe filmsjf = new FilmsJframe();
				filmsjf.setVisible(true);
				dispose();
			}
		});

		textFieldname = new JTextField();
		textFieldname.setBounds(161, 61, 170, 20);
		contentPane.add(textFieldname);
		textFieldname.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(105, 64, 226, 14);
		contentPane.add(lblName);
		
		JLabel lblBirth = new JLabel("Birth");
		lblBirth.setBounds(398, 66, 89, 14);
		contentPane.add(lblBirth);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmsJframe filmsjf = new FilmsJframe();
				filmsjf.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(398, 183, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblInvalidDuration = new JLabel("");
		lblInvalidDuration.setForeground(Color.RED);
		lblInvalidDuration.setBounds(492, 256, 181, 14);
		contentPane.add(lblInvalidDuration);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(398, 127, 77, 14);
		contentPane.add(lblCountry);
		
		JComboBox<Object> comboBoxCountry = new JComboBox<Object>(controller.getCountries().toArray());
		comboBoxCountry.setEditable(false);
		comboBoxCountry.setBounds(454, 123, 125, 22);
		contentPane.add(comboBoxCountry);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(453, 61, 126, 20);
		dateChooser.getDateEditor().setEnabled(false);
		contentPane.add(dateChooser);
		
		JRadioButton rdbtnDirector = new JRadioButton("Director");
		rdbtnDirector.setBounds(105, 123, 109, 23);
		contentPane.add(rdbtnDirector);
		
		JRadioButton rdbtnActor = new JRadioButton("Actor");
		rdbtnActor.setBounds(222, 123, 109, 23);
		contentPane.add(rdbtnActor);
		
		ButtonGroup buttogroup = new ButtonGroup();
		buttogroup.add(rdbtnDirector);
		buttogroup.add(rdbtnActor);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object itemCountry = comboBoxCountry.getSelectedItem();
				Integer idcountry = ((Country)itemCountry).getIdcountry();
				
				String name = textFieldname.getText();

				if(!idcountry.toString().equals("") && !name.equals("") && dateChooser.getDateEditor().getDate() != null && (rdbtnActor.isSelected() || rdbtnDirector.isSelected())){
					if(rdbtnActor.isSelected()) {
						Actor actor = new Actor();
						actor.setDateofbirth(dateChooser.getDate());
						actor.setName(name);
						actor.setCountry(idcountry);
						if(controller.insertActor(actor)) {
							JOptionPane.showMessageDialog(null, "Actor added!");
							textFieldname.setText(""); dateChooser.setDate(new Date());	comboBoxCountry.setSelectedIndex(0); 
							rdbtnActor.setSelected(false); rdbtnDirector.setSelected(false);
						}
					}else {
						if(rdbtnDirector.isSelected()) {
							Director director = new Director();
							director.setDateofbirth(dateChooser.getDate());
							director.setName(name);
							director.setCountry(idcountry);
							if(controller.insertDirector(director)) {
								JOptionPane.showMessageDialog(null, "Director added!");
								textFieldname.setText(""); dateChooser.setDate(new Date());	comboBoxCountry.setSelectedIndex(0); 
								rdbtnActor.setSelected(false); rdbtnDirector.setSelected(false);
							}
						}
					}
				}else JOptionPane.showMessageDialog(null, "Enter all parameters correctly!");
			}
		});
		btnInsert.setBounds(188, 183, 89, 23);
		contentPane.add(btnInsert);
	}
}
