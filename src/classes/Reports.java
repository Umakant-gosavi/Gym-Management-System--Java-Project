package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reports extends JFrame {

	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	 
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
	
	public void allMembers()
	{
		String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',contact_no as 'Contact No',address as 'Address',age as 'Age',reg_date as 'Join Date',end_date as 'End Date',duration as 'Duration',total_fee as 'Total Fee',paid_fee as 'Paid Fee',status as 'Status' from members";
        //String sql = "select * from members";
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
	
	public void paidFeeMembers()
	{
		String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',contact_no as 'Contact No',address as 'Address',age as 'Age',reg_date as 'Join Date',end_date as 'End Date',duration as 'Duration',total_fee as 'Total Fee',paid_fee as 'Paid Fee',status as 'Status' from members where status='Paid'";
        
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
	
	public void balanceFeeMembers()
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
	
	public void studentMembers()
	{
		String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',contact_no as 'Contact No',occupation as 'Occupation',address as 'Address',age as 'Age',reg_date as 'Join Date',end_date as 'End Date',duration as 'Duration',total_fee as 'Total Fee',paid_fee as 'Paid Fee',status as 'Status' from members where occupation='Student'";
        
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
            //JOptionPane.showMessageDialog(null,e);
        	JOptionPane.showMessageDialog(null,"No Data Availabel");
        }
	}
	
	public void employeeMembers()
	{
		String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',contact_no as 'Contact No',occupation as 'Occupation',address as 'Address',age as 'Age',reg_date as 'Join Date',end_date as 'End Date',duration as 'Duration',total_fee as 'Total Fee',paid_fee as 'Paid Fee',status as 'Status' from members where occupation='Employee'";
        
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
            //JOptionPane.showMessageDialog(null,e);
        	JOptionPane.showMessageDialog(null,"No Data Availabel");
        }
	}
	
	public void builderMembers()
	{
		String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',contact_no as 'Contact No',occupation as 'Occupation',address as 'Address',age as 'Age',reg_date as 'Join Date',end_date as 'End Date',duration as 'Duration',total_fee as 'Total Fee',paid_fee as 'Paid Fee',status as 'Status' from members where occupation='Bodybuilding'";
        
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
            //JOptionPane.showMessageDialog(null,e);
        	JOptionPane.showMessageDialog(null,"No Data Availabel");
        }
	}
	public Reports() {
		setTitle("Mass Gym || Reports");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 595);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cselect = new JComboBox();
		cselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = (String)cselect.getSelectedItem();
				
				if(value.equals("Show All Members"))
				{
					allMembers();
				}
				else if(value.equals("Paid Fees Members"))
				{
					paidFeeMembers();
				}
				else if(value.equals("Balance Fees Members"))
				{
					balanceFeeMembers();
				}
				else if(value.equals("Students in Gym"))
				{
					studentMembers();
				}
				else if(value.equals("Employees in Gym"))
				{
					employeeMembers();
				}
				else if(value.equals("Bodybuilders in Gym"))
				{
					builderMembers();
				}
			}
		});
		cselect.setForeground(Color.BLUE);
		cselect.setFont(new Font("Tahoma", Font.BOLD, 15));
		cselect.setModel(new DefaultComboBoxModel(new String[] {"Select Options", "Show All Members", "Paid Fees Members", "Balance Fees Members", "Students in Gym", "Employees in Gym", "Bodybuilders in Gym", "Show All Equipments", "Electronic Equipments", "Non-Electronics Equipments", "Show All Products", "Show Protein Supplements", "Show Gainer Supplements", "Show Creatine Supplements", "Show Sell Products Details"}));
		cselect.setMaximumRowCount(10);
		cselect.setBounds(10, 11, 253, 26);
		contentPane.add(cselect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 48, 1074, 509);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
