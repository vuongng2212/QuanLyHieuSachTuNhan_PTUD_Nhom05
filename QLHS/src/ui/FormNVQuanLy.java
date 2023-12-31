package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entity.Country;
import entity.userInfo;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.border.BevelBorder;


public class FormNVQuanLy extends JFrame{
	List<Country>listCountries = new ArrayList<Country>();
//	private JPanel contentPane,westPanel, tblPanel;
	private JPanel contentPane;
	private JMenu mnBar, mnTrangChu, mnNhanVien, mnPCC, mnSanPham, mnThongKe;
	private JMenuItem mnTimNV, mnQLNV, mnTimSP, mnTaoPhieuDH,mnTaoLichLV;
	private JLabel lblBG;
	private Image img_logo = new ImageIcon(FormNVQuanLy.class.getResource("/image/bookStore.png")).getImage().getScaledInstance(280, 200,Image.SCALE_SMOOTH );
	private Image img_employee = new ImageIcon(FormNVQuanLy.class.getResource("/image/manager_customer.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH );
	private Image img_user = new ImageIcon(FormNVQuanLy.class.getResource("/image/user.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_logout = new ImageIcon(FormNVQuanLy.class.getResource("/image/logout.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_background = new ImageIcon(FormNVQuanLy.class.getResource("/image/title.jpg")).getImage().getScaledInstance(1920, 816,Image.SCALE_SMOOTH );
	private Image img_home = new ImageIcon(FormNVQuanLy.class.getResource("/image/home.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH );
	private Image img_product = new ImageIcon(FormNVQuanLy.class.getResource("/image/product_icon.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH );
	private Image img_ca = new ImageIcon(FormNVQuanLy.class.getResource("/image/shift.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH );
	private Image img_taoLich = new ImageIcon(FormNVQuanLy.class.getResource("/image/shift.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_help = new ImageIcon(FormNVQuanLy.class.getResource("/image/help.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH );
	private Image img_tim = new ImageIcon(FormNVQuanLy.class.getResource("/image/find.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_nhapsach = new ImageIcon(FormNVQuanLy.class.getResource("/image/import_book.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_PhieuDH = new ImageIcon(FormNVQuanLy.class.getResource("/image/deitailss.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_control = new ImageIcon(FormNVQuanLy.class.getResource("/image/control.jpg")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_thongKe = new ImageIcon(frmNV.class.getResource("/image/thongKe_icon.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_thongKeSP = new ImageIcon(frmNV.class.getResource("/image/thongKeSP.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	
	private PanelTimNV PnTimNV = new PanelTimNV();
	private PanelTaoPhieuNhapSach pnDH = new PanelTaoPhieuNhapSach();
	private PanelQLNV pnQLNV = new PanelQLNV();
	private PanelShift pnShift = new PanelShift();
	private PanelNhapSach pnNhapSach = new PanelNhapSach();
	private PanelTimSPFormQuanLy pnTimSach = new PanelTimSPFormQuanLy();
	private PanelThongKe pnThongKe = new PanelThongKe();
	private JLabel lblAccountIcon;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNVQuanLy frame = new FormNVQuanLy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormNVQuanLy() {
		setTitle("Nhan vien quan ly");
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1936,1056);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1936,1056);
		contentPane.setForeground(new Color(192, 192, 192));
		
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JPanel northPanel = new JPanel();
		northPanel.setBounds(0, 0, 1920, 200);
		northPanel.setForeground(new Color(192, 192, 192));
		northPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(northPanel);
		northPanel.setLayout(null);
		
		JLabel lblTenNV = new JLabel("User:");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenNV.setForeground(new Color(0, 0, 160));
		lblTenNV.setBounds(10, 970, 56, 14);
		northPanel.add(lblTenNV);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(img_logo));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(70, 11, 250, 150);
		northPanel.add(lblLogo);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(192, 192, 192));
		menuPanel.setBounds(396, 0, 1524, 60);
		northPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		JMenuBar mnBar = new JMenuBar();
		mnBar.setBorderPainted(false);
		mnBar.setBackground(new Color(192, 192, 192));
		mnBar.setBounds(0, 0, 1524, 60);
		mnBar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuPanel.add(mnBar);
		
		mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setIcon(new ImageIcon(img_home));
		mnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnTrangChu);
		
		mnNhanVien = new JMenu("Nhân viên");
		mnNhanVien.setIcon(new ImageIcon(img_employee));
		mnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		mnBar.add(mnNhanVien);
		
		
		
		mnTimNV = new JMenuItem("Tìm nhân viên");
		mnTimNV.setIcon(new ImageIcon(img_tim));
		mnTimNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnNhanVien.add(mnTimNV);
		
		mnQLNV = new JMenuItem("Quản lý nhân viên");
		mnQLNV.setIcon(new ImageIcon(img_control));
		mnQLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnNhanVien.add(mnQLNV);
		
		mnTaoPhieuDH = new JMenuItem("Tạo phiếu nhập sách");
		mnTaoPhieuDH.setIcon(new ImageIcon(img_PhieuDH));
		mnNhanVien.add(mnTaoPhieuDH);
		
		mnTaoPhieuDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnTaoPhieuDH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hidePanel();
				contentPane.add(pnDH);
				pnDH.setVisible(true);
			}
		});
		
		mnPCC = new JMenu("Lịch làm việc");
		mnPCC.setIcon(new ImageIcon(img_ca));
		mnPCC.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnPCC);
		
		mnTaoLichLV = new JMenuItem("Tạo lịch làm việc");
		mnTaoLichLV.setIcon(new ImageIcon(img_taoLich));
		mnTaoLichLV.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnPCC.add(mnTaoLichLV);
		
		mnSanPham = new JMenu("Sách");
		mnSanPham.setIcon(new ImageIcon(img_product));
		mnSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnSanPham);
		
		mnTimSP = new JMenuItem("Tìm sách");
		mnTimSP.setIcon(new ImageIcon(img_tim));
		mnTimSP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnSanPham.add(mnTimSP);
		
		JMenuItem mnNhapSach = new JMenuItem("Nhập sách");
		mnNhapSach.setIcon(new ImageIcon(img_nhapsach));
		mnNhapSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnSanPham.add(mnNhapSach);
		
		mnThongKe = new JMenu("Thống kê");
		mnThongKe.setIcon(new ImageIcon(img_thongKe));
		mnThongKe.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnThongKe);
		
		JMenuItem mnItemThongKe = new JMenuItem("Thống kê");
		mnItemThongKe.setIcon(new ImageIcon(img_thongKeSP));
		mnItemThongKe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnThongKe.add(mnItemThongKe);
		
		JLabel lblDate = new JLabel("");
		lblDate.setBounds(105, 161, 180, 18);
		northPanel.add(lblDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE,dd/MM/yyyy",new Locale("vi"));
		String currentDate = dateFormat.format(new Date());
		lblDate.setText(currentDate);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblAccountIcon = new JLabel("");
		lblAccountIcon.setIcon(new ImageIcon(img_user));
		lblAccountIcon.setBounds(1570, 139, 40, 40);
		northPanel.add(lblAccountIcon);
		
		JButton btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lg = new LoginForm(null);
				lg.setVisible(true);
				FormNVQuanLy.this.dispose();	
			}
		});
		btnLogOut.setBackground(new Color(192, 192, 192));
		btnLogOut.setIcon(new ImageIcon(img_logout));
		btnLogOut.setBounds(1880, 139, 40, 40);
		northPanel.add(btnLogOut);
		
		JLabel lblTenUser = new JLabel("");
		lblTenUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenUser.setBounds(1620, 145, 250, 34);
		northPanel.add(lblTenUser);
		lblTenUser.setText(userInfo.getTenNV());
		lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(img_background));
		lblBG.setBounds(0, 200, 1920, 816);
		hidePanel();
		contentPane.add(lblBG);
//		Xu ly su kien Panel
		mnTimNV.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hidePanel();
				contentPane.add(PnTimNV);
				PnTimNV.setVisible(true);
			}
		});
		mnQLNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hidePanel();
				contentPane.add(pnQLNV);
				pnQLNV.setVisible(true);
			}
		});
		mnTrangChu.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				hidePanel();
				contentPane.add(lblBG);
			}
		});
		mnTaoLichLV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hidePanel();
				contentPane.add(pnShift);
				pnShift.setVisible(true);
			}
		});
		mnNhapSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hidePanel();
				contentPane.add(pnNhapSach);
				pnNhapSach.setVisible(true);
			}
		});
		mnTimSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hidePanel();
				contentPane.add(pnTimSach);
				pnTimSach.setVisible(true);
			}
		});	
		mnItemThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hidePanel();
				contentPane.add(pnThongKe);
				pnThongKe.setVisible(true);
			}
		});	
}
	public void hidePanel() {
		contentPane.remove(lblBG);
		PnTimNV.setVisible(false);
		pnDH.setVisible(false);
		pnQLNV.setVisible(false);
		pnShift.setVisible(false);
		pnNhapSach.setVisible(false);
		pnTimSach.setVisible(false);
		pnThongKe.setVisible(false);
	}

}
