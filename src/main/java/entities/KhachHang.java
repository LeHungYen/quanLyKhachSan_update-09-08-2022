package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KhachHang {
	@Id
	private int maKhachHang;
	private String tenKhachHang;
	private String sdt;
	private String email;
	private String cmnd;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	@OneToMany (mappedBy = "khachHang")
	private List<KhachTrongPhong> listKhachTrongPhong;
	
	public KhachHang(int maKhachHang, String tenKhachHang, String sdt, String email, String cmnd, Date ngaySinh,
			String gioiTinh, String diaChi,
			List<KhachTrongPhong> listKhachTrongPhong) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.email = email;
		this.cmnd = cmnd;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.listKhachTrongPhong = listKhachTrongPhong;
	}
	
	public KhachHang() {
		
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public List<KhachTrongPhong> getListKhachTrongPhong() {
		return listKhachTrongPhong;
	}

	public void setListKhachTrongPhong(List<KhachTrongPhong> listKhachTrongPhong) {
		this.listKhachTrongPhong = listKhachTrongPhong;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", sdt=" + sdt + ", email="
				+ email + ", cmnd=" + cmnd + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi
				+ ", listKhachTrongPhong=" + listKhachTrongPhong + "]";
	}

	
	
}
