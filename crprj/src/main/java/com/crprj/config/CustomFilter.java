package com.crprj.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO 自動生成されたメソッド・スタブ

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpReq = ((HttpServletRequest)request);
    String uri = httpReq.getRequestURI();
    if (isStatic(uri)) {
        chain.doFilter(request, response);
        return;
    }

    long start = System.currentTimeMillis();
    UUID uuid = UUID.randomUUID();
    String userName = httpReq.getRemoteUser();
    String requestIdentifier = "[" + userName + "]" + "[" + uuid + "]";

    log.info(String.format("%s start URI: %s", requestIdentifier, uri));

    Map<String, String[]> params = httpReq.getParameterMap();
    for (Entry<String, String[]> param : params.entrySet()) {
        log.info(String.format("%s PARAM_KEY: %s, PARAM_VALUE: %s"
                , requestIdentifier
                , param.getKey()
                , Arrays.toString(param.getValue())));
    }

    chain.doFilter(request, response);

    int status = ((HttpServletResponse)response).getStatus();

    log.info(String.format("%s end URI: %s in %d millisec. STATUS %d", requestIdentifier, uri, System.currentTimeMillis() - start, status));
}

private boolean isStatic(String uri) {
    return uri.contains("/js/")
    || uri.contains("/css/")
    || uri.contains("/fonts/");
}
  @Override
  public void destroy() {
    // TODO 自動生成されたメソッド・スタブ

  }

}
