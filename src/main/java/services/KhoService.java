package services;

import java.util.ArrayList;
import java.util.List;

import dao.KhoDao;
import entities.Kho;
import entities.SanPhamVaDichVu;
import models.DonViChiTietModel;
import models.KhoModel;
import models.SanPhamVaDichVuModel;
import utils.IoCContainer;

public class KhoService{
	private IoCContainer ioCContainer = new IoCContainer();
	private static List<Kho> _listKho = new ArrayList<Kho>();
	private List<KhoModel> _listKhoModels = new ArrayList<KhoModel>();
	private List<KhoModel> _listKhoModels_active = new ArrayList<KhoModel>();
	private List<KhoModel> _listKhoModels_inactive = new ArrayList<KhoModel>();
	private List<SanPhamVaDichVu> _listSanPhamVaDichVus = new ArrayList<SanPhamVaDichVu>();
	private KhoDao _KhoDao = (KhoDao) ioCContainer.getBean(KhoDao.class.toString());
	private Kho _Kho;

	public static Kho modelToEntity(KhoModel KhoModel) {
		Kho Kho = new Kho();
		Kho.setMaKho(KhoModel.getMaKho());
		Kho.setTenKho(KhoModel.getTenKho());
		Kho.setTrangThai(KhoModel.getTrangThai());
		return Kho;
	}
	
	public static KhoModel entityToModel(Kho kho) {
		KhoModel khoModel = new KhoModel();
		khoModel.setMaKho(kho.getMaKho());
		khoModel.setTenKho(kho.getTenKho());
		khoModel.setTrangThai(kho.getTrangThai());
		return khoModel;
	}
	
	public static List<Kho> listModelTolistEntities(List<KhoModel> listKhoModel) {
		List<Kho> listKho = new ArrayList<Kho>();
		for (KhoModel khoModel2 : listKhoModel) {
			Kho kho = modelToEntity(khoModel2);
			listKho.add(kho);
		}
		return listKho;
	}
	
	public static List<KhoModel> listEntitiesToListModel(List<Kho> listKho) {
		List<KhoModel> listKhoModel = new ArrayList<KhoModel>();
		for (Kho kho : listKho) {
			KhoModel khoModel = entityToModel(kho);
			listKhoModel.add(khoModel);
		}
		return listKhoModel;
	}

	public void them_sua(KhoModel khoModel) {
		boolean checkExisted = false;
		for(int i = 0 ; i< _listKhoModels.size() ; i++) {
			if(_listKhoModels.get(i).getMaKho() == khoModel.getMaKho()) {
				_listKhoModels.get(i).setTenKho(khoModel.getTenKho());
				_listKhoModels.get(i).setTrangThai(khoModel.getTrangThai());
				_Kho = modelToEntity(_listKhoModels.get(i));
				_KhoDao.them_sua(_Kho);
				checkExisted = true;
				break;
			}
		}
		if(!checkExisted) {
			_Kho = modelToEntity(khoModel);
			_KhoDao.them_sua(_Kho);
			_listKhoModels.add(khoModel);
		}
	}

	public List<SanPhamVaDichVuModel> getListSPVDVM (KhoModel khoModel){
		for (Kho kho : _listKho) {
			if(kho.getMaKho() == khoModel.getMaKho()) {
				_listSanPhamVaDichVus = kho.getListSanPhamVaDichVu();
				return SanPhamVaDichVuService.listEntitiesToListModel(_listSanPhamVaDichVus);
			}
		}
		return null;
	}
	
	public List<DonViChiTietModel> getListDVCTM (SanPhamVaDichVuModel spvdvm){
		List<DonViChiTietModel> listDVCTM = new ArrayList<DonViChiTietModel>();
		for (SanPhamVaDichVu spvdv : _listSanPhamVaDichVus) {
			if(spvdvm.getMaDichVu() == spvdv.getMaDichVu()) {
				return DonViChiTietService.listEntitiesTolistModel(spvdv.getListDonViChiTiet());
			}
		}
		return null;
	}
	
	public void updateListKhoModel() {
		_KhoDao.updateListKho();
		_listKho = _KhoDao.getListKho();
		_listKhoModels = listEntitiesToListModel(_listKho);

	}
	
	public void updateListKhoModel(String trangThai) {
		_KhoDao.updateListKho(trangThai);
		if(trangThai.equals("Hoat Dong")) {
			_listKho = _KhoDao.getListKho_active();
			_listKhoModels_active = listEntitiesToListModel(_listKho);
		}else {
			_listKho = _KhoDao.getListKho_inactive();
			_listKhoModels_inactive = listEntitiesToListModel(_listKho);
		}
		
	}

	public List<KhoModel> getListKhoModel() {
		return _listKhoModels;
	}
	public List<KhoModel> getListKhoModel_active() {
		return _listKhoModels_active;
	}
	public List<KhoModel> getListKhoModel_inactive() {
		return _listKhoModels_inactive;
	}
	
	public static void main(String[] args) {
		System.out.println(6+-3);
	}
}
