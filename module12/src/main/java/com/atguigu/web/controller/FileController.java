package com.atguigu.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@RestController
public class FileController {
    @PostMapping("/a/load")
    public String upload(@RequestPart("headPicture") MultipartFile headPicture) throws IOException {
        if (headPicture.isEmpty()){
            return "fail";
        }
        String inputName = headPicture.getName();
        System.out.println("上传文件请求参数名称：" + inputName);

        String originalFilename = headPicture.getOriginalFilename();
        System.out.println("原始文件名：" + originalFilename);

        long size = headPicture.getSize();
        System.out.println("文件大小：" + size);

        byte[] bytes = headPicture.getBytes();
        System.out.println("文件内容字节数组：" + Arrays.toString(bytes));

        InputStream inputStream = headPicture.getInputStream();
        System.out.println("把文件从缓冲区读取到内存的输入流：" + inputStream);

        String contentType = headPicture.getContentType();
        System.out.println("文件的内容类型：" + contentType);
        return "ok";
    }
    @GetMapping("/download/picture")
    public ResponseEntity<byte[]> downloadPicture() throws IOException {
        // 1、把要下载的目标文件，读取到内存中
        String fileName = "god2.png";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

        byte[] bytes = inputStream.readAllBytes();

        // 2、创建响应消息头
        HttpHeaders httpHeaders = new HttpHeaders();

        // [1]Content-Disposition：设置为attachment; filename=xxx强制浏览器下载文件
        httpHeaders.setContentDispositionFormData("attachment", fileName);

        // [2]Content-Type：设为application/octet-stream表示二进制流
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // [3]Content-Length：设置文件大小，可优化下载进度显示
        httpHeaders.setContentLength(bytes.length);

        // 3、创建 ResponseEntity 对象并返回
        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
    }
}
