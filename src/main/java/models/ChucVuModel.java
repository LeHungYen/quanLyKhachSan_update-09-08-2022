package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import entities.NhanVien;
import entities.Quyen_cv;

public class ChucVuModel implements Serializable{
	private int maChucVu;
	private String tenChucVu;
	private String trangThai;
	
	
	
	public ChucVuModel(int maChucVu, String tenChucVu, String trangThai) {
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
		this.trangThai = trangThai;
	}
	public ChucVuModel() {
		
	}



	public int getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
}
