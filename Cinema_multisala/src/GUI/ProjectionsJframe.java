package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import Controllers.Controller;
import Entity.Projection;

import javax.swing.JMenuItem;

public class ProjectionsJframe extends JFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectionsJframe frame = new ProjectionsJframe();
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
	public ProjectionsJframe() {
		Controller contruser = new Controller();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(screenSize.width/2, screenSize.height/2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Projections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem);
		getContentPane().setSize(getWidth(),getHeight());
		
		DefaultTableModel model = new DefaultTableModel();

		String[] columnNames = {"Film",
		        "Start",
		        "End",
		        "Room",
		        "Price",
		        "Seats",
		        "Buy"};
		model.setColumnIdentifiers(columnNames);
		
		LinkedList<Projection> list= (LinkedList<Projection>) contruser.findProjections();
		for (Projection pj : list) {
			  Object[] obj = new Object[6];
			  obj[0] = contruser.nameFilm(pj.getIdfilm());
			  obj[1] = pj.getInizioproiezione();
			  obj[2] = pj.getFineproiezione();
			  obj[3] = contruser.nameRoom(pj.getIdsala()).getDescrizione();
			  obj[4] = pj.getPrezzo()+"€";
			  obj[5] = contruser.nameRoom(pj.getIdsala()).getPosti();
			  model.addRow(obj);
			}
		
		table = new JTable(model);
		table.setSize(getWidth(),getHeight());
        
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0,getWidth(),getHeight());
		getContentPane().add(scrollPane);	
	}
}
