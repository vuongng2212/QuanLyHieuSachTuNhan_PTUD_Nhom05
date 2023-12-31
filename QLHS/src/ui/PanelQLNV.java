package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_NhanVien;
import dao.DAO_account;
import entity.NhanVien;
import list.DanhSachNhanVien;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class PanelQLNV extends JPanel{
	private JTable table;
	private DefaultTableModel tableModel;
	private DanhSachNhanVien ls;
	private DAO_NhanVien DAO_NV;
	private DAO_account DAO_acc;
	private JTextField txtMa,txtTen,txtSDT,txtDiaChi,txtEmail;
	private JComboBox cbGT,cbCV;
	private JDateChooser dateChooser;
	private int stt = 1;
	private Image img_TaoMaDH = new ImageIcon(FormNVQuanLy.class.getResource("/image/added.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	/**
	 * Create the panel.
	 */
	public PanelQLNV() {
		ls = new DanhSachNhanVien();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setBounds(0, 0, 400, 817);
		add(westPanel);
		
		JLabel lblTen = new JLabel("Tên nhân viên:");
		lblTen.setForeground(new Color(0, 0, 160));
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(10, 102, 150, 30);
		westPanel.add(lblTen);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setForeground(new Color(0, 0, 160));
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBounds(10, 225, 130, 30);
		westPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 160));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 307, 130, 30);
		westPanel.add(lblEmail);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setForeground(new Color(0, 0, 160));
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGT.setBounds(10, 143, 130, 30);
		westPanel.add(lblGT);
		
		JLabel lblDoB = new JLabel("Ngày sinh:");
		lblDoB.setForeground(new Color(0, 0, 160));
		lblDoB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoB.setBounds(10, 184, 130, 30);
		westPanel.add(lblDoB);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(205, 102, 160, 30);
		westPanel.add(txtTen);
		
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(205, 225, 160, 30);
		westPanel.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(205, 266, 160, 30);
		westPanel.add(txtDiaChi);
		
		cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbGT.setBounds(205, 143, 70, 30);
		westPanel.add(cbGT);
		
		JLabel lblTimNV = new JLabel("Quản lý nhân viên");
		lblTimNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimNV.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTimNV.setBounds(0, 0, 400, 50);
		westPanel.add(lblTimNV);
		
		JLabel lblMa = new JLabel("Mã nhân viên:");
		lblMa.setForeground(new Color(0, 0, 160));
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(10, 61, 130, 30);
		westPanel.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMa.setColumns(10);
		txtMa.setBounds(205, 61, 120, 30);
		westPanel.add(txtMa);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setForeground(new Color(0, 0, 160));
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(10, 266, 130, 30);
		westPanel.add(lblDiaChi);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(205, 307, 160, 30);
		westPanel.add(txtEmail);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setForeground(new Color(0, 0, 160));
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV.setBounds(10, 348, 130, 30);
		westPanel.add(lblChcV);
		
		cbCV = new JComboBox();
		cbCV.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên","Quản lý"}));
		cbCV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbCV.setBounds(205, 354, 130, 30);
		westPanel.add(cbCV);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(205, 184, 160, 30);
		dateChooser.getDate();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		westPanel.add(dateChooser);
		
		
		String[] headers = { "STT", "Mã nhân viên", "Họ và tên","Ngày sinh",  "Giới tính",  "SĐT", "Địa chỉ", "Email", "Chức vụ"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(400, 0, 1520, 760);
		scroll.setViewportView(table = new JTable(tableModel));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					txtMa.setEditable(false);
					txtMa.setText(table.getValueAt(row, 1).toString());
					txtTen.setText(table.getValueAt(row, 2).toString());
					String gt = table.getValueAt(row, 4).toString();
					txtSDT.setText(table.getValueAt(row, 5).toString());
					txtDiaChi.setText(table.getValueAt(row, 6).toString());
					txtEmail.setText(table.getValueAt(row, 7).toString());
					String cv = table.getValueAt(row, 8).toString();
					String d = table.getValueAt(row, 3).toString();
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date = null;
					try {
						date = sdf1.parse(d);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
					dateChooser.setDate(sqlStartDate);
					cbGT.setSelectedItem(gt);
					cbCV.setSelectedItem(cv);
				}
				
			}
		});
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
//		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
//		table.getColumnModel().getColumn(3).setPreferredWidth(50);
//		table.getColumnModel().getColumn(4).setPreferredWidth(10);
//		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(500);
		table.getColumnModel().getColumn(7).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		add(scroll);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				if (r != -1) {
					String ma = txtMa.getText();
					String ten = txtTen.getText();
					Date ns = new Date(dateChooser.getDate().getTime());
					String gioiTinh = cbGT.getSelectedItem().toString();
					Integer gt = 1;
					if(gioiTinh=="Nữ") {
						gt =0;
					}
					String sdt = txtSDT.getText();
					String diaChi = txtDiaChi.getText();
					String email = txtEmail.getText();
					String CV = cbCV.getSelectedItem().toString();
					DAO_NV = new DAO_NhanVien();
					NhanVien nv = new NhanVien(ma, ten, ns, gt, sdt, diaChi, email, CV);
					if(table.getValueAt(r, 1).toString().equals(ma)) {
						if (DAO_NV.updateNhanVien(nv)) {
							ls.capNhatThongTinNhanVien(nv);
							loadData();
							JOptionPane.showMessageDialog(getParent(), "Cập nhật thông tin nhân viên thành công!");
						}
						else {
							JOptionPane.showMessageDialog(getParent(), "Không thành công! Vui lòng kiểm tra lại...");
						}
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Không thể thay đổi mã NV");
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "Vui lòng chọn nhân viên muốn sửa thông tin!");
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua.setBackground(new Color(0, 128, 255));
		btnSua.setBounds(10, 516, 130, 30);
		westPanel.add(btnSua);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validData()) {
					String ma = txtMa.getText();
					String ten = txtTen.getText();
					Date ns = new Date(dateChooser.getDate().getTime());
					java.util.Date date = new java.util.Date(ns.getTime());
					String gioiTinh = cbGT.getSelectedItem().toString();
					Integer gt = 0;
					if(gioiTinh=="Nam"){
						gt = 1;
					}
					String sdt = txtSDT.getText();
					String diaChi = txtDiaChi.getText();
					String email = txtEmail.getText();
					String CV = cbCV.getSelectedItem().toString();
					NhanVien nv = new NhanVien(ma, ten, ns, gt, sdt, diaChi, email, CV);
					if(DAO_NV.add(nv) && DAO_NV.addPwd(nv.getSDT(), "1111")) {
						ls.themNhanVien(nv);
						Object row[] = {stt++,ma, ten, ns.toString(), gioiTinh, sdt, diaChi, email, CV};
						tableModel.addRow(row);
						JOptionPane.showMessageDialog(getParent(), "Thêm Nhân viên thành công! Mật khẩu mặc định là 1111");
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Thêm Nhân viên thất bại!");
					}
				}
				
			}
		});
		btnThem.setForeground(new Color(0, 0, 160));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(10, 445, 130, 30);
		westPanel.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				if (r != -1) {
					DAO_acc = new DAO_account();
					int tb = JOptionPane.showConfirmDialog(getParent(), "Bạn muốn xóa nhân viên này không?", "Chú ý!", JOptionPane.YES_NO_OPTION);
					if (tb == JOptionPane.YES_OPTION) {
						ls.xoaNV(r);
						DAO_acc.deleteAcc(table.getValueAt(r, 5).toString());
						DAO_NV.delete(table.getValueAt(r, 1).toString());
						tableModel.removeRow(r);
						JOptionPane.showMessageDialog(getParent(), "Xoá nhân viên thành công!");
						xoaTrang();
						loadData();
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "Vui lòng chọn nhân viên muốn xoá!");
				}
				
			}
		});
		
		btnXoa.setForeground(new Color(0, 0, 160));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(205, 516, 130, 30);
		westPanel.add(btnXoa);
		
		JButton btnRefresh = new JButton("Làm mới");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRefresh.setBackground(new Color(0, 128, 255));
		btnRefresh.setBounds(205, 445, 130, 30);
		westPanel.add(btnRefresh);
		
		JButton btnKhoiTaoMa = new JButton("");
		btnKhoiTaoMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO_NV = new DAO_NhanVien();
				String ma = DAO_NV.getLastNV();
				if(ma!=null) {	
					Integer strToInt = Integer.parseInt(ma.substring(2));
					String s = String.format("%03d", strToInt + 1);
					txtMa.setText("NV"+s);
				}
			}
		});
		btnKhoiTaoMa.setIcon(new ImageIcon(img_TaoMaDH));
		btnKhoiTaoMa.setBounds(335, 61, 30, 30);
		westPanel.add(btnKhoiTaoMa);
		
		JButton btnTaoQR = new JButton("Tạo QR");
		btnTaoQR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					DAO_NV = new DAO_NhanVien();
					String user = txtSDT.getText();
					String pwd = DAO_NV.getPwd(user);
					System.out.println(pwd);
					try {
						GenerateQR(user, pwd);
					} catch (WriterException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(getParent(), "Vui lòng chọn nhân viên muốn tạo QR");
				}
			}
		});
		btnTaoQR.setForeground(new Color(0, 0, 160));
		btnTaoQR.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTaoQR.setBackground(Color.GREEN);
		btnTaoQR.setBounds(1810, 771, 100, 30);
		add(btnTaoQR);

		loadData();
	}
	public void deleteAllDataJtable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
		stt = 1;
	}
	
	public void loadData() {
		xoaTrang();
		//delete all
		deleteAllDataJtable();
		//Load data
		DAO_NV = new DAO_NhanVien();
		stt = 1;
		ls.clear();
		for(NhanVien nv: DAO_NV.getAll()) {
			ls.themNhanVien(nv);
			String gioiTinh = "Nam";
			if(nv.getGioiTinh()==0) {
				gioiTinh = "Nữ";
			}
			Object row[] = {stt++,nv.getMaNV(),nv.getTenNV(),nv.getDoB(),gioiTinh,nv.getSDT(),nv.getDiaChi(),nv.getEmail(),nv.getChucVu()};
			tableModel.addRow(row);
		}
	}
	private void xoaTrang() {
		txtMa.setEditable(true);
		txtMa.setText("");
		txtTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		dateChooser.setCalendar(null);
	}
	private boolean validData() {
		String maNV = txtMa.getText().trim();
		String tenNV = txtTen.getText().trim();
		String sdt = txtSDT.getText().trim();
		String gmail = txtEmail.getText().trim();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		

		Pattern p = Pattern.compile("^(NV)[0-9]{3}");
		if (!(maNV.length() > 0 && p.matcher(maNV).find())) {
			JOptionPane.showMessageDialog(getParent(), "Loi ma nv");
			return false;
		}
		
		Pattern p1 = Pattern.compile("[a-zA-Z]+");
		if (!(tenNV.length() > 0 && p1.matcher(tenNV).find())) {
			JOptionPane.showMessageDialog(getParent(), "Loi ten nv");
			return false;
		}

		Pattern p3 = Pattern.compile("[0-9]{10}");
		if (!(sdt.length() > 0 && p3.matcher(sdt).find())) {
			JOptionPane.showMessageDialog(getParent(), "Loi SDT");
			return false;
		}

		Pattern p4 = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
		if (!(gmail.length() > 0 && p4.matcher(gmail).find())) {
			JOptionPane.showMessageDialog(getParent(), "Loi email");
			return false;
		}
		
		if(dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(getParent(), "Ngày sinh không được để trống");
			return false;
		}
		else {
			Integer date = Integer.parseInt(sdf.format(dateChooser.getDate()));
			int year = Year.now().getValue();
			if(year - date <= 18) {
				JOptionPane.showMessageDialog(getParent(), "Nhân viên nhỏ hơn 18 tuổi!");
				return false;
			}
		}
		
		return true;
	}
	public void GenerateQR(String user, String pwd) throws WriterException, IOException {
		String content = user + " " + pwd;
        String pathToStore = "D:\\"+user+".jpg";
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 500, 500);
        MatrixToImageWriter.writeToPath(bitMatrix, "jpg", Paths.get(pathToStore));
        JOptionPane.showMessageDialog(getParent(), "Tạo mã QR thành công! Mã QR được lưu vào ổ D:");
	}
}
