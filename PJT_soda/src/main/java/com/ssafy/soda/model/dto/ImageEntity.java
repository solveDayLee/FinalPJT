package com.ssafy.soda.model.dto;

public class ImageEntity {
	   private int id;                // 기본 키
	    private String filePath;        // 실제 파일 경로
	    private String originalFileName; // 원본 파일명
	    private Long fileSize;          // 파일 크기
	    private String createdAt; // 생성 시간
	    private Integer BoardNo;
	    
	    public ImageEntity() {
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getOriginalFileName() {
			return originalFileName;
		}

		public void setOriginalFileName(String originalFileName) {
			this.originalFileName = originalFileName;
		}

		public Long getFileSize() {
			return fileSize;
		}

		public void setFileSize(Long fileSize) {
			this.fileSize = fileSize;
		}

		public String getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}

		public Integer getBoardNo() {
			return BoardNo;
		}

		public void setBoardNo(Integer boardNo) {
			BoardNo = boardNo;
		}

		public ImageEntity(int id, String filePath, String originalFileName, Long fileSize, String createdAt,
				Integer boardNo) {
			super();
			this.id = id;
			this.filePath = filePath;
			this.originalFileName = originalFileName;
			this.fileSize = fileSize;
			this.createdAt = createdAt;
			BoardNo = boardNo;
		}

		@Override
		public String toString() {
			return "ImageEntity [id=" + id + ", filePath=" + filePath + ", originalFileName=" + originalFileName
					+ ", fileSize=" + fileSize + ", createdAt=" + createdAt + ", BoardNo=" + BoardNo + "]";
		}
	    

	    
	    
}
