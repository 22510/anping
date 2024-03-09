package com.ins.anping.config;


import com.ins.anping.utils.JwtToken;
import com.ins.anping.utils.RefreshTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author QingheLi
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtToken jwtToken;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // addPathPatterns 拦截所有, 用于已登录者更新token时间
        registry.addInterceptor(new RefreshTokenInterceptor(jwtToken))
                .addPathPatterns("/api/busi/**")
                .excludePathPatterns(
                        "/api/loginModule/**"
                ).order(0);
    }
}
