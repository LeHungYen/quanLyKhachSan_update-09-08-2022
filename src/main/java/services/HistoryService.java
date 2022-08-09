package services;

import java.util.ArrayList;
import java.util.List;

import dao.HistoryDao;
import entities.History;
import models.HistoryModel;
import models.NhanVienModel;
import utils.IoCContainer;

public class HistoryService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<HistoryModel> _listHistoryModels = new ArrayList<HistoryModel>();
	private HistoryDao _HistoryDao = (HistoryDao) ioCContainer.getBean(HistoryDao.class.toString());
	private History _History;

	public static History updateDataHistoryDependOnHistoryModel(HistoryModel HistoryModel) {
		History History = new History();
		History.setId(HistoryModel.getId());
		History.setNhanVien(NhanVienService.modelToEntity(HistoryModel.getNhanVienModel()));
		History.setDoiTuong(HistoryModel.getDoiTuong());
		History.setHanhDong(HistoryModel.getHanhDong());
		History.setGhiChu(HistoryModel.getGhiChu());
		return History;
	}
	
	public static HistoryModel updateDataHistoryModelDependOnHistory(History History) {
		HistoryModel HistoryModel = new HistoryModel();
		HistoryModel.setId(History.getId());
		HistoryModel.setNhanVienModel(NhanVienService.entityToModel(History.getNhanVien()));
		HistoryModel.setDoiTuong(History.getDoiTuong());
		HistoryModel.setHanhDong(History.getHanhDong());
		HistoryModel.setGhiChu(History.getGhiChu());
		return HistoryModel;
	}
	
	public static List<History> updateListHistoryDependOnListHistoryModel(List<HistoryModel> listHistoryModel) {
		List<History> listHistory = new ArrayList<History>();
		for (HistoryModel HistoryModel2 : listHistoryModel) {
			History History = updateDataHistoryDependOnHistoryModel(HistoryModel2);
			listHistory.add(History);
		}
		return listHistory;
	}
	
	public static List<HistoryModel> updateListHistoryModelDependOnListHistory(List<History> listHistory) {
		List<HistoryModel> listHistoryModel = new ArrayList<HistoryModel>();
		for (History History : listHistory) {
			HistoryModel HistoryModel = updateDataHistoryModelDependOnHistory(History);
			listHistoryModel.add(HistoryModel);
		}
		return listHistoryModel;
	}

	public void them_sua(HistoryModel HistoryModel) {
		_History = updateDataHistoryDependOnHistoryModel(HistoryModel);
		_HistoryDao.them_sua(_History);
		_listHistoryModels.add(HistoryModel);// check lại
	}

	public void updateListHistoryModel() {
		_HistoryDao.updateListHistory();
		List<History> listHistory = _HistoryDao.getListHistory();
		_listHistoryModels = updateListHistoryModelDependOnListHistory(listHistory);

	}

	public List<HistoryModel> getListHistoryModel() {
		return _listHistoryModels;
	}

}