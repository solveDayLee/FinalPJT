package com.ssafy.soda.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.soda.model.dto.ImageEntity;
import com.ssafy.soda.model.service.ImageService;

@RestController
@RequestMapping("/img")
public class ImageController {
	
	private ImageService imageService;
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
    
    // 이미지가 저장될 경로 설정
    private final String uploadDir = "src/main/resources/static/uploads/";

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            // 1. 파일 이름 생성 (중복 방지를 위해 UUID 사용)
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            
            // 2. 저장 경로 생성
            Path uploadPath = Paths.get(uploadDir);
            
            // 3. 디렉토리가 없으면 생성
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            
            // 4. 파일 저장
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
            ImageEntity imageEntity = new ImageEntity(); // 객체 생성
            
            imageEntity.setFilePath((filePath).toString());
            imageEntity.setOriginalFileName(file.getOriginalFilename());
            imageEntity.setFileSize(file.getSize());
            imageEntity.setBoardNo(null);
//            imageEntity.setIsTemp(true);
//            imageEntity.setUserId(userId);
            
            imageService.addImage(imageEntity);
            
            
            // 5. 클라이언트에서 접근 가능한 URL 생성
//            String fileUrl = "/uploads/" + fileName;
            String fileUrl = "http://192.168.210.73:8080/uploads/" + fileName;
            
            // 6. URL을 JSON 형태로 반환
            Map<String, String> response = new HashMap<>();
            response.put("url", fileUrl);
            response.put("imageId", String.valueOf(imageEntity.getId()));
            
            return ResponseEntity.ok(response);
            
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}