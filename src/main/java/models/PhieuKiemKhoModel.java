package models;

import java.sql.Date;
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

import entities.PhieuKiemKhoChiTiet;
import entities.Kho;
import entities.NhanVien;

public class PhieuKiemKhoModel {
	private int maKiemKho;
	private String ngayKiemKho;
	private NhanVienModel nhanVienModel;
	private KhoModel khoModel;
	private String ghiChu;
	
	public PhieuKiemKhoModel(int maKiemKho, String ngayKiemKho, NhanVienModel nhanVienModel, KhoModel khoModel,
			String ghiChu) {
		this.maKiemKho = maKiemKho;
		this.ngayKiemKho = ngayKiemKho;
		this.nhanVienModel = nhanVienModel;
		this.khoModel = khoModel;
		this.ghiChu = ghiChu;
	}
	
	public PhieuKiemKhoModel() {
	}

	public int getMaKiemKho() {
		return maKiemKho;
	}

	public void setMaKiemKho(int maKiemKho) {
		this.maKiemKho = maKiemKho;
	}

	public String getNgayKiemKho() {
		return ngayKiemKho;
	}

	public void setNgayKiemKho(String ngayKiemKho) {
		this.ngayKiemKho = ngayKiemKho;
	}

	public NhanVienModel getNhanVienModel() {
		return nhanVienModel;
	}

	public void setNhanVienModel(NhanVienModel nhanVienModel) {
		this.nhanVienModel = nhanVienModel;
	}

	public KhoModel getKhoModel() {
		return khoModel;
	}

	public void setKhoModel(KhoModel khoModel) {
		this.khoModel = khoModel;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "PhieuKiemKhoModel [maKiemKho=" + maKiemKho + ", ngayKiemKho=" + ngayKiemKho + ", nhanVienModel="
				+ nhanVienModel + ", khoModel=" + khoModel + ", ghiChu=" + ghiChu + "]";
	}

	
	
	
	
	
}
