package services;

import java.util.ArrayList;
import java.util.List;

import dao.PhieuKiemKhoDao;
import entities.PhieuKiemKho;
import models.PhieuKiemKhoChiTietModel;
import models.PhieuKiemKhoModel;
import utils.IoCContainer;

public class PhieuKiemKhoService {
	private IoCContainer ioCContainer = new IoCContainer();
	private List<PhieuKiemKho> _listPhieuKiemKhos = new ArrayList<PhieuKiemKho>();
	private List<PhieuKiemKhoModel> _listPhieuKiemKhoModels = new ArrayList<PhieuKiemKhoModel>();
	private PhieuKiemKhoDao _PhieuKiemKhoDao = (PhieuKiemKhoDao) ioCContainer.getBean(PhieuKiemKhoDao.class.toString());
	private PhieuKiemKho _PhieuKiemKho;
	private int maxID;
	
	public static PhieuKiemKho modelToEntity(PhieuKiemKhoModel PhieuKiemKhoModel) {
		PhieuKiemKho PhieuKiemKho = new PhieuKiemKho();
		PhieuKiemKho.setMaKiemKho(PhieuKiemKhoModel.getMaKiemKho());
		PhieuKiemKho.setNgayKiemKho(PhieuKiemKhoModel.getNgayKiemKho());
		PhieuKiemKho.setNhanVien(NhanVienService.modelToEntity(PhieuKiemKhoModel.getNhanVienModel()));
		PhieuKiemKho.setKho(KhoService.modelToEntity(PhieuKiemKhoModel.getKhoModel()));
		PhieuKiemKho.setGhiChu(PhieuKiemKhoModel.getGhiChu());
		return PhieuKiemKho;
	}
	public static PhieuKiemKhoModel entityToModel(PhieuKiemKho PhieuKiemKho) {
		PhieuKiemKhoModel PhieuKiemKhoModel = new PhieuKiemKhoModel();
		PhieuKiemKhoModel.setMaKiemKho(PhieuKiemKho.getMaKiemKho());
		PhieuKiemKhoModel.setNgayKiemKho(PhieuKiemKho.getNgayKiemKho());
		PhieuKiemKhoModel.setNhanVienModel(NhanVienService.entityToModel(PhieuKiemKho.getNhanVien()));
		PhieuKiemKhoModel.setKhoModel(KhoService.entityToModel(PhieuKiemKho.getKho()));
		PhieuKiemKhoModel.setGhiChu(PhieuKiemKho.getGhiChu());
		return PhieuKiemKhoModel;
	}
	
	public static List<PhieuKiemKhoModel> listEntitisToListModel (List<PhieuKiemKho> listPhieuKiemKho){
		List<PhieuKiemKhoModel> listPhieuKiemKhoModel = new ArrayList<PhieuKiemKhoModel>();
		for (PhieuKiemKho phieuKiemKho : listPhieuKiemKho) {
			PhieuKiemKhoModel phieuKiemKhoModel = entityToModel(phieuKiemKho);
			listPhieuKiemKhoModel.add(phieuKiemKhoModel);
		}
		return listPhieuKiemKhoModel;
	}
	public static List<PhieuKiemKho> listModelToListEntities (List<PhieuKiemKhoModel> listPhieuKiemKhoModel){
		List<PhieuKiemKho> listPhieuKiemKho = new ArrayList<PhieuKiemKho>();
		for (PhieuKiemKhoModel phieuKiemKhoModel : listPhieuKiemKhoModel) {
			PhieuKiemKho phieuKiemKho = modelToEntity(phieuKiemKhoModel);
			listPhieuKiemKho.add(phieuKiemKho);
		}
		return listPhieuKiemKho;
	}

	public void them_sua(PhieuKiemKhoModel PhieuKiemKhoModel) {
		_PhieuKiemKho = modelToEntity(PhieuKiemKhoModel);
		_PhieuKiemKhoDao.them_sua(_PhieuKiemKho);
		updateListPhieuKiemKhoModel();
	}
	
	public List<PhieuKiemKhoChiTietModel> getListPKKCTM (PhieuKiemKhoModel pkkm){
		for (PhieuKiemKho pkk : _listPhieuKiemKhos) {
			if(pkk.getMaKiemKho() == pkkm.getMaKiemKho()) {
				return PhieuKiemKhoChiTietService.listEntitiesToListModel(pkk.getListPhieuKiemKhoChiTiet());
			}
		}
		return null;
	}
	
	public void updateListPhieuKiemKhoModel() {
		_PhieuKiemKhoDao.updateListPhieuKiemKho();
		_listPhieuKiemKhos = _PhieuKiemKhoDao.getListPhieuKiemKho();
		_listPhieuKiemKhoModels = listEntitisToListModel(_listPhieuKiemKhos);
		maxID = _PhieuKiemKhoDao.getMaxID();
	}

	public int getMaxID() {
		return maxID;
	}
	
	public List<PhieuKiemKhoModel> getListPhieuKiemKhoModel() {
		return _listPhieuKiemKhoModels;
	}

}
