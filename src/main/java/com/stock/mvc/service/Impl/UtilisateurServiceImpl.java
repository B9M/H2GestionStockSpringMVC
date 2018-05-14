package com.stock.mvc.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IUtilisateurDao;
import com.stock.mvc.entities.Utilisateur;
import com.stock.mvc.service.IUtilisateurService;
@Transactional
public class UtilisateurServiceImpl  implements IUtilisateurService{

	private IUtilisateurDao iuDao;
	public void setIuDao(IUtilisateurDao iuDao) {
		this.iuDao = iuDao;
	}
	@Override
	public Utilisateur save(Utilisateur entity) {
		return iuDao.save(entity);
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		return iuDao.update(entity);
	}

	@Override
	public List<Utilisateur> selectAll() {
		return iuDao.selectAll();
	}

	@Override
	public List<Utilisateur> selectAll(String sortField, String sort) {
		return iuDao.selectAll(sortField, sort);
	}

	@Override
	public Utilisateur getById(Long id) {
		return iuDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		iuDao.remove(id);		
	}

	@Override
	public Utilisateur findOne(String paramName, Object paramValue) {
		return iuDao.findOne(paramName, paramValue);
	}

	@Override
	public Utilisateur findOne(String[] paramNames, Object[] paramValues) {
		iuDao.findOne(paramNames, paramValues);	
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return iuDao.findCountBy(paramName, paramValue);
	}

}
