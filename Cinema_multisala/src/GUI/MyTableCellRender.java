package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
class MyTableCellRender extends DefaultTableCellRenderer {
  
	public MyTableCellRender() {
		setOpaque(true);
	}
	  
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	  
		if(getText().equals("SOLD OUT")) {
			setBackground(Color.red);
			setForeground(Color.black);
			System.out.println("A");
		}
		System.out.println(value.toString());
		setText(value !=null ? value.toString() : "");	
	    return this;
	}
}