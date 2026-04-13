package Shop;

public class Item {
    public String product;
    public int qty;
    public int unitPrice;

    public Item(String product, int qty, int unitPrice){
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int price(){
        return qty * unitPrice;
    }
    public void increaseQuantity(){
        qty += 1;
    }

    public String toString(){
        return this.product + ": " + this.qty;
    }
}
