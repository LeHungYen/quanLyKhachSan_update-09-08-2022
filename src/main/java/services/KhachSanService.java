package services;

import java.util.ArrayList;
import java.util.List;

import dao.KhachSanDao;
import entities.KhachSan;
import models.KhachSanModel;
import utils.IoCContainer;

public class KhachSanService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<KhachSanModel> _listKhachSanModels = new ArrayList<KhachSanModel>();
	private KhachSanDao _KhachSanDao = (KhachSanDao) ioCContainer.getBean(KhachSanDao.class.toString());
	private KhachSan _KhachSan;

	public static KhachSan updateDataKhachSanDependOnKhachSanModel(KhachSanModel KhachSanModel) {
		KhachSan KhachSan = new KhachSan();
		KhachSan.setMaKhachSan(KhachSanModel.getMaKhachSan());
		KhachSan.setTenKhachSan(KhachSanModel.getTenKhachSan());
		KhachSan.setEmail(KhachSanModel.getEmail());
		KhachSan.setSdt(KhachSanModel.getSdt());
		KhachSan.setDiaChi(KhachSanModel.getDiaChi());
		return KhachSan;
	}
	
	public static KhachSanModel updateDataKhachSanModelDependOnKhachSan(KhachSan KhachSan) {
		KhachSanModel KhachSanModel = new KhachSanModel();
		KhachSanModel.setMaKhachSan(KhachSan.getMaKhachSan());
		KhachSanModel.setTenKhachSan(KhachSan.getTenKhachSan());
		KhachSanModel.setEmail(KhachSan.getEmail());
		KhachSanModel.setSdt(KhachSan.getSdt());
		KhachSanModel.setDiaChi(KhachSan.getDiaChi());
		return KhachSanModel;
	}
	
	public static List<KhachSan> updateListKhachSanDependOnListKhachSanModel(List<KhachSanModel> listKhachSanModel) {
		List<KhachSan> listKhachSan = new ArrayList<KhachSan>();
		for (KhachSanModel KhachSanModel2 : listKhachSanModel) {
			KhachSan KhachSan = updateDataKhachSanDependOnKhachSanModel(KhachSanModel2);
			listKhachSan.add(KhachSan);
		}
		return listKhachSan;
	}
	
	public static List<KhachSanModel> updateListKhachSanModelDependOnListKhachSan(List<KhachSan> listKhachSan) {
		List<KhachSanModel> listKhachSanModel = new ArrayList<KhachSanModel>();
		for (KhachSan KhachSan : listKhachSan) {
			KhachSanModel KhachSanModel = updateDataKhachSanModelDependOnKhachSan(KhachSan);
			listKhachSanModel.add(KhachSanModel);
		}
		return listKhachSanModel;
	}

	public void them_sua(KhachSanModel KhachSanModel) {
		_KhachSan = updateDataKhachSanDependOnKhachSanModel(KhachSanModel);
		_KhachSanDao.them_sua(_KhachSan);
		_listKhachSanModels.add(KhachSanModel);// check lại
	}

	public void updateListKhachSanModel() {
		_KhachSanDao.updateListKhachSan();
		List<KhachSan> listKhachSan = _KhachSanDao.getListKhachSan();
		_listKhachSanModels = updateListKhachSanModelDependOnListKhachSan(listKhachSan);

	}

	public List<KhachSanModel> getListKhachSanModel() {
		return _listKhachSanModels;
	}
}
