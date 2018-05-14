package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IVenteDao;
import com.stock.mvc.entities.Vente;
import com.stock.mvc.service.IVenteService;
@Transactional
public class VenteServiceImpl implements IVenteService {

	private IVenteDao ivDao;
	public void setIvDao(IVenteDao ivDao) {
		this.ivDao = ivDao;
	}
	@Override
	public Vente save(Vente entity) {
		return ivDao.save(entity);
	}

	@Override
	public Vente update(Vente entity) {
		return ivDao.update(entity);
	}

	@Override
	public List<Vente> selectAll() {
		return ivDao.selectAll();
	}

	@Override
	public List<Vente> selectAll(String sortField, String sort) {
		return ivDao.selectAll(sortField, sort);
	}

	@Override
	public Vente getById(Long id) {
		return ivDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		ivDao.remove(id);		
	}

	@Override
	public Vente findOne(String paramName, Object paramValue) {
		return ivDao.findOne(paramName, paramValue);
	}

	@Override
	public Vente findOne(String[] paramNames, Object[] paramValues) {
		return ivDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return ivDao.findCountBy(paramName, paramValue);
	}

}
