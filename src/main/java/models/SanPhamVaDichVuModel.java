package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.PhieuNhapKhoChiTiet;
import entities.DichVuPhong;
import entities.DonViChiTiet;
import entities.Kho;
import entities.PhieuKiemKhoChiTiet;
import entities.NhomSPVaDichVu;

public class SanPhamVaDichVuModel {
	private int maDichVu;
	private String tenHangHoa;
	private NhomSPVaDichVuModel nhomSPVaDichVuModel;
	private int soLuongTon;
	private double giaVon;
	private KhoModel khoModel;
	private String moTa;
	private String trangThai;
	public SanPhamVaDichVuModel(int maDichVu, String tenHangHoa, NhomSPVaDichVuModel nhomSPVaDichVuModel,
			int soLuongTon, double giaVon, KhoModel khoModel, String moTa, String trangThai) {
		this.maDichVu = maDichVu;
		this.tenHangHoa = tenHangHoa;
		this.nhomSPVaDichVuModel = nhomSPVaDichVuModel;
		this.soLuongTon = soLuongTon;
		this.giaVon = giaVon;
		this.khoModel = khoModel;
		this.moTa = moTa;
		this.trangThai = trangThai;
	}
	public SanPhamVaDichVuModel() {
	}
	public int getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(int maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenHangHoa() {
		return tenHangHoa;
	}
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	public NhomSPVaDichVuModel getNhomSPVaDichVuModel() {
		return nhomSPVaDichVuModel;
	}
	public void setNhomSPVaDichVuModel(NhomSPVaDichVuModel nhomSPVaDichVuModel) {
		this.nhomSPVaDichVuModel = nhomSPVaDichVuModel;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public double getGiaVon() {
		return giaVon;
	}
	public void setGiaVon(double giaVon) {
		this.giaVon = giaVon;
	}
	public KhoModel getKhoModel() {
		return khoModel;
	}
	public void setKhoModel(KhoModel khoModel) {
		this.khoModel = khoModel;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "SanPhamVaDichVuModel [maDichVu=" + maDichVu + ", tenHangHoa=" + tenHangHoa + ", nhomSPVaDichVuModel="
				+ nhomSPVaDichVuModel + ", soLuongTon=" + soLuongTon + ", giaVon=" + giaVon + ", khoModel=" + khoModel
				+ ", moTa=" + moTa + ", trangThai=" + trangThai + "]";
	}

	


}
