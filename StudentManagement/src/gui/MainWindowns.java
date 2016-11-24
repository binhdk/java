package gui;

import dal.*;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import java.awt.Button;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.BangDiem;
import model.SinhVien;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.SystemColor;

public class MainWindowns extends JFrame {

	public JFrame frame;
	private JTextField txtSearch;
	private static JTable table;
	public static JTable getTable() {
		return table;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowns window = new MainWindowns();
//					Dimension DimMax=Toolkit.getDefaultToolkit().getScreenSize();
//					window.frame.setMaximumSize(DimMax);
//					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					window.frame.setUndecorated(true);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindowns() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().show();

		JLabel lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD Sinh Vi\u00EAn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(233, 22, 270, 42);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(74, 70, 513, 67);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		txtSearch.setBounds(114, 24, 262, 20);
		panel.add(txtSearch);
		txtSearch.setColumns(10);

		JComboBox comboBoxSearch = new JComboBox();
		comboBoxSearch.setEditable(true);
		comboBoxSearch.setModel(new DefaultComboBoxModel(new String[] {
				"M\u00E3 SV", "T\u00EAn", "L\u1EDBp" }));
		comboBoxSearch.setBounds(10, 24, 78, 20);
		panel.add(comboBoxSearch);
		
				Button btnSearch = new Button("Search");
				btnSearch.setBounds(382, 22, 106, 22);
				panel.add(btnSearch);
				btnSearch.setBackground(Color.LIGHT_GRAY);
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							comboBoxSearch.getSelectedIndex();
							String mssv = txtSearch.getText().toString();
							if (comboBoxSearch.getSelectedIndex()==0)
						{
								DefaultTableModel mod = Listener.search(mssv);
								table.setModel(mod);
							
						}
							else if(comboBoxSearch.getSelectedIndex()==1)
							{
								DefaultTableModel mod = Listener.searchten(mssv);
								table.setModel(mod);
							}
							else if(comboBoxSearch.getSelectedIndex()==2)
							{
								DefaultTableModel mod = Listener.searchtenlop(mssv);
								table.setModel(mod);
							}
						}
					
					});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null,
				"Th\u00F4ng Tin Sinh Vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(26, 148, 577, 289);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(627, 148, 116, 292);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(230, 230, 250));
		btnAdd.setBounds(10, 21, 89, 23);
		panel_2.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameAdd S1 = new FrameAdd();
				S1.setTitle("Thêm Sinh Viên");

			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(230, 230, 250));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row =table.getSelectedRow();
				if (row < 0)
					JOptionPane.showMessageDialog(frame, "Chọn một người rồi sửa!");
				else {
					FrameInfo info = new FrameInfo();
					info.display(table);
				}
			}
		});
		btnUpdate.setBounds(10, 71, 89, 23);
		panel_2.add(btnUpdate);
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(230, 230, 250));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int i[] = table.getSelectedRows();
					if (i.length==0) {
						JOptionPane.showMessageDialog(null, "Hãy Chọn Hàng Bạn Muốn Xóa");
						return ;
					}
					int acction=JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Chắn?","Delete",JOptionPane.YES_NO_OPTION);
					if(acction==0)
					{
					DefaultTableModel model = new DefaultTableModel();
					int n=i.length;
					
					model = (DefaultTableModel) table.getModel();
					for (int count=n-1;count>=0;count--)
					{
					String s = table.getValueAt(i[count], 0).toString();
					SinhVien.remove(s);
					BangDiem.xoaDiem(s);
					model.removeRow(i[count]);
					table.setModel(model);

					}
				}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "FAIL DELETE");
					ex.printStackTrace();
				}
					
			}
		});
		btnDelete.setBounds(10, 126, 89, 23);
		panel_2.add(btnDelete);
		


		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnQunLThng = new JMenu("Danh M\u1EE5c");
		menuBar.add(mnQunLThng);

		JMenuItem mntmThot = new JMenuItem("Tho\u00E1t");
		mntmThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnQunLThng.add(mntmThot);

		JMenu mnNewMenu = new JMenu("Qu\u1EA3n l\u00FD ");
		menuBar.add(mnNewMenu);

		JMenuItem mntmThngTin_1 = new JMenuItem("Th\u00F4ng Tin");

		mntmThngTin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Listener.loadDulieu(table, true);
					btnDelete.setEnabled(true);
					btnUpdate.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(frame, "Lỗi kết nối");
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame,
							"Không kết nối vào được cơ sở dữ liệu");
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu.add(mntmThngTin_1);

		JMenuItem mntmim = new JMenuItem("\u0110i\u1EC3m");
	
		mntmim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Listener.loadDulieuDiem(table, true);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		mnNewMenu.add(mntmim);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about S3=new about();
				S3.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
	}
}
