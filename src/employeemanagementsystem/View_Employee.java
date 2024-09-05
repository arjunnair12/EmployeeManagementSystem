package employeemanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;



public class View_Employee extends JFrame implements ActionListener{

	Choice choiceEMP;
	JTable table;
	JButton searchbtn, print, update, back;

	public View_Employee() {

		getContentPane().setBackground(new Color(255, 131, 122));
		JLabel search = new JLabel("Search by employee id");
		search.setBounds(20, 20, 150, 20);
		add(search);

		choiceEMP = new Choice();
		choiceEMP.setBounds(180, 20, 150, 20);
		add(choiceEMP);

		try {
			Conn c = new Conn();
			ResultSet resultset = c.statement.executeQuery("select * from employee");
			while (resultset.next()) {
				choiceEMP.add(resultset.getString("empID"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		table = new JTable();
		try {
			Conn c = new Conn();
			ResultSet resultset = c.statement.executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(resultset));
		} catch (Exception E) {
			E.printStackTrace();
		}

		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(0, 100, 900, 600);
		add(jp);

		searchbtn = new JButton("Search");
		searchbtn.setBounds(20, 70, 80, 20);
		searchbtn.addActionListener(this);
		add(searchbtn);

		print = new JButton("Print");
		print.setBounds(120, 70, 80, 20);
		print.addActionListener(this);
		add(print);

		update = new JButton("Update");
		update.setBounds(220, 70, 80, 20);
		update.addActionListener(this);
		add(update);

		back = new JButton("Back");
		back.setBounds(320, 70, 80, 20);
		back.addActionListener(this);
		add(back);

		setSize(900, 700);
		setLocation(300, 100);
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchbtn) {
			String query = "select * from employee where empId = '"+choiceEMP.getSelectedItem()+"'";
					try {
						Conn c = new Conn();
						ResultSet resultset = c.statement.executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(resultset));
					}catch(Exception S) {
						S.printStackTrace();
					}
		}else if (e.getSource() == print) {
			try {
				table.print();
			}catch(Exception S) {
				S.printStackTrace();
				
			}
		}else if (e.getSource() == update) {
			setVisible(false);
			new UpdateEmployee(choiceEMP.getSelectedItem());
			
			
			
		}else {
			new Main_class();
			setVisible(false);
		}
		
		
		
	}

	public static void main(String[] args) {
		new View_Employee();
	}
}
