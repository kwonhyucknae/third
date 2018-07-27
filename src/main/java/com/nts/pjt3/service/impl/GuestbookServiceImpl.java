package com.nts.pjt3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.pjt3.dao.GuestbookDao;
import com.nts.pjt3.dto.Guestbook;
import com.nts.pjt3.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
	GuestbookDao guestbookDao;
	
	//Transactional 내부적으로 readOnly라는 형태로 connection 사용
	@Override
	@Transactional
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return list;
	}
	//readonly 가 아니다
	@Override
	@Transactional(readOnly=false)
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		
		return 0;
	}

	@Override
	@Transactional(readOnly=false)
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		return null;
	}

	@Override
	public int getCount() {
		return 0;
	}
}
