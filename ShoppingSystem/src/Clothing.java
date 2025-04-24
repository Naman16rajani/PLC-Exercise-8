public class Clothing extends Product {
    private String size;
    private String color;
    private static final double DISCOUNT_RATE = 0.05; // 5% discount on clothing
    
    public Clothing(String productName, String productID, double price, String size, String color) {
        super(productName, productID, price);
        this.size = size;
        this.color = color;
    }
    
    @Override
    public double calculatePrice(int quantity) {
        double basePrice = getPrice() * quantity;
        
        // Apply base discount plus additional discount for bulk purchases
        double discount = basePrice * DISCOUNT_RATE;
        if (quantity >= 5) {
            discount += basePrice * 0.10; // Additional 10% off for 5+ items
        }
        
        return basePrice - discount;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Type: Clothing, Size: " + size + ", Color: " + color + "]";
    }
}
