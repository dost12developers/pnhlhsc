package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Manufacture;

public interface ManufactureDAO {
	Manufacture get(int id);
	List<Manufacture> list();
	boolean add(Manufacture manufacture);
	boolean update(Manufacture manufacture);
	boolean delete(Manufacture manufacture);
}
