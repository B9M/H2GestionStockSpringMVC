package com.stock.mvc.service.Impl;

import java.io.InputStream;

import com.stock.mvc.dao.IFlickrDao;
import com.stock.mvc.service.IFlickrService;

public class FlickrServiceImpl implements IFlickrService {
	private IFlickrDao dao;

	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}
	@Override
	public String savePhoto(InputStream strem, String fileName) throws Exception {
		return dao.savePhoto(strem, fileName);
	}

}
