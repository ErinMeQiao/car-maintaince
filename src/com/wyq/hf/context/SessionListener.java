package com.wyq.hf.context;

import java.util.HashMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ���ܣ���¼����.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: yinbo</p>
 * @author ljyan
 * @version 1.0.0
 * date��Apr 19, 2010
 */
public class SessionListener extends HttpServlet implements HttpSessionListener {

	private static final long serialVersionUID = 7022373051622997694L;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	// �´���Session
	@SuppressWarnings("unchecked")
	public void sessionCreated(HttpSessionEvent se) {
		try {
			// ��ȡȫ�ֻỰ�б�
			HashMap loginSession = (HashMap) se.getSession().getServletContext()
					.getAttribute("loginSession");
			if (loginSession == null) {
				loginSession = new HashMap();
				se.getSession().getServletContext().setAttribute("loginSession",
						loginSession);
			}
			se.getSession().setMaxInactiveInterval(30*60);
			logger.debug("�´��� sessionid = " + se.getSession().getId());
			// ��session�����÷ŵ�һ��ȫ�־�̬����
			loginSession.put(se.getSession().getId(), se.getSession());
		} catch (RuntimeException e) {
			logger.error("�´��� Session �쳣��"+e.getMessage());
		}
	}

	// �ͷ�Session
	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent se) {
		try {
			HashMap loginSession = (HashMap) se.getSession().getServletContext()
					.getAttribute("loginSession");
			if (loginSession != null && loginSession.containsKey(se.getSession().getId())){
				logger.debug("�ͷ� Session = " + se.getSession().getId());
				// ���û��ĻỰ���ڲ�ȫ�ֻỰ�б���ɾ���
				loginSession.remove(se.getSession().getId());
			}
		} catch (RuntimeException e) {
			logger.error("�ͷ� Session �쳣��"+e.getMessage());
		}
	}
}
