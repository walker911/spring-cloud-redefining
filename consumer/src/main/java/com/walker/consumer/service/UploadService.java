package com.walker.consumer.service;

import com.walker.consumer.config.FeignUploadConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author walker
 * @date 2018/12/27
 */
@FeignClient(value = "provider", configuration = FeignUploadConfig.class)
public interface UploadService {

    /**
     * upload
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile file);
}
