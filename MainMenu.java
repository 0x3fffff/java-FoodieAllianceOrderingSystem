import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatIntelliJLaf;
import item.OrderForm;
import org.jdesktop.swingx.*;
import store.store;
import ui.InputWindow;
import ui.OrderFormWindow;
import ui.OrderingMeal;
import ui.warnWindow;
/*
 * Created by JFormDesigner on Mon Sep 04 10:43:37 CST 2023
 */



/**
 * @author 0x3fffff
 * @URL https://blog.csdn.net/qq_19655605?type=blog
 */
public class MainMenu extends JFrame {
    public MainMenu() {
        initComponents();
        this.setResizable(false);
    }

    private void button1MouseClicked(MouseEvent e) {
        new OrderingMeal(1).setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) {
        //查看订单
        for (OrderForm od: store.orders){
            System.out.println(od);
        }
        new OrderFormWindow(1).setVisible(true);
    }

    private void button3MouseClicked(MouseEvent e) {
        //签收订单
//        for (int i = 0; i < store.orders.size(); i++) {
//            store.orders.get(i).setFlag(true);
//        }
        new OrderFormWindow(3).setVisible(true);
        //new warnWindow(this,"订单已全部签收!").setVisible(true);
    }

    private void button4MouseClicked(MouseEvent e) {
        //删除订单
        for (OrderForm od: store.orders){
            System.out.println(od);
        }
        new OrderFormWindow(2).setVisible(true);
        //new InputWindow(this,"删除订单","请输入要删除的订单号",4).setVisible(true);
    }

    private void button5MouseClicked(MouseEvent e) {
        //我要点赞
        new OrderingMeal(2).setVisible(true);
    }

    private void button6MouseClicked(MouseEvent e) {
        //退出系统
        new warnWindow(this,"谢谢使用，欢迎下次光临").setVisible(true);
        this.dispose();
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();

        //======== this ========
        setTitle("\u5403\u8d27\u8054\u76df\u8ba2\u9910\u7cfb\u7edf");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/res/Home.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new VerticalLayout());

        //---- button1 ----
        button1.setText("\u6211\u8981\u8ba2\u9910");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);

        //---- button2 ----
        button2.setText("\u67e5\u770b\u9910\u888b");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2);

        //---- button3 ----
        button3.setText("\u7b7e\u6536\u8ba2\u5355");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3);

        //---- button4 ----
        button4.setText("\u5220\u9664\u8ba2\u5355");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });
        contentPane.add(button4);

        //---- button5 ----
        button5.setText("\u6211\u8981\u70b9\u8d5e");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked(e);
            }
        });
        contentPane.add(button5);

        //---- button6 ----
        button6.setText("\u9000\u51fa\u7cfb\u7edf");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button6MouseClicked(e);
            }
        });
        contentPane.add(button6);
        setSize(245, 210);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
