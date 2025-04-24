public class Electronics extends Product {
    private int warrantyPeriodMonths;
    private static final double TAX_RATE = 0.10; // 10% tax on electronics
    
    public Electronics(String productName, String productID, double price, int warrantyPeriodMonths) {
        super(productName, productID, price);
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }
    
    @Override
    public double calculatePrice(int quantity) {
        double basePrice = getPrice() * quantity;
        double tax = basePrice * TAX_RATE;
        
        // Offer 5% discount for purchases of 3 or more electronics items
        double discount = (quantity >= 3) ? basePrice * 0.05 : 0;
        
        return basePrice + tax - discount;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Type: Electronics, Warranty: " + warrantyPeriodMonths + " months]";
    }
}
