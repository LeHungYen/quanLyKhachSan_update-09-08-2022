package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.DichVuPhong;
import entities.KhachTrongPhong;
import entities.NhanVien;

public class HoaDonModel {
	private int maHoaDon;
	private String trangThai;
	private Date ngayCheckIn;
	private NhanVienModel nhanVienModel;
	private Date ngayTao;
	private double vat;
	private double giamGia;
	private double tienCoc;
	private List<KhachTrongPhongModel> listKhachTrongPhongModel;

	public HoaDonModel(int maHoaDon, String trangThai, Date ngayCheckIn, NhanVienModel nhanVienModel, Date ngayTao,
			double vat, double giamGia, double tienCoc, List<KhachTrongPhongModel> listKhachTrongPhongModel) {
		this.maHoaDon = maHoaDon;
		this.trangThai = trangThai;
		this.ngayCheckIn = ngayCheckIn;
		this.nhanVienModel = nhanVienModel;
		this.ngayTao = ngayTao;
		this.vat = vat;
		this.giamGia = giamGia;
		this.tienCoc = tienCoc;
		this.listKhachTrongPhongModel = listKhachTrongPhongModel;
	}

	public HoaDonModel() {
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayCheckIn() {
		return ngayCheckIn;
	}

	public void setNgayCheckIn(Date ngayCheckIn) {
		this.ngayCheckIn = ngayCheckIn;
	}

	public NhanVienModel getNhanVienModel() {
		return nhanVienModel;
	}

	public void setNhanVienModel(NhanVienModel nhanVienModel) {
		this.nhanVienModel = nhanVienModel;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(double tienCoc) {
		this.tienCoc = tienCoc;
	}


	public List<KhachTrongPhongModel> getListKhachTrongPhongModel() {
		return listKhachTrongPhongModel;
	}

	public void setListKhachTrongPhongModel(List<KhachTrongPhongModel> listKhachTrongPhongModel) {
		this.listKhachTrongPhongModel = listKhachTrongPhongModel;
	}

	@Override
	public String toString() {
		return "HoaDonModel [maHoaDon=" + maHoaDon + ", trangThai=" + trangThai + ", ngayCheckIn=" + ngayCheckIn
				+ ", nhanVienModel=" + nhanVienModel + ", ngayTao=" + ngayTao + ", vat=" + vat + ", giamGia=" + giamGia
				+ ", tienCoc=" + tienCoc + ", listKhachTrongPhongModel=" + listKhachTrongPhongModel + "]";
	}


}
