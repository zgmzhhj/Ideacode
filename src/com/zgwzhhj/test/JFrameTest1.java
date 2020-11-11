package com.zgwzhhj.test;

import javax.swing.*;
import java.awt.*;

public class JFrameTest1 {
    public static void main(String[] args) {
        new Flow();
    }

    private static class Flow extends JFrame {
        Flow() {
            Container container = this.getContentPane();
            JButton jButton1 = new JButton("b1");
            JButton jButton2 = new JButton("b2");
            JButton jButton3 = new JButton("b3");
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            flowLayout.setHgap(2);
            flowLayout.setVgap(5);
            container.setLayout(flowLayout);
            container.add(jButton1);
            container.add(jButton2);
            container.add(jButton3);
            jButton2.setSize(40, 40);
            jButton3.setPreferredSize(new Dimension(60, 60));
            validate();
            setBounds(100, 100, 200, 200);
            setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

    }
}
