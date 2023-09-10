/*
 * Created by JFormDesigner on Sat Sep 09 14:54:29 CST 2023
 */

package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import info.clearthought.layout.*;
import item.OrderForm;
import store.store;

/**
 * @author 0x3fffff
 * @URL https://blog.csdn.net/qq_19655605?type=blog
 */
public class InputWindow extends JDialog {
    public InputWindow(Window owner) {
        super(owner);
        this.owner = owner;
        initComponents();
    }
    public InputWindow(Window owner,String title,String Text,int type) {
        super(owner);
        this.type = type;
        this.owner = owner;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/res/Warin.png")).getImage());
        this.setTitle(title);
        label1.setText(Text);
    }

    private void button1MouseClicked(MouseEvent e) {
        if (type==1){
            ((OrderingMeal) owner).userName=textField1.getText();
        }else if (type==2){
            try{
                ((OrderingMeal) owner).time=Integer.parseInt(textField1.getText());
            }catch (Exception EE){
                new warnWindow(this,"请输入有效数字！").setVisible(true);
            }
        }else if (type==3){
            ((OrderingMeal) owner).address=textField1.getText();
        }else if (type==4){
            try{
                if(store.orders.get(Integer.parseInt(textField1.getText())-1).isFlag()){
                    store.orders.remove(Integer.parseInt(textField1.getText())-1);
                    OrderForm of = store.orders.get(Integer.parseInt(textField1.getText())-1);
                    new warnWindow(this,"订单"+textField1.getText()+":  "+of.getFoodName()+"x"+of.getNum()+"  已删除！").setVisible(true);
                }else{
                    new warnWindow(this,"请输入已完成的订单").setVisible(true);
                }
            }catch (Exception EE){
                new warnWindow(this,"请输入有效数字！").setVisible(true);
            }

        }

        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(null);

            //---- label1 ----
            label1.setText("text");
            dialogPane.add(label1);
            label1.setBounds(25, 10, 285, 30);
            dialogPane.add(textField1);
            textField1.setBounds(25, 50, 290, textField1.getPreferredSize().height);

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            dialogPane.add(button1);
            button1.setBounds(new Rectangle(new Point(130, 100), button1.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialogPane.getComponentCount(); i++) {
                    Rectangle bounds = dialogPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialogPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialogPane.setMinimumSize(preferredSize);
                dialogPane.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private Window owner;
    private int type=0;
    public String getVal(){
        return textField1.getText();
    }
}
