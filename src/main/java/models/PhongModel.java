package models;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.DichVuPhong;
import entities.KhachTrongPhong;
import entities.LoaiPhong;
import entities.Tang;

public class PhongModel {
	private int maPhong;
	private LoaiPhongModel loaiPhongModel;
	private String trangThai;
	private TangModel tangModel;
	private List<KhachTrongPhongModel> listKhachTrongPhongModel;
	
	public PhongModel(int maPhong, LoaiPhongModel loaiPhongModel, String trangThai, TangModel tangModel,
			List<KhachTrongPhongModel> listKhachTrongPhongModel) {
		this.maPhong = maPhong;
		this.loaiPhongModel = loaiPhongModel;
		this.trangThai = trangThai;
		this.tangModel = tangModel;
		this.listKhachTrongPhongModel = listKhachTrongPhongModel;
	}
	
	public PhongModel() {
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public LoaiPhongModel getLoaiPhongModel() {
		return loaiPhongModel;
	}

	public void setLoaiPhongModel(LoaiPhongModel loaiPhongModel) {
		this.loaiPhongModel = loaiPhongModel;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public TangModel getTangModel() {
		return tangModel;
	}

	public void setTangModel(TangModel tangModel) {
		this.tangModel = tangModel;
	}

	public List<KhachTrongPhongModel> getListKhachTrongPhongModel() {
		return listKhachTrongPhongModel;
	}

	public void setListKhachTrongPhongModel(List<KhachTrongPhongModel> listKhachTrongPhongModel) {
		this.listKhachTrongPhongModel = listKhachTrongPhongModel;
	}

	@Override
	public String toString() {
		return "PhongModel [maPhong=" + maPhong + ", loaiPhongModel=" + loaiPhongModel + ", trangThai=" + trangThai
				+ ", tangModel=" + tangModel + ", listKhachTrongPhongModel=" + listKhachTrongPhongModel + "]";
	}



	
	
	
}
