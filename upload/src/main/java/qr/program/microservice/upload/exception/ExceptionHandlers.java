package qr.program.microservice.upload.exception;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author qr
 * @Date 2022/5/6-21:37
 */
@RestControllerAdvice
public class ExceptionHandlers {

    /**
     * 请求方法不支持时的异常统一处理
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public String requestMethodsNotSupportedHandler(
            HttpRequestMethodNotSupportedException e,
            HttpServletRequest request
    ) {
        return "该改方法不支持: " + request.getMethod() + " 请求";
    }
}
