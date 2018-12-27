package com.walker.consumer.controller;

import com.walker.consumer.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author walker
 * @date 2018/12/27
 */
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        return uploadService.upload(file);
    }
}
