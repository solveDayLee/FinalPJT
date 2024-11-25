package com.ssafy.soda.model.service;

import com.ssafy.soda.model.dto.ImageEntity;

public interface ImageService {

	void updateBoardNo(int boardNo, Long[] imageIds);

	boolean addImage(ImageEntity imageEntity);

}
