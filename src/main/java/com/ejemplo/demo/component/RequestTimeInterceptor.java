package com.ejemplo.demo.component;

import com.ejemplo.demo.repository.LogRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    private static final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        String url = request.getRequestURL().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if(auth != null && auth.isAuthenticated()){
            username = auth.getName();
            logRepository.save(new com.ejemplo.demo.entity.Log(LocalDate.now(), auth.getDetails().toString(), username, url));
        }
        LOGGER.info("Url to: '" + url + "' in: '" + (System.currentTimeMillis() - startTime) + "ms'");
    }


}