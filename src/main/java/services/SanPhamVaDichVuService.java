package services;

import java.util.ArrayList;
import java.util.List;

import dao.SanPhamVaDichVuDao;
import dao.SanPhamVaDichVuDao;
import entities.DonViChiTiet;
import entities.NhomSPVaDichVu;
import entities.SanPhamVaDichVu;
import entities.SanPhamVaDichVu;
import utils.IoCContainer;
import models.DonViChiTietModel;
import models.KhoModel;
import models.NhomSPVaDichVuModel;
import models.PhieuKiemKhoChiTietModel;
import models.SanPhamVaDichVuModel;
import models.SanPhamVaDichVuModel;

public class SanPhamVaDichVuService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<SanPhamVaDichVu> _listSanPhamVaDichVus = new ArrayList<SanPhamVaDichVu>();
	private List<SanPhamVaDichVuModel> _listSanPhamVaDichVuModels = new ArrayList<SanPhamVaDichVuModel>();
	private List<SanPhamVaDichVuModel> _listSanPhamVaDichVuModels_active = new ArrayList<SanPhamVaDichVuModel>();
	private List<SanPhamVaDichVuModel> _listSanPhamVaDichVuModels_inactive = new ArrayList<SanPhamVaDichVuModel>();
	private SanPhamVaDichVuDao _SanPhamVaDichVuDao = (SanPhamVaDichVuDao) ioCContainer
			.getBean(SanPhamVaDichVuDao.class.toString());
	private SanPhamVaDichVu _SanPhamVaDichVu;
	private int maxID;

	public static SanPhamVaDichVu modelToEntity(SanPhamVaDichVuModel spvdvm) {
		SanPhamVaDichVu spvdv = new SanPhamVaDichVu();
		spvdv.setMaDichVu(spvdvm.getMaDichVu());
		spvdv.setTenHangHoa(spvdvm.getTenHangHoa());
		spvdv.setNhomSPVaDichVu(NhomSPVaDichVuService.modelToEntity(spvdvm.getNhomSPVaDichVuModel()));
		spvdv.setSoLuongTon(spvdvm.getSoLuongTon());
		spvdv.setGiaVon(spvdvm.getGiaVon());
		spvdv.setKho(KhoService.modelToEntity(spvdvm.getKhoModel()));
		spvdv.setMoTa(spvdvm.getMoTa());
		spvdv.setTrangThai(spvdvm.getTrangThai());
		return spvdv;
	}

	public static SanPhamVaDichVuModel entityToModel(SanPhamVaDichVu spvdv) {
		SanPhamVaDichVuModel spvdvm = new SanPhamVaDichVuModel();
		spvdvm.setMaDichVu(spvdv.getMaDichVu());
		spvdvm.setTenHangHoa(spvdv.getTenHangHoa());
		spvdvm.setNhomSPVaDichVuModel(NhomSPVaDichVuService.entityToModel(spvdv.getNhomSPVaDichVu()));
		spvdvm.setSoLuongTon(spvdv.getSoLuongTon());
		spvdvm.setGiaVon(spvdv.getGiaVon());
		spvdvm.setKhoModel(KhoService.entityToModel(spvdv.getKho()));
		spvdvm.setMoTa(spvdv.getMoTa());
		spvdvm.setTrangThai(spvdv.getTrangThai());
		return spvdvm;
	}

	public static List<SanPhamVaDichVuModel> listEntitiesToListModel(List<SanPhamVaDichVu> listSPVDV) {
		List<SanPhamVaDichVuModel> listSanPhamVaDichVuModel = new ArrayList<SanPhamVaDichVuModel>();
		for (SanPhamVaDichVu sanPhamVaDichVu : listSPVDV) {
			SanPhamVaDichVuModel sanPhamVaDichVuModel = entityToModel(sanPhamVaDichVu);
			listSanPhamVaDichVuModel.add(sanPhamVaDichVuModel);
		}
		return listSanPhamVaDichVuModel;
	}

	public static List<SanPhamVaDichVu> ListModelToListEntities(List<SanPhamVaDichVuModel> listSPVDVM) {
		List<SanPhamVaDichVu> listSPVDV = new ArrayList<SanPhamVaDichVu>();
		for (SanPhamVaDichVuModel sanPhamVaDichVuModel : listSPVDVM) {
			SanPhamVaDichVu sanPhamVaDichVu = modelToEntity(sanPhamVaDichVuModel);
			listSPVDV.add(sanPhamVaDichVu);
		}
		return listSPVDV;
	}

	public void them_sua(SanPhamVaDichVuModel spvdvm) {
		_SanPhamVaDichVu = modelToEntity(spvdvm);
		_SanPhamVaDichVuDao.them_sua(_SanPhamVaDichVu);
		updateListSanPhamVaDichVuModel();
	}
	public void them_sua(SanPhamVaDichVuModel spvdvm , String trangThai) {
		_SanPhamVaDichVu = modelToEntity(spvdvm);
		_SanPhamVaDichVuDao.them_sua(_SanPhamVaDichVu);
		updateListSanPhamVaDichVuModel(trangThai);
	}
	
	public List<DonViChiTietModel> getListDVCTM(SanPhamVaDichVuModel spvdvm){
		List<DonViChiTietModel> listDVCTM;
		for (SanPhamVaDichVu sanPhamVaDichVu : _listSanPhamVaDichVus) {
			if(sanPhamVaDichVu.getMaDichVu() == spvdvm.getMaDichVu()) {
				listDVCTM = DonViChiTietService.listEntitiesTolistModel(sanPhamVaDichVu.getListDonViChiTiet());
				return listDVCTM;
			}
		}
		return null;
	}

	public DonViChiTietModel getDonViMacDinh(SanPhamVaDichVuModel spvdvm) {
		for (SanPhamVaDichVu spvdv : _listSanPhamVaDichVus) {
			if (spvdvm.getMaDichVu() == spvdv.getMaDichVu()) {
				List<DonViChiTiet> listDVCT = spvdv.getListDonViChiTiet();
				for (DonViChiTiet donViChiTiet : listDVCT) {
					if(donViChiTiet.getDonViMacDinh() == 1 && donViChiTiet.getTrangThai().equals("Hoat Dong")) {
						DonViChiTietModel dvctm = DonViChiTietService.entityToModel(donViChiTiet);
						return dvctm;
					}
				}
				break;
			}
		}
		return null;
	}
	
	public void updateListSanPhamVaDichVuModel() {
		_SanPhamVaDichVuDao.updateListSanPhamVaDichVu();
		_listSanPhamVaDichVus = _SanPhamVaDichVuDao.getListSanPhamVaDichVu();
		_listSanPhamVaDichVuModels = listEntitiesToListModel(_listSanPhamVaDichVus);
		maxID = _SanPhamVaDichVuDao.getMaxID();
	}

	public void updateListSanPhamVaDichVuModel(String trangThai) {
		_SanPhamVaDichVuDao.updateListSanPhamVaDichVu(trangThai);
		if (trangThai.equals("Hoat Dong")) {
			_listSanPhamVaDichVus = _SanPhamVaDichVuDao.getListSanPhamVaDichVu_active();
			_listSanPhamVaDichVuModels_active = listEntitiesToListModel(_listSanPhamVaDichVus);
		} else {
			_listSanPhamVaDichVus = _SanPhamVaDichVuDao.getListSanPhamVaDichVu_inactive();
			_listSanPhamVaDichVuModels_inactive = listEntitiesToListModel(_listSanPhamVaDichVus);
		}

	}

	public List<SanPhamVaDichVuModel> getListSanPhamVaDichVuModel() {
		return _listSanPhamVaDichVuModels;
	}

	public List<SanPhamVaDichVuModel> getListSanPhamVaDichVuModel_active() {
		return _listSanPhamVaDichVuModels_active;
	}

	public List<SanPhamVaDichVuModel> getListSanPhamVaDichVuModel_inactive() {
		return _listSanPhamVaDichVuModels_inactive;
	}

	public int getMaxID() {
		return maxID;
	}

}
