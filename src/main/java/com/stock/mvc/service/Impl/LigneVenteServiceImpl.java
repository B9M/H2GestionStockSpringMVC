package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.ILigneVenteDao;
import com.stock.mvc.entities.LigneVente;
import com.stock.mvc.service.ILigneVenteService;
@Transactional
public class LigneVenteServiceImpl implements ILigneVenteService{
	private ILigneVenteDao ilvDao;
	public void setIlvDao(ILigneVenteDao ilvDao) {
		this.ilvDao = ilvDao;
	}

	@Override
	public LigneVente save(LigneVente entity) {
		return ilvDao.save(entity);
	}

	@Override
	public LigneVente update(LigneVente entity) {
		return ilvDao.update(entity);
	}

	@Override
	public List<LigneVente> selectAll() {
		return ilvDao.selectAll();
	}

	@Override
	public List<LigneVente> selectAll(String sortField, String sort) {
		return ilvDao.selectAll(sortField, sort);
	}

	@Override
	public LigneVente getById(Long id) {
		return ilvDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		ilvDao.remove(id);
	}

	@Override
	public LigneVente findOne(String paramName, Object paramValue) {
		return ilvDao.findOne(paramName, paramValue);
	}

	@Override
	public LigneVente findOne(String[] paramNames, Object[] paramValues) {
		return ilvDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return ilvDao.findCountBy(paramName, paramValue);
	}

}
