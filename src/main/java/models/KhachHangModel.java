package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import entities.DichVuPhong;
import entities.KhachTrongPhong;

public class KhachHangModel {
	private int maKhachHang;
	private String tenKhachHang;
	private String sdt;
	private String email;
	private String cmnd;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private List<KhachTrongPhongModel> listKhachTrongPhongModel;

	public KhachHangModel(int maKhachHang, String tenKhachHang, String sdt, String email, String cmnd, Date ngaySinh,
			String gioiTinh, String diaChi, List<KhachTrongPhongModel> listKhachTrongPhongModel) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.email = email;
		this.cmnd = cmnd;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.listKhachTrongPhongModel = listKhachTrongPhongModel;
	}
	public KhachHangModel() {
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


	public List<KhachTrongPhongModel> getListKhachTrongPhongModel() {
		return listKhachTrongPhongModel;
	}

	public void setListKhachTrongPhongModel(List<KhachTrongPhongModel> listKhachTrongPhongModel) {
		this.listKhachTrongPhongModel = listKhachTrongPhongModel;
	}

	@Override
	public String toString() {
		return "KhachHangModel [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", sdt=" + sdt
				+ ", email=" + email + ", cmnd=" + cmnd + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", diaChi=" + diaChi + ", listKhachTrongPhongModel=" + listKhachTrongPhongModel + "]";
	}

	

}
