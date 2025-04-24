public abstract class Product {
    private String productName;
    private String productID;
    private double price;
    
    public Product(String productName, String productID, double price) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public String getProductID() {
        return productID;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Abstract method to calculate price based on quantity
    public abstract double calculatePrice(int quantity);
    
    @Override
    public String toString() {
        return "Product [productName=" + productName + ", productID=" + productID + ", price=$" + price + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productID.equals(product.productID);
    }
    
    @Override
    public int hashCode() {
        return productID.hashCode();
    }
}
