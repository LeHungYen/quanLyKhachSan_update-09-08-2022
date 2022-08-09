package models;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.KhachSan;
import entities.Phong;

public class TangModel {
	private int maTang;
	private KhachSanModel khachSanModel;
	private String trangThai;
	private List<PhongModel> listPhongModel ;
	public TangModel(int maTang, KhachSanModel khachSanModel, String trangThai, List<PhongModel> listPhongModel) {
		this.maTang = maTang;
		this.khachSanModel = khachSanModel;
		this.trangThai = trangThai;
		this.listPhongModel = listPhongModel;
	}
	public TangModel() {
	}
	public int getMaTang() {
		return maTang;
	}
	public void setMaTang(int maTang) {
		this.maTang = maTang;
	}
	public KhachSanModel getKhachSanModel() {
		return khachSanModel;
	}
	public void setKhachSanModel(KhachSanModel khachSanModel) {
		this.khachSanModel = khachSanModel;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public List<PhongModel> getListPhongModel() {
		return listPhongModel;
	}
	public void setListPhongModel(List<PhongModel> listPhongModel) {
		this.listPhongModel = listPhongModel;
	}
	@Override
	public String toString() {
		return "TangModel [maTang=" + maTang + ", khachSanModel=" + khachSanModel + ", trangThai=" + trangThai
				+ ", listPhongModel=" + listPhongModel + "]";
	}
	
	
	
}
