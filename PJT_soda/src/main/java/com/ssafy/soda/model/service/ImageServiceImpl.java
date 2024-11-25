package com.ssafy.soda.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.soda.model.dao.ImageDao;
import com.ssafy.soda.model.dto.ImageEntity;
@Service
public class ImageServiceImpl implements ImageService {

	ImageDao imageDao;

	public ImageServiceImpl(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	@Override
	public void updateBoardNo(int boardNo, Long[] imageIds) {
		if (imageIds != null && imageIds.length > 0) {
			imageDao.updateBoardNo(boardNo, imageIds);
		}
	}

	@Override
	public boolean addImage(ImageEntity imageEntity) {
		if (imageDao.insertImage(imageEntity) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
