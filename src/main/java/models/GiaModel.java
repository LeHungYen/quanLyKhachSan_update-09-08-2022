package models;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import entities.LoaiPhong;

public class GiaModel {
	private int maGia;
	private String gioCheckIn;
	private String gioCheckOut;
	private double phatCheckInSom;
	private double phatCheckOutMuon;
	private List<LoaiPhongModel> listLoaiPhongModel;
	
	public GiaModel(int maGia, String gioCheckIn, String gioCheckOut, double phatCheckInSom, double phatCheckOutMuon,
			List<LoaiPhongModel> listLoaiPhongModel) {
		this.maGia = maGia;
		this.gioCheckIn = gioCheckIn;
		this.gioCheckOut = gioCheckOut;
		this.phatCheckInSom = phatCheckInSom;
		this.phatCheckOutMuon = phatCheckOutMuon;
		this.listLoaiPhongModel = listLoaiPhongModel;
	}
	public GiaModel() {
		this.maGia = maGia;
		this.gioCheckIn = gioCheckIn;
		this.gioCheckOut = gioCheckOut;
		this.phatCheckInSom = phatCheckInSom;
		this.phatCheckOutMuon = phatCheckOutMuon;
		this.listLoaiPhongModel = listLoaiPhongModel;
	}
	public int getMaGia() {
		return maGia;
	}
	public void setMaGia(int maGia) {
		this.maGia = maGia;
	}
	public String getGioCheckIn() {
		return gioCheckIn;
	}
	public void setGioCheckIn(String gioCheckIn) {
		this.gioCheckIn = gioCheckIn;
	}
	public String getGioCheckOut() {
		return gioCheckOut;
	}
	public void setGioCheckOut(String gioCheckOut) {
		this.gioCheckOut = gioCheckOut;
	}
	public double getPhatCheckInSom() {
		return phatCheckInSom;
	}
	public void setPhatCheckInSom(double phatCheckInSom) {
		this.phatCheckInSom = phatCheckInSom;
	}
	public double getPhatCheckOutMuon() {
		return phatCheckOutMuon;
	}
	public void setPhatCheckOutMuon(double phatCheckOutMuon) {
		this.phatCheckOutMuon = phatCheckOutMuon;
	}
	public List<LoaiPhongModel> getListLoaiPhongModel() {
		return listLoaiPhongModel;
	}
	public void setListLoaiPhongModel(List<LoaiPhongModel> listLoaiPhongModel) {
		this.listLoaiPhongModel = listLoaiPhongModel;
	}
	@Override
	public String toString() {
		return "GiaModel [maGia=" + maGia + ", gioCheckIn=" + gioCheckIn + ", gioCheckOut=" + gioCheckOut
				+ ", phatCheckInSom=" + phatCheckInSom + ", phatCheckOutMuon=" + phatCheckOutMuon + "]";
	}
	
	
	
}
