package services;

import java.util.ArrayList;
import java.util.List;

import dao.DonViTinhDao;
import entities.DonViTinh;
import models.DonViTinhModel;
import utils.IoCContainer;

public class DonViTinhService {
	private IoCContainer ioCContainer = new IoCContainer();
	private List<DonViTinhModel> _listDonViTinhModels = new ArrayList<DonViTinhModel>();
	private List<DonViTinhModel> _listDonViTinhModels_active = new ArrayList<DonViTinhModel>();
	private List<DonViTinhModel> _listDonViTinhModels_inactive = new ArrayList<DonViTinhModel>();
	private DonViTinhDao _DonViTinhDao = (DonViTinhDao) ioCContainer.getBean(DonViTinhDao.class.toString());
	private DonViTinh _DonViTinh;
	private DonViTinhModel _DonViTinhModel = (DonViTinhModel) IoCContainer.getBean(DonViTinhModel.class.toString());;
	private int _stt = 0;

	public static DonViTinh modelToEntity(DonViTinhModel DonViTinhModel) {
		DonViTinh DonViTinh = new DonViTinh();
		DonViTinh.setMaDonVi(DonViTinhModel.getMaDonVi());
		DonViTinh.setTenDonVi(DonViTinhModel.getTenDonVi());
		DonViTinh.setTrangThai(DonViTinhModel.getTrangThai());
		return DonViTinh;
	}

	public static DonViTinhModel entityToModel(DonViTinh DonViTinh) {
		DonViTinhModel donViTinhModel = new DonViTinhModel();
		donViTinhModel.setMaDonVi(DonViTinh.getMaDonVi());
		donViTinhModel.setTenDonVi(DonViTinh.getTenDonVi());
		donViTinhModel.setTrangThai(DonViTinh.getTrangThai());
		return donViTinhModel;
	}

	public static List<DonViTinh> listModelToListEntities(List<DonViTinhModel> listDonViTinhModel) {
		List<DonViTinh> listDonViTinh = new ArrayList<DonViTinh>();
		for (DonViTinhModel donViTinhModel : listDonViTinhModel) {
			DonViTinh donViTinh = modelToEntity(donViTinhModel);
			listDonViTinh.add(donViTinh);
		}
		return listDonViTinh;
	}

	public static List<DonViTinhModel> listEntitiesToListModel(List<DonViTinh> listDonViTinh) {
		List<DonViTinhModel> listDonViTinhModel = new ArrayList<DonViTinhModel>();
		for (DonViTinh donViTinh : listDonViTinh) {
			DonViTinhModel donViTinhModel = entityToModel(donViTinh);
			listDonViTinhModel.add(donViTinhModel);
		}
		return listDonViTinhModel;
	}

	public void them_sua(DonViTinhModel DonViTinhModel) {
		boolean checkExisted = false;
		for (int i = 0; i < _listDonViTinhModels.size(); i++) {
			if (_listDonViTinhModels.get(i).getMaDonVi() == DonViTinhModel.getMaDonVi()) {
				_listDonViTinhModels.get(i).setTenDonVi(DonViTinhModel.getTenDonVi());
				_listDonViTinhModels.get(i).setTrangThai(DonViTinhModel.getTrangThai());
				DonViTinh donViTinh = modelToEntity(_listDonViTinhModels.get(i));
				_DonViTinhDao.them_sua(donViTinh);
				checkExisted = true;
				break;
			}
		}
		if (!checkExisted) {
			DonViTinh donViTinh = modelToEntity(DonViTinhModel);
			_DonViTinhDao.them_sua(donViTinh);
			_listDonViTinhModels.add(DonViTinhModel);
		}
	}

	public void updateListDonViTinhModel() {
		_DonViTinhDao.updateListDonViTinh();
		List<DonViTinh> listDonViTinh = _DonViTinhDao.getListDonViTinh();
		_listDonViTinhModels = listEntitiesToListModel(listDonViTinh);

	}

	public void updateListDonViTinhModel_active() {
		_DonViTinhDao.updateListDonViTinh_active();
		List<DonViTinh> listDonViTinh = _DonViTinhDao.getListDonViTinh_active();
		_listDonViTinhModels_active = listEntitiesToListModel(listDonViTinh);

	}

	public void updateListDonViTinhModel_inactive() {
		_DonViTinhDao.updateListDonViTinh_inactive();
		List<DonViTinh> listDonViTinh = _DonViTinhDao.getListDonViTinh_inactive();
		_listDonViTinhModels_inactive = listEntitiesToListModel(listDonViTinh);

	}

	public List<DonViTinhModel> getListDonViTinhModel() {
		return _listDonViTinhModels;
	}

	public List<DonViTinhModel> getListDonViTinhModel_active() {
		return _listDonViTinhModels_active;
	}

	public List<DonViTinhModel> getListDonViTinhModel_inactive() {
		return _listDonViTinhModels_inactive;
	}

}
