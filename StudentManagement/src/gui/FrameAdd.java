package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.BangDiem;
import model.SinhVien;

public class FrameAdd extends JFrame {

	private JTextField textMSSV;
	private JTextField txtTen;
	private JTextField textLop;
	private JTextField textNgaySinh;
	private JTextField textDiaChi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAdd window = new FrameAdd();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameAdd() {
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
		label.setBounds(28, 68, 62, 14);
		this.getContentPane().add(label);
		
		textMSSV = new JTextField();
		textMSSV.setColumns(10);
		textMSSV.setBounds(112, 65, 247, 20);
		this.getContentPane().add(textMSSV);
		
		JLabel label_1 = new JLabel("T\u00EAn");
		label_1.setBounds(28, 112, 62, 14);
		this.getContentPane().add(label_1);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(112, 109, 247, 20);
		this.getContentPane().add(txtTen);
		
		JLabel label_2 = new JLabel("T\u00EAn L\u1EDBp");
		label_2.setBounds(28, 156, 62, 14);
		this.getContentPane().add(label_2);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y Sinh");
		lblNgySinh.setBounds(28, 200, 76, 14);
		this.getContentPane().add(lblNgySinh);
		
		textLop = new JTextField();
		textLop.setColumns(10);
		textLop.setBounds(111, 153, 248, 20);
		this.getContentPane().add(textLop);
		
		textNgaySinh = new JTextField();
		textNgaySinh.setColumns(10);
		textNgaySinh.setBounds(111, 197, 248, 20);
		this.getContentPane().add(textNgaySinh);
		
		JLabel label_4 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		label_4.setBounds(28, 241, 62, 14);
		this.getContentPane().add(label_4);
		
		textDiaChi = new JTextField();
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(111, 238, 248, 20);
		this.getContentPane().add(textDiaChi);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		Image img1= new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnAdd.setIcon(new ImageIcon(img1));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int acction=JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Chắn Thêm ?","Thêm",JOptionPane.YES_NO_OPTION);
				if(acction==0)
				{
				try {
					if (textNgaySinh.getText().equals("")) 
						{
						JOptionPane.showMessageDialog(null, "Phải Nhập Thông Tin Ngày Sinh");
						return;
						}
					SinhVien S1= new SinhVien(textMSSV.getText(),txtTen.getText(),textLop.getText(),Date.valueOf(textNgaySinh.getText()),textDiaChi.getText());
					SinhVien.add(S1);
					BangDiem D1=new BangDiem(textMSSV.getText(),"","M01",0);
					BangDiem.addBD(D1);
					BangDiem D2=new BangDiem(textMSSV.getText(),"","M02",0);
					BangDiem.addBD(D2);
					BangDiem D3=new BangDiem(textMSSV.getText(),"","M03",0);
					BangDiem.addBD(D3);
					JOptionPane.showMessageDialog(null,"DATA Save" );
					SinhVien.Reset();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Lỗi Trùng Mã Sinh Viên");
					setVisible(false);
					
					e.printStackTrace();
				}
				}
			}
		});
		btnAdd.setBounds(111, 280, 114, 23);
		
		this.getContentPane().add(btnAdd);
		
		JButton btncancel = new JButton("Cancel");
		btncancel.setHorizontalAlignment(SwingConstants.LEFT);
		Image img2= new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		btncancel.setIcon(new ImageIcon(img2));
		
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int acction=JOptionPane.showConfirmDialog(null,"Bạn Có Muốn Thoát","Thoát",JOptionPane.YES_NO_OPTION);
				if (acction==0)
				setVisible(false);
			}
		});
		btncancel.setBounds(252, 280, 107, 23);
		this.getContentPane().add(btncancel);
	}
	
}
