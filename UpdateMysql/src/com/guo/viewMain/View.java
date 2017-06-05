package com.guo.viewMain;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.guo.utils.Addimage;
/**
 * 同步数据
 * @author guo
 *
 */
public class View extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	//	界面字体
	Font font1 = new Font("宋体",Font.BOLD,15);
	//	获得屏幕宽度
	public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	//	获得屏幕高度
	public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	public View(){
		this.setLayout(null);
		this.setSize(500,400);
		//		设置登陆界面位置
		this.setLocation((width-500)/2, (height-500)/2);
		//		设置可以关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		设置可见性
		this.setVisible(true);
		//		设置不可变大小
		this.setResizable(false);
		this.setTitle("图书馆人流量统计系统");
//		获得背景图片
		Addimage addImage=new Addimage((new ImageIcon("login.jpg")).getImage());
		addImage.setBounds(0,0,500,400);//背景大小
//		添加数据
		this.add(addImage);
		//		刷新
		this.repaint();
	}

	//		对抽取图书馆数据库进行监听
	@Override
	public void actionPerformed(final ActionEvent e) {

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				
//				if(e.getSource()==button1){
//					
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException ex) {
//						ex.printStackTrace();
//					}
//					//					启动线程
//					Thread au=new AutoUpdate();
//					//					au.run();
//					au.start();
//				}
//			}
//		}).start();
	}

	public static void main(String[] args) {
		View mv=new View();
	}
}
