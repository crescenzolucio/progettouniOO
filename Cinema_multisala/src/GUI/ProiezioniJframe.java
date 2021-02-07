package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class ProiezioniJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProiezioniJframe frame = new ProiezioniJframe();
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
	public ProiezioniJframe() {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(screenSize.width/2, screenSize.height/2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Projections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(screenSize.width/2, screenSize.height/2);
		contentPane.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		
		
		JMenuItem mntmProjections = new JMenuItem("Projections");
		menuBar.add(mntmProjections);
		
		JMenuItem mntmFilms = new JMenuItem("Films");
		menuBar.add(mntmFilms);
		
		JMenuItem mntmRooms = new JMenuItem("Rooms");
		menuBar.add(mntmRooms);
		
	}
}
