package qr.program.mircoservice.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author qr
 * @Date 2022/5/6-16:01
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Value("${uploadPath}")
    private String path;

    @PostMapping("/file")
    public String uploadFile(
            @RequestParam("img")MultipartFile file,
            @RequestParam("name") String name
    ) {
        // 上传文件时可以借助 isEmpty() 或 getSize() 等进行安全校验
        // 对于 size 的限制可以在 MultipartConfigFactory 设置文件上传大小的限制
        if (file.isEmpty()) {
            return "文件为空";
        }
        String filename = file.getOriginalFilename();
        assert filename != null;
        log.info("用户: {} 正在上传文件: {}", name, filename);
        String[] strings = filename.split("\\.");
        String newFileName = UUID.randomUUID().toString();
        if (strings.length == 2) {
            newFileName = newFileName + "." + strings[1];
        }
        File newFile = new File(path + newFileName);
        try {
            file.transferTo(newFile);
            return newFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传文件失败";
    }
}
