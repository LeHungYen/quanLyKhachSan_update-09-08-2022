package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import entities.SanPhamVaDichVu;

public class NhomSPVaDichVuModel {
	private int maNhomSP;
	private String tenNhomSP;
	private String nhomHangHoa;
	private String ghiChu;
	private String trangThai;
	
	public NhomSPVaDichVuModel(int maNhomSP, String tenNhomSP, String nhomHangHoa, String ghiChu, String trangThai) {
		this.maNhomSP = maNhomSP;
		this.tenNhomSP = tenNhomSP;
		this.nhomHangHoa = nhomHangHoa;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
	}
	public NhomSPVaDichVuModel() {
	}
	public int getMaNhomSP() {
		return maNhomSP;
	}
	public void setMaNhomSP(int maNhomSP) {
		this.maNhomSP = maNhomSP;
	}
	public String getTenNhomSP() {
		return tenNhomSP;
	}
	public void setTenNhomSP(String tenNhomSP) {
		this.tenNhomSP = tenNhomSP;
	}
	public String getNhomHangHoa() {
		return nhomHangHoa;
	}
	public void setNhomHangHoa(String nhomHangHoa) {
		this.nhomHangHoa = nhomHangHoa;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
	
	
	
	
	
}
