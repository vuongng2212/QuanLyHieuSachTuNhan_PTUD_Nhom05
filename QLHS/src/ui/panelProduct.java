package ui;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_SanPham;
import entity.SanPham;
import list.DanhSachSanPham;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelProduct extends JPanel {
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtTheLoai;
	private JTextField txtTacGia;
	private JTextField txtNXB;
	private JTextField txtNamXB;
	private JTextField txtSoLuong;
	private JTextField txtDonGiaGoc;
	private Image img_add = new ImageIcon(frmNV.class.getResource("/image/added.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_remove = new ImageIcon(frmNV.class.getResource("/image/rm.png")).getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH );
	private Image img_update = new ImageIcon(frmNV.class.getResource("/image/reload.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_search = new ImageIcon(frmNV.class.getResource("/image/search.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	public PanelSearchProduct panelSearchProduct;
	private JPanel panelTable;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private DanhSachSanPham listSp;
	private DAO_SanPham daoSp;
	private SanPham sp;
	private JTextField txtDonGiaBan;

	/**
	 * Create the panel.
	 */
	public panelProduct() {
		listSp = new DanhSachSanPham();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoSp = new DAO_SanPham();
		listSp = daoSp.getAll();
		this.setVisible(false);
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(244, 164, 96));
		panelTitle.setBounds(0, 0, 1534, 101);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lbllTitle = new JLabel("Thông Tin Sách");
		lbllTitle.setForeground(new Color(127, 255, 0));
		lbllTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbllTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTitle.setBounds(0, 0, 1534, 101);
		panelTitle.add(lbllTitle);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(250, 235, 215));
		panelSearch.setBounds(0, 143, 1534, 200);
		add(panelSearch);
		panelSearch.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Sách");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 82, 31);
		panelSearch.add(lblNewLabel);
		
		JLabel lbllMaSach = new JLabel("Mã Sách");
		lbllMaSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaSach.setBounds(0, 53, 82, 31);
		panelSearch.add(lbllMaSach);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(92, 57, 153, 27);
		panelSearch.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lbllTenSach = new JLabel("Tên Sách");
		lbllTenSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenSach.setBounds(277, 53, 82, 31);
		panelSearch.add(lbllTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(369, 57, 170, 27);
		panelSearch.add(txtTenSach);
		
		JLabel lbllDanhMuc = new JLabel("Danh Mục");
		lbllDanhMuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDanhMuc.setBounds(578, 53, 82, 31);
		panelSearch.add(lbllDanhMuc);
		
		txtTheLoai = new JTextField();
		txtTheLoai.setColumns(10);
		txtTheLoai.setBounds(670, 57, 170, 27);
		panelSearch.add(txtTheLoai);
		
		JLabel lbllTacGia = new JLabel("Tác Giả");
		lbllTacGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTacGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTacGia.setBounds(0, 104, 82, 31);
		panelSearch.add(lbllTacGia);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(92, 108, 153, 27);
		panelSearch.add(txtTacGia);
		
		JLabel lbllNXB = new JLabel("NXB");
		lbllNXB.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNXB.setBounds(277, 104, 82, 31);
		panelSearch.add(lbllNXB);
		
		txtNXB = new JTextField();
		txtNXB.setColumns(10);
		txtNXB.setBounds(369, 108, 170, 27);
		panelSearch.add(txtNXB);
		
		JLabel lbllNamXB = new JLabel("Năm XB");
		lbllNamXB.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNamXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNamXB.setBounds(578, 104, 82, 31);
		panelSearch.add(lbllNamXB);
		
		txtNamXB = new JTextField();
		txtNamXB.setColumns(10);
		txtNamXB.setBounds(670, 108, 170, 27);
		panelSearch.add(txtNamXB);
		
		JLabel lbllSoLuong = new JLabel("Số Lượng");
		lbllSoLuong.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSoLuong.setBounds(890, 53, 82, 31);
		panelSearch.add(lbllSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(994, 57, 170, 27);
		panelSearch.add(txtSoLuong);
		
		JLabel lbllDonGia = new JLabel("Đơn Giá Gốc");
		lbllDonGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDonGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDonGia.setBounds(863, 104, 109, 31);
		panelSearch.add(lbllDonGia);
		
		txtDonGiaGoc = new JTextField();
		txtDonGiaGoc.setColumns(10);
		txtDonGiaGoc.setBounds(994, 108, 170, 27);
		panelSearch.add(txtDonGiaGoc);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaSach.getText().equals("") || txtTenSach.getText().equals("") || txtTheLoai.getText().equals("") || txtSoLuong.getText().equals("") || txtTacGia.getText().equals("") || txtNXB.getText().equals("") || txtNamXB.getText().equals("") || txtDonGiaGoc.getText().equals("") || txtDonGiaBan.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền tất cả thông tin");
				}else {
					if(listSp.timSPTheoMa(txtMaSach.getText())==-1) {
						System.out.println("Bat dau");
						daoSp = new DAO_SanPham();
						sp = new SanPham();
						sp.setMaSP(txtMaSach.getText());
						sp.setTenSP(txtTenSach.getText());
						sp.setTenTG(txtTacGia.getText());
						sp.setNhaXB(txtNXB.getText());
						sp.setNamXB(Integer.parseInt(txtNamXB.getText()));
						sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
						sp.setDonGiaGoc(Double.parseDouble(txtDonGiaGoc.getText()));
						sp.setDonGiaMua(Double.parseDouble(txtDonGiaBan.getText()));
//						sp.setTinhTrang(txtTinhTrang.getText());
						sp.setDanhMuc(txtTheLoai.getText());
						
						System.out.println(sp.toString());
						if(daoSp.add(sp)) {
							listSp.add(sp);
							row[0] = txtMaSach.getText();
							row[1]  =txtTenSach.getText();
							row[2] = txtTacGia.getText();
							row[3] = txtTheLoai.getText();
							row[4] = txtNXB.getText();
							row[5] = txtNamXB.getText();
							row[6] = txtSoLuong.getText();
							row[7] = txtDonGiaGoc.getText();
							row[8] = txtDonGiaBan.getText();
//							row[9] = txtTinhTrang.getText();
							model.addRow(row);
						}
						txtMaSach.setText("");
						txtTenSach.setText("");
						txtTacGia.setText("");
						txtTheLoai.setText("");
						txtNXB.setText("");
						txtNamXB.setText("");
						txtSoLuong.setText("");
						txtDonGiaGoc.setText("");
						txtDonGiaBan.setText("");
//						txtTinhTrang.setText("");
						JOptionPane.showMessageDialog(null, "Thêm thành công");
					}else {
						JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại");
					}
				}
				
			}
		});
		btnThem.setBackground(new Color(240, 128, 128));
		btnThem.setForeground(new Color(60, 179, 113));
		btnThem.setIcon(new ImageIcon(img_add));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setBounds(250, 158, 125, 31);
		panelSearch.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
//				String maSP = model.getValueAt(i, 0).toString();
				if(i>=0) {
					SanPham sp = new SanPham();
					sp.setMaSP(txtMaSach.getText());
					sp.setTenSP(txtTenSach.getText());
					sp.setTenTG(txtTacGia.getText());
					sp.setNhaXB(txtNXB.getText());
					sp.setNamXB(Integer.parseInt(txtNamXB.getText()));
					sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
					sp.setDonGiaGoc(Double.parseDouble(txtDonGiaGoc.getText()));
					sp.setDonGiaMua(Double.parseDouble(txtDonGiaBan.getText()));
//					sp.setTinhTrang(txtTinhTrang.getText());
					sp.setDanhMuc(txtTheLoai.getText());
					listSp.update(sp);
					daoSp.update(sp);
					model.setValueAt(txtMaSach.getText(), i, 0);
					model.setValueAt(txtTenSach.getText(), i, 1);
					model.setValueAt(txtTacGia.getText(), i, 2);
					model.setValueAt(txtTheLoai.getText(), i, 3);
					model.setValueAt(txtNXB.getText(), i, 4);
					model.setValueAt(txtNamXB.getText(), i, 5);
					model.setValueAt(txtSoLuong.getText(), i, 6);
					model.setValueAt(txtDonGiaGoc.getText(), i, 7);
					model.setValueAt(txtDonGiaBan.getText(), i, 8);
//					model.setValueAt(txtTinhTrang.getText(), i, 9);
					JOptionPane.showMessageDialog(null, "Đã sửa thành công");
				}else {
					JOptionPane.showMessageDialog(null,"Vui lòng chọn bảng cần sửa");
				}
			}
		});
		btnSua.setBackground(new Color(218, 112, 214));
		btnSua.setForeground(new Color(0, 255, 255));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setIcon(new ImageIcon(img_update));
		btnSua.setBounds(509, 158, 109, 31);
		panelSearch.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					daoSp.delete(txtMaSach.getText());
					listSp.xoa(i);
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần xóa");
				}
			}
		});
		btnXoa.setBackground(new Color(123, 104, 238));
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setIcon(new ImageIcon(img_remove));
		btnXoa.setBounds(784, 158, 109, 31);
		panelSearch.add(btnXoa);
		
//		JCheckBox checkBoxKhuyenMai = new JCheckBox("Khuyến Mãi");
//		checkBoxKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 13));
//		checkBoxKhuyenMai.setBackground(null);
//		
//		checkBoxKhuyenMai.setBounds(1230, 108, 109, 25);
//		panelSearch.add(checkBoxKhuyenMai);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				panelSearchProduct.setVisible(true);
			}
		});
		btnSearch.setBounds(92, 11, 51, 31);
		btnSearch.setIcon(new ImageIcon(img_search));
		btnSearch.setBackground(null);
		btnSearch.setOpaque(false);
		btnSearch.setBorderPainted(false);
		
		panelSearch.add(btnSearch);
		
		JLabel lbllDonGiaMua = new JLabel("Đơn Giá Bán");
		lbllDonGiaMua.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDonGiaMua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDonGiaMua.setBounds(1200, 104, 109, 31);
		panelSearch.add(lbllDonGiaMua);
		
		txtDonGiaBan = new JTextField();
		txtDonGiaBan.setColumns(10);
		txtDonGiaBan.setBounds(1319, 104, 170, 27);
		panelSearch.add(txtDonGiaBan);
		
		JLabel lbllSearch = new JLabel("Sách");
		lbllSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllSearch.setForeground(new Color(255, 165, 0));
		lbllSearch.setBounds(10, 112, 118, 27);
		add(lbllSearch);
		
		
		
		panelTable = new JPanel();
		panelTable.setBounds(0, 354, 1534, 663);
		add(panelTable);
//		String[] column = {"Mã Sách","Tên Sách","Danh Mục","Tên Tác Giả","Nhà XB","năm XB","Số Lượng","Đơn Giá","Tình Trạng","Khuyến Mãi"};
//		DefaultTableModel model = new DefaultTableModel(column,0);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 29, 1534, 602);
		panelTable.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtMaSach.setText(model.getValueAt(i, 0).toString());
				txtTenSach.setText(model.getValueAt(i, 1).toString());
				txtTacGia.setText(model.getValueAt(i, 2).toString());
				txtTheLoai.setText(model.getValueAt(i, 3).toString());
				txtNXB.setText(model.getValueAt(i, 4).toString());
				txtNamXB.setText(model.getValueAt(i, 5).toString());
				txtSoLuong.setText(model.getValueAt(i, 6).toString());
				txtDonGiaGoc.setText(model.getValueAt(i, 7).toString());
				txtDonGiaBan.setText(model.getValueAt(i, 8).toString());
//				txtTinhTrang.setText(model.getValueAt(i, 9).toString());
			}
		});
		
		model = new DefaultTableModel();
		Object[] column = {"Mã Sản Phẩm","Tên Sản Phẩm","Tác Giả","Danh Mục","Nhà XB","Năm XB","Số Lượng","Giá Gốc","Giá Bán"};
		row = new Object[9];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		for (SanPham sp : listSp.getList()) {
			row[0] = sp.getMaSP();
			row[1] = sp.getTenSP();
			row[2] = sp.getTenTG();
			row[3] = sp.getDanhMuc();
			row[4] = sp.getNhaXB();
			row[5] = sp.getNamXB();
			row[6] = sp.getSoLuong();
			row[7] = sp.getDonGiaGoc();
			row[8] = sp.getDonGiaMua();
//			row[9] = sp.getTinhTrang();
			model.addRow(row);
		}
	
	}
}
