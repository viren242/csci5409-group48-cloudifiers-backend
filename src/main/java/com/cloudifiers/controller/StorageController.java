package com.cloudifiers.controller;

import java.io.File;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudifiers.constants.CloudifiersConstants;
import com.cloudifiers.constants.CloudifiersConstants.ApiEndPoints;
import com.cloudifiers.constants.CloudifiersConstants.ControllerInfo;
import com.cloudifiers.service.IStorageService;
import com.cloudifiers.util.Converter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = ControllerInfo.STORAGE_CONTROLLER_VALUE, description = ControllerInfo.STORAGE_CONTROLLER_DESC)
@RestController
@RequestMapping(CloudifiersConstants.BASE_API_URL)
public class StorageController {

	@Autowired
	private IStorageService storageService;

	@ApiOperation(value = ApiEndPoints.UPLOAD_FILE_DESC, response = String.class)
	@PostMapping(ApiEndPoints.UPLOAD_FILE_URL)
	public URL uploadFile(@RequestPart(value = "file") MultipartFile multipartFile) {
		File file = Converter.converMultipartFileToFile(multipartFile);
		String fileName = Converter.generateUniqueName(file.getName());
		storageService.uploadFile(fileName, file);
		file.delete();
		return storageService.getFileUrl(fileName);
	}
	
	@ApiOperation(value = ApiEndPoints.REMOVE_FILE_DESC, response = String.class)
	@DeleteMapping(ApiEndPoints.REMOVE_FILE_URL)
	public void removeFile(@PathVariable("fileName") String fileName) {
		storageService.deleteFile(fileName);
	}
}
