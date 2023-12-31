package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import connectDB.ConnectDB;
import dao.DAO_NhanVien;
import dao.DAO_account;
import entity.userInfo;

import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoptionChangePwd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DAO_account daoAccout;
	private JPasswordField txtNewPwd;
	private JPasswordField txtConfirm;
	private boolean flagFirst;
	private boolean flagSecond;
	private boolean flagThird;
	private JPasswordField txtPasswordCu;
	private String sdt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JoptionChangePwd dialog = new JoptionChangePwd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JoptionChangePwd() {
//		System.out.println(userInfo.sdt);
		flagFirst = false;
		flagSecond = false;
		flagThird = false;
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		daoAccout = new DAO_account();

		setBounds(100, 100, 703, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập Mật Khẩu Cũ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(160, 38, 149, 43);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNhpMtKhu = new JLabel("Nhập Mật Khẩu Mới");
		lblNhpMtKhu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNhpMtKhu.setBounds(160, 116, 149, 43);
		contentPanel.add(lblNhpMtKhu);
		
		JLabel lblNhpMtKhu_1 = new JLabel("Nhập Mật Khẩu Mới");
		lblNhpMtKhu_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNhpMtKhu_1.setBounds(160, 201, 149, 43);
		contentPanel.add(lblNhpMtKhu_1);
		
		txtNewPwd = new JPasswordField();
		txtNewPwd.setBounds(319, 113, 243, 51);
		contentPanel.add(txtNewPwd);
		txtNewPwd.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusLost(FocusEvent e){
				if(txtNewPwd.getText().toString().trim().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,"Không Được Để Trống");
					flagSecond = false;
				}else {
					flagSecond = true;
				}
			}
		});
		
		txtConfirm = new JPasswordField();
		txtConfirm.setBounds(319, 193, 243, 51);
		txtConfirm.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusLost(FocusEvent e){
				if(!txtNewPwd.getText().toString().trim().equalsIgnoreCase(txtNewPwd.getText().toString().trim())) {
					JOptionPane.showMessageDialog(null,"Không Được Để Trống");
					flagThird = false;
				}else {
					flagThird = true;
				}
			}
		});
		
		contentPanel.add(txtConfirm);
		
		txtPasswordCu = new JPasswordField();
		txtPasswordCu.setBounds(317, 38, 245, 43);
		contentPanel.add(txtPasswordCu);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						System.out.println(userInfo.sdt);
						if(checkFirst()) {
							if(checkEmpty()) {
								if(checkTrung()) {
									
									daoAccout = new DAO_account();
									daoAccout.ChangePwd(userInfo.sdt,txtNewPwd.getText().toString());
									dispose();
									JOptionPane.showMessageDialog(null,"Đổi mật khẩu thành công!!");
								}else {
									JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu 1 cách chính xác!!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Không được để trống!!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Mật khẩu cũ không chính xác!!");
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private boolean checkFirst() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		daoAccout = new DAO_account();
		DAO_NhanVien nv = new DAO_NhanVien();
		if(txtPasswordCu.getText().toString().equalsIgnoreCase(nv.getPwdForChange(userInfo.maNV))) {
			return true;
		}
		return false;
	}
	private boolean checkEmpty() {
		if(txtNewPwd.getText().toString().equalsIgnoreCase("") || txtConfirm.getText().toString().equalsIgnoreCase("")) {
			return false;
		}
		return true;

	}
	private boolean checkTrung() {
		if(txtNewPwd.getText().toString().equalsIgnoreCase(txtConfirm.getText().toString()))
			return true;
		return false;
	}
}
