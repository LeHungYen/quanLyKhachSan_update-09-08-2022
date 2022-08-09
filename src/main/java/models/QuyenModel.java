package models;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import entities.Quyen_cv;

public class QuyenModel {
	private int maQuyen;
	private String tenQuyen;
	private List<Quyen_cvModel> listQuyen_cvModel;
	public QuyenModel(int maQuyen, String tenQuyen, List<Quyen_cvModel> listQuyen_cvModel) {
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
		this.listQuyen_cvModel = listQuyen_cvModel;
	}
	public QuyenModel() {
	}
	public int getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return tenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	public List<Quyen_cvModel> getListQuyen_cvModel() {
		return listQuyen_cvModel;
	}
	public void setListQuyen_cvModel(List<Quyen_cvModel> listQuyen_cvModel) {
		this.listQuyen_cvModel = listQuyen_cvModel;
	}
	@Override
	public String toString() {
		return "QuyenModel [maQuyen=" + maQuyen + ", tenQuyen=" + tenQuyen + ", listQuyen_cvModel=" + listQuyen_cvModel
				+ "]";
	}
	
	
}
