package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IMvStkDao;
import com.stock.mvc.entities.MvtStk;
import com.stock.mvc.service.IMvtStkService;
@Transactional
public class MvtStkServiceImpl implements IMvtStkService {

	private IMvStkDao imsDao;
	public void setImsDao(IMvStkDao imsDao) {
		this.imsDao = imsDao;
	}
	@Override
	public MvtStk save(MvtStk entity) {
		return imsDao.save(entity);
	}

	@Override
	public MvtStk update(MvtStk entity) {
		return imsDao.update(entity);
	}

	@Override
	public List<MvtStk> selectAll() {
		return imsDao.selectAll();
	}

	@Override
	public List<MvtStk> selectAll(String sortField, String sort) {
		return imsDao.selectAll(sortField, sort);
	}

	@Override
	public MvtStk getById(Long id) {
		return imsDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		imsDao.remove(id);
		
	}

	@Override
	public MvtStk findOne(String paramName, Object paramValue) {
		return imsDao.findOne(paramName, paramValue);
	}

	@Override
	public MvtStk findOne(String[] paramNames, Object[] paramValues) {
		return imsDao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return imsDao.findCountBy(paramName, paramValue);
	}

}
