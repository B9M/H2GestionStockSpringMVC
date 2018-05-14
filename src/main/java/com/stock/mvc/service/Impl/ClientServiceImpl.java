package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IClientDao;
import com.stock.mvc.entities.Client;
import com.stock.mvc.service.IClientService;
@Transactional
public class ClientServiceImpl implements IClientService {
	private IClientDao icDao;
	public void setIcDao(IClientDao icDao) {
		this.icDao = icDao;
	}
	@Override
	public Client save(Client entity) {
		return icDao.save(entity);
	}

	@Override
	public Client update(Client entity) {
		return icDao.update(entity);
	}

	@Override
	public List<Client> selectAll() {
		return icDao.selectAll();
	}

	@Override
	public List<Client> selectAll(String sortField, String sort) {
		return icDao.selectAll(sortField, sort);
	}

	@Override
	public Client getById(Long id) {
		return icDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		icDao.remove(id);		
	}

	@Override
	public Client findOne(String paramName, Object paramValue) {
		icDao.findOne(paramName, paramValue);
		return null;
	}

	@Override
	public Client findOne(String[] paramNames, Object[] paramValues) {
		return icDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return icDao.findCountBy(paramName, paramValue);
	}

}
