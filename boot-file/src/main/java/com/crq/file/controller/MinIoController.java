package com.crq.file.controller;

import com.crq.file.util.MinIoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-14 20:17
 **/
@RestController
public class MinIoController {
    @Resource
    private MinIoTemplate minIoTemplate;

    @PostMapping("/create/bucket")
    String create(String bucketName) throws Exception {
        minIoTemplate.makeBucket(bucketName);
        return "创建成功";
    }

    @PostMapping("/put")
    String putObject(MultipartFile uploadFile, @RequestParam String bucketName) {
        String originalFilename = uploadFile.getOriginalFilename();
        try {
            minIoTemplate.putObject(bucketName, originalFilename, uploadFile.getInputStream());
        } catch (Exception e) {
            System.out.println(e);
            return "创建失败";
        }
        return "http://139.196.153.80:9000/" + bucketName + "/" + originalFilename;
    }
}

