package com.wyq.hf.web.action.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.util.List;
import java.util.Map;

/**
 * ���ܣ����?����.
 * <p>Title: ���?����</p>
 * <p>Description: ���?����</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: yinbo</p>
 * @author ljyan
 * @version 1.0.0
 * date��Apr 12, 2010
 */
public class ReportUtil {
	
	private static final Log log = LogFactory.getLog(ReportUtil.class);
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param beanList
	 * @param paramMap
	 */
	@SuppressWarnings("unchecked")
	public static void exportApplet(HttpServletRequest request, HttpServletResponse response, List beanList, Map paramMap, String templateFile){
		
		JRDataSource ds = new JRBeanCollectionDataSource(beanList);
		ServletContext servletContext = request.getSession()
				.getServletContext();
		JasperReport jasperReport;

		try {
			//�����ڵ�ǰ���ڴ�
			jasperReport = JasperCompileManager.compileReport(servletContext
					.getRealPath(templateFile)); // ʹ��.jrxml����ʽ
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, paramMap, ds);

			OutputStream outputStream = response.getOutputStream();

			response.setContentType("application/octet-stream");
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			oos.writeObject(jasperPrint);
			oos.flush();
			oos.close();

			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			log.warn("�����IO�쳣��");
		} catch (JRException e) {
			log.warn("�����JRE�쳣��");
		}
	}
}
