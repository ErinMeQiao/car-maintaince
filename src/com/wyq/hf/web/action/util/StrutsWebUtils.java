/**
 * 
 */
package com.wyq.hf.web.action.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.wyq.hf.context.Constants;
import com.yinbo.service.DisplaytagPagerUtils;
import com.yinbo.utils.CharTools;
import com.yinbo.web.utils.Struts2Utils;

/**
 * ���ܣ�webͨ�ù�����.
 * <p>Title: webͨ�ù�����</p>
 * <p>Description: webͨ�ù�����</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: yinbo</p>
 * @author ljyan
 * @version 1.0.0
 * date��Apr 12, 2010
 */
public class StrutsWebUtils {

	/**
	 * ��ȡ������·��.
	 * 
	 * @param request
	 * @param path
	 * @return String
	 */
	public static String getAppAbsPath(HttpServletRequest request, String path) {
		assert (request != null);
		return (path == null) ? request.getContextPath() : (request
				.getContextPath() + path);
	}

	/**
	 * ��ɲ���ɹ���ʧ��ҳ��ķ��ص�ַ ���������request��ʽ��ȡ�������޷������ѯ���.
	 * @param questurl �����url��ַ
	 * @param objects ���浽��ѯ����Ĳ���
	 */
	public static void savePreUrl(String questurl, Object... objects) {
		HttpServletRequest request = Struts2Utils.getRequest();
		StringBuffer urlBuf = new StringBuffer(questurl);
		if (objects.length > 0) {
			urlBuf.append("?");
			String paramName = "";
			for (int i = 0; i < objects.length; i++) {
				if (objects[i] instanceof String) {
					paramName = objects[i].toString();
					if (i > 0) {
						urlBuf.append("&");
					}
					urlBuf.append(paramName).append("=")
							.append(
									StringUtils.isBlank(request
											.getParameter(paramName)) ? ""
											: CharTools.Utf8URLencode(request.getParameter(paramName)));
				}
			}
		}
		urlBuf.append(DisplaytagPagerUtils.getPageNoString(request));
		Struts2Utils.getSession().setAttribute(Constants.URL_KEY,
				urlBuf.toString());
	}
	
	/**
	 * ���˲�ѯ����еĵ����.
	 * @param request
	 * @param objects
	 * @return ���ڵ���ŷ��� true ���򣺷���false;
	 */
	public static boolean isInSingleMarks(HttpServletRequest request,
			Object... objects) {
		boolean flag = false;
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof String) {				
				String paramName = objects[i].toString();				
				if (StringUtils.isNotBlank(request.getParameter(paramName)) && ((request.getParameter(paramName)).contains("'") || (request.getParameter(paramName)).contains("%"))) {
					request.setAttribute(DisplaytagPagerUtils.RS_SIZE, 0);
					flag = true;
				}
				request.setAttribute(paramName, StringUtils.trim(request.getParameter(paramName)));
			}
		}
		return flag;
	}
}
