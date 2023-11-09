package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import connectDB.ConnectDB;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import dao.DAO_SanPham;
import entity.SanPham;
import list.DanhSachChiTietHoaDon;
import list.DanhSachHoaDon;
import list.DanhSachSanPham;

import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.JScrollPane;

public class panelBanHang extends JPanel {
	private Image img_title = new ImageIcon(frmNV.class.getResource("/image/pluss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_6;
	public JTextField txtLoaiKH;
	public JTextField txtTongTien;
	public JTextField txtTienNhan;
	public JTextField txtTienTra;
	public JTextField txtTenKH;
	public JTextField txtDiaChi;
	public JLabel lblTcGi;
	public JLabel lblNhXutBn;
	public JLabel lbllSoLuong;
	public JLabel lblTimKH;
	public JLabel lbllKH;
	public JLabel lblTnKhchHng;
	public JLabel lblSi;
	public JLabel lblaCh;
	public JLabel lbllLoai;
	public JLabel lbllTongTien;
	public JLabel lbllTienNhan;
	public JLabel lblTienTra;
	public JButton btnHuy;
	public JButton btnThanhToan;
	public JButton btnInHD;
	public JLabel lbllTitle;
	public JLabel lbllProduct;
	public JLabel lbllTenSach;
	public JLabel lblDanhMc;
	public JButton btnNewButton;
	public JButton btnLmMi;
	public JTextField textField_5;
	public JLabel lbllMaSach;
	private JButton btnSearch;
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableModel modelHd;
	
	// Phần DAO của sản phẩm
	private DanhSachSanPham listSP;
	private DAO_SanPham daosp;
	private Object[] rowSP;
	
	// Phần DAO của hóa đơn
	private DanhSachHoaDon listHD;
	private DAO_HoaDon daoHD;
	
	private Object[] rowHD;
	
	
	//Phần DAO của chi tiết hóa đơn
	private DanhSachChiTietHoaDon listCTHD;
	private DAO_ChiTietHoaDon daoCTHD;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JTable tableListspTrongHD;
	private JScrollPane scrollPane_1;
	
//	private ArrayList<SanPham>
	
	
	public panelBanHang() {
		
		//Phan san pham
		daosp = new DAO_SanPham();
		listSP = new DanhSachSanPham();
		rowSP = new Object[11];
		
		//Phan hoa don
		daoHD = new DAO_HoaDon();
		listHD = new DanhSachHoaDon();
		rowHD = new Object[5];
		
		listCTHD = new DanhSachChiTietHoaDon();
		daoCTHD = new DAO_ChiTietHoaDon();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		listSP = daosp.getAll();
		listHD = daoHD.getAll();
		listCTHD = daoCTHD.getAll();
		
//		this.setVisible(false);
		setBounds(0,0,1534,956);
		setLayout(null);
		
		JPanel Title = new JPanel();
		Title.setBackground(new Color(255, 255, 204));
		Title.setBounds(0, 0, 1534, 89);
		add(Title);
		Title.setLayout(null);
		
		lbllTitle = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lbllTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbllTitle.setForeground(new Color(0, 204, 51));
		lbllTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTitle.setBounds(0, 0, 1534, 89);
		Title.add(lbllTitle);
		
		JPanel txtSach = new JPanel();
		txtSach.setBounds(0, 100, 1534, 89);
		txtSach.setBackground(new Color(102, 204, 255));
		add(txtSach);
		txtSach.setLayout(null);
		
		lbllProduct = new JLabel("Tìm Sách");
		lbllProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllProduct.setBounds(10, 11, 100, 23);
		txtSach.add(lbllProduct);
		
		lbllTenSach = new JLabel("Tên Sách");
		lbllTenSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenSach.setBounds(680, 45, 157, 23);
		txtSach.add(lbllTenSach);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(847, 47, 210, 23);
		txtSach.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(849, 13, 210, 23);
		txtSach.add(textField_1);
		
		lblDanhMc = new JLabel("Danh Mục");
		lblDanhMc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDanhMc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDanhMc.setBounds(680, 11, 144, 23);
		txtSach.add(lblDanhMc);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1274, 47, 210, 23);
		txtSach.add(textField_2);
		
		lblTcGi = new JLabel("Tác Giả");
		lblTcGi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTcGi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTcGi.setBounds(1140, 45, 124, 23);
		txtSach.add(lblTcGi);
		
		lblNhXutBn = new JLabel("Nhà Xuất Bản");
		lblNhXutBn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNhXutBn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhXutBn.setBounds(1096, 11, 168, 23);
		txtSach.add(lblNhXutBn);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(1274, 13, 210, 23);
		txtSach.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(376, 13, 210, 23);
		txtSach.add(textField_5);
		
		lbllMaSach = new JLabel("Mã Sách");
		lbllMaSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaSach.setBounds(228, 11, 138, 23);
		txtSach.add(lbllMaSach);
		
		btnSearch = new JButton("");
		btnSearch.setBounds(581, 11, 63, 31);
		btnSearch.setBackground(null);
		btnSearch.setOpaque(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setIcon(new ImageIcon(img_title));
		txtSach.add(btnSearch);
		
		table = new JTable();
		table.setBounds(0, 88, 1534, 300);
		txtSach.add(table);
		String[] column = {"Mã Sách","Tên Sách","Tên Tác Giả","Danh Mục","Nhà XB","năm XB","Số Lượng","Đơn Giá","Tình Trạng","Khuyến Mãi"};
		
		DefaultTableModel model = new DefaultTableModel();
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("Button.border"));
		panel.setBounds(0, 489, 477, 40);
		add(panel);
		panel.setLayout(null);
		
		lbllSoLuong = new JLabel("Số Lượng");
		lbllSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSoLuong.setBounds(10, 11, 129, 18);
		panel.add(lbllSoLuong);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(149, 12, 44, 20);
		panel.add(spinner);
		
		btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(102, 204, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(229, 11, 89, 23);
		panel.add(btnNewButton);
		
		btnLmMi = new JButton("Làm Mới");
		btnLmMi.setBackground(new Color(102, 204, 0));
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLmMi.setBounds(328, 11, 96, 23);
		panel.add(btnLmMi);
		
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(922, 489, 612, 467);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 776, 32);
		
		
		
		panel_2.add(panel_3);
		panel_3.setBorder(createStrikethroughBorder());
		panel_3.setLayout(null);
		
		lblTimKH = new JLabel("Tìm Khách Hàng");
		lblTimKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKH.setBounds(10, 0, 138, 28);
		panel_3.add(lblTimKH);
		
		lbllKH = new JLabel("Mã Khách Hàng");
		lbllKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllKH.setBounds(10, 40, 99, 25);
		panel_2.add(lbllKH);
		
		textField_4 = new JTextField();
		textField_4.setBounds(155, 43, 144, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnKhchHng.setBounds(309, 40, 125, 25);
		panel_2.add(lblTnKhchHng);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(155, 74, 144, 20);
		panel_2.add(textField_6);
		
		lblSi = new JLabel("Số Điện Thoại");
		lblSi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSi.setBounds(10, 76, 99, 25);
		panel_2.add(lblSi);
		
		lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblaCh.setBounds(314, 71, 120, 25);
		panel_2.add(lblaCh);
		
		lbllLoai = new JLabel("Loại Khách Hàng");
		lbllLoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllLoai.setBounds(10, 112, 109, 25);
		panel_2.add(lbllLoai);
		
		txtLoaiKH = new JTextField();
		txtLoaiKH.setBackground(new Color(51, 255, 255));
		txtLoaiKH.setBounds(129, 115, 52, 20);
		txtLoaiKH.setEditable(false);
		panel_2.add(txtLoaiKH);
		txtLoaiKH.setColumns(10);
		
		lbllTongTien = new JLabel("Tổng Tiền");
		lbllTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTongTien.setBounds(10, 148, 129, 38);
		panel_2.add(lbllTongTien);
		
		txtTongTien = new JTextField();
		txtTongTien.setBackground(new Color(204, 255, 0));
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTongTien.setBounds(149, 146, 138, 38);
		txtTongTien.setEditable(false);
		panel_2.add(txtTongTien);
		txtTongTien.setColumns(10);
		
		lbllTienNhan = new JLabel("Tiền Nhận");
		lbllTienNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTienNhan.setBounds(10, 204, 129, 38);
		panel_2.add(lbllTienNhan);
		
		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTienNhan.setEditable(false);
		txtTienNhan.setColumns(10);
		txtTienNhan.setBackground(new Color(204, 255, 0));
		txtTienNhan.setBounds(149, 205, 138, 38);
		panel_2.add(txtTienNhan);
		
		lblTienTra = new JLabel("Tiền Trả");
		lblTienTra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTienTra.setBounds(10, 262, 129, 38);
		panel_2.add(lblTienTra);
		
		txtTienTra = new JTextField();
		txtTienTra.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTienTra.setEditable(false);
		txtTienTra.setColumns(10);
		txtTienTra.setBackground(new Color(204, 255, 0));
		txtTienTra.setBounds(149, 263, 138, 38);
		panel_2.add(txtTienTra);
		
		btnHuy = new JButton("Hủy Bỏ");
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuy.setBounds(52, 311, 138, 38);
		panel_2.add(btnHuy);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThanhToan.setBackground(new Color(102, 204, 0));
		btnThanhToan.setBounds(256, 312, 138, 38);
		panel_2.add(btnThanhToan);
		
		btnInHD = new JButton("In Hóa Đơn");
		btnInHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInHD.setBackground(new Color(102, 204, 0));
		btnInHD.setBounds(448, 311, 154, 38);
		panel_2.add(btnInHD);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(436, 40, 166, 20);
		panel_2.add(txtTenKH);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(436, 74, 166, 20);
		panel_2.add(txtDiaChi);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 188, 1534, 298);
		add(scrollPane);
		
		table_1 = new JTable();
		model = new DefaultTableModel();
		
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 540, 924, 416);
		add(scrollPane_1);
		
		tableListspTrongHD = new JTable();
		String[] columnHd = {"Tên Sách","Số Lượng","Giá Gốc","Khuyến Mãi","Thành Tiền"};
		modelHd = new DefaultTableModel();
		modelHd.setColumnIdentifiers(columnHd);
		tableListspTrongHD.setModel(modelHd);
		
		scrollPane_1.setViewportView(tableListspTrongHD);
		
		refreshHD();
		
		
	}
	private void refreshHD2() {
		
	}
	private void refreshHD() {
		listSP = daosp.getAll();
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
		for (SanPham sp : listSP.getList()) {
			rowSP[0] = sp.getMaSP();
			rowSP[1] = sp.getTenSP();
			rowSP[2] = sp.getTenTG();
			rowSP[3] = sp.getDanhMuc();
			rowSP[4] = sp.getNhaXB();
			rowSP[5] = sp.getNamXB();
			rowSP[6] = sp.getSoLuong();
			rowSP[7] = sp.getDonGiaMua();
			rowSP[8] = sp.getTinhTrang();
			rowSP[9] = "null";
			
			
			model.addRow(rowSP);
		}
	}
	
	
	private static Border createStrikethroughBorder() {
		return BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black),BorderFactory.createEmptyBorder(0, 0, 2, 0)
		        );
	}
	private static Border TopcreateStrikethroughBorder() {
		return BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black),BorderFactory.createEmptyBorder(0, 0, 2, 0)
		        );
	}
	
	private class OvalDrawingExample extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.drawOval(50, 50, 50, 50);
			
		}
		  @Override
		    public Dimension getPreferredSize() {
		        return new Dimension(200, 250); // Kích thước ưu tiên cho JPanel
		    }
	}
}
