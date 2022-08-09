package services;

import java.util.ArrayList;
import java.util.List;

import dao.KhachTrongPhongDao;
import entities.KhachTrongPhong;
import models.HoaDonModel;
import models.KhachTrongPhongModel;
import utils.IoCContainer;

public class KhachTrongPhongService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<KhachTrongPhongModel> _listKhachTrongPhongModels = new ArrayList<KhachTrongPhongModel>();
	private KhachTrongPhongDao _KhachTrongPhongDao = (KhachTrongPhongDao) ioCContainer.getBean(KhachTrongPhongDao.class.toString());
	private KhachTrongPhong _KhachTrongPhong;
	public static KhachTrongPhong updateDataKhachTrongPhongDependOnKhachTrongPhongModel(KhachTrongPhongModel KhachTrongPhongModel) {
		KhachTrongPhong KhachTrongPhong = new KhachTrongPhong();
		KhachTrongPhong.setMaKhachTrongPhong(KhachTrongPhongModel.getMaKhachTrongPhong());
		KhachTrongPhong.setKhachHang(KhachHangService.updateDataKhachHangDependOnKhachHangModel(KhachTrongPhongModel.getKhachHangModel()));
		KhachTrongPhong.setHoaDon(HoaDonService.updateDataHoaDonDependOnHoaDonModel(KhachTrongPhongModel.getHoaDonModel()));
		KhachTrongPhong.setPhong(PhongService.updateDataPhongDependOnPhongModel(KhachTrongPhongModel.getPhongModel()));
		KhachTrongPhong.setNgayCheckOut(KhachTrongPhongModel.getNgayCheckOut());
		KhachTrongPhong.setGiaPhong(KhachTrongPhongModel.getGiaPhong());
		KhachTrongPhong.setPhuPhi(KhachTrongPhongModel.getPhuPhi());
		KhachTrongPhong.setGhiChu(KhachTrongPhongModel.getGhiChu());
		return KhachTrongPhong;
	}
	
	public static KhachTrongPhongModel updateDataKhachTrongPhongModelDependOnKhachTrongPhong(KhachTrongPhong KhachTrongPhong) {
		KhachTrongPhongModel KhachTrongPhongModel = new KhachTrongPhongModel();
		KhachTrongPhongModel.setMaKhachTrongPhong(KhachTrongPhong.getMaKhachTrongPhong());
		KhachTrongPhongModel.setKhachHangModel(KhachHangService.updateDataKhachHangModelDependOnKhachHang(KhachTrongPhong.getKhachHang()));
		KhachTrongPhongModel.setHoaDonModel(HoaDonService.updateDataHoaDonModelDependOnHoaDon(KhachTrongPhong.getHoaDon()));
		KhachTrongPhongModel.setPhongModel(PhongService.updateDataPhongModelDependOnPhong(KhachTrongPhong.getPhong()));
		KhachTrongPhongModel.setNgayCheckOut(KhachTrongPhong.getNgayCheckOut());
		KhachTrongPhongModel.setGiaPhong(KhachTrongPhong.getGiaPhong());
		KhachTrongPhongModel.setPhuPhi(KhachTrongPhong.getPhuPhi());
		KhachTrongPhongModel.setGhiChu(KhachTrongPhong.getGhiChu());
		return KhachTrongPhongModel;
	}
	
	public static List<KhachTrongPhong> updateListKhachTrongPhongDependOnListKhachTrongPhongModel(List<KhachTrongPhongModel> listKhachTrongPhongModel) {
		List<KhachTrongPhong> listKhachTrongPhong = new ArrayList<KhachTrongPhong>();
		for (KhachTrongPhongModel KhachTrongPhongModel2 : listKhachTrongPhongModel) {
			KhachTrongPhong KhachTrongPhong = updateDataKhachTrongPhongDependOnKhachTrongPhongModel(KhachTrongPhongModel2);
			listKhachTrongPhong.add(KhachTrongPhong);
		}
		return listKhachTrongPhong;
	}
	
	public static List<KhachTrongPhongModel> updateListKhachTrongPhongModelDependOnListKhachTrongPhong(List<KhachTrongPhong> listKhachTrongPhong) {
		List<KhachTrongPhongModel> listKhachTrongPhongModel = new ArrayList<KhachTrongPhongModel>();
		for (KhachTrongPhong KhachTrongPhong : listKhachTrongPhong) {
			KhachTrongPhongModel KhachTrongPhongModel = updateDataKhachTrongPhongModelDependOnKhachTrongPhong(KhachTrongPhong);
			listKhachTrongPhongModel.add(KhachTrongPhongModel);
		}
		return listKhachTrongPhongModel;
	}

	public void them_sua(KhachTrongPhongModel KhachTrongPhongModel) {
		_KhachTrongPhong = updateDataKhachTrongPhongDependOnKhachTrongPhongModel(KhachTrongPhongModel);
		_KhachTrongPhongDao.them_sua(_KhachTrongPhong);
		_listKhachTrongPhongModels.add(KhachTrongPhongModel);// check lại
	}

	public void updateListKhachTrongPhongModel() {
		_KhachTrongPhongDao.updateListKhachTrongPhong();
		List<KhachTrongPhong> listKhachTrongPhong = _KhachTrongPhongDao.getListKhachTrongPhong();
		_listKhachTrongPhongModels = updateListKhachTrongPhongModelDependOnListKhachTrongPhong(listKhachTrongPhong);

	}

	public List<KhachTrongPhongModel> getListKhachTrongPhongModel() {
		return _listKhachTrongPhongModels;
	}

}

