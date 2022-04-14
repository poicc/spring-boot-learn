package com.crq.file.util;

import io.minio.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.InputStream;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-14 20:12
 **/
@Component
@Configuration
public class MinIoTemplate {

    @Resource
    private FileResource fileResource;

//    @Value("${minio.endPoint}")
//    private String endPoint;
//
//    @Value("${minio.accessKey}")
//    private String accessKey;
//
//    @Value("${minio.secretKey}")
//    private String secretKey;

    private MinioClient instance;

    @PostConstruct
    public void init() {
        instance = MinioClient.builder()
                .endpoint(fileResource.getEndPoint())
                .credentials(fileResource.getAccessKey(), fileResource.getSecretKey())
                .build();
    }

    /**
     * 判断 bucket是否存在
     */
    public boolean bucketExists(String bucketName) throws Exception {
        return instance.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 创建 bucket
     */
    public void makeBucket(String bucketName) throws Exception {
        boolean isExist = this.bucketExists(bucketName);
        if (!isExist) {
            instance.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build());

            StringBuilder builder = new StringBuilder();
            builder.append("{\n");
            builder.append("    \"Statement\": [\n");
            builder.append("        {\n");
            builder.append("            \"Action\": [\n");
            builder.append("                \"s3:GetBucketLocation\",\n");
            builder.append("                \"s3:ListBucket\"\n");
            builder.append("            ],\n");
            builder.append("            \"Effect\": \"Allow\",\n");
            builder.append("            \"Principal\": \"*\",\n");
            builder.append("            \"Resource\": \"arn:aws:s3:::my-bucketname\"\n");
            builder.append("        },\n");
            builder.append("        {\n");
            builder.append("            \"Action\": \"s3:GetObject\",\n");
            builder.append("            \"Effect\": \"Allow\",\n");
            builder.append("            \"Principal\": \"*\",\n");
            builder.append("            \"Resource\": \"arn:aws:s3:::my-bucketname/myobject*\"\n");
            builder.append("        }\n");
            builder.append("    ],\n");
            builder.append("    \"Version\": \"2012-10-17\"\n");
            builder.append("}\n");
            instance.setBucketPolicy(
                    SetBucketPolicyArgs.builder().bucket("my-bucketname").config(builder.toString()).build());

        }
    }

    /**
     * 文件上传
     *
     * @param bucketName bucket名称
     * @param objectName 对象名称，文件名称
     * @param filepath   文件路径
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, String filepath) throws Exception {
        return instance.uploadObject(
                UploadObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .filename(filepath).build());
    }

    /**
     * 文件上传
     *
     * @param bucketName  bucket名称
     * @param objectName  对象名称，文件名称
     * @param inputStream 文件输入流
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) throws Exception {
        return instance.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName).stream(inputStream, -1, 10485760)
                        .build());
    }

    /**
     * 删除文件
     *
     * @param bucketName bucket名称
     * @param objectName 对象名称
     */
    public void removeObject(String bucketName, String objectName) throws Exception {
        instance.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build());
    }
}
