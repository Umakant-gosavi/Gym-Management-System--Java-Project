package classes;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Show_Equipments extends JFrame {

	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	private JPanel contentPane;
	private JTable equptable;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_Equipments frame = new Show_Equipments();
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
	public Show_Equipments() {
		setTitle("Mass Gym || Equipments");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 877, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 861, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(258, 11, 276, 32);
		panel.add(panel_1);
		
		JLabel lblAllEquipments = new JLabel("All Equipments");
		lblAllEquipments.setForeground(new Color(0, 0, 255));
		lblAllEquipments.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblAllEquipments);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String sql = "select ID as'ID', Name as 'Equipment Name', price as 'Cost', purdate as 'Purchase Date',dealer_name as 'Dealer Name', Type 'Type' from equipment";
					con=Connect.connectDb();
		            pst=con.prepareStatement(sql);
		            rs=pst.executeQuery();
		          //  rs.next();
		            equptable.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ms)
				{
					
				}
				
			}
		});
		btnRefresh.setForeground(Color.BLUE);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(10, 53, 89, 23);
		panel.add(btnRefresh);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Equipment eqp = new Add_Equipment();
				eqp.setVisible(true);
			}
		});
		btnAddNew.setForeground(Color.BLUE);
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddNew.setBounds(111, 55, 107, 23);
		panel.add(btnAddNew);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con= Connect.connectDb();
					
					int row= equptable.getSelectedRow();
					if(row>0)
					{
						int p=JOptionPane.showConfirmDialog(null,"Are you sure to delete" , "Delete Confirmation", JOptionPane.YES_NO_OPTION);
						if(p==0)
						{
							
						String table_click=equptable.getModel().getValueAt(row,0).toString();
					String sql="Delete from equipment where id="+table_click+"";
					pst=con.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(equptable, "Deleted successfully");
					}
					}
					else {
						JOptionPane.showMessageDialog(equptable, "Pleasse select any history");
						
						
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(228, 53, 89, 23);
		panel.add(btnDelete);
		
		JLabel lblEquipmentName = new JLabel("Equipment Name");
		lblEquipmentName.setForeground(Color.WHITE);
		lblEquipmentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEquipmentName.setBounds(556, 55, 125, 23);
		panel.add(lblEquipmentName);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel table = (DefaultTableModel)equptable.getModel();
		        String search = txtSearch.getText();
		        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
		        equptable.setRowSorter(tr);
		        tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		txtSearch.setBounds(687, 55, 164, 23);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 90, 861, 354);
		contentPane.add(scrollPane);
		
		equptable = new JTable();
		equptable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(equptable);
	}
}
