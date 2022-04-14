package com.crq.file.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-14 15:24
 **/
@RestController
public class FileUploadController {
    /**
     * 绑定文件上传路径到uploadPath
     */
    @Value("${file.upload-path}")
    private String uploadPath;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        //通过日期对上传的文件归类保存
        String format = sdf.format(new Date());
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        //对上传的文件重命名 避免文件重名
        String oldName = uploadFile.getOriginalFilename();
        assert oldName != null;
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        //保存文件
        uploadFile.transferTo(new File(folder, newName));

        //返回文件上传的访问路径
        //http://localhost:8080/2022/04/14/3cc1e41d-b3cd-4b20-bd6b-162a103ea40d.jpg
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + format + newName;

    }
}
