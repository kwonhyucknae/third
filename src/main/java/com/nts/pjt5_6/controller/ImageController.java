package com.nts.pjt5_6.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt5_6.dto.DisplayInfoImages;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;
import com.nts.pjt5_6.service.DisplayInfoService;
import com.nts.pjt5_6.service.ImageService;

@RestController
public class ImageController {
	private static final int FIRST_IMG = 0;
	private static final String FILE_LOCATION = "C:\\tmp\\";
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private DisplayInfoService displayInfoService;
	
	
	/**
	 * @description productId 값에 해당하는 이미지를 출력시킵니다. 
	 * type 값에 따라 해당 product의 이미지가 출력됩니다.
	 * @return productId , type 에 해당하는 이미지
	 * @throws IOException productId에 해당되는 type 값이 없는 경우 예외 발생
	 */
	@GetMapping(value = "/productImages/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getProductImageByIdAndType(@PathVariable(name = "id") int productId,
			@RequestParam(name = "type", required = false, defaultValue = "ma") String type, HttpServletRequest request)
			throws IOException {
		
		List<ProductImages> productImageInfo = imageService.getProductImagesInfoByIdAndType(productId, type);
		String imgFileName = productImageInfo.get(FIRST_IMG).getSaveFileName();
		InputStream inputStream = new FileInputStream(request.getServletContext().getRealPath(imgFileName));
		
		return IOUtils.toByteArray(inputStream);
	}
	
	/**
	 * @description productId 와 productImageId 가 주어졌을때 해당 이미지를 출력시킵니다.
	 * @return productId 와 productImageId 에 해당하는 이미지 출력
	 * @throws IOException productId에 해당되는 productImageId가 없을 경우 예외 발생
	 */
	@GetMapping(value = "/productImages/{productId}/{productImageId}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getProductImageById(@PathVariable(name = "productId") int productId,
			@PathVariable(name = "productImageId") int productImageId , HttpServletRequest request) throws IOException{
		ProductImages productImageInfo = imageService.getProductImagesInfoByProductImageId(productImageId);
		String imgFileName = productImageInfo.getSaveFileName();
		InputStream inputStream = new FileInputStream(request.getServletContext().getRealPath(imgFileName));
		
		return IOUtils.toByteArray(inputStream); 
	}
	
	/**
	 * @description 지도 이미지를 출력시키는 메소드입니다.
	 * @return  해당되는 displayId 가 주어지면 해당 지도 이미지를 출력합니다.
	 * @throws IOException displayId에 저장되어있는 save_file_name 값이 경로에 없다면 예외 발생
	 */
	@GetMapping(value = "/displayImages/{displayId}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getMapImage(@PathVariable(name = "displayId") int dpInfoId,
			HttpServletRequest request) throws IOException{
		List<DisplayInfoImages> displayImagesInfo = displayInfoService.getDisplayImagesInfo(dpInfoId);
		String imgFileName = displayImagesInfo.get(FIRST_IMG).getSaveFileName();
		InputStream inputStream = new FileInputStream(request.getServletContext().getRealPath(imgFileName));
		
		return IOUtils.toByteArray(inputStream); 
	}
	
	/**
	 * @description commentId 가 주어지면 해당되는 comment의 이미지를 출력합니다. 
	 * @return comment 에 저장 되어있는 이미지를 출력합니다.
	 * @throws IOException 해당 이미지가 없다면 예외 발생
	 */
	@GetMapping(value = "/commentImage/{commentId}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getCommentImage(@PathVariable(name = "commentId") int commentId,
			HttpServletRequest request) throws IOException{
		List<ReservationUserCommentImages> displayImagesInfo = displayInfoService.getCommentImagesByCommentID(commentId);
		System.out.println("commentId===" + commentId);
		System.out.println(displayImagesInfo);
		String imgFileName = displayImagesInfo.get(FIRST_IMG).getSaveFileName();
		InputStream inputStream = new FileInputStream(FILE_LOCATION + imgFileName);
//		InputStream inputStream = new FileInputStream(request.getServletContext().getRealPath(imgFileName));
		
		return IOUtils.toByteArray(inputStream); 
	}
	
}
