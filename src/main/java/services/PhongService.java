package services;

import java.util.ArrayList;
import java.util.List;

import dao.PhongDao;
import entities.Phong;
import models.PhongModel;
import utils.IoCContainer;

public class PhongService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<PhongModel> _listPhongModels = new ArrayList<PhongModel>();
	private PhongDao _PhongDao = (PhongDao) ioCContainer.getBean(PhongDao.class.toString());
	private Phong _Phong;

	public static Phong updateDataPhongDependOnPhongModel(PhongModel PhongModel) {
		Phong Phong = new Phong();
		Phong.setMaPhong(PhongModel.getMaPhong());
		Phong.setLoaiPhong(LoaiPhongService.modelToEntity(PhongModel.getLoaiPhongModel()));
		Phong.setTrangThai(PhongModel.getTrangThai());
		Phong.setTang(TangService.updateDataTangDependOnTangModel(PhongModel.getTangModel()));
		return Phong;
	}
	
	public static PhongModel updateDataPhongModelDependOnPhong(Phong Phong) {
		PhongModel PhongModel = new PhongModel();
		PhongModel.setMaPhong(Phong.getMaPhong());
		PhongModel.setLoaiPhongModel(LoaiPhongService.entityToModel(Phong.getLoaiPhong()));
		PhongModel.setTrangThai(Phong.getTrangThai());
		PhongModel.setTangModel(TangService.updateDataTangModelDependOnTang(Phong.getTang()));
		return PhongModel;
	}
	
	public static List<Phong> updateListPhongDependOnListPhongModel(List<PhongModel> listPhongModel) {
		List<Phong> listPhong = new ArrayList<Phong>();
		for (PhongModel PhongModel2 : listPhongModel) {
			Phong Phong = updateDataPhongDependOnPhongModel(PhongModel2);
			listPhong.add(Phong);
		}
		return listPhong;
	}
	
	public static List<PhongModel> updateListPhongModelDependOnListPhong(List<Phong> listPhong) {
		List<PhongModel> listPhongModel = new ArrayList<PhongModel>();
		for (Phong Phong : listPhong) {
			PhongModel PhongModel = updateDataPhongModelDependOnPhong(Phong);
			listPhongModel.add(PhongModel);
		}
		return listPhongModel;
	}

	public void them_sua(PhongModel PhongModel) {
		_Phong = updateDataPhongDependOnPhongModel(PhongModel);
		_PhongDao.them_sua(_Phong);
		_listPhongModels.add(PhongModel);// check lại
	}

	public void updateListPhongModel() {
		_PhongDao.updateListPhong();
		List<Phong> listPhong = _PhongDao.getListPhong();
		_listPhongModels = updateListPhongModelDependOnListPhong(listPhong);

	}

	public List<PhongModel> getListPhongModel() {
		return _listPhongModels;
	}
}
