package services;

import java.util.ArrayList;
import java.util.List;

import dao.PhieuNhapKhoDao;
import entities.PhieuNhapKho;
import models.PhieuNhapKhoChiTietModel;
import models.PhieuNhapKhoModel;
import utils.IoCContainer;

public class PhieuNhapKhoService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<PhieuNhapKhoModel> _listPhieuNhapKhoModels = new ArrayList<PhieuNhapKhoModel>();
	private List<PhieuNhapKho> _listPhieuNhapKhos = new ArrayList<PhieuNhapKho>();
	private PhieuNhapKhoDao _PhieuNhapKhoDao = (PhieuNhapKhoDao) ioCContainer.getBean(PhieuNhapKhoDao.class.toString());
	private PhieuNhapKho _PhieuNhapKho;
	private int maxID;
	public static PhieuNhapKho modelToEntity(PhieuNhapKhoModel PhieuNhapKhoModel) {
		PhieuNhapKho PhieuNhapKho = new PhieuNhapKho();
		PhieuNhapKho.setMaNhap(PhieuNhapKhoModel.getMaNhap());
		PhieuNhapKho.setNgayNhap(PhieuNhapKhoModel.getNgayNhap());
		PhieuNhapKho.setTinhTrang(PhieuNhapKhoModel.getTinhTrang());
		PhieuNhapKho.setNhanVien(NhanVienService.modelToEntity(PhieuNhapKhoModel.getNhanVienModel()));
		PhieuNhapKho.setGiamGia(PhieuNhapKhoModel.getGiamGia());
		PhieuNhapKho.setVat(PhieuNhapKhoModel.getVat());
		PhieuNhapKho.setPhiShip(PhieuNhapKhoModel.getPhiShip());
		return PhieuNhapKho;
	}
	public static PhieuNhapKhoModel entityToModel(PhieuNhapKho PhieuNhapKho) {
		PhieuNhapKhoModel PhieuNhapKhoModel = new PhieuNhapKhoModel();
		PhieuNhapKhoModel.setMaNhap(PhieuNhapKho.getMaNhap());
		PhieuNhapKhoModel.setNgayNhap(PhieuNhapKho.getNgayNhap());
		PhieuNhapKhoModel.setTinhTrang(PhieuNhapKho.getTinhTrang());
		PhieuNhapKhoModel.setNhanVienModel(NhanVienService.entityToModel(PhieuNhapKho.getNhanVien()));
		PhieuNhapKhoModel.setGiamGia(PhieuNhapKho.getGiamGia());
		PhieuNhapKhoModel.setVat(PhieuNhapKho.getVat());
		PhieuNhapKhoModel.setPhiShip(PhieuNhapKho.getPhiShip());
		return PhieuNhapKhoModel;
	}

	public static List<PhieuNhapKhoModel> listEntitiesToListModel (List<PhieuNhapKho> listPhieuNhapKho){
		List<PhieuNhapKhoModel> listPhieuNhapKhoModel = new ArrayList<PhieuNhapKhoModel>();
		for (PhieuNhapKho phieuNhapKho : listPhieuNhapKho) {
			PhieuNhapKhoModel phieuNhapKhoModel = entityToModel(phieuNhapKho);
			listPhieuNhapKhoModel.add(phieuNhapKhoModel);
		}
		return listPhieuNhapKhoModel;
	}
	
	public static List<PhieuNhapKho> listModelToListEntities (List<PhieuNhapKhoModel> listPhieuNhapKhoModel){
		List<PhieuNhapKho> listPhieuNhapKho = new ArrayList<PhieuNhapKho>();
		for (PhieuNhapKhoModel phieuNhapKhoModel : listPhieuNhapKhoModel) {
			PhieuNhapKho phieuNhapKho = modelToEntity(phieuNhapKhoModel);
			listPhieuNhapKho.add(phieuNhapKho);
		}
		return listPhieuNhapKho;
	}
	
	public void them_sua(PhieuNhapKhoModel PhieuNhapKhoModel) {
		_PhieuNhapKho = modelToEntity(PhieuNhapKhoModel);
		_PhieuNhapKhoDao.them_sua(_PhieuNhapKho);
		updateListPhieuNhapKhoModel();
	}

	public List<PhieuNhapKhoChiTietModel> getListPNKCTM (PhieuNhapKhoModel pnkm){
		for (PhieuNhapKho phieuNhapKho : _listPhieuNhapKhos) {
			if(pnkm.getMaNhap() == phieuNhapKho.getMaNhap()) {
				return PhieuNhapKhoChiTietService.listEntitiesToListModel(phieuNhapKho.getListPhieuNhapKhoChiTiet());
			}
		}
		return null;
	}
	
	public void updateListPhieuNhapKhoModel() {
		_PhieuNhapKhoDao.updateListPhieuNhapKho();
		_listPhieuNhapKhos = _PhieuNhapKhoDao.getListPhieuNhapKho();
		_listPhieuNhapKhoModels = listEntitiesToListModel(_listPhieuNhapKhos);
		maxID = _PhieuNhapKhoDao.getMaxID();
	}

	public int getMaxID() {
		return maxID;
	}
	
	public List<PhieuNhapKhoModel> getListPhieuNhapKhoModel() {
		return _listPhieuNhapKhoModels;
	}

}
