package com.stock.mvc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.stock.mvc.dao.impl.FlickrDaoImpl;

public class TestFlickr {

	public static void main(String[] args) {
		FlickrDaoImpl flickr = new FlickrDaoImpl();
		try {
			InputStream is = new FileInputStream(new File("C:\\Users\\Badr\\Desktop\\ch1.png"));
			String url = flickr.savePhoto(is, "Myimage1");
			System.out.println(url);
			
			// ce test va uploader l'images ds ls serveur de flickr il va retourner l'url ou il est stocké voir console puis
			// acceder a ce url 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
