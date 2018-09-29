package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @auther 李明浩
 * @date 9/29/2018 10:42 AM
 */
public interface IFileService {
    public String upload(MultipartFile file, String path);
}
