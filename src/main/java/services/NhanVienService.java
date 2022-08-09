package services;

import java.util.ArrayList;
import java.util.List;

import dao.NhanVienDao;
import entities.ChucVu;
import entities.SanPhamVaDichVu;
import entities.NhanVien;
import entities.PhieuNhapKho;
import models.ChucVuModel;
import models.SanPhamVaDichVuModel;
import models.NhanVienModel;
import utils.IoCContainer;

public class NhanVienService {
	private IoCContainer ioCContainer = new IoCContainer();
	private List<NhanVienModel> _listNhanVienModels = new ArrayList<NhanVienModel>();
	private NhanVienDao _nhanVienDao = (NhanVienDao) ioCContainer.getBean(NhanVienDao.class.toString());
	private NhanVien _nhanVien;
	private NhanVienModel _nhanVienModel = (NhanVienModel) IoCContainer.getBean(NhanVienModel.class.toString());;
	private int _maxID;
	
	public static NhanVien modelToEntity(NhanVienModel nhanVienModel) {
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNV(nhanVienModel.getMaNV());
		nhanVien.setTenNV(nhanVienModel.getTenNV());
		nhanVien.setSdt(nhanVienModel.getSdt());
		nhanVien.setGioiTinh(nhanVienModel.getGioiTinh());
		nhanVien.setEmail(nhanVienModel.getEmail());
		nhanVien.setChucVu(ChucVuService.modelToEntity(nhanVienModel.getChucVuModel()));
		nhanVien.setTrangThai(nhanVienModel.getTrangThai());
		nhanVien.setCmnd(nhanVienModel.getCmnd());
		nhanVien.setUserName(nhanVienModel.getUserName());
		nhanVien.setPassword(nhanVienModel.getPassword());
		nhanVien.setNgaySinh(nhanVienModel.getNgaySinh());
		return nhanVien;
		
	}
	
	public static NhanVienModel entityToModel(NhanVien nhanVien) {
		NhanVienModel nhanVienModel = new NhanVienModel();
		nhanVienModel.setMaNV(nhanVien.getMaNV());
		nhanVienModel.setTenNV(nhanVien.getTenNV());
		nhanVienModel.setSdt(nhanVien.getSdt());
		nhanVienModel.setGioiTinh(nhanVien.getGioiTinh());
		nhanVienModel.setEmail(nhanVien.getEmail());
		nhanVienModel.setChucVuModel(ChucVuService.entityToModel(nhanVien.getChucVu()));
		nhanVienModel.setTrangThai(nhanVien.getTrangThai());
		nhanVienModel.setCmnd(nhanVien.getCmnd());
		nhanVienModel.setUserName(nhanVien.getUserName());
		nhanVienModel.setPassword(nhanVien.getPassword());
		nhanVienModel.setNgaySinh(nhanVien.getNgaySinh());
		return nhanVienModel;
	}
	
	public static List<NhanVienModel> listEntitiesToListModel  (List<NhanVien> listNhanVien){
		List<NhanVienModel> listNhanVienModel = new ArrayList<NhanVienModel>();
		for (NhanVien nhanVien : listNhanVien) {
			NhanVienModel nhanVienModel = entityToModel(nhanVien);
			listNhanVienModel.add(nhanVienModel);
		}
		return listNhanVienModel;
	}
	
	public static List<NhanVien> listModelToListEntities  (List<NhanVienModel> listNhanVienModel){
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		for (NhanVienModel nhanVienModel : listNhanVienModel) {
			NhanVien nhanVien = modelToEntity(nhanVienModel);
			listNhanVien.add(nhanVien);
		}
		return listNhanVien;
	}
	
	public void them_sua(NhanVienModel nhanVienModel) {
		_nhanVien = modelToEntity(nhanVienModel);
		_nhanVienDao.them_sua(_nhanVien);
		updateListNhanVienModel();
	}
	
	public void sua(NhanVienModel nhanVienModel) {
		_nhanVien = modelToEntity(nhanVienModel);
		_nhanVienDao.them_sua(_nhanVien);
	}

	
	public void updateListNhanVienModel() {
		_nhanVienDao.updateListNhanVien();
		List<NhanVien> listNhanVien = _nhanVienDao.getListNhanVien();
		_listNhanVienModels = listEntitiesToListModel(listNhanVien);
		_maxID = _nhanVienDao.getMaxID();
	}
	
	public void updateListNhanVienModel_active(String trangThai) {
		_nhanVienDao.updateListNhanVien_active();
		List<NhanVien> listNhanVien = _nhanVienDao.getListNhanVien();
		_listNhanVienModels = listEntitiesToListModel(listNhanVien);
		_maxID = _nhanVienDao.getMaxID();
	}
	
	public int getMaxID() {
		return _maxID;
	}

	public List<NhanVienModel> getListNhanVienModel() {
		return _listNhanVienModels;
	}

}