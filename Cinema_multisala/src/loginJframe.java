import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class loginJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginJframe frame = new loginJframe();
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
	public loginJframe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(loginJframe.class.getResource("/Images/logo.png")));
		setTitle("Cinema multisala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 420);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUser = new JTextField();
		textFieldUser.setToolTipText("Username");
		textFieldUser.setForeground(new Color(51, 51, 51));
		textFieldUser.setBounds(212, 149, 228, 35);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(5);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setToolTipText("Password");
		textFieldPassword.setBounds(212, 218, 228, 35);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setIcon(null);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(UIManager.getFont("Button.font"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String User = textFieldUser.getText();
				String Password = textFieldPassword.getText();
				if(User.equals("Poggio")) {
					
					JOptionPane.showMessageDialog(null,"UwU è weeb!!!");
				}else {
					
					JOptionPane.showMessageDialog(null,"Test2");	
				}
				
			}
		});
		btnLogin.setBounds(369, 296, 71, 28);
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
		
		JLabel lblLoginNle = new JLabel("Login to your account");
		lblLoginNle.setForeground(Color.WHITE);
		lblLoginNle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginNle.setBounds(72, 96, 368, 35);
		contentPane.add(lblLoginNle);
	}
}
