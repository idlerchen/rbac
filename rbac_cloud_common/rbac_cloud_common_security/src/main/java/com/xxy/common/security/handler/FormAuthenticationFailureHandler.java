package com.xxy.common.security.handler;

import cn.hutool.http.HttpUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

@Slf4j
public class FormAuthenticationFailureHandler implements AuthenticationFailureHandler {
	/**
	 * Called when an authentication attempt fails.
	 *
	 * @param request   the request during which the authentication attempt occurred.
	 * @param response  the response.
	 * @param exception the exception which was thrown to reject the authentication
	 */
	@Override
	@SneakyThrows
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
		log.debug("表单登录失败:{}", exception.getLocalizedMessage());
		response.sendRedirect(String.format("/token/login?error=%s"
				, HttpUtil.encodeParams(exception.getMessage(), Charset.defaultCharset())));
	}
}
