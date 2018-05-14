package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.ICommandeFournisseurDao;
import com.stock.mvc.entities.CommandeFournisseur;
import com.stock.mvc.service.ICommandeFournisseurService;
@Transactional
public class CommandeFournisseurServiceImpl implements ICommandeFournisseurService {

	private ICommandeFournisseurDao icfDao;
	public void setIcfDao(ICommandeFournisseurDao icfDao) {
		this.icfDao = icfDao;
	}
	@Override
	public CommandeFournisseur save(CommandeFournisseur entity) {
		return icfDao.save(entity);
	}

	@Override
	public CommandeFournisseur update(CommandeFournisseur entity) {
		return icfDao.update(entity);
	}

	@Override
	public List<CommandeFournisseur> selectAll() {
		return icfDao.selectAll();
	}

	@Override
	public List<CommandeFournisseur> selectAll(String sortField, String sort) {
		return icfDao.selectAll(sortField, sort);
	}

	@Override
	public CommandeFournisseur getById(Long id) {
		return icfDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		icfDao.remove(id);		
	}

	@Override
	public CommandeFournisseur findOne(String paramName, Object paramValue) {
		return icfDao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		return icfDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return findCountBy(paramName, paramValue);
	}

}
