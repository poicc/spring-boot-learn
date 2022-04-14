package com.crq.file.controller;

import com.crq.boot.fastdfs.FastDFSClientUtil;
import com.crq.file.util.AjaxResponse;
import com.crq.file.util.CustomException;
import com.crq.file.util.CustomExceptionType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-14 21:29
 **/
@RestController
@RequestMapping(value = "fastdfs")
public class FastDfsController {
    @Resource
    private FastDFSClientUtil fastDFSClientUtil;

    @PostMapping("/upload")
    public AjaxResponse upload(@RequestParam("file") MultipartFile file) {
        String fileId;
        try {
            String originalFileName = file.getOriginalFilename();
            assert originalFileName != null;
            fileId = fastDFSClientUtil.uploadFile(file.getBytes(),originalFileName.substring(originalFileName.lastIndexOf(".")));
            return AjaxResponse.success(fastDFSClientUtil.getSourceUrl(fileId));
        } catch (Exception e) {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"文件上传图片服务器失败");
        }
    }

}
