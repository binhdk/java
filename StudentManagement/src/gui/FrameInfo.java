package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dal.DAO;

import model.SinhVien;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;

public class FrameInfo  extends JFrame{
	private JTextField textMSSV;
	private JTextField textTen;
	private JTextField textLop;
	private JTextField textDate;
	private JTextField textDiaChi;
	private JTextField textDiem1;
	private JTextField textDiem2;
	private JTextField textDiem3;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInfo window = new FrameInfo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 459, 478);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		JLabel label = new JLabel("MSSV");
		label.setBounds(43, 29, 62, 14);
		this.getContentPane().add(label);
		
		textMSSV = new JTextField();
		textMSSV.setColumns(10);
		textMSSV.setBounds(157, 26, 210, 20);
		this.getContentPane().add(textMSSV);
		
		JLabel label_1 = new JLabel("T\u00EAn");
		label_1.setBounds(43, 60, 62, 14);
		this.getContentPane().add(label_1);
		
		textTen = new JTextField();
		textTen.setColumns(10);
		textTen.setBounds(157, 57, 210, 20);
		this.getContentPane().add(textTen);
		
		JLabel label_2 = new JLabel("T\u00EAn L\u1EDBp");
		label_2.setBounds(43, 96, 62, 14);
		this.getContentPane().add(label_2);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y Sinh");
		lblNgySinh.setBounds(43, 129, 76, 14);
		this.getContentPane().add(lblNgySinh);
		
		textLop = new JTextField();
		textLop.setColumns(10);
		textLop.setBounds(157, 92, 210, 20);
		this.getContentPane().add(textLop);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(157, 123, 210, 20);
		this.getContentPane().add(textDate);
		
		JLabel label_4 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		label_4.setBounds(43, 157, 62, 14);
		this.getContentPane().add(label_4);
		
		textDiaChi = new JTextField();
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(157, 154, 210, 20);
		this.getContentPane().add(textDiaChi);
		
		JLabel lblimMn = new JLabel("\u0110i\u1EC3m M\u00F4n 1");
		lblimMn.setBounds(43, 193, 76, 14);
		this.getContentPane().add(lblimMn);
		
		textDiem1 = new JTextField();
		textDiem1.setColumns(10);
		textDiem1.setBounds(157, 190, 210, 20);
		this.getContentPane().add(textDiem1);
		
		JLabel lblimMn_1 = new JLabel("\u0110i\u1EC3m M\u00F4n 2");
		lblimMn_1.setBounds(43, 224, 76, 14);
		this.getContentPane().add(lblimMn_1);
		
		textDiem2 = new JTextField();
		textDiem2.setColumns(10);
		textDiem2.setBounds(157, 221, 210, 20);
		this.getContentPane().add(textDiem2);
		
		JLabel lblimMn_2 = new JLabel("\u0110i\u1EC3m M\u00F4n 3");
		lblimMn_2.setBounds(43, 254, 76, 14);
		this.getContentPane().add(lblimMn_2);
		
		textDiem3 = new JTextField();
		textDiem3.setColumns(10);
		textDiem3.setBounds(157, 254, 210, 20);
		this.getContentPane().add(textDiem3);
		
		JButton btnUpdate = new JButton("S\u1EEDa");
		Image img2= new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		btnUpdate.setIcon(new ImageIcon(img2));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int acction=JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Chắn ?","UPDATE",JOptionPane.YES_NO_OPTION);
				if(acction==0)
				{
					Listener.update( textMSSV, textTen, textLop, textDate, textDiaChi, textDiem1, textDiem2, textDiem3 );
					try {
						SinhVien.Reset();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
			}
		});
		btnUpdate.setBounds(157, 319, 89, 23);
		this.getContentPane().add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		Image img1= new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		btnCancel.setIcon(new ImageIcon(img1));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(256, 319, 93, 23);
		this.getContentPane().add(btnCancel);
	}
	
	public  void display(JTable t) {
		
	int row = t.getSelectedRow();
	textMSSV.setText(t.getValueAt(row, 0).toString());
	textTen.setText(t.getValueAt(row, 1).toString());
	textLop.setText(t.getValueAt(row, 2).toString());
	textDate.setText(t.getValueAt(row, 3).toString());
	textDiaChi.setText(t.getValueAt(row,4).toString());
	String s=textMSSV.getText();
	String query="select DIEM from BANGDIEM where MASV='"+s+"'";
		ResultSet rs = null;
	try {
		rs = DAO.getResultSet(query);
	} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(getParent(), "loi load class");
		e.printStackTrace();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(getParent(), "loi sql");
		e.printStackTrace();
	}
	 String []s2 =new String[3];
	 int i=0;
	try {
		while(rs.next()){
			s2[i]=rs.getString(1);
			i++;
		}
		textDiem1.setText(String.valueOf(s2[0]==null?"":s2[0]));
		textDiem2.setText(String.valueOf(s2[1]==null?"":s2[1]));
		textDiem3.setText(String.valueOf(s2[2]==null?"":s2[2]));
		rs.close();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "loi sql");
		e.printStackTrace();
	}
	
}
}
