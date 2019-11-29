package com.gameloft9.demo.mgrframework.aop;

import com.gameloft9.demo.mgrframework.beans.response.IResult;
import com.gameloft9.demo.mgrframework.utils.CheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ApiControllerAOP
 * @Description 从请求中获取url, 再将url作为参数传到ApiController执行方法中
 * @Author 梁臣
 * @Date 2019/11/29 14:21
 * @Version 1.0
 **/
@Slf4j
@Aspect
@Component
public class ApiControllerAOP {
    @Pointcut("@annotation(com.gameloft9.demo.mgrframework.annotation.AdviceAnnotation)")
    public void resultPtCut() {
    }

    /**
     * 环绕通知处理
     */
    @Around("resultPtCut()")
    public Object handlerControllerMethods(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url={}", request.getRequestURI());
        log.info("method={}", request.getMethod());
        Object[] params = new Object[]{request.getRequestURI() + request.getMethod().toLowerCase()};
        return pjp.proceed(params);
    }


}
