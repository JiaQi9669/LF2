package com.guo.utils;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
/**
 * 添加背景图片
 * @author guo
 *
 */
public class Addimage extends JPanel{
//	图片背景加载类
    Image im;
    public Addimage(Image im){
    	this.im=im;
    	this.setOpaque(true);
    }
    public void paintComponent(Graphics g){
    	super.paintComponents(g);
    	g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
