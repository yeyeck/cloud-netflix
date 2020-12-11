package org.yeyeck.eurekaservicezuul.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class MyFilter extends ZuulFilter {

  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    String token = request.getParameter("token");
    if (StringUtils.isBlank(token)) {
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      try {
        ctx.getResponse().getWriter().write("token is empty");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public String filterType() {
    return "pre";
  }
  
}
