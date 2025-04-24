
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String name;
    private List<Book> bookCollection;
    private Map<String, User> registeredUsers;
    
    public Library(String name) {
        this.name = name;
        this.bookCollection = new ArrayList<>();
        this.registeredUsers = new HashMap<>();
    }
    
    // Book management
    public void addBook(Book book) {
        bookCollection.add(book);
        System.out.println("Added to " + name + ": " + book.getTitle());
    }
    
    public void removeBook(String bookId) {
        for (int i = 0; i < bookCollection.size(); i++) {
            if (bookCollection.get(i).getId().equals(bookId)) {
                Book book = bookCollection.remove(i);
                System.out.println("Removed from collection: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found with ID: " + bookId);
    }
    
    // User management
    public void registerUser(User user) {
        registeredUsers.put(user.getId(), user);
        System.out.println("Registered new user: " + user.getName());
    }
    
    public User findUser(String userId) {
        return registeredUsers.get(userId);
    }
    
    // Book search
    public Book findBook(String bookId) {
        for (Book book : bookCollection) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
    
    // Borrowing functionality
    public void borrowBook(String userId, String bookId) {
        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found: " + userId);
            return;
        }
        
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found: " + bookId);
            return;
        }
        
        user.borrowBook(book);
    }
    
    public void returnBook(String userId, String bookId) {
        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found: " + userId);
            return;
        }
        
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found: " + bookId);
            return;
        }
        
        user.returnBook(book);
    }
    
    // Display methods
    public void displayAllBooks() {
        System.out.println("\n=== Books at " + name + " ===");
        for (Book book : bookCollection) {
            book.displayDetails();
            System.out.println("-----------------------");
        }
    }
    
    public void displayAvailableBooks() {
        System.out.println("\n=== Available Books at " + name + " ===");
        for (Book book : bookCollection) {
            if (book.isAvailable()) {
                book.displayDetails();
                System.out.println("-----------------------");
            }
        }
    }
    
    // Book type specific collections
    public List<PrintedBook> getPrintedBooks() {
        List<PrintedBook> result = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book instanceof PrintedBook) {
                result.add((PrintedBook) book);
            }
        }
        return result;
    }
    
    public List<EBook> getEBooks() {
        List<EBook> result = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book instanceof EBook) {
                result.add((EBook) book);
            }
        }
        return result;
    }
    
    public List<AudioBook> getAudioBooks() {
        List<AudioBook> result = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book instanceof AudioBook) {
                result.add((AudioBook) book);
            }
        }
        return result;
    }
}
