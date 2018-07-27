package com.nts.pjt3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.pjt3.dao.CategorieDao;
import com.nts.pjt3.dto.Category;
import com.nts.pjt3.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService{
	@Autowired
	CategorieDao categorieDao;
	
	@Override
	@Transactional
	public List<Category> getCategorie(){
		List<Category> list = categorieDao.selectAll();
		return list;
	}

	@Override
	@Transactional
	public int getCount() {
		int count = categorieDao.selectCategorieCount();
		return count;
	}
}
