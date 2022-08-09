package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.DichVuPhong;
import entities.HoaDon;
import entities.KhachHang;
import entities.Phong;

public class KhachTrongPhongModel {
	private int maKhachTrongPhong;
	private KhachHangModel khachHangModel;
	private HoaDonModel hoaDonModel;
	private PhongModel phongModel;
	private Date ngayCheckOut;
	private double giaPhong;
	private double phuPhi;
	private String ghiChu;
	private List<DichVuPhongModel> listDichVuPhongModel;
	
	public KhachTrongPhongModel(int maKhachTrongPhong, KhachHangModel khachHangModel, HoaDonModel hoaDonModel,
			PhongModel phongModel, Date ngayCheckOut, double giaPhong, double phuPhi, String ghiChu,
			List<DichVuPhongModel> listDichVuPhongModel) {
		this.maKhachTrongPhong = maKhachTrongPhong;
		this.khachHangModel = khachHangModel;
		this.hoaDonModel = hoaDonModel;
		this.phongModel = phongModel;
		this.ngayCheckOut = ngayCheckOut;
		this.giaPhong = giaPhong;
		this.phuPhi = phuPhi;
		this.ghiChu = ghiChu;
		this.listDichVuPhongModel = listDichVuPhongModel;
	}
	public KhachTrongPhongModel() {
	}
	public int getMaKhachTrongPhong() {
		return maKhachTrongPhong;
	}
	public void setMaKhachTrongPhong(int maKhachTrongPhong) {
		this.maKhachTrongPhong = maKhachTrongPhong;
	}
	public KhachHangModel getKhachHangModel() {
		return khachHangModel;
	}
	public void setKhachHangModel(KhachHangModel khachHangModel) {
		this.khachHangModel = khachHangModel;
	}
	public HoaDonModel getHoaDonModel() {
		return hoaDonModel;
	}
	public void setHoaDonModel(HoaDonModel hoaDonModel) {
		this.hoaDonModel = hoaDonModel;
	}
	public PhongModel getPhongModel() {
		return phongModel;
	}
	public void setPhongModel(PhongModel phongModel) {
		this.phongModel = phongModel;
	}
	public Date getNgayCheckOut() {
		return ngayCheckOut;
	}
	public void setNgayCheckOut(Date ngayCheckOut) {
		this.ngayCheckOut = ngayCheckOut;
	}
	public double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}
	public double getPhuPhi() {
		return phuPhi;
	}
	public void setPhuPhi(double phuPhi) {
		this.phuPhi = phuPhi;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public List<DichVuPhongModel> getListDichVuPhongModel() {
		return listDichVuPhongModel;
	}
	public void setListDichVuPhongModel(List<DichVuPhongModel> listDichVuPhongModel) {
		this.listDichVuPhongModel = listDichVuPhongModel;
	}
	
	@Override
	public String toString() {
		return "KhachTrongPhongModel [maKhachTrongPhong=" + maKhachTrongPhong + ", khachHangModel=" + khachHangModel
				+ ", hoaDonModel=" + hoaDonModel + ", phongModel=" + phongModel + ", ngayCheckOut=" + ngayCheckOut
				+ ", giaPhong=" + giaPhong + ", phuPhi=" + phuPhi + ", ghiChu=" + ghiChu + ", listDichVuPhongModel="
				+ listDichVuPhongModel + "]";
	}
	
	
}
