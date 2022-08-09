package services;

import java.util.ArrayList;
import java.util.List;

import dao.DichVuPhongDao;
import entities.DichVuPhong;
import models.DichVuPhongModel;
import utils.IoCContainer;

public class DichVuPhongService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<DichVuPhongModel> _listDichVuPhongModels = new ArrayList<DichVuPhongModel>();
	private DichVuPhongDao _DichVuPhongDao = (DichVuPhongDao) ioCContainer.getBean(DichVuPhongDao.class.toString());
	private DichVuPhong _DichVuPhong;
	private DichVuPhongModel _DichVuPhongModel = (DichVuPhongModel) IoCContainer.getBean(DichVuPhongModel.class.toString());;

	public static DichVuPhong updateDataDichVuPhongDependOnDichVuPhongModel(DichVuPhongModel DichVuPhongModel) {
		DichVuPhong DichVuPhong = new DichVuPhong();
		DichVuPhong.setMaDichVuPhong(DichVuPhongModel.getMaDichVuPhong());
		DichVuPhong.setSanPhamVaDichVu(SanPhamVaDichVuService.modelToEntity(DichVuPhongModel.getSanPhamVaDichVuModel()));
		DichVuPhong.setKhachTrongPhong(KhachTrongPhongService.updateDataKhachTrongPhongDependOnKhachTrongPhongModel(DichVuPhongModel.getKhachTrongPhongModel()));
		DichVuPhong.setGiaBan(DichVuPhongModel.getGiaBan());
		DichVuPhong.setSoLuong(DichVuPhongModel.getSoLuong());
		return DichVuPhong;
	}

	public static DichVuPhongModel updateDataDichVuPhongModelDependOnDichVuPhong(DichVuPhong DichVuPhong) {
		DichVuPhongModel DichVuPhongModel = new DichVuPhongModel();
		DichVuPhongModel.setMaDichVuPhong(DichVuPhong.getMaDichVuPhong());
		DichVuPhongModel.setSanPhamVaDichVuModel(SanPhamVaDichVuService.entityToModel(DichVuPhong.getSanPhamVaDichVu()));
		DichVuPhongModel.setKhachTrongPhongModel(KhachTrongPhongService.updateDataKhachTrongPhongModelDependOnKhachTrongPhong(DichVuPhong.getKhachTrongPhong()));
		DichVuPhongModel.setGiaBan(DichVuPhong.getGiaBan());
		DichVuPhongModel.setSoLuong(DichVuPhong.getSoLuong());
		return DichVuPhongModel;
	}
	
	public static List<DichVuPhongModel> updateListDichVuPhongModelDependOnListDichVuPhong (List<DichVuPhong> listDichVuPhong){
		List<DichVuPhongModel> listDichVuPhongModel = new ArrayList<DichVuPhongModel>();
		for (DichVuPhong DichVuPhong : listDichVuPhong) {
			DichVuPhongModel DichVuPhongModel = updateDataDichVuPhongModelDependOnDichVuPhong(DichVuPhong);
			listDichVuPhongModel.add(DichVuPhongModel);
		}
		return listDichVuPhongModel;
	}
	
	public static List<DichVuPhong> updateListDichVuPhongDependOnListDichVuPhongModel (List<DichVuPhongModel> listDichVuPhongModel){
		List<DichVuPhong> listDichVuPhong = new ArrayList<DichVuPhong>();
		for (DichVuPhongModel DichVuPhongModel : listDichVuPhongModel) {
			DichVuPhong DichVuPhong = updateDataDichVuPhongDependOnDichVuPhongModel(DichVuPhongModel);
			listDichVuPhong.add(DichVuPhong);
		}
		return listDichVuPhong;
	}
	
	public void them_sua(DichVuPhongModel DichVuPhongModel) {
		_DichVuPhong = updateDataDichVuPhongDependOnDichVuPhongModel(DichVuPhongModel);
		_DichVuPhongDao.them_sua(_DichVuPhong);
		_listDichVuPhongModels.add(DichVuPhongModel);
	}

	public void updateListDichVuPhongModel() {
		_DichVuPhongDao.updateListDichVuPhong();
		ArrayList<DichVuPhong> listDichVuPhong = _DichVuPhongDao.getListDichVuPhong();
		_listDichVuPhongModels = updateListDichVuPhongModelDependOnListDichVuPhong(listDichVuPhong);

	}

	public List<DichVuPhongModel> getListDichVuPhongModel() {
		return _listDichVuPhongModels;
	}
}
