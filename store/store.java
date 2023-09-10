package store;

import com.formdev.flatlaf.FlatIntelliJLaf;
import item.Food;
import item.OrderForm;

import javax.swing.*;
import java.util.Arrays;
import java.util.Vector;

public class store {
    public static Vector<Vector> FoodV = new Vector<>();
    public static Vector<String> TitleV = new Vector<>();
    private static Food[] foods = new Food[]{new Food("红烧带鱼",38,0),new Food("鱼香肉丝",20,0),new Food("时令鲜蔬",10,0),new Food("荆楚肥牛",13,0),new Food("可乐鸡",13,0)};
    private static String[] title = new String[]{"序号","名称","单价","点赞数","购买份数"};
    public static Vector<OrderForm> orders = new Vector<>();
    public static int statistics[] = new int[100];
    public static void init(){
        TitleV.addAll(Arrays.asList(title));
        for (Food f:foods){
            Vector<Object> v = new Vector<>();
            v.add(f.getId());
            v.add(f.getName());
            v.add(f.getPrice());
            v.add(f.getLikeNum());
            v.add(0);
            FoodV.add(v);
        }
    }
    public static int getFoodLen(){
        return foods.length;
    }
}
