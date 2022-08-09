package services;

import java.util.ArrayList;
import java.util.List;

import dao.DonViChiTietDao;
import entities.DonViChiTiet;
import models.DonViChiTietModel;
import models.DonViTinhModel;
import utils.IoCContainer;

public class DonViChiTietService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<DonViChiTietModel> _listDonViChiTietModels = new ArrayList<DonViChiTietModel>();
	private List<DonViChiTiet> _listDonViChiTiets = new ArrayList<DonViChiTiet>();
	private DonViChiTietDao _DonViChiTietDao = (DonViChiTietDao) ioCContainer.getBean(DonViChiTietDao.class.toString());
	private DonViChiTiet _DonViChiTiet;
	private DonViChiTietModel _DonViChiTietModel = (DonViChiTietModel) IoCContainer.getBean(DonViChiTietModel.class.toString());
	private int maxID;

	public static DonViChiTiet modelToEntity(DonViChiTietModel DonViChiTietModel) {
		DonViChiTiet DonViChiTiet = new DonViChiTiet();
		DonViChiTiet.setMaDonViChiTiet(DonViChiTietModel.getMaDonViChiTiet());
		DonViChiTiet.setDonViTinh(DonViTinhService.modelToEntity(DonViChiTietModel.getDonViTinhModel()));
		DonViChiTiet.setSanPhamVaDichVu(SanPhamVaDichVuService.modelToEntity(DonViChiTietModel.getSanPhamVaDichVuModel()));
		DonViChiTiet.setGiaTriQuyDoi(DonViChiTietModel.getGiaTriQuyDoi());
		DonViChiTiet.setGiaBan(DonViChiTietModel.getGiaBan());
		DonViChiTiet.setTrangThai(DonViChiTietModel.getTrangThai());
		DonViChiTiet.setDonViMacDinh(DonViChiTietModel.getDonViMacDinh());
		return DonViChiTiet;
	}
	public static DonViChiTietModel entityToModel(DonViChiTiet donViChiTiet) {
		DonViChiTietModel donViChiTietModel = new DonViChiTietModel();
		donViChiTietModel.setMaDonViChiTiet(donViChiTiet.getMaDonViChiTiet());
		donViChiTietModel.setDonViTinhModel(DonViTinhService.entityToModel(donViChiTiet.getDonViTinh()));
		donViChiTietModel.setSanPhamVaDichVuModel(SanPhamVaDichVuService.entityToModel(donViChiTiet.getSanPhamVaDichVu()));
		donViChiTietModel.setGiaTriQuyDoi(donViChiTiet.getGiaTriQuyDoi());
		donViChiTietModel.setGiaBan(donViChiTiet.getGiaBan());
		donViChiTietModel.setTrangThai(donViChiTiet.getTrangThai());
		donViChiTietModel.setDonViMacDinh(donViChiTiet.getDonViMacDinh());
		return donViChiTietModel;
	}
	
	public static List<DonViChiTiet> listModelToListEntities(List<DonViChiTietModel> listDonViChiTietModel) {
		List<DonViChiTiet> listDonViChiTiet = new ArrayList<DonViChiTiet>();
		for (DonViChiTietModel donViChiTietModel : listDonViChiTietModel) {
			DonViChiTiet donViChiTiet = modelToEntity(donViChiTietModel);
			listDonViChiTiet.add(donViChiTiet);
		}
		return listDonViChiTiet;
	}
	
	public static List<DonViChiTietModel> listEntitiesTolistModel(List<DonViChiTiet> listDonViChiTiet) {
		List<DonViChiTietModel> listDonViChiTietModel = new ArrayList<DonViChiTietModel>();
		for (DonViChiTiet donViChiTiet : listDonViChiTiet) {
			DonViChiTietModel donViChiTietModel = entityToModel(donViChiTiet);
			listDonViChiTietModel.add(donViChiTietModel);
		}
		return listDonViChiTietModel;
	}
	

	public void them_sua(DonViChiTietModel DonViChiTietModel) {
		_DonViChiTiet = modelToEntity(DonViChiTietModel);
		_DonViChiTietDao.them_sua(_DonViChiTiet);
		_listDonViChiTietModels.add(DonViChiTietModel); // check lai
	}

	public DonViTinhModel getDonViTinhModel (DonViChiTietModel dvctm) {
		for (DonViChiTiet dvct : _listDonViChiTiets) {
			if(dvct.getMaDonViChiTiet() == dvctm.getMaDonViChiTiet()) {
				return DonViTinhService.entityToModel(dvct.getDonViTinh());
			}
		}
		return null;
	}
	
	public void updateListDonViChiTietModel() {
		_DonViChiTietDao.updateListDonViChiTiet();
		_listDonViChiTiets = _DonViChiTietDao.getListDonViChiTiet();
		_listDonViChiTietModels = listEntitiesTolistModel(_listDonViChiTiets);
		maxID = _DonViChiTietDao.getMaxID();
	}

	public List<DonViChiTietModel> getListDonViChiTietModel() {
		return _listDonViChiTietModels;
	}
	
	public int getMaxID() {
		return maxID;
	}

}
