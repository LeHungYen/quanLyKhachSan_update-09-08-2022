package services;

import java.util.ArrayList;
import java.util.List;

import dao.LoaiPhongDao;
import entities.LoaiPhong;
import models.LoaiPhongModel;
import utils.IoCContainer;

public class LoaiPhongService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<LoaiPhongModel> _listLoaiPhongModels = new ArrayList<LoaiPhongModel>();
	private LoaiPhongDao _LoaiPhongDao = (LoaiPhongDao) ioCContainer.getBean(LoaiPhongDao.class.toString());
	private LoaiPhong _LoaiPhong;

	public static LoaiPhong modelToEntity(LoaiPhongModel LoaiPhongModel) {
		LoaiPhong LoaiPhong = new LoaiPhong();
		LoaiPhong.setMaLoaiPhong(LoaiPhongModel.getMaLoaiPhong());
		LoaiPhong.setTenLoai(LoaiPhongModel.getTenLoai());
		LoaiPhong.setSoNguoiToiDa(LoaiPhongModel.getSoNguoiToiDa());
		LoaiPhong.setGia(LoaiPhongModel.getGia());
		LoaiPhong.setGiaQuaDem(LoaiPhongModel.getGiaQuaDem());
		LoaiPhong.setGiaTheoGio(LoaiPhongModel.getGiaTheoGio());
		LoaiPhong.setTrangThai(LoaiPhongModel.getTrangThai());
		return LoaiPhong;
	}
	
	public static LoaiPhongModel entityToModel(LoaiPhong LoaiPhong) {
		LoaiPhongModel LoaiPhongModel = new LoaiPhongModel();
		LoaiPhongModel.setMaLoaiPhong(LoaiPhong.getMaLoaiPhong());
		LoaiPhongModel.setTenLoai(LoaiPhong.getTenLoai());
		LoaiPhongModel.setSoNguoiToiDa(LoaiPhong.getSoNguoiToiDa());
		LoaiPhongModel.setGia(LoaiPhong.getGia());
		LoaiPhongModel.setGiaQuaDem(LoaiPhong.getGiaQuaDem());
		LoaiPhongModel.setGiaTheoGio(LoaiPhong.getGiaTheoGio());
		LoaiPhongModel.setTrangThai(LoaiPhong.getTrangThai());
		return LoaiPhongModel;
	}
	
	public static List<LoaiPhong> listModelToListEntities(List<LoaiPhongModel> listLoaiPhongModel) {
		List<LoaiPhong> listLoaiPhong = new ArrayList<LoaiPhong>();
		for (LoaiPhongModel LoaiPhongModel2 : listLoaiPhongModel) {
			LoaiPhong LoaiPhong = modelToEntity(LoaiPhongModel2);
			listLoaiPhong.add(LoaiPhong);
		}
		return listLoaiPhong;
	}
	
	public static List<LoaiPhongModel> listEntitiesToListModel(List<LoaiPhong> listLoaiPhong) {
		List<LoaiPhongModel> listLoaiPhongModel = new ArrayList<LoaiPhongModel>();
		for (LoaiPhong LoaiPhong : listLoaiPhong) {
			LoaiPhongModel LoaiPhongModel = entityToModel(LoaiPhong);
			listLoaiPhongModel.add(LoaiPhongModel);
		}
		return listLoaiPhongModel;
	}

	public void them_sua(LoaiPhongModel LoaiPhongModel) {
		_LoaiPhong = modelToEntity(LoaiPhongModel);
		_LoaiPhongDao.them_sua(_LoaiPhong);
		updateListLoaiPhongModel();
	}

	public void updateListLoaiPhongModel() {
		_LoaiPhongDao.updateListLoaiPhong();
		List<LoaiPhong> listLoaiPhong = _LoaiPhongDao.getListLoaiPhong();
		_listLoaiPhongModels = listEntitiesToListModel(listLoaiPhong);

	}

	public List<LoaiPhongModel> getListLoaiPhongModel() {
		return _listLoaiPhongModels;
	}
}
