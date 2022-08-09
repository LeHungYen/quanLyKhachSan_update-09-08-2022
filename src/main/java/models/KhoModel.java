package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import entities.PhieuKiemKho;
import entities.SanPhamVaDichVu;

public class KhoModel {
	private int maKho;
	private String tenKho;
	private String trangThai;
	public KhoModel(int maKho, String tenKho, String trangThai) {
		this.maKho = maKho;
		this.tenKho = tenKho;
		this.trangThai = trangThai;
	}
	
	public KhoModel() {
	}

	public int getMaKho() {
		return maKho;
	}

	public void setMaKho(int maKho) {
		this.maKho = maKho;
	}

	public String getTenKho() {
		return tenKho;
	}

	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return maKho+"/"+tenKho + "/" + trangThai;
	}
	
	
	
	
	
	
}
