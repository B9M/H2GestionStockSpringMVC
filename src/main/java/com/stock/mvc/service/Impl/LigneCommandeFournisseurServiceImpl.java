package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.ILigneCommandeFournisseurDao;
import com.stock.mvc.entities.LigneCommandeFournisseur;
import com.stock.mvc.service.ILigneCommandeFournisseurService;
@Transactional
public class LigneCommandeFournisseurServiceImpl implements ILigneCommandeFournisseurService{
	private ILigneCommandeFournisseurDao ilcfDao;
	public void setIlcfDao(ILigneCommandeFournisseurDao ilcfDao) {
		this.ilcfDao = ilcfDao;
	}

	@Override
	public LigneCommandeFournisseur save(LigneCommandeFournisseur entity) {
		return ilcfDao.save(entity);
	}

	@Override
	public LigneCommandeFournisseur update(LigneCommandeFournisseur entity) {
		return ilcfDao.update(entity);
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll() {
		return ilcfDao.selectAll();
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll(String sortField, String sort) {
		return ilcfDao.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeFournisseur getById(Long id) {
		return ilcfDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		ilcfDao.remove(id);		
	}

	@Override
	public LigneCommandeFournisseur findOne(String paramName, Object paramValue) {
		return ilcfDao.findOne(paramName, paramValue);
	}

	@Override
	public LigneCommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		return ilcfDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return ilcfDao.findCountBy(paramName, paramValue);
	}

}
