package services;

import java.util.ArrayList;
import java.util.List;

import dao.PhieuKiemKhoChiTietDao;
import entities.PhieuKiemKhoChiTiet;
import models.PhieuKiemKhoChiTietModel;
import utils.IoCContainer;

public class PhieuKiemKhoChiTietService {
	private IoCContainer ioCContainer = new IoCContainer();
	private List<PhieuKiemKhoChiTietModel> _listPhieuKiemKhoChiTietModels = new ArrayList<PhieuKiemKhoChiTietModel>();
	private PhieuKiemKhoChiTietDao _PhieuKiemKhoChiTietDao = (PhieuKiemKhoChiTietDao) ioCContainer.getBean(PhieuKiemKhoChiTietDao.class.toString());
	private PhieuKiemKhoChiTiet _PhieuKiemKhoChiTiet;

	public static PhieuKiemKhoChiTiet modelToEntity(PhieuKiemKhoChiTietModel pkkctm) {
		PhieuKiemKhoChiTiet pkkct = new PhieuKiemKhoChiTiet();
		pkkct.setPhieuKiemKho(PhieuKiemKhoService.modelToEntity(pkkctm.getPhieuKiemKhoModel()));
		pkkct.setSanPhamVaDichVu(SanPhamVaDichVuService.modelToEntity(pkkctm.getSanPhamVaDichVuModel()));
		pkkct.setSoLuongTruocKhiKiem(pkkctm.getSoLuongTruocKhiKiem());
		pkkct.setSoLuongThucTe(pkkctm.getSoLuongThucTe());
		pkkct.setSoLuongChenhLech(pkkctm.getSoLuongChenhLech());
		pkkct.setGhiChuLiDoChenhLech(pkkctm.getGhiChuLiDoChenhLech());
		return pkkct;
	}
	public static PhieuKiemKhoChiTietModel entityToModel(PhieuKiemKhoChiTiet pkkct) {
		PhieuKiemKhoChiTietModel pkkctm = new PhieuKiemKhoChiTietModel();
		pkkctm.setPhieuKiemKhoModel(PhieuKiemKhoService.entityToModel(pkkct.getPhieuKiemKho()));
		pkkctm.setSanPhamVaDichVuModel(SanPhamVaDichVuService.entityToModel(pkkct.getSanPhamVaDichVu()));
		pkkctm.setSoLuongTruocKhiKiem(pkkct.getSoLuongTruocKhiKiem());
		pkkctm.setSoLuongThucTe(pkkct.getSoLuongThucTe());
		pkkctm.setSoLuongChenhLech(pkkct.getSoLuongChenhLech());
		pkkctm.setGhiChuLiDoChenhLech(pkkct.getGhiChuLiDoChenhLech());
		return pkkctm;
	}
	
	public static List<PhieuKiemKhoChiTietModel> listEntitiesToListModel (List<PhieuKiemKhoChiTiet> listPhieuKiemKhoChiTiet){
		List<PhieuKiemKhoChiTietModel> litPhieuKiemKhoChiTietModel = new ArrayList<PhieuKiemKhoChiTietModel>();
		for (PhieuKiemKhoChiTiet phieuKiemKhoChiTiet : listPhieuKiemKhoChiTiet) {
			PhieuKiemKhoChiTietModel phieuKiemKhoChiTietModel = entityToModel(phieuKiemKhoChiTiet);
			litPhieuKiemKhoChiTietModel.add(phieuKiemKhoChiTietModel);
		}
		return litPhieuKiemKhoChiTietModel;
	}
	public static List<PhieuKiemKhoChiTiet> updateListPhieuKiemKhoChiTietDependOnListPhieuKiemKhoChiTietModel (List<PhieuKiemKhoChiTietModel> listPhieuKiemKhoChiTietModel){
		List<PhieuKiemKhoChiTiet> litPhieuKiemKhoChiTiet = new ArrayList<PhieuKiemKhoChiTiet>();
		for (PhieuKiemKhoChiTietModel phieuKiemKhoChiTietModel : listPhieuKiemKhoChiTietModel) {
			PhieuKiemKhoChiTiet phieuKiemKhoChiTiet= modelToEntity(phieuKiemKhoChiTietModel);
			litPhieuKiemKhoChiTiet.add(phieuKiemKhoChiTiet);
		}
		return litPhieuKiemKhoChiTiet;
	}

	public void them_sua(PhieuKiemKhoChiTietModel PhieuKiemKhoChiTietModel) {
		_PhieuKiemKhoChiTiet = modelToEntity(PhieuKiemKhoChiTietModel);
		_PhieuKiemKhoChiTietDao.them_sua(_PhieuKiemKhoChiTiet);
		_listPhieuKiemKhoChiTietModels.add(PhieuKiemKhoChiTietModel);
	}

	
	public void updateListPhieuKiemKhoChiTietModel() {
		_PhieuKiemKhoChiTietDao.updateListPhieuKiemKhoChiTiet();
		List<PhieuKiemKhoChiTiet> listPhieuKiemKhoChiTiet = _PhieuKiemKhoChiTietDao.getListPhieuKiemKhoChiTiet();
		_listPhieuKiemKhoChiTietModels = listEntitiesToListModel(listPhieuKiemKhoChiTiet);

	}

	public List<PhieuKiemKhoChiTietModel> getListPhieuKiemKhoChiTietModel() {
		return _listPhieuKiemKhoChiTietModels;
	}

}
