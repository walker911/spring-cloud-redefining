package com.walker.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.walker.common.exception.BaseException;
import com.walker.common.exception.BaseExceptionBody;
import com.walker.common.exception.CommonError;
import com.walker.common.util.HttpConvertUtil;
import com.walker.common.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 鉴权 filter
 *
 * @author walker
 * @date 2019/1/2
 */
@Slf4j
@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        authUser(context);
        return null;
    }

    private static void authUser(RequestContext context) {
        HttpServletRequest request = context.getRequest();
        Map<String, String> headers = HttpConvertUtil.httpRequestToMap(request);
        String userId = headers.get(User.CONTEXT_KEY_USERID);
        if (StringUtils.isEmpty(userId)) {
            try {
                BaseException baseException = new BaseException(1L, CommonError.AUTH_EMPTY_ERROR.getCode(),
                        CommonError.AUTH_EMPTY_ERROR.getCodeEn(), CommonError.AUTH_EMPTY_ERROR.getMessage());
                BaseExceptionBody exceptionBody = new BaseExceptionBody(baseException);
                context.setSendZuulResponse(false);
                context.setResponseStatusCode(401);
                context.addZuulResponseHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                context.setResponseBody(JSON.toJSONString(exceptionBody));
            } catch (Exception e) {
                log.error("print message error", e);
            }
        } else {
            headers.forEach(context::addZuulRequestHeader);
        }
    }
}
