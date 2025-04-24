public class Groceries extends Product {
    private boolean perishable;
    private String expiryDate;
    
    public Groceries(String productName, String productID, double price, boolean perishable, String expiryDate) {
        super(productName, productID, price);
        this.perishable = perishable;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public double calculatePrice(int quantity) {
        double basePrice = getPrice() * quantity;
        
        // Buy 4 get 1 free promotion
        int freeItems = quantity / 5;
        double discount = freeItems * getPrice();
        
        return basePrice - discount;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Type: Groceries, Perishable: " + perishable + ", Expiry: " + expiryDate + "]";
    }
}
