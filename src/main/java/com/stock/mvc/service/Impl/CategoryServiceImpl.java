package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.ICategoryDao;
import com.stock.mvc.entities.Category;
import com.stock.mvc.service.ICategoryService;
@Transactional
public class CategoryServiceImpl implements ICategoryService{
	private ICategoryDao icDao;
	public void setIcDao(ICategoryDao icDao) {
		this.icDao = icDao;
	}
	@Override
	public Category save(Category entity) {
		return icDao.save(entity);
	}

	@Override
	public Category update(Category entity) {
		return icDao.update(entity);
	}

	@Override
	public List<Category> selectAll() {
		return icDao.selectAll();
	}

	@Override
	public List<Category> selectAll(String sortField, String sort) {
		return icDao.selectAll(sortField, sort);
	}

	@Override
	public Category getById(Long id) {
		return icDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		icDao.remove(id);
	}

	@Override
	public Category findOne(String paramName, Object paramValue) {
		return icDao.findOne(paramName, paramValue);
	}

	@Override
	public Category findOne(String[] paramNames, Object[] paramValues) {
		return icDao.findOne(paramNames, paramValues);
	}
	@Override
	public int findCountBy(String paramName, String paramValue) {
		return icDao.findCountBy(paramName, paramValue);
	}

}
