package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import DAO.UserPostgreDAO;
import Entity.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldUser;
	private JPasswordField passwordPassword;
	private JPasswordField passwordConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterJframe frame = new RegisterJframe();
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
	public RegisterJframe() {
		Controller contruser = new Controller();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Register here");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 420);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(215, 168, 228, 35);
		contentPane.add(passwordPassword);
		
		passwordConfirmPassword = new JPasswordField();
		passwordConfirmPassword.setBounds(215, 238, 228, 35);
		contentPane.add(passwordConfirmPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String User = textFieldUser.getText();
				String Password = new String(passwordPassword.getPassword());
				String ConfirmPassword = new String(passwordConfirmPassword.getPassword());
				String Email = textFieldEmail.getText();
				if(Password.equals(ConfirmPassword)) {
					if(checkEmail(Email)) {
						User user = new User(User, Password, Email);
						contruser.addInfoUser(user);
						LoginJframe login = new LoginJframe();
						login.setVisible(true);
						setVisible(false);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Enter a valid e-mail!");				
					}
				}else{
					JOptionPane.showMessageDialog(null,"Password and confirm password does not match!");					
				}

			}
		});
		contentPane.add(btnRegister);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(UIManager.getFont("Button.font"));
		btnRegister.setBackground(Color.DARK_GRAY);
		btnRegister.setBounds(347, 297, 96, 28);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(215, 100, 228, 35);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(215, 39, 228, 35);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(10, 35, 191, 35);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(10, 96, 195, 35);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(10, 168, 191, 35);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmPassword.setBounds(10, 238, 191, 35);
		contentPane.add(lblConfirmPassword);
	}
	
	private boolean checkEmail(String email) {
		String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
}
