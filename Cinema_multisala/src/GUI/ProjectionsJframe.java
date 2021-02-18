package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Controllers.Controller;
import Entity.Projection;
import ImportedClass.ButtonColumn;

public class ProjectionsJframe extends JFrame {

	private JTextField textFieldFilter;

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
		Controller controller = new Controller();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    setSize(screenSize.width/2, screenSize.height/2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Today Projections");
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

		String[] columnNames = {"Room","Film","Price","Start proj.","End proj.","Delete",""};
		model.setColumnIdentifiers(columnNames);
		
		LinkedList<Projection> list= (LinkedList<Projection>) controller.getProjections();
		for (Projection pj : list) {
			  Object[] obj = new Object[7];
			  obj[0] = pj.getRoomdescription();
			  obj[1] = pj.getFilmdescription();
			  obj[2] = pj.getPrice();
			  obj[3] = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(pj.getStartpj());
			  obj[4] = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(pj.getEndpj());
			  obj[5] = "DELETE";
			  obj[6] = pj.getIdpj();
			  model.addRow(obj);
			}
		
		//Jtable not editable
		JTable table = new JTable(model){  
			/****/
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row,int column){
		        Object value = getModel().getValueAt(row, column);
				return column == 5 && value.equals("DELETE") ? true : false;
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
        table.getColumnModel().getColumn(2).setMinWidth(50);
        table.getColumnModel().getColumn(2).setMaxWidth(50);
        table.getColumnModel().getColumn(3).setMinWidth(180);
        table.getColumnModel().getColumn(3).setMaxWidth(180);
        table.getColumnModel().getColumn(4).setMinWidth(180);
        table.getColumnModel().getColumn(4).setMaxWidth(180);
        table.getColumnModel().getColumn(5).setMinWidth(120);
        table.getColumnModel().getColumn(5).setMaxWidth(120);
                
        //Invisible Column
        table.getColumnModel().getColumn(6).setMinWidth(0);
        table.getColumnModel().getColumn(6).setMaxWidth(0);
        
        
        //Action table button
        Action delete = new AbstractAction(){
            /****/
			private static final long serialVersionUID = 1L;
			//Delete film
			public void actionPerformed(ActionEvent e){
				String text = "Do you want to delete the projection?";
				if(JOptionPane.showConfirmDialog(null, text, "Delete projection", 0, 1, null) == 0) {
					Integer idpj =  Integer.parseInt(table.getValueAt(table.getSelectedRow(),6).toString());
					sorter.setRowFilter(null);
					model.removeRow(table.getSelectedRow());
					if(controller.deleteProjection(idpj) > 0) {
						JOptionPane.showMessageDialog(null , "Deleted successfully");
						textFieldFilter.setText("");
					}else JOptionPane.showMessageDialog(null , "Nothing deleted");

				}
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(table, delete, 5);
        
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
		
		JButton btnNewProjection = new JButton("New projection");
		btnNewProjection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertProjectionJframe insertpjjf = new InsertProjectionJframe();
				insertpjjf.setVisible(true);
				dispose();
			}
		});
		btnNewProjection.setBounds(388, -1, 125, 23);
		getContentPane().add(btnNewProjection);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodayProjectionsJframe pjframe =  new TodayProjectionsJframe();
				pjframe.setVisible(true);
				dispose();
			}
		});
		btnUndo.setBounds(523, -1, 89, 23);
		getContentPane().add(btnUndo);
		
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
