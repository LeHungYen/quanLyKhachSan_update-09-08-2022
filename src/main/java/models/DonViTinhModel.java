package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.DichVuPhong;
import entities.DonViChiTiet;

public class DonViTinhModel {
	private int maDonVi;
	private String tenDonVi;
	private String trangThai;

	public DonViTinhModel(int maDonVi, String tenDonVi, String trangThai) {
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
		this.trangThai = trangThai;
	}

	public DonViTinhModel() {
	}

	public int getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(int maDonVi) {
		this.maDonVi = maDonVi;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "DonViTinhModel [maDonVi=" + maDonVi + ", tenDonVi=" + tenDonVi + ", trangThai=" + trangThai + "]";
	}

	

}
