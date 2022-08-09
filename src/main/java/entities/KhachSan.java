package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KhachSan {
	@Id
	private int maKhachSan;
	private String tenKhachSan;
	private String email;
	private String sdt;
	private String diaChi;
	@OneToMany (mappedBy = "khachSan")
	private List<Tang> listTang;
	
	public KhachSan(int maKhachSan, String tenKhachSan, String email, String sdt, String diaChi, List<Tang> listTang) {
		this.maKhachSan = maKhachSan;
		this.tenKhachSan = tenKhachSan;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.listTang = listTang;
	}
	public KhachSan() {
	
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
	public List<Tang> getListTang() {
		return listTang;
	}
	public void setListTang(List<Tang> listTang) {
		this.listTang = listTang;
	}
	
	@Override
	public String toString() {
		return "KhachSan [maKhachSan=" + maKhachSan + ", tenKhachSan=" + tenKhachSan + ", email=" + email + ", sdt="
				+ sdt + ", diaChi=" + diaChi + ", listTang=" + listTang + "]";
	}
	
	
}
