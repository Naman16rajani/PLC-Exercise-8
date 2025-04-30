public class ShoppingSystem {
    public static void main(String[] args) {

        Electronics laptop = new Electronics("Laptop", "E001", 999.99, 24);
        Electronics smartphone = new Electronics("Smartphone", "E002", 599.99, 12);
        
        Clothing tshirt = new Clothing("T-Shirt", "C001", 19.99, "Medium", "Blue");
        Clothing jeans = new Clothing("Jeans", "C002", 49.99, "32", "Black");
        
        Groceries milk = new Groceries("Milk", "G001", 3.99, true, "2025-05-01");
        Groceries bread = new Groceries("Bread", "G002", 2.49, true, "2025-04-28");
        
        ShoppingCart cart = new ShoppingCart();
        
        cart.addProduct(laptop, 1);
        cart.addProduct(smartphone, 2);
        cart.addProduct(tshirt, 3);
        cart.addProduct(milk, 5);
        
        cart.viewCart();
        
        cart.addProduct(jeans, 2);
        cart.addProduct(bread, 2);
        
        cart.viewCart();
        
        cart.removeProduct(milk);
        
        cart.viewCart();
        
        cart.checkout();
        
        cart.viewCart();
    }
}
