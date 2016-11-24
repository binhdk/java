package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class about extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					about frame = new about();
					frame.setTitle("ABOUT");
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
	public about() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(337, 45, 46, 52);
		getContentPane().add(lblNewLabel);
		//setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ok = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/key-icon.png")).getImage();
		ok.setIcon(new ImageIcon(img));
		ok.setBounds(332, -8, 92, 123);
		contentPane.add(ok);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u00F3m Th\u1EF1c Hi\u1EC7n:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(10, 28, 110, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tr\u1EA7n Tr\u1ECDng \u0110\u1EA1o");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(122, 15, 120, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nguy\u1EC5n Duy Thi\u1EC7n");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(151, 40, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNguynVnBnh = new JLabel("Nguy\u1EC5n V\u0103n B\u00ECnh");
		lblNguynVnBnh.setForeground(Color.CYAN);
		lblNguynVnBnh.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNguynVnBnh.setBounds(175, 65, 108, 14);
		contentPane.add(lblNguynVnBnh);
		
		JLabel lblBiHongc = new JLabel("B\u00F9i Ho\u00E0ng \u0110\u1EE9c");
		lblBiHongc.setForeground(Color.GREEN);
		lblBiHongc.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBiHongc.setBounds(193, 89, 90, 14);
		contentPane.add(lblBiHongc);
		
		JLabel lblPhmQuangTh = new JLabel("Ph\u1EA1m Quang Th\u1ECD");
		lblPhmQuangTh.setForeground(Color.BLUE);
		lblPhmQuangTh.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPhmQuangTh.setBounds(221, 114, 108, 14);
		contentPane.add(lblPhmQuangTh);
		
		JLabel lblNewLabel_4 = new JLabel("\u0110\u01B0\u1EDDng D\u00E2y N\u00F3ng:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(207, 139, 115, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("01654647262");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_5.setBounds(305, 139, 71, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u0110\u1ECBa Ch\u1EC9:");
		lblNewLabel_6.setBounds(33, 182, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u0110H GTVT TPHCM");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(94, 182, 340, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("C\u1EA3m \u01A1n ace \u0111\u00E3 s\u1EED d\u1EE5ng S\u1EA3n ph\u1EA9m.");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblNewLabel_8.setBounds(143, 237, 200, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("C\u01A1 s\u1EDF 2:210 Tr\u1EA7n N\u00E3o,Qu\u1EADn 2.");
		lblNewLabel_9.setBounds(104, 212, 225, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("C\u01A1 S\u1EDF 3:10 T\u00F4 K\u00FD,ph\u01B0\u1EDDng T\u00E2n Ch\u00E1nh Hi\u1EC7p,Qu\u1EADn  12.");
		lblNewLabel_10.setBounds(106, 223, 297, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("C\u01A1 S\u1EDF 1:D3,ph\u01B0\u1EDDng 25,qu\u1EADn B\u00ECnh Th\u1EA1nh.");
		lblNewLabel_11.setBounds(104, 198, 254, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblEmailtrngdahtgmailcom = new JLabel("Email:PhongD401KM14B@gmail.com");
		lblEmailtrngdahtgmailcom.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEmailtrngdahtgmailcom.setBounds(215, 157, 188, 14);
		contentPane.add(lblEmailtrngdahtgmailcom);
		
		JLabel icone = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/1233.jpg")).getImage();
		icone.setIcon(new ImageIcon(img1));
		icone.setBounds(0, 65, 183, 106);
		contentPane.add(icone);
		
		JButton btnok = new JButton("OK");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnok.setBounds(10, 232, 81, 23);
		contentPane.add(btnok);
	}
}
