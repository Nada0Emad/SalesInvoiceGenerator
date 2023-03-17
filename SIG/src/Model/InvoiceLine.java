

package Model;


public class InvoiceLine {
  // Fields
  private int id;
  private String itemName;
  private double itemPrice;
  private int count;

  // Constructor
  public InvoiceLine(int id, String itemName, double itemPrice, int count) {
    this.id = id;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.count = count;
  }


  // Getters and setters
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(double itemPrice) {
    this.itemPrice = itemPrice;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}