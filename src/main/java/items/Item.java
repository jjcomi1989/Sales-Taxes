package items;

/**
 * Created by jjcomi1989 on 09/10/16.
 */

// This class is an abstract for an input item.

public abstract class Item {

    // Item description
    private String description;
    // Item price without taxes
    private float price;
    // Item quantity
    private int quantity;
    // Bool who stores if imported or not
    private boolean imported;
    // Bool price + taxes
    private float taxedPrice;

    public Item() {
        this.description = "";
        this.price = 0.0f;
        this.quantity = 0;
        this.imported = false;
        this.taxedPrice = 0.0f;
    }

    public Item(String description, float price, int quantity, boolean imported){
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imported = imported;
    }

    // Getter and setter methods

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setImported(boolean imported){
        this.imported = imported;
    }

    public void setTaxedPrice(float taxedPrice) {
        this.taxedPrice = taxedPrice;
    }

    public String getDescription(){
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public boolean isImported(){
        return imported;
    }

    public float getTaxedPrice(){
        return taxedPrice;
    }

    public abstract float getTaxValue();

    @Override
    public String toString() {
        return "Item[quantity=" + getQuantity() + "name=" + getDescription() + ", price=" + getPrice() + ", imported=" + isImported() + "]";
    }
}