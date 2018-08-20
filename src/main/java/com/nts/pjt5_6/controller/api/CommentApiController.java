package com.nts.pjt5_6.controller.api;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.service.CommentService;

@RestController
@RequestMapping(path = "/api/reservationUserComments")
public class CommentApiController {
	
	private String saveFileName;
	
	@Autowired
	private CommentService commentService;
 	@PostMapping
	public Comments addReservationInfo(@RequestBody Comments userComment) {
 		System.out.println("들어온 데이터"+userComment);
		userComment.getUserCommentImages().get(0).setSaveFileName(saveFileName);
		
		commentService.insertReservComment(userComment);
		Comments tt = new Comments();
		return tt;
	}
 	@PostMapping("/image")
	public void imageUpload(@RequestParam("file") MultipartFile file) {
 		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 크기 : " + file.getSize());
 		try (FileOutputStream fos = new FileOutputStream("c:/tmp/" + file.getOriginalFilename());
			 InputStream is = file.getInputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}
		
		saveFileName = file.getOriginalFilename();
		System.out.println("saveFileName=="+saveFileName);
		System.out.println(file);
	}
}
