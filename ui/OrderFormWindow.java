/*
 * Created by JFormDesigner on Sat Sep 09 16:49:12 CST 2023
 */

package ui;

import java.awt.event.*;
import item.Food;
import item.OrderForm;
import store.store;

import java.awt.*;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 0x3fffff
 * @URL https://blog.csdn.net/qq_19655605?type=blog
 */
public class OrderFormWindow extends JFrame {
    public OrderFormWindow() {
        in();
        initComponents();
    }
    public OrderFormWindow(int type) {//1.查看 2.删除 3.签收
        this.type=type;
        in();
        initComponents();
        if (type==1){
            button1.setVisible(false);
        }else if (type==2){
            button1.setText("删除订单");
            button1.setVisible(true);
        }else if (type==3) {
            button1.setText("签收订单");
            button1.setVisible(true);
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        if (type==2){
            int index = table1.getSelectedRow();
            System.out.println(index);
            if (store.orders.get(index).isFlag()){
                store.orders.remove(index);
                in();
                DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                table1.setModel(tableModel);
                new warnWindow(this,"订单"+store.orders.get(index).getId()+":  "+store.orders.get(index).getFoodName()+"x"+store.orders.get(index).getNum()+"  已删除！").setVisible(true);
            }else{
                new warnWindow(this,"请选择已完成的订单").setVisible(true);
            }
        }else if(type==3){
            int index = table1.getSelectedRow();
            store.orders.get(index).setFlag(true);
            in();
            DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
            table1.setModel(tableModel);
            new warnWindow(this,"订单"+store.orders.get(index).getId()+":  "+store.orders.get(index).getFoodName()+"x"+store.orders.get(index).getNum()+"  已签收！").setVisible(true);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable(FoodV,TitleV);
        button1 = new JButton();

        //======== this ========
        setTitle("\u9910\u888b");
        setIconImage(new ImageIcon(getClass().getResource("/res/Order.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);

        //---- button1 ----
        button1.setText("\u5220\u9664");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private Vector<Vector> FoodV = new Vector<>();
    private Vector<String> TitleV = new Vector<>();
    private String[] title = new String[]{"序号","名称","数量","用户名","地址","时间","金额","状态"};
    private int type;
    public void in(){
        FoodV.clear();
        TitleV.clear();
        TitleV.addAll(Arrays.asList(title));
        for (OrderForm f: store.orders){
            Vector<Object> v = new Vector<>();
            v.add(f.getId());
            v.add(f.getFoodName());
            v.add(f.getNum());
            v.add(f.getUserName());
            v.add(f.getAddress());
            v.add(f.getTime());
            v.add(f.getTotalAmount());
            if (f.isFlag()){
                v.add("已完成");
            }else{v.add("已预定");}
            FoodV.add(v);
        }
    }
}
