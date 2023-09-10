/*
 * Created by JFormDesigner on Mon Sep 04 11:05:06 CST 2023
 */

package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import item.Food;
import store.store;
import item.OrderForm;

/**
 * @author 0x3fffff
 * @URL https://blog.csdn.net/qq_19655605?type=blog
 */
public class OrderingMeal extends JFrame {
    public OrderingMeal() {
        in();
        initComponents();
    }
    public OrderingMeal(int type) {
        this.type=type;
        in();
        initComponents();
        if (type==1){
            for (int i=0;i<store.getFoodLen();i++){
                table1.getModel().setValueAt(0,i,4);
            }
            setTitle("订餐");
            button1.setText("订购");
        }
        else if (type==2){
            label1.setVisible(false);
            for (int i=0;i<store.getFoodLen();i++){
                table1.getModel().setValueAt(store.statistics[i],i,4);
                System.out.print(store.statistics[i]);
            }
            setTitle("点赞");
            button1.setText("点赞");
        }
    }
    public OrderingMeal(String userName) {
        in();
        this.userName=userName;
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        if (type==1) {
            System.out.println(userName);
            new InputWindow(this, "点餐", "送餐时间,要求当天10到20点间整点送餐", 2).setVisible(true);
            while (time > 20 || time < 10) {
                new warnWindow(this, "请输入10到20之间的整数").setVisible(true);
                new InputWindow(this, "点餐", "送餐时间,要求当天10到20点间整点送餐", 2).setVisible(true);
            }
            new InputWindow(this, "点餐", "送餐地址", 3).setVisible(true);
            for (Vector v : FoodV) {
                try {
                    int num = Integer.parseInt((String) v.get(4));
                    if (num > 0) {
                        store.statistics[(int)v.get(0)-1]+=num;
                        System.out.println(" "+(int)v.get(0)+"  "+num);
                        store.orders.add(new OrderForm((String) v.get(1), num, userName, address, time, false, (double) v.get(2) * num));
                    }
                } catch (Exception E) {
                    System.out.println("-");
                }
            }

            this.dispose();
        }else if (type==2){
            int index = table1.getSelectedRow();
            System.out.println(index);
            FoodV.get(index).set(3,(int)FoodV.get(index).get(3)+1);

            table1.setModel(new TableModel());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable(new TableModel());
        button1 = new JButton();
        label1 = new JLabel();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/res/Shop.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, BorderLayout.SOUTH);

        //---- label1 ----
        label1.setText("\u603b\u91d1\u989d\uff1a0\u5143");
        contentPane.add(label1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private Vector<Vector> FoodV = store.FoodV;
    private Vector<String> TitleV = store.TitleV;
    public String userName,address;
    public int time;
    private int type;
    public void in(){
        if (type==1){
            new InputWindow(this,"点餐","请输入姓名",1).setVisible(true);
            while (userName==null){
                new warnWindow(this, "请先输入姓名!").setVisible(true);
                new InputWindow(this,"点餐","请输入姓名",1).setVisible(true);
            }
        }

    }
    public double getTotalAmount(){
        double total=0;
        for (Vector i :FoodV){
            try {
                total+=((double)i.get(2))*Integer.parseInt((String) i.get(4));
            } catch (Exception e) {
                System.out.println("-");
            }
        }
        return total;
    }

    private class TableModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return FoodV.size();
        }

        @Override
        public int getColumnCount() {
            return TitleV.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return FoodV.get(rowIndex).get(columnIndex);
        }

        @Override
        public String getColumnName(int column) {
            return TitleV.get(column);
        }

        @Override
        public boolean isCellEditable(int row,int column){
            return column == 4;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            System.out.println(aValue);
            FoodV.get(rowIndex).set(columnIndex,aValue);
            super.setValueAt(aValue, rowIndex, columnIndex);
            double totalAmount = getTotalAmount();
            if (totalAmount < 50) label1.setText("总金额："+(totalAmount+6)+"元 (含6元配送费)");
            else label1.setText("总金额："+getTotalAmount()+"元 (免配送费)");
        }
    }
}
