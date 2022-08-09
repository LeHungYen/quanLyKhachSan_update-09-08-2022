package services;

import java.util.ArrayList;
import java.util.List;

import dao.QuyenDao;
import entities.Quyen;
import models.QuyenModel;
import utils.IoCContainer;

public class QuyenService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<QuyenModel> _listQuyenModels = new ArrayList<QuyenModel>();
	private QuyenDao _QuyenDao = (QuyenDao) ioCContainer.getBean(QuyenDao.class.toString());
	private Quyen _Quyen;

	public static Quyen updateDataQuyenDependOnQuyenModel(QuyenModel QuyenModel) {
		Quyen Quyen = new Quyen();
		Quyen.setMaQuyen(QuyenModel.getMaQuyen());
		Quyen.setTenQuyen(QuyenModel.getTenQuyen());
		return Quyen;
	}
	
	public static QuyenModel updateDataQuyenModelDependOnQuyen(Quyen Quyen) {
		QuyenModel QuyenModel = new QuyenModel();
		QuyenModel.setMaQuyen(Quyen.getMaQuyen());
		QuyenModel.setTenQuyen(Quyen.getTenQuyen());
		return QuyenModel;
	}
	
	public static List<Quyen> updateListQuyenDependOnListQuyenModel(List<QuyenModel> listQuyenModel) {
		List<Quyen> listQuyen = new ArrayList<Quyen>();
		for (QuyenModel QuyenModel2 : listQuyenModel) {
			Quyen Quyen = updateDataQuyenDependOnQuyenModel(QuyenModel2);
			listQuyen.add(Quyen);
		}
		return listQuyen;
	}
	
	public static List<QuyenModel> updateListQuyenModelDependOnListQuyen(List<Quyen> listQuyen) {
		List<QuyenModel> listQuyenModel = new ArrayList<QuyenModel>();
		for (Quyen Quyen : listQuyen) {
			QuyenModel QuyenModel = updateDataQuyenModelDependOnQuyen(Quyen);
			listQuyenModel.add(QuyenModel);
		}
		return listQuyenModel;
	}

	public void them_sua(QuyenModel QuyenModel) {
		_Quyen = updateDataQuyenDependOnQuyenModel(QuyenModel);
		_QuyenDao.them_sua(_Quyen);
		_listQuyenModels.add(QuyenModel);// check lại
	}

	public void updateListQuyenModel() {
		_QuyenDao.updateListQuyen();
		List<Quyen> listQuyen = _QuyenDao.getListQuyen();
		_listQuyenModels = updateListQuyenModelDependOnListQuyen(listQuyen);

	}

	public List<QuyenModel> getListQuyenModel() {
		return _listQuyenModels;
	}
}
