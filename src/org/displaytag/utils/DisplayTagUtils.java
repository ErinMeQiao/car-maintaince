/**
 * 
 */
package org.displaytag.utils;

import java.util.regex.Pattern;

/**
 * ���ܣ�displaytag������
 * <p>Title: displaytag������</p>
 * <p>Description: displaytag������</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: yinbo</p>
 * @author ljyan
 * @version 1.0.0
 * date��Apr 16, 2010
 */
public class DisplayTagUtils {
	
	/**
	 * ����HTML��ǩ
	 * @param inputString
	 * @return String
	 */
	public static String html2Text(String inputString) {
		String htmlStr = inputString; //��html��ǩ���ַ���    
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //����script��������ʽ{��<script[^>]*?>[\\s\\S]*?<\\/script> }    
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //����style��������ʽ{��<style[^>]*?>[\\s\\S]*?<\\/style> }    
			String regEx_html = "<[^>]+>"; //����HTML��ǩ��������ʽ    

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); //����script��ǩ    

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); //����style��ǩ    

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); //����html��ǩ

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;//�����ı��ַ���    
	}
}
