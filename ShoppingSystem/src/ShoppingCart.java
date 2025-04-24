import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> cartItems = new HashMap<>();
    
    // Add a product to cart
    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero");
            return;
        }
        
        // If product already in cart, update quantity
        if (cartItems.containsKey(product)) {
            int currentQuantity = cartItems.get(product);
            cartItems.put(product, currentQuantity + quantity);
        } else {
            cartItems.put(product, quantity);
        }
        
        System.out.println(quantity + " " + product.getProductName() + "(s) added to cart.");
    }
    
    // Remove a product from cart
    public void removeProduct(Product product) {
        if (cartItems.containsKey(product)) {
            cartItems.remove(product);
            System.out.println(product.getProductName() + " removed from cart.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }
    
    // View cart contents
    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        
        System.out.println("\n===== SHOPPING CART =====");
        System.out.println("Items in cart: " + getTotalItems());
        
        int itemNumber = 1;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            
            System.out.println(itemNumber + ". " + product.getProductName() + 
                               " - $" + product.getPrice() + " x " + quantity + 
                               " = $" + String.format("%.2f", product.calculatePrice(quantity)));
            itemNumber++;
        }
        
        System.out.println("------------------------");
        System.out.println("Total: $" + String.format("%.2f", calculateTotal()));
        System.out.println("=========================\n");
    }
    
    // Calculate total cost of all items
    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.calculatePrice(quantity);
        }
        return total;
    }
    
    // Get total number of items in cart
    public int getTotalItems() {
        int totalItems = 0;
        for (int quantity : cartItems.values()) {
            totalItems += quantity;
        }
        return totalItems;
    }
    
    // Checkout process
    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Cannot checkout - your cart is empty.");
            return;
        }
        
        double total = calculateTotal();
        System.out.println("\n===== CHECKOUT =====");
        System.out.println("Total items: " + getTotalItems());
        System.out.println("Total amount: $" + String.format("%.2f", total));
        System.out.println("Thank you for your purchase!");
        System.out.println("===================\n");
        
        // Clear the cart after checkout
        cartItems.clear();
    }
}
