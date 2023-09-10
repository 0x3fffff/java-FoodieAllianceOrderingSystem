package item;
public class Food {
    public static int num=0;
    private int id,likeNum;
    private String name;
    private double price;
    public Food() {}
    public Food(String name, double price,int likeNum) {
        num++;
        this.id=num;
        this.name = name;
        this.price = price;
        this.likeNum = likeNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

