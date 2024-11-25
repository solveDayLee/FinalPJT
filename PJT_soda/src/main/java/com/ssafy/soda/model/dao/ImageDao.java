package com.ssafy.soda.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.soda.model.dto.ImageEntity;

public interface ImageDao {
    ImageEntity selectImageById(Long id);
    List<ImageEntity> selectAllImages();
    void deleteImageById(Long id);
    
	int insertImage(ImageEntity imageEntity);
	
//	void updateBoardNo(int boardNo, Long[] imageIds);
	void updateBoardNo(@Param("boardNo") int boardNo, @Param("imageIds") Long[] imageIds);
}
