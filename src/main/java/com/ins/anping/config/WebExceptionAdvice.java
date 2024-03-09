//package com.ins.anping.config;
//
//import com.ins.anping.model.common.ResponseResult;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
///**
// * @author QingheLi
// * 全局异常捕获
// */
//@Slf4j
//@RestControllerAdvice
//public class WebExceptionAdvice {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseResult<?> handleRuntimeException(RuntimeException e) {
//        log.error("catch exception:{}", e.getMessage());
//        return ResponseResult.errorResult(500, "服务器异常, 请联系开发人员");
//    }
//}
