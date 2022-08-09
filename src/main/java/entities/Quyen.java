package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quyen {
	@Id
	private int maQuyen;
	private String tenQuyen;
	@OneToMany (mappedBy = "quyen")
	private List<Quyen_cv> listQuyen_cv;
	
	public Quyen(int maQuyen, String tenQuyen, List<Quyen_cv> listQuyen_cv) {
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
		this.listQuyen_cv = listQuyen_cv;
	}
	
	public Quyen() {
	}

	public int getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public List<Quyen_cv> getListQuyen_cv() {
		return listQuyen_cv;
	}

	public void setListQuyen_cv(List<Quyen_cv> listQuyen_cv) {
		this.listQuyen_cv = listQuyen_cv;
	}

	@Override
	public String toString() {
		return "Quyen [maQuyen=" + maQuyen + ", tenQuyen=" + tenQuyen + ", listQuyen_cv=" + listQuyen_cv + "]";
	}
	
	
}
