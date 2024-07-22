package com.candy.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类 plus
 */

@Slf4j
@Component
public class AliOSSUtils {
//    private String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
//    private String bucketName = "tlias-springboot1";
    @Autowired
    private AliOSSProperties aliOSSProperties;

    /**
     * 实现上传图片到OSS
     */
    public String upload(MultipartFile file) throws Exception {
        //获取阿里云oss参数
        String endpoint = aliOSSProperties.getEndpoint();
        String bucketName = aliOSSProperties.getBucketName();
        log.info("阿里云oss参数:{} == {}",endpoint,bucketName);
        // 通过环境变量获取id和secret
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖,使用UUID创建唯一识别码
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //存放在oos的fitness文件中
        fileName = "fitness/" + fileName;


        //上传文件到 OSS
            // 1 创建OSSClient实例,连接阿里云,输入id和secret。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
            // 2 指明空间buket名,文件名,文件数据
        ossClient.putObject(bucketName, fileName, inputStream);

        //文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }

}
