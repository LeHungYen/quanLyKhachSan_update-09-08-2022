package services;

import java.util.ArrayList;
import java.util.List;

import dao.Quyen_cvDao;
import entities.Quyen_cv;
import models.ChucVuModel;
import models.Quyen_cvModel;
import utils.IoCContainer;

public class Quyen_cvService {
	private IoCContainer ioCContainer = new IoCContainer();
	private List<Quyen_cvModel> _listQuyen_cvModels = new ArrayList<Quyen_cvModel>();
	private Quyen_cvDao _Quyen_cvDao = (Quyen_cvDao) ioCContainer.getBean(Quyen_cvDao.class.toString());
	private Quyen_cv _Quyen_cv;

	public static Quyen_cv updateDataQuyen_cvDependOnQuyen_cvModel(Quyen_cvModel Quyen_cvModel) {
		Quyen_cv Quyen_cv = new Quyen_cv();
		Quyen_cv.setQuyen(QuyenService.updateDataQuyenDependOnQuyenModel(Quyen_cvModel.getQuyenModel()));
		Quyen_cv.setChucVu(ChucVuService.modelToEntity(Quyen_cvModel.getChucVuModel()));
		return Quyen_cv;
	}
	
	public static Quyen_cvModel updateDataQuyen_cvModelDependOnQuyen_cv(Quyen_cv Quyen_cv) {
		Quyen_cvModel Quyen_cvModel = new Quyen_cvModel();
		Quyen_cvModel.setQuyenModel(QuyenService.updateDataQuyenModelDependOnQuyen(Quyen_cv.getQuyen()));
		Quyen_cvModel.setChucVuModel(ChucVuService.entityToModel(Quyen_cv.getChucVu()));
		return Quyen_cvModel;
	}
	
	public static List<Quyen_cv> updateListQuyen_cvDependOnListQuyen_cvModel(List<Quyen_cvModel> listQuyen_cvModel) {
		List<Quyen_cv> listQuyen_cv = new ArrayList<Quyen_cv>();
		for (Quyen_cvModel Quyen_cvModel2 : listQuyen_cvModel) {
			Quyen_cv Quyen_cv = updateDataQuyen_cvDependOnQuyen_cvModel(Quyen_cvModel2);
			listQuyen_cv.add(Quyen_cv);
		}
		return listQuyen_cv;
	}
	
	public static List<Quyen_cvModel> updateListQuyen_cvModelDependOnListQuyen_cv(List<Quyen_cv> listQuyen_cv) {
		List<Quyen_cvModel> listQuyen_cvModel = new ArrayList<Quyen_cvModel>();
		for (Quyen_cv Quyen_cv : listQuyen_cv) {
			Quyen_cvModel Quyen_cvModel = updateDataQuyen_cvModelDependOnQuyen_cv(Quyen_cv);
			listQuyen_cvModel.add(Quyen_cvModel);
		}
		return listQuyen_cvModel;
	}

	public void them_sua(Quyen_cvModel Quyen_cvModel) {
		_Quyen_cv = updateDataQuyen_cvDependOnQuyen_cvModel(Quyen_cvModel);
		_Quyen_cvDao.them_sua(_Quyen_cv);
		_listQuyen_cvModels.add(Quyen_cvModel);// check lại
	}

	public void updateListQuyen_cvModel() {
		_Quyen_cvDao.updateListQuyen_cv();
		List<Quyen_cv> listQuyen_cv = _Quyen_cvDao.getListQuyen_cv();
		_listQuyen_cvModels = updateListQuyen_cvModelDependOnListQuyen_cv(listQuyen_cv);

	}

	public List<Quyen_cvModel> getListQuyen_cvModel() {
		return _listQuyen_cvModels;
	}
}
