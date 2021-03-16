package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Controllers.Controller;
import Entity.Room;
import ImportedClass.ButtonColumn;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class RoomsJframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private JTextField textFieldFilter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomsJframe frame = new RoomsJframe();
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
	public RoomsJframe() {
		Controller controller = new Controller();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    setSize(screenSize.width/2, screenSize.height/2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Rooms");
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TodayProjectionsJframe projectionsjf = new TodayProjectionsJframe();
				projectionsjf.setVisible(true);
				dispose();
			}
		});
		
		DefaultTableModel model = new DefaultTableModel();

		String[] columnNames = {"Description","Audio","Video tech.","Seats.","Delete",""};
		model.setColumnIdentifiers(columnNames);
		
		LinkedList<Room> list= (LinkedList<Room>) controller.getRooms();
		for (Room room : list) {
			  Object[] obj = new Object[6];
			  obj[0] = room.getDescription();
			  obj[1] = room.getTechaudiodesc();
			  obj[2] = room.getTechprojdesc();
			  obj[3] = room.getSeats();
			  obj[4] = "DELETE";
			  obj[5] = room.getIdroom();
			  model.addRow(obj);
			}
		
		//Jtable not editable
		JTable table = new JTable(model){  
			/****/
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row,int column){
		        Object value = getModel().getValueAt(row, column);
				return column == 4 && value.equals("DELETE") ? true : false;
		    }  
        };
        //Sorter
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        
        //No drag
        table.getTableHeader().setReorderingAllowed(false);
        
        //Width Columns
        table.getColumnModel().getColumn(0).setMinWidth(200);
        table.getColumnModel().getColumn(0).setMaxWidth(200);
        table.getColumnModel().getColumn(1).setMinWidth(200);
        table.getColumnModel().getColumn(1).setMaxWidth(200);
        table.getColumnModel().getColumn(2).setMinWidth(200);
        table.getColumnModel().getColumn(2).setMaxWidth(200);
        table.getColumnModel().getColumn(3).setMinWidth(50);
        table.getColumnModel().getColumn(3).setMaxWidth(50);
                
        //Invisible Column
        table.getColumnModel().getColumn(5).setMinWidth(0);
        table.getColumnModel().getColumn(5).setMaxWidth(0);
        
        
        //Action table button
        Action delete = new AbstractAction(){
            /****/
			private static final long serialVersionUID = 1L;
			//Delete film
			public void actionPerformed(ActionEvent e){
				String text = "Do you want to delete the room?";
				if(JOptionPane.showConfirmDialog(null, text, "Delete room", 0, 1, null) == 0) {
					Integer idroom =  Integer.parseInt(table.getValueAt(table.getSelectedRow(),5).toString());
					sorter.setRowFilter(null);
					model.removeRow(table.getSelectedRow());
					if(controller.deleteRoom(idroom) > 0) {
						JOptionPane.showMessageDialog(null , "Deleted successfully");
						textFieldFilter.setText("");
					}else JOptionPane.showMessageDialog(null , "Nothing deleted");
				}
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(table, delete, 4);
        
        buttonColumn.setMnemonic(KeyEvent.VK_D);
		getContentPane().setLayout(null);
		table.setSize(getWidth(),getHeight());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 20,944,481);
		getContentPane().add(scrollPane);	
		
		textFieldFilter = new JTextField();
		textFieldFilter.setBounds(98, 0, 280, 20);
		getContentPane().add(textFieldFilter);
		textFieldFilter.setColumns(10);
		
		JButton btnNewFilm = new JButton("New room");
		btnNewFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertRoomJframe insertroomjf = new InsertRoomJframe();
				insertroomjf.setVisible(true);
				dispose();
			}
		});
		btnNewFilm.setBounds(388, -1, 101, 23);
		getContentPane().add(btnNewFilm);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodayProjectionsJframe pjframe =  new TodayProjectionsJframe();
				pjframe.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(499, -1, 89, 23);
		getContentPane().add(btnBack);
		
		//Filter
		JLabel lblFilter = new JLabel("Filter");
		lblFilter.setBounds(10, 3, 46, 14);
		getContentPane().add(lblFilter);
		textFieldFilter.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				filter();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				filter();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				filter();
			}
		    // implement the methods
			public void filter() {
				sorter.setRowFilter(RowFilter.regexFilter("(?i)" +textFieldFilter.getText()));
			}
		});
	}
}
