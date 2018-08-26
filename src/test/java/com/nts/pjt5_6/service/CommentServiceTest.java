package com.nts.pjt5_6.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nts.pjt5_6.config.ApplicationConfig;
import com.nts.pjt5_6.dao.FileInfoMapper;
import com.nts.pjt5_6.dao.ReservationUserCommentImageMapper;
import com.nts.pjt5_6.dao.ReservationUserCommentMapper;
import com.nts.pjt5_6.dto.CommentWrite;
import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;
import com.nts.pjt5_6.service.impl.CommentServiceImpl;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class CommentServiceTest {

	@Mock
	ReservationUserCommentMapper commentMapper; 
	@Mock
	ReservationUserCommentImageMapper commentImageMapper;
	@Mock
	FileInfoMapper fileMapper;
	@InjectMocks
	CommentServiceImpl commentService;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void 한줄평_등록_테스트() {
	    CommentWrite 등록할_한줄평 = new CommentWrite();
	    ReservationUserCommentImages 등록할_한줄평_이미지 = new ReservationUserCommentImages();
	    Comments 등록된_한줄평 =new Comments();
	    
	    when(commentMapper.insertReservUserComment(등록할_한줄평)).thenReturn(1);
	    when(commentImageMapper.insertReservationImage(등록할_한줄평_이미지)).thenReturn(1);
	    when(commentMapper.selectCommentsByCommentId(1)).thenReturn(등록된_한줄평);
	    
	    assertThat(commentMapper.insertReservUserComment(등록할_한줄평),is(1));
	    assertThat(commentImageMapper.insertReservationImage(등록할_한줄평_이미지),is(1));
	    assertThat(commentMapper.selectCommentsByCommentId(1),is(등록된_한줄평));
	    
	    verify(commentMapper, atLeast(1)).insertReservUserComment(등록할_한줄평);
		verify(commentImageMapper, atLeast(1)).insertReservationImage(등록할_한줄평_이미지);
		verify(commentMapper, atLeast(1)).selectCommentsByCommentId(1);
	}

}
