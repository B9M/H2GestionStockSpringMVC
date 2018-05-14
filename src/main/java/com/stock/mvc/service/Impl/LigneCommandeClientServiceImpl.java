package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.ILigneCommandeClientDao;
import com.stock.mvc.entities.LigneCommandeClient;
import com.stock.mvc.service.ILigneCommandeClientService;
@Transactional
public class LigneCommandeClientServiceImpl implements ILigneCommandeClientService{
	
	private ILigneCommandeClientDao ilccDao;
	public void setIlccDao(ILigneCommandeClientDao ilccDao) {
		this.ilccDao = ilccDao;
	}
	@Override
	public LigneCommandeClient save(LigneCommandeClient entity) {
		return ilccDao.save(entity);
	}

	@Override
	public LigneCommandeClient update(LigneCommandeClient entity) {
		return ilccDao.update(entity);
	}

	@Override
	public List<LigneCommandeClient> selectAll() {
		return ilccDao.selectAll();
	}

	@Override
	public List<LigneCommandeClient> selectAll(String sortField, String sort) {
		return ilccDao.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeClient getById(Long id) {
		return ilccDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		ilccDao.remove(id);		
	}

	@Override
	public LigneCommandeClient findOne(String paramName, Object paramValue) {
		return ilccDao.findOne(paramName, paramValue);
	}

	@Override
	public LigneCommandeClient findOne(String[] paramNames, Object[] paramValues) {
		return ilccDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return ilccDao.findCountBy(paramName, paramValue);
	}

}
