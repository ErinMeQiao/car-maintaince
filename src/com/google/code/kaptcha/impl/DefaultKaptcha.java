package com.google.code.kaptcha.impl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import com.google.code.kaptcha.BackgroundProducer;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.text.WordRenderer;
import com.google.code.kaptcha.util.Configurable;


/**
 * 功能：去掉图片验证码上的干扰.
 * <p>Title: 去掉图片验证码上的干扰</p>
 * <p>Description: 去掉图片验证码上的干扰</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: yinbo</p>
 * @author ljyan
 * @version 1.0.0
 * date：Mar 11, 2010
 */
public class DefaultKaptcha extends Configurable implements Producer {
	private int width = 200;

	private int height = 50;

	public BufferedImage createImage(String text) {
		WordRenderer wordRenderer = getConfig().getWordRendererImpl();

		//GimpyEngine gimpyEngine = getConfig().getObscurificatorImpl();

		BackgroundProducer backgroundProducer = getConfig().getBackgroundImpl();
		boolean isBorderDrawn = getConfig().isBorderDrawn();
		this.width = getConfig().getWidth();
		this.height = getConfig().getHeight();

		BufferedImage bi = wordRenderer.renderWord(text, width, height);

		//去掉图像上的干扰
		//bi = gimpyEngine.getDistortedImage(bi);

		bi = backgroundProducer.addBackground(bi);
		Graphics2D graphics = bi.createGraphics();
		if (isBorderDrawn) {
			drawBox(graphics);
		}
		return bi;
	}

	private void drawBox(Graphics2D graphics) {
		Color borderColor = getConfig().getBorderColor();
		int borderThickness = getConfig().getBorderThickness();

		graphics.setColor(borderColor);

		if (borderThickness != 1) {
			BasicStroke stroke = new BasicStroke(borderThickness);
			graphics.setStroke(stroke);
		}

		Line2D line1 = new Line2D.Double(0, 0, 0, width);
		graphics.draw(line1);
		Line2D line2 = new Line2D.Double(0, 0, width, 0);
		graphics.draw(line2);
		line2 = new Line2D.Double(0, height - 1, width, height - 1);
		graphics.draw(line2);
		line2 = new Line2D.Double(width - 1, height - 1, width - 1, 0);
		graphics.draw(line2);
	}

	/**
	 * @return the text to be drawn
	 */
	public String createText() {
		return getConfig().getTextProducerImpl().getText();
	}
}
