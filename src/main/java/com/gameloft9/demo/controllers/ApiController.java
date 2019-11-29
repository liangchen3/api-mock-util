package com.gameloft9.demo.controllers;

import com.gameloft9.demo.beans.ApiBean;
import com.gameloft9.demo.mgrframework.annotation.AdviceAnnotation;
import com.gameloft9.demo.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 动态api处理controller，
 * <p>
 * Created by gameloft9 on 2018/8/9.   支持10个api注册，可手动添加
 * update by  liangchen on 2019/11/29  实现可以生成不限个数的接口，不再仅限于10个
 */
@Controller
@Slf4j
public class ApiController {

    @ResponseBody
    @AdviceAnnotation
    public String commonApiMethod(String requestUrl) {
        ApiBean apiBean = Constants.requestMappings.get(requestUrl);
        return getReturnMsg(apiBean.getMsg());
    }

    /**
     * 拿到注册的返回报文
     */
    private String getReturnMsg(String msg) {
        if (StringUtils.isBlank(msg)) {
            return "success";
        }

        return msg;
    }
}
