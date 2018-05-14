package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.ICommandeClientDao;
import com.stock.mvc.entities.CommandeClient;
import com.stock.mvc.service.ICommandeClientService;
@Transactional
public class CommandeClientServiceImpl implements ICommandeClientService{

	
	private ICommandeClientDao iccDao;
	public void setIccDao(ICommandeClientDao iccDao) {
		this.iccDao = iccDao;
	}
	@Override
	public CommandeClient save(CommandeClient entity) {
		return iccDao.save(entity);
	}

	@Override
	public CommandeClient update(CommandeClient entity) {
		return iccDao.update(entity);
	}

	@Override
	public List<CommandeClient> selectAll() {
		return iccDao.selectAll();
	}

	@Override
	public List<CommandeClient> selectAll(String sortField, String sort) {
		return iccDao.selectAll(sortField, sort);
	}

	@Override
	public CommandeClient getById(Long id) {
		return iccDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		iccDao.remove(id);		
	}

	@Override
	public CommandeClient findOne(String paramName, Object paramValue) {
		return iccDao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeClient findOne(String[] paramNames, Object[] paramValues) {
		return iccDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return iccDao.findCountBy(paramName, paramValue);
	}
 
}
