package models;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import entities.Tang;

public class KhachSanModel {
	private int maKhachSan;
	private String tenKhachSan;
	private String email;
	private String sdt;
	private String diaChi;
	private List<TangModel> listTangModel;
	
	public KhachSanModel(int maKhachSan, String tenKhachSan, String email, String sdt, String diaChi,
			List<TangModel> listTangModel) {
		this.maKhachSan = maKhachSan;
		this.tenKhachSan = tenKhachSan;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.listTangModel = listTangModel;
	}
	public KhachSanModel() {
	}
	public int getMaKhachSan() {
		return maKhachSan;
	}
	public void setMaKhachSan(int maKhachSan) {
		this.maKhachSan = maKhachSan;
	}
	public String getTenKhachSan() {
		return tenKhachSan;
	}
	public void setTenKhachSan(String tenKhachSan) {
		this.tenKhachSan = tenKhachSan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public List<TangModel> getListTangModel() {
		return listTangModel;
	}
	public void setListTangModel(List<TangModel> listTangModel) {
		this.listTangModel = listTangModel;
	}
	@Override
	public String toString() {
		return "KhachSanModel [maKhachSan=" + maKhachSan + ", tenKhachSan=" + tenKhachSan + ", email=" + email
				+ ", sdt=" + sdt + ", diaChi=" + diaChi + "]";
	}
	
	
}
