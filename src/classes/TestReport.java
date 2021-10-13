package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
public class TestReport extends JFrame {
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestReport frame = new TestReport();
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
	public void showTrainers()
	{
		try
		{
			String sql = "select id as'ID', trainer_name as 'Trainer Name', contact_No as 'Contact No', address as 'Address',join_date as 'Join Date', certification as 'Certification',experience as 'Experience', type as 'Experties' from trainer";
			con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next();
            table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception ms)
		{
			
		}
	}
	
	public void showMembers()
	{
		String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',contact_no as 'Contact No',address as 'Address',age as 'Age',reg_date as 'Join Date',end_date as 'End Date',duration as 'Duration',total_fee as 'Total Fee',paid_fee as 'Paid Fee',status as 'Status' from members where status='Balance'";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next();
           table.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
 		    rs.close();
 		    con.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
	}
	public TestReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 825, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox csel = new JComboBox();
		csel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String val = (String)csel.getSelectedItem();
				if(val.equals("All Members"))
				{
					showMembers();
				}
			}
		});
		csel.setModel(new DefaultComboBoxModel(new String[] {"All Members", "All Trainers"}));
		csel.setBounds(20, 23, 158, 22);
		contentPane.add(csel);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = (String)csel.getSelectedItem();
				if(value.equals("All Trainers"))
				{
					showTrainers();
				}
			}
		});
		btnShow.setBounds(199, 22, 89, 23);
		contentPane.add(btnShow);
	}
}
