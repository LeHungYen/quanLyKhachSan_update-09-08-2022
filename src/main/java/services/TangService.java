package services;

import java.util.ArrayList;
import java.util.List;

import dao.TangDao;
import entities.Tang;
import models.TangModel;
import utils.IoCContainer;

public class TangService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<TangModel> _listTangModels = new ArrayList<TangModel>();
	private TangDao _TangDao = (TangDao) ioCContainer.getBean(TangDao.class.toString());
	private Tang _Tang;

	public static Tang updateDataTangDependOnTangModel(TangModel TangModel) {
		Tang Tang = new Tang();
		Tang.setMaTang(TangModel.getMaTang());
		Tang.setKhachSan(KhachSanService.updateDataKhachSanDependOnKhachSanModel(TangModel.getKhachSanModel()));
		Tang.setTrangThai(TangModel.getTrangThai());
		return Tang;
	}
	
	public static TangModel updateDataTangModelDependOnTang(Tang Tang) {
		TangModel TangModel = new TangModel();
		TangModel.setMaTang(Tang.getMaTang());
		TangModel.setKhachSanModel(KhachSanService.updateDataKhachSanModelDependOnKhachSan(Tang.getKhachSan()));
		TangModel.setTrangThai(Tang.getTrangThai());
		return TangModel;
	}
	
	public static List<Tang> updateListTangDependOnListTangModel(List<TangModel> listTangModel) {
		List<Tang> listTang = new ArrayList<Tang>();
		for (TangModel TangModel2 : listTangModel) {
			Tang Tang = updateDataTangDependOnTangModel(TangModel2);
			listTang.add(Tang);
		}
		return listTang;
	}
	
	public static List<TangModel> updateListTangModelDependOnListTang(List<Tang> listTang) {
		List<TangModel> listTangModel = new ArrayList<TangModel>();
		for (Tang Tang : listTang) {
			TangModel TangModel = updateDataTangModelDependOnTang(Tang);
			listTangModel.add(TangModel);
		}
		return listTangModel;
	}

	public void them_sua(TangModel TangModel) {
		_Tang = updateDataTangDependOnTangModel(TangModel);
		_TangDao.them_sua(_Tang);
		_listTangModels.add(TangModel);// check lại
	}

	public void updateListTangModel() {
		_TangDao.updateListTang();
		List<Tang> listTang = _TangDao.getListTang();
		_listTangModels = updateListTangModelDependOnListTang(listTang);

	}

	public List<TangModel> getListTangModel() {
		return _listTangModels;
	}

}
