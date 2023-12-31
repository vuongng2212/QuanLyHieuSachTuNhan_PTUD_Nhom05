package entity;

import java.sql.Date;

public class PhanCongCa {
	private String maNV;
	private Date ngayLV;
	private Integer maCa;
	private String tenNV;
	public PhanCongCa() {
		super();
	}
	public PhanCongCa(String maNV) {
		super();
		this.maNV = maNV;
	}
	
	public PhanCongCa(String maNV, Date ngayLV, Integer maCa, String tenNV) {
		super();
		this.maNV = maNV;
		this.ngayLV = ngayLV;
		this.maCa = maCa;
		this.tenNV = tenNV;
	}
	public PhanCongCa(Date ngayLV) {
		super();
		this.ngayLV = ngayLV;
	}
	public PhanCongCa(String maNV, Integer maCa , Date ngayLV) {
		super();
		this.maNV = maNV;
		this.ngayLV = ngayLV;
		this.maCa = maCa;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Date getNgayLV() {
		return ngayLV;
	}
	public void setNgayLV(Date ngayLV) {
		this.ngayLV = ngayLV;
	}
	public Integer getMaCa() {
		return maCa;
	}
	public void setMaCa(Integer maCa) {
		this.maCa = maCa;
	}
	
}
