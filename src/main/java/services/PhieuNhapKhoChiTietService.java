package services;

import java.util.ArrayList;
import java.util.List;

import dao.PhieuNhapKhoChiTietDao;
import entities.PhieuNhapKhoChiTiet;
import models.PhieuNhapKhoChiTietModel;
import utils.IoCContainer;

public class PhieuNhapKhoChiTietService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<PhieuNhapKhoChiTietModel> _listPhieuNhapKhoChiTietModels = new ArrayList<PhieuNhapKhoChiTietModel>();
	private PhieuNhapKhoChiTietDao _PhieuNhapKhoChiTietDao = (PhieuNhapKhoChiTietDao) ioCContainer.getBean(PhieuNhapKhoChiTietDao.class.toString());
	private PhieuNhapKhoChiTiet _PhieuNhapKhoChiTiet;

	public static PhieuNhapKhoChiTiet modelToEntity(PhieuNhapKhoChiTietModel PhieuNhapKhoChiTietModel) {
		PhieuNhapKhoChiTiet PhieuNhapKhoChiTiet = new PhieuNhapKhoChiTiet();
		PhieuNhapKhoChiTiet.setPhieuNhapKho(PhieuNhapKhoService.modelToEntity(PhieuNhapKhoChiTietModel.getPhieuNhapKhoModel()));
		PhieuNhapKhoChiTiet.setDonViChiTiet(DonViChiTietService.modelToEntity(PhieuNhapKhoChiTietModel.getDonViChiTietModel()));
		PhieuNhapKhoChiTiet.setSoLuong(PhieuNhapKhoChiTietModel.getSoLuong());
		PhieuNhapKhoChiTiet.setGiaNhap(PhieuNhapKhoChiTietModel.getGiaNhap());
		PhieuNhapKhoChiTiet.setGhiChu(PhieuNhapKhoChiTietModel.getGhiChu());
		return PhieuNhapKhoChiTiet;
	}
	public static PhieuNhapKhoChiTietModel entityToModel(PhieuNhapKhoChiTiet phieuNhapKhoChiTiet) {
		PhieuNhapKhoChiTietModel PhieuNhapKhoChiTietModel = new PhieuNhapKhoChiTietModel();
		PhieuNhapKhoChiTietModel.setPhieuNhapKhoModel(PhieuNhapKhoService.entityToModel(phieuNhapKhoChiTiet.getPhieuNhapKho()));
		PhieuNhapKhoChiTietModel.setDonViChiTietModel(DonViChiTietService.entityToModel(phieuNhapKhoChiTiet.getDonViChiTiet()));
		PhieuNhapKhoChiTietModel.setSoLuong(phieuNhapKhoChiTiet.getSoLuong());
		PhieuNhapKhoChiTietModel.setGiaNhap(phieuNhapKhoChiTiet.getGiaNhap());
		PhieuNhapKhoChiTietModel.setGhiChu(phieuNhapKhoChiTiet.getGhiChu());
		return PhieuNhapKhoChiTietModel;
	}

	public static List<PhieuNhapKhoChiTietModel> listEntitiesToListModel (List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet){
		List<PhieuNhapKhoChiTietModel> listPhieuNhapKhoChiTietModel = new ArrayList<PhieuNhapKhoChiTietModel>();
		for (PhieuNhapKhoChiTiet phieuNhapKhoChiTiet : listPhieuNhapKhoChiTiet) {
			PhieuNhapKhoChiTietModel phieuNhapKhoChiTietModel = entityToModel(phieuNhapKhoChiTiet);
			listPhieuNhapKhoChiTietModel.add(phieuNhapKhoChiTietModel);
		}
		return listPhieuNhapKhoChiTietModel;
	}
	public static List<PhieuNhapKhoChiTiet> listModelToListEntities (List<PhieuNhapKhoChiTietModel> listPhieuNhapKhoChiTietModel){
		List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet = new ArrayList<PhieuNhapKhoChiTiet>();
		for (PhieuNhapKhoChiTietModel phieuNhapKhoChiTietModel : listPhieuNhapKhoChiTietModel) {
			PhieuNhapKhoChiTiet phieuNhapKhoChiTiet = modelToEntity(phieuNhapKhoChiTietModel);
			listPhieuNhapKhoChiTiet.add(phieuNhapKhoChiTiet);
		}
		return listPhieuNhapKhoChiTiet;
	}
	
	public void them_sua(PhieuNhapKhoChiTietModel PhieuNhapKhoChiTietModel) {
		_PhieuNhapKhoChiTiet = modelToEntity(PhieuNhapKhoChiTietModel);
		_PhieuNhapKhoChiTietDao.them_sua(_PhieuNhapKhoChiTiet);
		_listPhieuNhapKhoChiTietModels.add(PhieuNhapKhoChiTietModel);
	}

	public void updateListPhieuNhapKhoChiTietModel() {
		_PhieuNhapKhoChiTietDao.updateListPhieuNhapKhoChiTiet();
		List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet = _PhieuNhapKhoChiTietDao.getListPhieuNhapKhoChiTiet();
		_listPhieuNhapKhoChiTietModels = listEntitiesToListModel(listPhieuNhapKhoChiTiet);
	}

	public List<PhieuNhapKhoChiTietModel> getListPhieuNhapKhoChiTietModel() {
		return _listPhieuNhapKhoChiTietModels;
	}

}
