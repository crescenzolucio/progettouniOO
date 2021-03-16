package GUI;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class LoginJframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJframe LoginJframe = new LoginJframe();
					LoginJframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginJframe() {
		Controller controller = new Controller();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Cinema multisala");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 420);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUser = new JTextField();
		textFieldUser.setBackground(SystemColor.scrollbar);
		textFieldUser.setToolTipText("Username");
		textFieldUser.setForeground(SystemColor.desktop);
		textFieldUser.setBounds(212, 149, 228, 35);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(5);
		
		JButton btnLogin = new JButton("Sign In");
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setIcon(null);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(UIManager.getFont("Button.font"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String User = textFieldUser.getText();
				String Password = new String(passwordField.getPassword());
				if(controller.searchUser(User)) {
					if(controller.checkPasswordUser(User, Password)){
						TodayProjectionsJframe projectionJF = new TodayProjectionsJframe();
						projectionJF.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Wrong password!");						
					}
				}else {
					JOptionPane.showMessageDialog(null,"User not present!");
				}
			}
		});
		btnLogin.setBounds(226, 297, 96, 28);
		contentPane.add(btnLogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(72, 148, 130, 29);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(72, 217, 130, 29);
		contentPane.add(lblPassword);
		
		JLabel lblLoginNle = new JLabel("User Login");
		lblLoginNle.setForeground(Color.WHITE);
		lblLoginNle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginNle.setBounds(72, 96, 368, 35);
		contentPane.add(lblLoginNle);
		
		JButton btnRegistrazione = new JButton("Sign Up");
		btnRegistrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterJframe registerJF = new RegisterJframe();
				registerJF.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrazione.setForeground(Color.WHITE);
		btnRegistrazione.setFont(UIManager.getFont("Button.font"));
		btnRegistrazione.setBackground(Color.DARK_GRAY);
		btnRegistrazione.setBounds(347, 297, 96, 28);
		contentPane.add(btnRegistrazione);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 210, 228, 35);
		contentPane.add(passwordField);
	}
}
