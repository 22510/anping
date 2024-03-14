package com.ins.anping.utils;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ins.anping.other.Dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.ins.anping.utils.someConstant.USER_TOKEN_EXPTIME;


/**
 * @author QingheLi
 */
@Slf4j
public class RefreshTokenInterceptor implements HandlerInterceptor {

    private final JwtToken jwtToken;

    public RefreshTokenInterceptor(JwtToken jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 处理跨域请求处理
        if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
//        Enumeration<String> headers = request.getHeaders("token");
//        log.warn(String.valueOf(headers));
        String token = request.getHeader("Authorization");
        if (StrUtil.isBlank(token)){
            log.warn("用户没有携带token");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(new ObjectMapper().writeValueAsString("No Token"));
            // 设置响应状态码为401
            return false;
        }

        Map<String, Object> map = jwtToken.DecodedJWT(token, new String[]{"username", "JueSe"});
        if (map == null) {
            log.warn("系统错误");
            throw new RuntimeException("系统错误");
//            return false;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(map.get("username").toString());
        userDTO.setJueSe(map.get("JueSe").toString());

        UserHolder.saveUser(userDTO);
        log.info("[Token] 刷新用户{}的token", userDTO.getUsername());
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", map.get("username").toString());
        userMap.put("JueSe", map.get("JueSe").toString());
        response.setHeader("Token", jwtToken.createToken(userMap, USER_TOKEN_EXPTIME));
        return true;
    }


//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
