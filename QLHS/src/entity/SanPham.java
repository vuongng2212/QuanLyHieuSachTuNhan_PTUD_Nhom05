package entity;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String tenTG;
	private String nhaXB;
	private int namXB;
	private int slNhap,slGoc,soLuong;
	private double donGiaGoc;
	private double donGiaMua;
	private String tinhTrang;
	private String danhMuc;

	
	
	public SanPham() {
		super();
	}

	public int getSlNhap() {
		return slNhap;
	}

	public void setSlNhap(int slNhap) {
		this.slNhap = slNhap;
	}

	public int getSlGoc() {
		return slGoc;
	}

	public void setSlGoc(int slGoc) {
		this.slGoc = slGoc;
	}

	public SanPham(String maSP, String tenSP, int slNhap, int slGoc, int soLuong) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.slNhap = slNhap;
		this.slGoc = slGoc;
		this.soLuong = soLuong;
	}

	public SanPham(String maSP, String tenSP, String tenTG, String nhaXB, int namXB, int soLuong, double donGiaGoc,
			double donGiaMua, String tinhTrang, String danhMuc) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.tenTG = tenTG;
		this.nhaXB = nhaXB;
		this.namXB = namXB;
		this.soLuong = soLuong;
		this.donGiaGoc = donGiaGoc;
		this.donGiaMua = donGiaMua;
		this.tinhTrang = tinhTrang;
		this.danhMuc = danhMuc;
	}




	public String getMaSP() {
		return maSP;
	}




	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}




	public String getTenSP() {
		return tenSP;
	}




	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}




	public String getTenTG() {
		return tenTG;
	}




	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}




	public String getNhaXB() {
		return nhaXB;
	}




	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}




	public int getNamXB() {
		return namXB;
	}




	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}




	public int getSoLuong() {
		return soLuong;
	}




	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}




	public double getDonGiaGoc() {
		return donGiaGoc;
	}




	public void setDonGiaGoc(double donGiaGoc) {
		this.donGiaGoc = donGiaGoc;
	}




	public double getDonGiaMua() {
		return donGiaMua;
	}




	public void setDonGiaMua(double donGiaMua) {
		this.donGiaMua = donGiaMua;
	}




	public String getTinhTrang() {
		return tinhTrang;
	}




	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}




	public String getDanhMuc() {
		return danhMuc;
	}




	public void setDanhMuc(String danhMuc) {
		this.danhMuc = danhMuc;
	}




	public SanPham(String maSP, String tenSP, String nhaXB, int namXB, int soLuong, double donGiaGoc, String tinhTrang,
			String danhMuc) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.nhaXB = nhaXB;
		this.namXB = namXB;
		this.soLuong = soLuong;
		this.donGiaGoc = donGiaGoc;
		this.tinhTrang = tinhTrang;
		this.danhMuc = danhMuc;
	}
	
	
	
}
