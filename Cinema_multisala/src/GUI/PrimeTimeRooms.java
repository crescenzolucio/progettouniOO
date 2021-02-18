package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import Controllers.Controller;

public class PrimeTimeRooms extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfitableShows frame = new ProfitableShows();
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
	public PrimeTimeRooms() {

		Controller controller = new Controller();
	    
	    setSize(642, 417);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Prime Time");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TodayProjectionsJframe projectionJf = new TodayProjectionsJframe();
				projectionJf.setVisible(true);
				dispose();
			}
		});
		setResizable(false);

		//Jtable not editable
		JTable table = new JTable(controller.PrimeTimeRoomsView()){  
			/****/
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row,int column){
				return false;
		    }  
        };
        //No drag
        table.getTableHeader().setReorderingAllowed(false);
        
        //Width Columns
        table.getColumnModel().getColumn(0).setMinWidth(200);
        table.getColumnModel().getColumn(0).setMaxWidth(200);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        
		table.setSize(getWidth(),getHeight());
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(642, 417);
		getContentPane().add(scrollPane);	
	}
}
