package services;

import java.util.ArrayList;
import java.util.List;

import dao.HoaDonDao;
import entities.HoaDon;
import models.HoaDonModel;
import utils.IoCContainer;

public class HoaDonService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<HoaDonModel> _listHoaDonModels = new ArrayList<HoaDonModel>();
	private HoaDonDao _HoaDonDao = (HoaDonDao) ioCContainer.getBean(HoaDonDao.class.toString());
	private HoaDon _HoaDon;

	public static HoaDon updateDataHoaDonDependOnHoaDonModel(HoaDonModel HoaDonModel) {
		HoaDon HoaDon = new HoaDon();
		HoaDon.setMaHoaDon(HoaDonModel.getMaHoaDon());
		HoaDon.setTrangThai(HoaDonModel.getTrangThai());
		HoaDon.setNgayCheckIn(HoaDonModel.getNgayCheckIn());
		HoaDon.setNhanVien(NhanVienService.modelToEntity(HoaDonModel.getNhanVienModel()));
		HoaDon.setNgayTao(HoaDonModel.getNgayTao());
		HoaDon.setVat(HoaDonModel.getVat());
		HoaDon.setGiamGia(HoaDonModel.getGiamGia());
		HoaDon.setTienCoc(HoaDonModel.getTienCoc());
		return HoaDon;
	}
	
	public static HoaDonModel updateDataHoaDonModelDependOnHoaDon(HoaDon HoaDon) {
		HoaDonModel HoaDonModel = new HoaDonModel();
		HoaDonModel.setMaHoaDon(HoaDon.getMaHoaDon());
		HoaDonModel.setTrangThai(HoaDon.getTrangThai());
		HoaDonModel.setNgayCheckIn(HoaDon.getNgayCheckIn());
		HoaDonModel.setNhanVienModel(NhanVienService.entityToModel(HoaDon.getNhanVien()));
		HoaDonModel.setNgayTao(HoaDon.getNgayTao());
		HoaDonModel.setVat(HoaDon.getVat());
		HoaDonModel.setGiamGia(HoaDon.getGiamGia());
		HoaDonModel.setTienCoc(HoaDon.getTienCoc());
		return HoaDonModel;
	}
	
	public static List<HoaDon> updateListHoaDonDependOnListHoaDonModel(List<HoaDonModel> listHoaDonModel) {
		List<HoaDon> listHoaDon = new ArrayList<HoaDon>();
		for (HoaDonModel HoaDonModel2 : listHoaDonModel) {
			HoaDon HoaDon = updateDataHoaDonDependOnHoaDonModel(HoaDonModel2);
			listHoaDon.add(HoaDon);
		}
		return listHoaDon;
	}
	
	public static List<HoaDonModel> updateListHoaDonModelDependOnListHoaDon(List<HoaDon> listHoaDon) {
		List<HoaDonModel> listHoaDonModel = new ArrayList<HoaDonModel>();
		for (HoaDon HoaDon : listHoaDon) {
			HoaDonModel HoaDonModel = updateDataHoaDonModelDependOnHoaDon(HoaDon);
			listHoaDonModel.add(HoaDonModel);
		}
		return listHoaDonModel;
	}

	public void them_sua(HoaDonModel HoaDonModel) {
		_HoaDon = updateDataHoaDonDependOnHoaDonModel(HoaDonModel);
		_HoaDonDao.them_sua(_HoaDon);
		_listHoaDonModels.add(HoaDonModel);// check lại
	}

	public void updateListHoaDonModel() {
		_HoaDonDao.updateListHoaDon();
		List<HoaDon> listHoaDon = _HoaDonDao.getListHoaDon();
		_listHoaDonModels = updateListHoaDonModelDependOnListHoaDon(listHoaDon);

	}

	public List<HoaDonModel> getListHoaDonModel() {
		return _listHoaDonModels;
	}

}