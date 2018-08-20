package com.nts.pjt5_6.dto;

public class ReservationUserCommentImages {
	private int id;
	private int reservationInfoId;
	private int reservationUserCommentId;
	private int fileId;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private int deleteFlag;
	private String createDate;
	private String modifyDate;

	public ReservationUserCommentImages() {
	}
	
	public ReservationUserCommentImages(int id,int reservationInfoId,int reservationUserCommentId,int fileId
			,String fileName,String saveFileName,String contentType,int deleteFlag,String createDate,String modifyDate) {
		this.id = id;
		this.reservationInfoId = reservationInfoId;
		this.reservationUserCommentId = reservationUserCommentId;
		this.fileId = fileId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
	public int getId() {
		return id;
	}
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}
	public int getFileId() {
		return fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getContentType() {
		return contentType;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public String getCreateDate() {
		return createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	
	@Override
	public String toString() {
		return "ReservationUserCommentImages [id=" + id + ", reservationInfoId=" + reservationInfoId
				+ ", reservationUserCommentId=" + reservationUserCommentId + ", fileId=" + fileId + ", fileName="
				+ fileName + ", saveFileName=" + saveFileName + ", contentType=" + contentType + ", deleteFlag="
				+ deleteFlag + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
	
	public static class Builder {
		private int id;
		private int reservationInfoId;
		private int reservationUserCommentId;
		private int fileId;
		private String fileName;
		private String saveFileName;
		private String contentType;
		private int deleteFlag;
		private String createDate;
		private String modifyDate;
 		
		
		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		public Builder setReservationInfoId(int reservationInfoId) {
			this.reservationInfoId = reservationInfoId;
			return this;
		}
		public Builder setReservationUserCommentId(int reservationUserCommentId) {
			this.reservationUserCommentId = reservationUserCommentId;
			return this;
		}
		public Builder setFileId(int fileId) {
			this.fileId = fileId;
			return this;
		}
		public Builder setFileName(String fileName) {
			this.fileName = fileName;
			return this;
		}
		public Builder setSaveFileName(String saveFileName) {
			this.saveFileName = saveFileName;
			return this;
		}
		public Builder setContentType(String contentType) {
			this.contentType = contentType;
			return this;
		}
		public Builder setDeleteFlag(int deleteFlag) {
			this.deleteFlag = deleteFlag;
			return this;
		}
		
		public Builder setCreateDate(String createDate) {
			this.createDate = createDate;
			return this;
		}
		public Builder setModifyDate(String modifyDate) {
			this.modifyDate = modifyDate;
			return this;
		}
		
		public ReservationUserCommentImages build() {
			return new ReservationUserCommentImages(id,reservationInfoId,reservationUserCommentId,fileId
					,fileName,saveFileName,contentType,deleteFlag,createDate,modifyDate);
		}
	}
	
}
