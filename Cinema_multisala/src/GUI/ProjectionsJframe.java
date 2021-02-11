package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import Controllers.Controller;
import Entity.Projection;
import ImportedClass.ButtonColumn;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ProjectionsJframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

		String[] columnNames = {"Film","Start","End","Room","Price","Seats","Buy",""};
		model.setColumnIdentifiers(columnNames);
		
		LinkedList<Projection> list= (LinkedList<Projection>) contruser.findProjections();
		for (Projection pj : list) {
			  Object[] obj = new Object[8];
			  Integer notavailable = contruser.seatsNotAvailableProjection(pj.getIdpj());
			  Integer roomseats = contruser.nameRoom(pj.getIdsala()).getPosti();
			  obj[0] = contruser.nameFilm(pj.getIdfilm());
			  obj[1] = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(pj.getStartpj());
			  obj[2] = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(pj.getEndpj());
			  obj[3] = contruser.nameRoom(pj.getIdsala()).getDescrizione();
			  obj[4] = pj.getPrice()+"€";
			  obj[5] = notavailable+"/"+roomseats;
			  if(notavailable.equals(roomseats)) {
				  obj[6] = "SOLD OUT";
			  }else {
				  obj[6] = "BUY";  				  
			  }
			  obj[7] = pj.getIdpj();
			  model.addRow(obj);
			}
		
		//Jtable not editable
		JTable table = new JTable(model){  
			/****/
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column){
		        Object value = getModel().getValueAt(row, column);
				return column == 6 && value.equals("BUY") ? true : false;
		    }  
        };
        //change rendere
        table.setDefaultRenderer(Object.class, new MyTableCellRender());
        
        //Width
        table.getColumnModel().getColumn(6).setMaxWidth(120);
        table.getColumnModel().getColumn(6).setMinWidth(120);
        table.getColumnModel().getColumn(5).setMaxWidth(60);
        table.getColumnModel().getColumn(5).setMinWidth(60);
        table.getColumnModel().getColumn(4).setMaxWidth(60);
        table.getColumnModel().getColumn(4).setMinWidth(60);
        table.getColumnModel().getColumn(0).setMinWidth(350);
        table.getColumnModel().getColumn(0).setMaxWidth(350);
        
        //No drag
        table.getTableHeader().setReorderingAllowed(false);
        
        //Invisible Column
        table.getColumnModel().getColumn(7).setMinWidth(0);
        table.getColumnModel().getColumn(7).setMaxWidth(0);
        
        //Action table button
        Action delete = new AbstractAction(){
            /****/
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
            	String film = table.getValueAt(table.getSelectedRow(), 0).toString();
            	String projectionstart = table.getValueAt(table.getSelectedRow(), 1).toString();
            	String projectionend = table.getValueAt(table.getSelectedRow(), 2).toString();
            	String room = table.getValueAt(table.getSelectedRow(), 3).toString();
            	String price = table.getValueAt(table.getSelectedRow(), 4).toString();
            	Integer seats = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString().split("/")[0])+1;
            	Integer idpj = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 7).toString());
            	TicketJframe ticket = new TicketJframe(idpj,price,film,room,projectionstart,projectionend,seats);	
            	ticket.setVisible(true);
            	dispose();
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(table, delete, 6);
        
        buttonColumn.setMnemonic(KeyEvent.VK_D);
		table.setSize(getWidth(),getHeight());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0,getWidth(),getHeight());
		getContentPane().add(scrollPane);	
	}
}
