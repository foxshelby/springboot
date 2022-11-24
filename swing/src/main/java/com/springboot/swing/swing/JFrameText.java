package com.springboot.swing.swing;

import javax.swing.*;
import java.awt.*;

public class JFrameText {
    public static void main(String[] args) {
        new MyJFrame().init();
    }
}

//窗口
class MyJFrame extends JFrame {
    public void init(){//一个好的编程习惯，定义一个初始化方法
        this.setBounds(100,100,400,300);
        this.setVisible(true);
//        this.setBackground(Color.black);//不添加容器无法设置颜色
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//默认实现窗口推出监听

        JLabel jLabel = new JLabel("欢迎使用JFrame！");
        this.add(jLabel);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);//设置标签居中

        //获得一个容器
        Container container = this.getContentPane();
        container.setBackground(Color.YELLOW);//设置容器颜色
    }
}
