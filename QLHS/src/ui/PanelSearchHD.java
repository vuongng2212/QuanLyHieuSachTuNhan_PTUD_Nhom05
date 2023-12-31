package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_HoaDon;
import entity.HoaDon;
import list.DanhSachHoaDon;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PanelSearchHD extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private DAO_HoaDon daohd;
	private DanhSachHoaDon listHD;
	private HoaDon hd;
	public DialogXemHD xemHd;
	private JButton btnXemChiTiet;
	private JButton btnTimKiem;
	private JLabel lbllNgayTao;
	private JLabel lbllTimHoaDon;
	private JButton btnLamMoi;
	private String maHD,maNV,maKh,ngayTao,thanhTien;
	private JLabel lblTImKH;
	private JTextField txtMaKH;
	public DialogAddKHSearchHD dialogAddKH;
	private JDateChooser batdau;
	/**
	 * Create the panel.
	 */
	public PanelSearchHD() {
		setBounds(0,0,1534,1017);
		setLayout(null);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
//		dialogAddKH = new DialogAddKHSearchHD();
		xemHd = new DialogXemHD(this);
		dialogAddKH = new DialogAddKHSearchHD(this);
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1534, 78);
		add(panel);
		panel.setLayout(null);
		
		lbllTimHoaDon = new JLabel("Tìm Hóa Đơn");
		lbllTimHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTimHoaDon.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbllTimHoaDon.setBounds(0, 0, 1534, 78);
		panel.add(lbllTimHoaDon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 102, 1534, 153);
		add(panel_1);
		panel_1.setLayout(null);
		
		batdau = new JDateChooser();
		batdau.setDateFormatString("dd-MM-yyyy");
		batdau.setBounds(186, 22, 178, 35);
		panel_1.add(batdau);
		
		lbllNgayTao = new JLabel("Ngày Tạo");
		lbllNgayTao.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNgayTao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllNgayTao.setBounds(39, 22, 137, 35);
		panel_1.add(lbllNgayTao);
		
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(batdau.getDate() == null && txtMaKH.getText().equalsIgnoreCase("")) {
					refresh();
				}else {
					if(!txtMaKH.getText().equalsIgnoreCase("") && batdau.getDate()==null) {
						
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
						daohd = new DAO_HoaDon();
						ArrayList<HoaDon>listhd = new ArrayList<HoaDon>();
						listhd = daohd.SearchHDTheomaKH(txtMaKH.getText());
						model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						for (HoaDon hd : listhd) {
							row[0] = hd.getMaHD();
							row[1] = hd.getMaNV();
							row[2] = hd.getMaKH();
							row[3] = dateformat.format(hd.getNgayTaoHD());
							row[4] = hd.getThanhTien();
							model.addRow(row);
						}
						
					}else if(!txtMaKH.getText().equalsIgnoreCase("") && batdau.getDate()!=null) {
						System.out.println("Loc 2 field");
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
						daohd = new DAO_HoaDon();
						ArrayList<HoaDon>listhd = new ArrayList<HoaDon>();
						listhd = daohd.SearchHDTheomaKHvaNgay(dateformat.format(batdau.getDate()),txtMaKH.getText());
						model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						for (HoaDon hd : listhd) {
							row[0] = hd.getMaHD();
							row[1] = hd.getMaNV();
							row[2] = hd.getMaKH();
							row[3] = dateformat.format(hd.getNgayTaoHD());
							row[4] = hd.getThanhTien();
							model.addRow(row);
						}
						
					}else {
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
						daohd = new DAO_HoaDon();
						ArrayList<HoaDon>listhd = new ArrayList<HoaDon>();
						listhd = daohd.SearchHDTheoNgay(dateformat.format(batdau.getDate()));
						model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						for (HoaDon hd : listhd) {
							row[0] = hd.getMaHD();
							row[1] = hd.getMaNV();
							row[2] = hd.getMaKH();
							row[3] = dateformat.format(hd.getNgayTaoHD());
							row[4] = hd.getThanhTien();
							model.addRow(row);
						}
					}

				}
			}
		});
		btnTimKiem.setBounds(220, 96, 197, 46);
		panel_1.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refresh();
			}
		});
		btnLamMoi.setBounds(624, 96, 197, 46);
		panel_1.add(btnLamMoi);
		
		btnXemChiTiet = new JButton("Xem Chi Tiết");
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXemChiTiet.setEnabled(false);
		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				onOpenFrmButtonClick();
			}
		});
		btnXemChiTiet.setBounds(991, 96, 220, 46);
		panel_1.add(btnXemChiTiet);
		
		lblTImKH = new JLabel("Tìm Khách Hàng");
		lblTImKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTImKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTImKH.setBounds(466, 22, 145, 35);
		panel_1.add(lblTImKH);
		
		JButton btnTimKh = new JButton("Tìm");
		btnTimKh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				dialogAddKH.setModal(true);
//				dialogAddKH.setVisible(true);
				onOpenFormButtonClickKH();
			}
		});
		btnTimKh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKh.setBounds(629, 22, 90, 35);
		panel_1.add(btnTimKh);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng");
		lblMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaKH.setBounds(751, 22, 111, 35);
		panel_1.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(872, 22, 74, 35);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		txtMaKH.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 254, 1534, 763);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					btnXemChiTiet.setEnabled(true);
				}
			}
		});
		model = new DefaultTableModel();
		String[] column = {"Mã Hóa Đơn","Mã Nhân Viên","Mã Khách Hàng","Ngày Tạo Hóa Đơn","Thành Tiền"};
		row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		refresh();
	}
	public void refresh() {
		txtMaKH.setText("");
		batdau.setDate(null);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daohd  = new DAO_HoaDon();
		listHD = new DanhSachHoaDon();
		listHD = daohd.getAll();
		row = new Object[5];
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (HoaDon hd : listHD.getList()) {
			row[0] = hd.getMaHD();
			row[1] = hd.getMaNV();
			row[2] = hd.getMaKH();
			row[3] = dateformat.format(hd.getNgayTaoHD());
			row[4] = hd.getThanhTien();
			model.addRow(row);
		}
	}
	private void onOpenFrmButtonClick() {
		model =(DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		
		xemHd.searchHd = this;
		xemHd.txtMaHD.setText(model.getValueAt(i,0).toString());
		xemHd.refresh();
		xemHd.setModal(true);
		xemHd.setVisible(true);
	}
	public void refreshLocale(String cs1,String cs2) {
		Locale locale = new Locale(cs1, cs2);
		ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
		lbllTimHoaDon.setText(rd.getString("timHD"));
		lbllNgayTao.setText(rd.getString("ngayTao"));
		btnTimKiem.setText(rd.getString("tim"));
		btnLamMoi.setText(rd.getString("lammoi"));
		btnXemChiTiet.setText(rd.getString("xemChiTiet"));
		
		maHD= rd.getString("maHoaDon");
		maNV=rd.getString("maNV");
		maKh=rd.getString("maKH");
		ngayTao=rd.getString("ngayTao");
		thanhTien=rd.getString("thanhTien");
		model = (DefaultTableModel) table.getModel();
		String[] column = {maHD,maNV,maKh,ngayTao,thanhTien};
		model.setColumnIdentifiers(column);
	}
	private void onOpenFormButtonClickKH() {
		dialogAddKH.searchHd = this;
		dialogAddKH.setModal(true);
		dialogAddKH.setVisible(true);
		dialogAddKH.setSearchHd(this);
		
	}
	public void onDataReturnedKH(String str) {
		System.out.println("Ma sp vua tra ve la:" + str);
		
		txtMaKH.setText(str);
	}
}
