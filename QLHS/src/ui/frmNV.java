package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.DAO_NhanVien;
import entity.Country;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class frmNV extends JFrame {

	List<Country>listCountries = new ArrayList<Country>();
	private JPanel contentPane;
	private Image img_logo = new ImageIcon(frmNV.class.getResource("/image/bookStore.png")).getImage().getScaledInstance(250, 250,Image.SCALE_SMOOTH );
	private Image img_system = new ImageIcon(frmNV.class.getResource("/image/system_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_product = new ImageIcon(frmNV.class.getResource("/image/product_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_searchCustomer = new ImageIcon(frmNV.class.getResource("/image/searchCustomer.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_managerCustomer = new ImageIcon(frmNV.class.getResource("/image/manager_customer.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	
	private Image img_thuNhap = new ImageIcon(frmNV.class.getResource("/image/thuNhap.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_thongKeSP = new ImageIcon(frmNV.class.getResource("/image/thongKeSP.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_khuyenMai = new ImageIcon(frmNV.class.getResource("/image/khuyenMai.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_taoHD = new ImageIcon(frmNV.class.getResource("/image/taoHD.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_xemHD = new ImageIcon(frmNV.class.getResource("/image/xemHD.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_searchProduct = new ImageIcon(frmNV.class.getResource("/image/searchProduct.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_managerProduct = new ImageIcon(frmNV.class.getResource("/image/managerbook.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_quanLiHT = new ImageIcon(frmNV.class.getResource("/image/quanliHT.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_xemLich = new ImageIcon(frmNV.class.getResource("/image/iconXemLich.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	
	private Image img_datSach = new ImageIcon(frmNV.class.getResource("/image/datHang.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_taoDonDatSach = new ImageIcon(frmNV.class.getResource("/image/iconTaoDonDatSach.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_xemDonDatSach = new ImageIcon(frmNV.class.getResource("/image/iconXacNhanSach.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	
	
	
	private Image img_payment = new ImageIcon(frmNV.class.getResource("/image/payment_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_thongKe = new ImageIcon(frmNV.class.getResource("/image/thongKe_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_customer = new ImageIcon(frmNV.class.getResource("/image/customer_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_user = new ImageIcon(frmNV.class.getResource("/image/user.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_logout = new ImageIcon(frmNV.class.getResource("/image/logout.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_title = new ImageIcon(frmNV.class.getResource("/image/title.jpg")).getImage().getScaledInstance(1550, 1500,Image.SCALE_SMOOTH );
	private Image img_logo_test = new ImageIcon(frmNV.class.getResource("/image/title.jpg")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH );
	
	private final JLabel lblNewLabel = new JLabel("");
	private panelLichLam system;
	private panelProduct product;
	private PanelBill bill;
	private PanelCustomer customer;
	private PanelThongKe thongke;
	private PanelCRUDKHang panelCRUDKHang;
	private JLabel lbllImage;
	private PanelSearchProduct panelSearchProduct;
	private JPanel panel_image_title;
	private JComboBox comboCountries;
	private JLabel lbllDateShow;
	private JLabel lbllDate;
	private final LoginForm frmLogin = new LoginForm(null);
	private JMenuItem itemQLtaiKhoan;
	private JMenu menuHeThong;
	private JMenu menuSanPham;
	private JMenuItem menuTimSP;
	private JMenuItem menuItemQLSP;
	private JMenu menuHoaDon;
	private JMenuItem menuTaoHD;
	private JMenu menuKhachHang;
	private JMenuItem menuItemTimKH;
	private JMenuItem menuItemQlKH;
	private JMenu menuThongKe;
	private JMenu menuDatHang;
	private JMenuItem menuThongKeSP;
	private JMenuItem thongKe;
	private JMenuItem menuKhuyenMai;
	private PanelTimKhuyenMai searchKm;
	private PanelKhuyenMai khuyenMai;
	private PanelProfit profit;
	private SanPhamFrm dialogfrm;
	private DialogAddKH2 dialogKH2;
	private DialogShowKhuyenMai dialogShowKm;
	private DialogAddSP dialogAddSp;
	private DialogAddKH dialogAddKh;
	private DialogAddKH3 dialogAddKH3;
	private DialogFixKm dialogFixKm;
	private JMenuItem menuSearchHD;
	private PanelSearchHD searchHD;
	private DialogXemHD xemHD;
	private DialogAddKHSearchHD dialogSearchKHHD;
	private PanelKHDatSach panelDatSach;
	private PanelKhXacNhanDatSach panelXacNhanDatSach;
	private DialogAddSP2 dialogSP2;
	private DialogAddSP3 dialogSP3;
	private JMenuItem menuTaoDonDatSach;
	private JMenuItem itemXemLichLam;
	private JMenuItem menuXacNhanDatSach;
	private JMenuItem xemKM;
	private JLabel lbllInfo;
	private DialogChangeSDT changeSDT;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNV frame = new frmNV();
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
	public frmNV() {
		
//		  try {
//	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//	            e.printStackTrace();
//	        }
		  
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(0, 0, 1936, 1056);
		setSize(1936,1056);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		product = new panelProduct();
		panelDatSach = new PanelKHDatSach();
		
		bill = new PanelBill();
		bill.setVisible(false);
		customer = new PanelCustomer();
		
		thongke = new PanelThongKe();
		
		panelCRUDKHang = new PanelCRUDKHang(customer);
		searchHD = new PanelSearchHD();
		panelSearchProduct = new PanelSearchProduct();
		
		profit = new PanelProfit();
		panelXacNhanDatSach = new PanelKhXacNhanDatSach();
		khuyenMai = new PanelKhuyenMai();
		searchKm = new PanelTimKhuyenMai();
		dialogShowKm = new DialogShowKhuyenMai();
		dialogAddSp = new DialogAddSP();
		xemHD = new DialogXemHD();
		dialogSearchKHHD = new DialogAddKHSearchHD();
		dialogSP2 = new DialogAddSP2();
		changeSDT = new DialogChangeSDT();
		dialogSP3 = new DialogAddSP3();
		dialogAddKh = new DialogAddKH();
		dialogAddKH3 = new DialogAddKH3();
		dialogFixKm = new DialogFixKm();
		dialogfrm = new SanPhamFrm();
		dialogKH2 = new DialogAddKH2();
		dialogfrm.setKhuyenMai(khuyenMai);
		dialogKH2.setDatSach(panelDatSach);
		JPanel panel = new JPanel();
		

		
		panel.setBackground(new Color(217,217,217));
		panel.setBounds(0, 0, 388, 1017);
		
		contentPane.add(panel);
		panel.setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 385, 219);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		panel.add(lblNewLabel);
		
		JPanel panelHeThong = new JPanel();
		
		panelHeThong.setBounds(0, 309, 385, 98);
		panelHeThong.setBackground(new Color(217,217,217));
//		panel.add(panelHeThong);
		panelHeThong.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 0, 167, 98);
		lblNewLabel_1.setIcon(new ImageIcon(img_system));
		panelHeThong.add(lblNewLabel_1);
		
		JLabel lbllHeThong = new JLabel("Hệ Thống");
		lbllHeThong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllHeThong.setBounds(177, 0, 57, 98);
		panelHeThong.add(lbllHeThong);
		
		JPanel PanelSanPham = new JPanel();
		PanelSanPham.addMouseListener(new PanelButtonMouseAdapter(PanelSanPham,product));
		PanelSanPham.setBounds(0, 407, 385, 98);
		
		PanelSanPham.setBackground(new Color(217,217,217));
		
//		panel.add(PanelSanPham);
		PanelSanPham.setLayout(null);
		
		JLabel lbllSanPham = new JLabel("");
		lbllSanPham.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSanPham.setBounds(10, 0, 155, 98);
		lbllSanPham.setIcon(new ImageIcon(img_product));
		PanelSanPham.add(lbllSanPham);
		
		JLabel lbllProduct = new JLabel("Sản Phẩm");
		lbllProduct.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllProduct.setBounds(177, 0, 208, 98);
		PanelSanPham.add(lbllProduct);
		
		JPanel panelHD = new JPanel();
		panelHD.addMouseListener(new PanelButtonMouseAdapter(panelHD,bill));
		panelHD.setBounds(0, 504, 233, 98);
//		panel.add(panelHD);
		
		panelHD.setBackground(new Color(217,217,217));
		
		panelHD.setLayout(null);
		
		JLabel lbllHoaDon = new JLabel("");
		lbllHoaDon.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllHoaDon.setBounds(10, 0, 147, 98);
		lbllHoaDon.setIcon(new ImageIcon(img_payment));
		panelHD.add(lbllHoaDon);
		
		JLabel lbllHD = new JLabel("Hóa Đơn");
		lbllHD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllHD.setBounds(177, 0, 57, 98);
		panelHD.add(lbllHD);
		
		JPanel panelKH = new JPanel();
		panelKH.addMouseListener(new PanelButtonMouseAdapter(panelKH,customer));
		panelKH.setBounds(0, 602, 385, 98);

		panelKH.setBackground(new Color(217,217,217));
//		panel.add(panelKH);
		
		
		panelKH.setLayout(null);
		
		JLabel lbllKH = new JLabel("Khách Hàng");
		lbllKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllKH.setBounds(177, 0, 208, 98);
		panelKH.add(lbllKH);
		
		JLabel lbllKhachHang = new JLabel("");
		lbllKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllKhachHang.setBounds(10, 0, 139, 98);
		lbllKhachHang.setIcon(new ImageIcon(img_customer));
		panelKH.add(lbllKhachHang);
		
		JPanel panelThongKe = new JPanel();
		panelThongKe.addMouseListener(new PanelButtonMouseAdapter(panelThongKe,thongke));
		panelThongKe.setBounds(0, 700, 385, 98);
//		panel.add(panelThongKe);
		
		panelThongKe.setBackground(new Color(217,217,217));
		
		panelThongKe.setLayout(null);
		
		JLabel lbllThongKe = new JLabel("Thống Kê");
		lbllThongKe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllThongKe.setBounds(177, 0, 208, 98);
		panelThongKe.add(lbllThongKe);
		
		JLabel lbllTK = new JLabel("");
		lbllTK.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTK.setBounds(10, 0, 155, 98);
		lbllTK.setIcon(new ImageIcon(img_thongKe));
		panelThongKe.add(lbllTK);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBounds(0, 809, 385, 219);
		panel.add(panel_1);
		
		panel_1.setBackground(new Color(217,217,217));
		
		panel_1.setLayout(null);
		
		JLabel icon_user = new JLabel("");
		icon_user.setHorizontalAlignment(SwingConstants.CENTER);
		icon_user.setBounds(10, 138, 61, 59);
		icon_user.setIcon(new ImageIcon(img_user));
		panel_1.add(icon_user);
		
		lbllInfo = new JLabel("Người Dùng");
		lbllInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllInfo.setBounds(156, 138, 150, 59);
		panel_1.add(lbllInfo);
		
		
		JLabel icon_logout = new JLabel("");
		icon_logout.setHorizontalAlignment(SwingConstants.CENTER);
		icon_logout.setBounds(316, 141, 51, 49);
		icon_logout.setIcon(new ImageIcon(img_logout));
		panel_1.add(icon_logout);
		icon_logout.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int option  = JOptionPane.showConfirmDialog(null, "Xác nhận Đăng Xuất?","Xác Nhận",JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					frmLogin.setVisible(true);
					frmNV.this.dispose();

				}
			}
		});
		
		JLabel lbllNgonNgu = new JLabel("Ngôn Ngữ");
		lbllNgonNgu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNgonNgu.setBounds(10, 11, 92, 34);
		panel_1.add(lbllNgonNgu);
		
		comboCountries = new JComboBox();
		comboCountries.setFont(new Font("Tahoma", Font.BOLD, 16));
		FillCountries();
		comboCountries.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = comboCountries.getSelectedIndex();
				String []country = listCountries.get(index).getId().split("-");
				Locale locale = new Locale(country[0], country[1]);
				bill.banHang.refreshLocale(country[0], country[1]);
				panelCRUDKHang.refreshLocale(country[0], country[1]);
				searchKm.refreshLocale(country[0], country[1]);
				product.refreshLocale(country[0], country[1]);
				searchHD.refreshLocale(country[0], country[1]);
				khuyenMai.refreshLocale(country[0], country[1]);
				panelDatSach.refreshLocale(country[0], country[1]);
				panelSearchProduct.refreshLocale(country[0], country[1]);
				panelXacNhanDatSach.refreshLocale(country[0], country[1]);
				customer.refreshLocale(country[0], country[1]);
				profit.refreshLocale(country[0], country[1]);
				
				
				
				ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
				
				bill.lbllHoaDonBanHang.setText(rd.getString("hoaDonBanHang"));
				
				
				//Change Date
				DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale);
				lbllDateShow.setText(df.format(new Date()));

				// Change Text For Jmenu
				menuHeThong.setText(rd.getString("heThong"));
				itemQLtaiKhoan.setText(rd.getString("quanLiTK"));
				itemXemLichLam.setText(rd.getString("xemLich"));
				menuSanPham.setText(rd.getString("sanPham"));
				menuTimSP.setText(rd.getString("timSanPham"));
				menuItemQLSP.setText(rd.getString("quanLiSanPham"));
				menuHoaDon.setText(rd.getString("hoaDon"));
				menuTaoHD.setText(rd.getString("taoHoaDon"));
				menuSearchHD.setText(rd.getString("timHD"));
				menuKhachHang.setText(rd.getString("khachHang"));
				menuItemTimKH.setText(rd.getString("timKH"));
				menuItemQlKH.setText(rd.getString("qlKH"));
//				menuThongKeSP.setText(rd.getString("thongKe"));
				menuThongKe.setText(rd.getString("khuyenMai"));
				thongKe.setText(rd.getString("thongKe"));
				xemKM.setText(rd.getString("xemKM"));
				menuKhuyenMai.setText(rd.getString("khuyenMai"));
				menuDatHang.setText(rd.getString("datHang"));
				menuTaoDonDatSach.setText(rd.getString("taoDonDH"));
				menuXacNhanDatSach.setText(rd.getString("xacNhanDH"));
				
				//Change Text for Lbll
				lbllHeThong.setText(rd.getString("heThong"));
				lbllHeThong.setFont(listCountries.get(index).getFont());
				lbllProduct.setText(rd.getString("sanPham"));
				lbllProduct.setFont(listCountries.get(index).getFont());
				lbllHD.setText(rd.getString("hoaDon"));
				lbllHD.setFont(listCountries.get(index).getFont());
				lbllKH.setText(rd.getString("khachHang"));
				lbllKH.setFont(listCountries.get(index).getFont());
				lbllThongKe.setText(rd.getString("thongKe"));
				lbllThongKe.setFont(listCountries.get(index).getFont());
				lbllDate.setText(rd.getString("lich"));
				lbllDate.setFont(listCountries.get(index).getFont());
				//Change Text Frm Show
				//thêm các thay đổi vào bên trong 
				system.lbllSystem.setText(rd.getString("heThong"));
				system.lbllSystem.setFont(listCountries.get(index).getFont());
				
				//Change text for frm Bill
//				bill.lblNewLabel.setText(rd.getString("banhang")); //Ban Hang
//				bill.lblNewLabel.setFont(listCountries.get(index).getFont());
//				bill.lblNewLabel_1.setText(rd.getString("nhaphang")); //Nhap hang
//				bill.lblNewLabel_1.setFont(listCountries.get(index).getFont());
				
				//Change text for Bill.panelBanHang
//				bill.banHang.lblTcGi.setText(rd.getString("tacGia"));
//				bill.banHang.lblNhXutBn.setText(rd.getString("NXB"));
//				bill.banHang.lbllSoLuong.setText(rd.getString("soluong"));
//				bill.banHang.lblTimKH.setText(rd.getString("timKH"));
//				bill.banHang.lbllKH.setText(rd.getString("maKH"));
//				bill.banHang.lblTnKhchHng.setText(rd.getString("tenKH"));
//				bill.banHang.lblSi.setText(rd.getString("SDT"));
//				bill.banHang.lblaCh.setText(rd.getString("diaChi"));
//				bill.banHang.lbllLoai.setText(rd.getString("loaiKH"));
//				bill.banHang.lbllTongTien.setText(rd.getString("tongTien"));
//				bill.banHang.lbllTienNhan.setText(rd.getString("tienNhan"));
//				bill.banHang.lblTienTra.setText(rd.getString("tienTra"));
//				bill.banHang.btnHuy.setText(rd.getString("huyBo"));
//				bill.banHang.btnThanhToan.setText(rd.getString("thanhToan"));
//				bill.banHang.btnInHD.setText(rd.getString("inHD"));
////				bill.banHang.lbllTitle.setText(rd.getString("banhang"));
//				bill.banHang.lbllProduct.setText(rd.getString("timsach"));
//				bill.banHang.lbllMaSach.setText(rd.getString("maSach"));
////				bill.banHang.lbllTenSach.setText(rd.getString("tenSach"));
////				bill.banHang.lblDanhMc.setText(rd.getString("danhMuc"));
//				
//				bill.banHang.btnNewButton.setText(rd.getString("them"));
//				bill.banHang.btnLmMi.setText(rd.getString("lammoi"));
				
				
				//Change currency
				NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
				//
			}
		});
		comboCountries.setBounds(125, 11, 174, 34);
		panel_1.add(comboCountries);
		
		lbllDate = new JLabel("Lịch");
		lbllDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDate.setBounds(10, 102, 92, 34);
		panel_1.add(lbllDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE,dd/MM/yyyy",new Locale("vi"));
		String currentDate = dateFormat.format(new Date());
		
		lbllDateShow = new JLabel();
		lbllDateShow.setText(currentDate);
		lbllDateShow.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbllDateShow.setBounds(125, 100, 242, 38);
		panel_1.add(lbllDateShow);
		
		JLabel lblNewLabel_3_1 = new JLabel("User");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(69, 138, 77, 59);
		panel_1.add(lblNewLabel_3_1);
		
		JPanel panelFrm = new JPanel();
		panelFrm.setBounds(386, 41, 1534, 976);
		contentPane.add(panelFrm);
	
		
		panelFrm.setLayout(null);
		lbllImage = new JLabel(new ImageIcon(img_title));
		lbllImage.setHorizontalAlignment(SwingConstants.CENTER);
		lbllImage.setHorizontalAlignment(JLabel.CENTER);
		lbllImage.setVerticalAlignment(JLabel.CENTER);
		lbllImage.setBounds(0, 0, 1534, 1017);
		
		
		panel_image_title = new JPanel();
		
		panel_image_title.setBounds(0, 0, 1534, 1006);
		panel_image_title.add(lbllImage);
		
		
		panel_image_title.setLayout(null);
		
		FillMovePanel();
		product.setVisible(false);
		panelDatSach.setVisible(false);
		thongke.setVisible(false);
		customer.setVisible(false);
		panelCRUDKHang.setVisible(false);
		searchHD.setVisible(false);
		panelSearchProduct.setVisible(false);
		panel_image_title.setVisible(true);
		profit.setVisible(false);
		panelXacNhanDatSach.setVisible(false);
		dialogShowKm.setVisible(false);
		dialogAddSp.setVisible(false);
		xemHD.setVisible(false);
		dialogSearchKHHD.setVisible(false);
		dialogSP2.setVisible(false);
		changeSDT.setVisible(false);
		dialogSP3.setVisible(false);
		dialogAddKh.setVisible(false);
		dialogAddKH3.setVisible(false);
		dialogFixKm.setVisible(false);
		searchKm.setVisible(false);
		khuyenMai.setVisible(false);
		panelFrm.add(product);
		panelFrm.add(panelDatSach);
		panelFrm.add(bill);
		panelFrm.add(profit);
		panelFrm.add(panelXacNhanDatSach);
		panelFrm.add(searchKm);
		panelFrm.add(khuyenMai);
		
		system = new panelLichLam();
		system.setBounds(0, -70, 1554, 1015);
		bill.banHang.add(system);
		panelHeThong.addMouseListener(new PanelButtonMouseAdapter(panelHeThong,system));
		system.setVisible(false);
		panelFrm.add(customer);
		panelFrm.add(thongke);
		panelFrm.add(panelCRUDKHang);
		panelFrm.add(searchHD);
		panelFrm.add(panelSearchProduct);
		panelFrm.add(panel_image_title);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(255, 255, 255));
		panelMenu.setBounds(386, 0, 1084, 41);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JMenuBar menuBarSystem = new JMenuBar();
		menuBarSystem.setBounds(0, 0, 1084, 41);
		
		

		
		  menuHeThong = new JMenu("Hệ Thống");
		  menuHeThong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		  menuHeThong.setBorder(new LineBorder(Color.black, 1));
		  menuHeThong.setBackground(new Color(0, 128, 0));
		  menuHeThong.setIcon(new ImageIcon(img_system));
		  menuHeThong.setHorizontalAlignment(SwingConstants.CENTER);
		  menuHeThong.setPreferredSize(new Dimension(180, 41));
		  itemQLtaiKhoan = new JMenuItem("Quản lí tài khoản", new ImageIcon(img_quanLiHT));
		  itemQLtaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);
		  
		  itemQLtaiKhoan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				menuClicked(profit);
				profit.refresh();
				
			}
		});
		  
		  itemQLtaiKhoan.setFont(new Font("Tímes New Roman",Font.BOLD,12));
		  itemQLtaiKhoan.setPreferredSize(new Dimension(180, 41));
		  itemXemLichLam = new JMenuItem("Xem lịch làm", new ImageIcon(img_xemLich));
		  itemXemLichLam.setFont(new Font("Tímes New Roman",Font.BOLD,12));
		  itemXemLichLam.setPreferredSize(new Dimension(180, 41));
		  menuHeThong.add(itemQLtaiKhoan);
//		  menuHeThong.add(itemXemLichLam);
		  
		  
		  menuSanPham = new JMenu("Sản Phẩm");
		  menuSanPham.setBorder(new LineBorder(Color.black, 1));
		  menuSanPham.setBackground(new Color(0, 128, 0));
		  menuSanPham.setFont(new Font("Times New Roman", Font.BOLD, 18)); ///
		  menuSanPham.setIcon(new ImageIcon(img_product));
		  menuSanPham.setHorizontalAlignment(SwingConstants.RIGHT);
		  menuSanPham.setPreferredSize(new Dimension(180, 41));
//		  JMenuItem menuItem = new JMenuItem("MenuItem", new ImageIcon(img_logo_test));

		  
		  menuTimSP = new JMenuItem("Tìm Sản Phẩm", new ImageIcon(img_searchProduct));
		  menuTimSP.setFont(new Font("Tímes New Roman",Font.BOLD,12));
		  menuTimSP.setPreferredSize(new Dimension(180, 41));
		  menuTimSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(panelSearchProduct);
				panelSearchProduct.refresh();
			}
		});
		  menuItemQLSP = new JMenuItem("Quản Lí Sản Phẩm", new ImageIcon(img_managerProduct));
		  menuItemQLSP.setFont(new Font("Tímes New Roman",Font.BOLD,12));
		  menuItemQLSP.setPreferredSize(new Dimension(180, 41));
		  menuItemQLSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(product);
				product.refresh();
			}
		});
		  menuSanPham.add(menuTimSP);
		  menuSanPham.add(menuItemQLSP);
		  
		  
		  menuHoaDon = new JMenu("Hóa Đơn");
		  menuHoaDon.setBorder(new LineBorder(Color.black, 1));
		  menuHoaDon.setBackground(new Color(0, 128, 0));
		  
		  menuHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 18)); ////
		  menuHoaDon.setIcon(new ImageIcon(img_payment));
		  menuHoaDon.setHorizontalAlignment(SwingConstants.RIGHT);
		  menuHoaDon.setPreferredSize(new Dimension(180, 41));
		  
		  menuTaoHD = new JMenuItem("Tạo Hóa Đơn", new ImageIcon(img_taoHD));
		  menuTaoHD.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  menuTaoHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(bill);
				bill.banHang.refresh();
			}
		});
		  menuTaoHD.setPreferredSize(new Dimension(180, 41));
//		  JMenuItem menuItem = new JMenuItem("Quản Lí Khách Hàng", new ImageIcon(img_customer));
//		  menuItemQlKH.setFont(new Font("Times New Roman", Font.BOLD, 14)); ////
		  menuHoaDon.add(menuTaoHD);
		  
		  menuSearchHD = new JMenuItem("Tạo Hóa Đơn");
		  menuSearchHD.setBorder(new LineBorder(Color.black, 1));
		  menuSearchHD.setBackground(new Color(0, 128, 0));
		  
		  menuSearchHD.setFont(new Font("Times New Roman", Font.BOLD, 18)); ////
		  menuSearchHD.setIcon(new ImageIcon(img_payment));
		  menuSearchHD.setHorizontalAlignment(SwingConstants.RIGHT);
		  menuSearchHD.setPreferredSize(new Dimension(180, 41));
		  
		  menuSearchHD = new JMenuItem("Xem Hóa Đơn", new ImageIcon(img_xemHD));
		  menuSearchHD.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  menuSearchHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(searchHD);
				searchHD.refresh();
			}
		});
		  menuSearchHD.setPreferredSize(new Dimension(180, 41));
		  menuHoaDon.add(menuSearchHD);
		  
		  
		  menuKhachHang = new JMenu("Khách Hàng");
		  menuKhachHang.setBorder(new LineBorder(Color.black, 1));
		  menuKhachHang.setBackground(new Color(0, 128, 0));
		  menuKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 18)); ////
		  menuKhachHang.setIcon(new ImageIcon(img_customer));
		  menuKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		  menuKhachHang.setPreferredSize(new Dimension(180, 41));
		  
		  menuItemTimKH = new JMenuItem("Tìm Khách Hàng", new ImageIcon(img_searchCustomer));
		  menuItemTimKH.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
//		  menuItemTimKH.setIcon(new ImageIcon(img_searchCustomer));
		  menuItemTimKH.setPreferredSize(new Dimension(180, 41));
		  menuItemTimKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(customer);
				customer.refresh();
			}
		});
		  menuItemQlKH = new JMenuItem("Quản Lí Khách Hàng", new ImageIcon(img_managerCustomer));
		  menuItemQlKH.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  menuItemQlKH.setPreferredSize(new Dimension(180, 41));
		  menuItemQlKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(panelCRUDKHang);
				panelCRUDKHang.refresh();
			}
		});
		  menuKhachHang.add(menuItemTimKH);
		  menuKhachHang.add(menuItemQlKH);
		  
		  
		  menuThongKe = new JMenu("Khuyến Mãi");
		  menuThongKe.setBorder(new LineBorder(Color.black, 1));
		  menuThongKe.setBackground(new Color(0, 128, 0));
		  menuThongKe.setFont(new Font("Times New Roman", Font.BOLD, 18)); ////
		  menuThongKe.setIcon(new ImageIcon(img_thongKe));
		  menuThongKe.setHorizontalAlignment(SwingConstants.RIGHT);
		  menuThongKe.setPreferredSize(new Dimension(180, 41));
		  
		  thongKe = new JMenuItem("Thống Kê", new ImageIcon(img_thongKeSP));
		  thongKe.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  thongKe.setPreferredSize(new Dimension(180, 41));
		  thongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(thongke);
			}
		});
		  xemKM = new JMenuItem("Xem Khuyến Mãi", new ImageIcon(img_thuNhap));
		  xemKM.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  xemKM.setPreferredSize(new Dimension(180, 41));
		  xemKM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(searchKm);
				searchKm.refresh();
			}
		});
		  menuKhuyenMai = new JMenuItem("Khuyến Mãi", new ImageIcon(img_khuyenMai));
		  
		  menuKhuyenMai.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  menuKhuyenMai.setPreferredSize(new Dimension(180, 41));
		  menuKhuyenMai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuClicked(khuyenMai);
			}
		});
//		  menuThongKe.add(thongKe);
		  menuThongKe.add(xemKM);
		  menuThongKe.add(menuKhuyenMai);
		  
		  

		  
		  menuThongKeSP = new JMenuItem("Thống Kê", new ImageIcon(img_thongKeSP));
		  menuThongKeSP.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  menuThongKeSP.setPreferredSize(new Dimension(180, 41));
		  menuThongKeSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(thongke);
			}
		});
		  menuDatHang = new JMenu("Đặt Hàng");
//		  menuThongKe = new JMenu("Thống Kê");
		  menuDatHang.setBorder(new LineBorder(Color.black, 1));
		  menuDatHang.setBackground(new Color(0, 128, 0));
		  menuDatHang.setFont(new Font("Times New Roman", Font.BOLD, 18)); ////
		  menuDatHang.setIcon(new ImageIcon(img_datSach));
		  menuDatHang.setHorizontalAlignment(SwingConstants.RIGHT);
		  menuDatHang.setPreferredSize(new Dimension(180, 41));
		  
		  menuTaoDonDatSach = new JMenuItem("Đặt Hàng", new ImageIcon(img_taoDonDatSach));
		  menuTaoDonDatSach.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  menuTaoDonDatSach.setPreferredSize(new Dimension(180, 41));
		  menuTaoDonDatSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(panelDatSach);
				panelDatSach.refresh();
			}
		});
		  menuXacNhanDatSach = new JMenuItem("Xác Nhận Đơn", new ImageIcon(img_xemDonDatSach));
		  menuXacNhanDatSach.setFont(new Font("Times New Roman", Font.BOLD, 12)); ////
		  menuXacNhanDatSach.setPreferredSize(new Dimension(180, 41));
		  menuXacNhanDatSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClicked(panelXacNhanDatSach);
				panelXacNhanDatSach.refresh();
			}
		});
		  menuDatHang.add(menuTaoDonDatSach);
		  menuDatHang.add(menuXacNhanDatSach);
		  
		  menuBarSystem.add(menuHeThong);
		  menuBarSystem.add(menuSanPham);
		  menuBarSystem.add(menuHoaDon);
		  menuBarSystem.add(menuKhachHang);
		  menuBarSystem.add(menuThongKe);
		  menuBarSystem.add(menuDatHang);
	
		  

		  itemQLtaiKhoan.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					
//					menuClicked(jpanelShow);
//				}
				@Override
				public void mouseEntered(MouseEvent e) {
					
					itemQLtaiKhoan.setBackground(Color.red);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					
					itemQLtaiKhoan.setBackground(Color.red);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					
					itemQLtaiKhoan.setBackground(Color.red);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				
					itemQLtaiKhoan.setBackground(Color.red);
				}
		  });
		  

		  


			
		panelMenu.add(menuBarSystem);
		
		JLabel icon_logout_1 = new JLabel("");
		icon_logout_1.setHorizontalAlignment(SwingConstants.CENTER);
		icon_logout_1.setBounds(1856, 0, 40, 41);
		contentPane.add(icon_logout_1);
		
		
		
		
		
		
	}
	
	public void menuClicked(JPanel panel) {
		panel_image_title.setVisible(false);
		system.setVisible(false);
		product.setVisible(false);
		panelDatSach.setVisible(false);
		bill.setVisible(false);
		customer.setVisible(false);
		thongke.setVisible(false);		
		profit.setVisible(false);
		searchKm.setVisible(false);
		panelXacNhanDatSach.setVisible(false);
		khuyenMai.setVisible(false);
//		system.setVisible(false);
//		product.setVisible(false);
//		thongke.setVisible(false);
//		customer.setVisible(false);
		panelCRUDKHang.setVisible(false);
		searchHD.setVisible(false);
		panelSearchProduct.setVisible(false);
		
		panel.setVisible(true);	
	}
	private void FillCountries() {
		listCountries.add(new Country("vi-VN", "VietNam", new Font("Tahoma", Font.BOLD, 20)));
		listCountries.add(new Country("en-US","English",new Font("Tahoma", Font.BOLD, 20)));
//		listCountries.add(new Country("ja-JP","Japan",new Font("MS Gothic", Font.PLAIN, 20)));
		for (Country country : listCountries) {
			comboCountries.addItem(country.getName());
		}
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		JPanel jpanelShow;
		public PanelButtonMouseAdapter(JPanel panel,JPanel panelShow) {
			
			this.panel = panel;
			this.jpanelShow = panelShow;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
			menuClicked(jpanelShow);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			panel.setBackground(new Color(112,128,144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
			panel.setBackground(new Color(217,217,217));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
			panel.setBackground(new Color(60,179,113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
	}
	
	private void FillMovePanel() {
		dialogKH2.datSach = panelDatSach;
		customer.crudkHang = panelCRUDKHang;
		product.panelSearchProduct = panelSearchProduct;
		panelSearchProduct.panelProduct = product;
		searchKm.dialogShow = dialogShowKm;
		searchKm.dialogShow.timKhuyenMai = searchKm;
		bill.banHang.dialogAddSp = dialogAddSp;
		searchHD.xemHd = xemHD;
		searchHD.dialogAddKH = dialogSearchKHHD;
		panelDatSach.dialogSP = dialogSP2;
//		profit.changeSDT.profit = profit;
		changeSDT.profit = profit;
		panelXacNhanDatSach.dialogSP = dialogSP3;
		bill.banHang.dialogAddKH = dialogAddKh;
		panelXacNhanDatSach.dialogKH = dialogAddKH3;
		searchKm.dialogShow.dialogFixKm = dialogFixKm;
		searchKm.dialogShow.dialogFixKm.dialogShowKhuyenMai = searchKm.dialogShow;
	}
	public void setInfoUser(String str) {
		DAO_NhanVien daoNV = new DAO_NhanVien();
		
		lbllInfo.setText(daoNV.getTenNV(str));
	}
}
