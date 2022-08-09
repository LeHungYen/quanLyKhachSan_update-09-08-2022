package models;

import javax.persistence.ManyToOne;

import entities.ChucVu;
import entities.Quyen;

public class Quyen_cvModel {
	private QuyenModel quyenModel;
	private ChucVuModel chucVuModel;
	public Quyen_cvModel(QuyenModel quyenModel, ChucVuModel chucVuModel) {
		this.quyenModel = quyenModel;
		this.chucVuModel = chucVuModel;
	}
	
	public Quyen_cvModel() {
	}

	public QuyenModel getQuyenModel() {
		return quyenModel;
	}

	public void setQuyenModel(QuyenModel quyenModel) {
		this.quyenModel = quyenModel;
	}

	public ChucVuModel getChucVuModel() {
		return chucVuModel;
	}

	public void setChucVuModel(ChucVuModel chucVuModel) {
		this.chucVuModel = chucVuModel;
	}

	@Override
	public String toString() {
		return "Quyen_cvModel [chucVuModel=" + chucVuModel + "]";
	}
	
	
}
