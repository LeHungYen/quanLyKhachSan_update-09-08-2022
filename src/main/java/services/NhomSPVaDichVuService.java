package services;

import java.util.ArrayList;
import java.util.List;

import dao.NhomSPVaDichVuDao;
import entities.NhomSPVaDichVu;
import models.NhomSPVaDichVuModel;
import models.SanPhamVaDichVuModel;
import utils.IoCContainer;

public class NhomSPVaDichVuService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<NhomSPVaDichVuModel> _listNhomSPVaDichVuModels = new ArrayList<NhomSPVaDichVuModel>();
	private List<NhomSPVaDichVuModel> _listNhomSPVaDichVuModelsInactive = new ArrayList<NhomSPVaDichVuModel>();
	private List<NhomSPVaDichVuModel> _listNhomSPVaDichVuModelsActive = new ArrayList<NhomSPVaDichVuModel>();
	private NhomSPVaDichVuDao _NhomSPVaDichVuDao = (NhomSPVaDichVuDao) ioCContainer.getBean(NhomSPVaDichVuDao.class.toString());
	private NhomSPVaDichVu _NhomSPVaDichVu;

	public static NhomSPVaDichVu modelToEntity(NhomSPVaDichVuModel NhomSPVaDichVuModel) {
		NhomSPVaDichVu NhomSPVaDichVu = new NhomSPVaDichVu();
		NhomSPVaDichVu.setMaNhomSP(NhomSPVaDichVuModel.getMaNhomSP());
		NhomSPVaDichVu.setTenNhomSP(NhomSPVaDichVuModel.getTenNhomSP());
		NhomSPVaDichVu.setNhomHangHoa(NhomSPVaDichVuModel.getNhomHangHoa());
		NhomSPVaDichVu.setGhiChu(NhomSPVaDichVuModel.getGhiChu());
		NhomSPVaDichVu.setTrangThai(NhomSPVaDichVuModel.getTrangThai());
		return NhomSPVaDichVu;
	}
	public static NhomSPVaDichVuModel entityToModel(NhomSPVaDichVu NhomSPVaDichVu) {
		NhomSPVaDichVuModel nhomSPVaDichVuModel = new NhomSPVaDichVuModel();
		nhomSPVaDichVuModel.setMaNhomSP(NhomSPVaDichVu.getMaNhomSP());
		nhomSPVaDichVuModel.setTenNhomSP(NhomSPVaDichVu.getTenNhomSP());
		nhomSPVaDichVuModel.setNhomHangHoa(NhomSPVaDichVu.getNhomHangHoa());
		nhomSPVaDichVuModel.setGhiChu(NhomSPVaDichVu.getGhiChu());
		nhomSPVaDichVuModel.setTrangThai(NhomSPVaDichVu.getTrangThai());
		return nhomSPVaDichVuModel;
	}
	
	public static List<NhomSPVaDichVuModel> listEntitiesToListModel (List<NhomSPVaDichVu> listNhomSPVaDichVu){
		List<NhomSPVaDichVuModel> listNhomSPVaDichVuModel = new ArrayList<NhomSPVaDichVuModel>();
		for (NhomSPVaDichVu nhomSPVaDichVu : listNhomSPVaDichVu) {
			NhomSPVaDichVuModel nhomSPVaDichVuModel = entityToModel(nhomSPVaDichVu);
			listNhomSPVaDichVuModel.add(nhomSPVaDichVuModel);
		}
		return listNhomSPVaDichVuModel;
	}
	
	public static List<NhomSPVaDichVu> listModelToListEntities (List<NhomSPVaDichVuModel> listNhomSPVaDichVuModel){
		List<NhomSPVaDichVu> listNhomSPVaDichVu = new ArrayList<NhomSPVaDichVu>();
		for (NhomSPVaDichVuModel nhomSPVaDichVuModel : listNhomSPVaDichVuModel) {
			NhomSPVaDichVu nhomSPVaDichVu = modelToEntity(nhomSPVaDichVuModel);
			listNhomSPVaDichVu.add(nhomSPVaDichVu);
		}
		return listNhomSPVaDichVu;
	}

	public void them_sua(NhomSPVaDichVuModel NhomSPVaDichVuModel) {
		boolean checkExisted = false;
		for(int i = 0 ; i< _listNhomSPVaDichVuModels.size() ; i++) {
			if(_listNhomSPVaDichVuModels.get(i).getMaNhomSP() == NhomSPVaDichVuModel.getMaNhomSP()) { // bug
				_listNhomSPVaDichVuModels.get(i).setTenNhomSP(NhomSPVaDichVuModel.getTenNhomSP());
				_listNhomSPVaDichVuModels.get(i).setNhomHangHoa(NhomSPVaDichVuModel.getNhomHangHoa());
				_listNhomSPVaDichVuModels.get(i).setGhiChu(NhomSPVaDichVuModel.getGhiChu());
				_listNhomSPVaDichVuModels.get(i).setTrangThai(NhomSPVaDichVuModel.getTrangThai());
				
				_NhomSPVaDichVu = modelToEntity(_listNhomSPVaDichVuModels.get(i));
				_NhomSPVaDichVuDao.them_sua(_NhomSPVaDichVu);
				checkExisted = true;
				break;
			}
		}
		if(!checkExisted) {
			_NhomSPVaDichVu = modelToEntity(NhomSPVaDichVuModel);
			_NhomSPVaDichVuDao.them_sua(_NhomSPVaDichVu);
			_listNhomSPVaDichVuModels.add(NhomSPVaDichVuModel);
		}
	}

	public void updateListNhomSPVaDichVuModel() {
		_NhomSPVaDichVuDao.updateListNhomSPVaDichVu();
		List<NhomSPVaDichVu> listNhomSPVaDichVu = _NhomSPVaDichVuDao.getListNhomSPVaDichVu();
		_listNhomSPVaDichVuModels = listEntitiesToListModel(listNhomSPVaDichVu);
	}
	
	public void updateListNhomSPVaDichVuModel(String trangThai) {
		_NhomSPVaDichVuDao.updateListNhomSPVaDichVu(trangThai);
		if(trangThai.equals("Hoat Dong")) {
			List<NhomSPVaDichVu> listNhomSPVaDichVu = _NhomSPVaDichVuDao.getListNhomSPVaDichVu_active();
			_listNhomSPVaDichVuModelsActive = listEntitiesToListModel(listNhomSPVaDichVu);
		}else {
			List<NhomSPVaDichVu> listNhomSPVaDichVu = _NhomSPVaDichVuDao.getListNhomSPVaDichVu_inactive();
			_listNhomSPVaDichVuModelsInactive = listEntitiesToListModel(listNhomSPVaDichVu);
		}
		
	}
	
	

	public List<NhomSPVaDichVuModel> getListNhomSPVaDichVuModel() {
		return _listNhomSPVaDichVuModels;
	}
	public List<NhomSPVaDichVuModel> getListNhomSPVaDichVuModelActive() {
		return _listNhomSPVaDichVuModelsActive;
	}
	public List<NhomSPVaDichVuModel> getListNhomSPVaDichVuModelInactive() {
		return _listNhomSPVaDichVuModelsInactive;
	}
	
	public static void main(String[] args) {
		NhomSPVaDichVuService nsp = new NhomSPVaDichVuService();
		nsp.updateListNhomSPVaDichVuModel("Hoat Dong");
	}
}
