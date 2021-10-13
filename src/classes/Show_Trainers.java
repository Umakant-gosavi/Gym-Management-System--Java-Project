package classes;

import java.sql.*;
//import com.mysql.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Show_Trainers extends JFrame {
	
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	
	 
	private JPanel contentPane;
	private JTable trainertable;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Show_Trainers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show_Trainers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show_Trainers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show_Trainers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_Trainers frame = new Show_Trainers();
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
	public Show_Trainers() {
		con=Connect.connectDb();
		setTitle("Mass Gym || All Trainers");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 882, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 866, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton brefresh = new JButton("Refresh");
		brefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		brefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try
				{
					String sql = "select id as'ID', trainer_name as 'Trainer Name', contact_No as 'Contact No', address as 'Address',join_date as 'Join Date', certification as 'Certification',experience as 'Experience', type as 'Experties' from trainer";
					con=Connect.connectDb();
		            pst=con.prepareStatement(sql);
		            rs=pst.executeQuery();
		          //  rs.next();
		            trainertable.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ms)
				{
					
				}
			}
		});
		brefresh.setBounds(10, 11, 89, 23);
		panel.add(brefresh);
		
		JButton badd = new JButton("Add");
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Trainer trainers=new Add_Trainer();
				trainers.show();
			}
		});
		badd.setFont(new Font("Tahoma", Font.BOLD, 14));
		badd.setBounds(109, 11, 89, 23);
		panel.add(badd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con= Connect.connectDb();
					
					int row= trainertable.getSelectedRow();
					if(row>0)
					{
						int p=JOptionPane.showConfirmDialog(null,"Are you sure to delete" , "Delete Confirmation", JOptionPane.YES_NO_OPTION);
						if(p==0)
						{
							
						String table_click=trainertable.getModel().getValueAt(row,0).toString();
					String sql="Delete from trainer where id="+table_click+"";
					pst=con.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(trainertable, "Deleted successfully");
					}
					}
					else {
						JOptionPane.showMessageDialog(trainertable, "Pleasse select any history");
						
						
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnDelete.setBounds(208, 13, 89, 23);
		panel.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="select trainer_name as 'Trainer Name', contact_No as 'Contact No', address as 'Address',join_date as 'Join Date', certification as 'Certification',experience as 'Experience', type as 'Experties'from trainer where id="+txtSearch.getText();
		        try{
		        	con=Connect.connectDb();
		            pst=con.prepareStatement(sql);
		            rs=pst.executeQuery();
		           if( rs.next())
		           {
		        	   trainertable.setModel(DbUtils.resultSetToTableModel(rs));
		           		           }
		           else {
		        	   JOptionPane.showMessageDialog(null, "There is no any data having ID:"+txtSearch.getText()+"");
		           }
		           pst.close();
		 		    rs.close();
		 		    con.close();
		            
		        }
		        catch(Exception e)
		        {
		            JOptionPane.showMessageDialog(null,e);
		        }
		        finally{
			    	   try {
			    		   pst.close();
			    		   rs.close();
			    		   con.close();
			    	   }
			        	catch(Exception e){
			        		
			        	}
			        }
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(747, 11, 89, 23);
		panel.add(btnSearch);
		
		JLabel lblTrainerId = new JLabel("Trainer ID");
		lblTrainerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrainerId.setBounds(491, 14, 105, 17);
		panel.add(lblTrainerId);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel table = (DefaultTableModel)trainertable.getModel();
		        String search = txtSearch.getText();
		        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
		        trainertable.setRowSorter(tr);
		        tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSearch.setBounds(578, 14, 143, 18);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 42, 856, 423);
		contentPane.add(scrollPane);
		
		trainertable = new JTable();
		scrollPane.setViewportView(trainertable);
	}
}
