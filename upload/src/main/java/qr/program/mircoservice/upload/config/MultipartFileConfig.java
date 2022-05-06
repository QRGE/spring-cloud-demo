package qr.program.mircoservice.upload.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @Author qr
 * @Date 2022/5/6-18:22
 */
@Configuration
public class MultipartFileConfig {

    /**
     * 设置 multipartFile 的上传文件限制
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件的大小限制
        factory.setMaxFileSize(DataSize.parse("10240KB"));
        // 总文件的大小限制
        factory.setMaxRequestSize(DataSize.parse("102400KB"));
        return factory.createMultipartConfig();
    }
}
