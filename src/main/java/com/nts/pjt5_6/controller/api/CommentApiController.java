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
	
	private static final int FIRST_IMG = 0;
	private String saveFileName;
	
	@Autowired
	private CommentService commentService;
 	@PostMapping
	public Comments addReservationInfo(@RequestBody Comments userComment) {
 		
 		if(userComment.getUserCommentImages() != null) {
 			userComment.getUserCommentImages().get(FIRST_IMG).setSaveFileName(saveFileName);
 		}
		
		commentService.insertReservComment(userComment);
		Comments tt = new Comments();
		return tt;
	}
 	
 	@PostMapping("/image")
	public void imageUpload(@RequestParam("file") MultipartFile file) {
		saveFileName = "img/" + file.getOriginalFilename();

		try (FileOutputStream fos = new FileOutputStream("c:/tmp/" + saveFileName);
			 InputStream is = file.getInputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}
		
	}
}
