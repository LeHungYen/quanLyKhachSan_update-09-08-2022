package services;

import java.util.ArrayList;
import java.util.List;

import dao.ChucVuDao;
import dao.NhanVienDao;
import entities.ChucVu;
import entities.NhanVien;
import models.ChucVuModel;
import models.NhanVienModel;
import utils.IoCContainer;

public class ChucVuService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<ChucVuModel> _listChucVuModels = new ArrayList<ChucVuModel>();
	private ChucVuDao _chucVuDao = (ChucVuDao) ioCContainer.getBean(ChucVuDao.class.toString());
	private ChucVu _chucVu;

	public static ChucVu modelToEntity(ChucVuModel chucVuModel) {
		ChucVu chucVu = new ChucVu();
		chucVu.setMaChucVu(chucVuModel.getMaChucVu());
		chucVu.setTenChucVu(chucVuModel.getTenChucVu());
		chucVu.setTrangThai(chucVuModel.getTrangThai());
		return chucVu;
	}

	public static ChucVuModel entityToModel(ChucVu chucVu) {
		ChucVuModel chucVuModel = new ChucVuModel();
		chucVuModel.setMaChucVu(chucVu.getMaChucVu());
		chucVuModel.setTenChucVu(chucVu.getTenChucVu());
		chucVuModel.setTrangThai(chucVu.getTrangThai());
		return chucVuModel;
	}
	
	public static List<ChucVuModel> listEntitiesToListModel (List<ChucVu> listChucVu){
		List<ChucVuModel> listChucVuModel = new ArrayList<ChucVuModel>();
		for (ChucVu chucVu : listChucVu) {
			ChucVuModel chucVuModel = entityToModel(chucVu);
			listChucVuModel.add(chucVuModel);
		}
		return listChucVuModel;
	}
	
	public static List<ChucVu> listModelToListEntities (List<ChucVuModel> listChucVuModel){
		List<ChucVu> listChucVu = new ArrayList<ChucVu>();
		for (ChucVuModel chucVuModel : listChucVuModel) {
			ChucVu chucVu = modelToEntity(chucVuModel);
			listChucVu.add(chucVu);
		}
		return listChucVu;
	}
	
	public void them_sua(ChucVuModel chucVuModel) {
		_chucVu = modelToEntity(chucVuModel);
		_chucVuDao.them_sua(_chucVu);
		_listChucVuModels.add(chucVuModel);
	}

	public void updateListChucVuModel() {
		_chucVuDao.updateListChucVu();
		ArrayList<ChucVu> listChucVu = _chucVuDao.getListChucVu();
		_listChucVuModels = listEntitiesToListModel(listChucVu);

	}

	public List<ChucVuModel> getListChucVuModel() {
		return _listChucVuModels;
	}

}
