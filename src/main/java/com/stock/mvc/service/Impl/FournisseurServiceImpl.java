package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IFournisseurDao;
import com.stock.mvc.entities.Fournisseur;
import com.stock.mvc.service.IFournisseurService;
@Transactional
public class FournisseurServiceImpl implements IFournisseurService {
	
	private IFournisseurDao ifDao;
	public void setIfDao(IFournisseurDao ifDao) {
		this.ifDao = ifDao;
	}

	@Override
	public Fournisseur save(Fournisseur entity) {
		return ifDao.save(entity);
	}

	@Override
	public Fournisseur update(Fournisseur entity) {
		return ifDao.update(entity);
	}

	@Override
	public List<Fournisseur> selectAll() {
		return ifDao.selectAll();
	}

	@Override
	public List<Fournisseur> selectAll(String sortField, String sort) {
		return ifDao.selectAll(sortField, sort);
	}

	@Override
	public Fournisseur getById(Long id) {
		return ifDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		ifDao.remove(id);
	}

	@Override
	public Fournisseur findOne(String paramName, Object paramValue) {
		return ifDao.findOne(paramName, paramValue);
	}

	@Override
	public Fournisseur findOne(String[] paramNames, Object[] paramValues) {
		return ifDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return ifDao.findCountBy(paramName, paramValue);
	}

}
