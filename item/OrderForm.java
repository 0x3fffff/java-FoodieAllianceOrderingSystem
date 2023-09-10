package item;

public class OrderForm {
    private int id,num,time;
    private String userName,foodName,address;
    private boolean flag;
    private Double totalAmount;
    public static int cnt=0;
    public OrderForm() {
    }

    public OrderForm(String foodName,int num,String userName,String address, int time,boolean flag, Double totalAmount) {
        cnt++;
        this.id = cnt;
        this.num = num;
        this.time = time;
        this.userName = userName;
        this.foodName = foodName;
        this.address = address;
        this.flag = flag;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "id=" + id +
                ", num=" + num +
                ", time=" + time +
                ", userName='" + userName + '\'' +
                ", foodName='" + foodName + '\'' +
                ", address='" + address + '\'' +
                ", flag=" + flag +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
