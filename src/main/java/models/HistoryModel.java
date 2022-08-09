package models;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import entities.NhanVien;

public class HistoryModel {
	private int id;
	private NhanVienModel nhanVienModel;
	private String doiTuong;
	private String hanhDong;
	private String ghiChu;
	
	public HistoryModel(int id, NhanVienModel nhanVienModel, String doiTuong, String hanhDong, String ghiChu) {
		this.id = id;
		this.nhanVienModel = nhanVienModel;
		this.doiTuong = doiTuong;
		this.hanhDong = hanhDong;
		this.ghiChu = ghiChu;
	}
	public HistoryModel() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NhanVienModel getNhanVienModel() {
		return nhanVienModel;
	}
	public void setNhanVienModel(NhanVienModel nhanVienModel) {
		this.nhanVienModel =nhanVienModel;
	}
	public String getDoiTuong() {
		return doiTuong;
	}
	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}
	public String getHanhDong() {
		return hanhDong;
	}
	public void setHanhDong(String hanhDong) {
		this.hanhDong = hanhDong;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "HistoryModel [id=" + id + ", nhanVienModel=" + nhanVienModel + ", doiTuong=" + doiTuong + ", hanhDong=" + hanhDong
				+ ", ghiChu=" + ghiChu + "]";
	}
	
	
}
