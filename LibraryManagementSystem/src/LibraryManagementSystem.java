public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create library
        Library cityLibrary = new Library("City Public Library");
        
        // Add books
        PrintedBook book1 = new PrintedBook("P1001", "To Kill a Mockingbird", "Harper Lee", 
                                          "Good", "Paperback", 1);
        PrintedBook book2 = new PrintedBook("P1002", "1984", "George Orwell", 
                                          "Excellent", "Hardcover", 2);
        
        EBook book3 = new EBook("E2001", "The Martian", "Andy Weir", 
                              "EPUB", "http://library.com/martian.epub", 3.2);
        EBook book4 = new EBook("E2002", "Digital Fortress", "Dan Brown", 
                              "PDF", "http://library.com/digital-fortress.pdf", 2.8);
        
        AudioBook book5 = new AudioBook("A3001", "Harry Potter", "J.K. Rowling", 
                                      12.5, "Stephen Fry", "MP3");
        AudioBook book6 = new AudioBook("A3002", "The Hobbit", "J.R.R. Tolkien", 
                                      11.2, "Andy Serkis", "AAC");
        
        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);
        cityLibrary.addBook(book3);
        cityLibrary.addBook(book4);
        cityLibrary.addBook(book5);
        cityLibrary.addBook(book6);
        
        // Register users
        User user1 = new User("U001", "Alice Johnson", "alice@example.com");
        User user2 = new User("U002", "Bob Smith", "bob@example.com");
        
        cityLibrary.registerUser(user1);
        cityLibrary.registerUser(user2);
        
        // Display all books in library
        cityLibrary.displayAllBooks();
        
        // Borrow books
        cityLibrary.borrowBook("U001", "P1001");  // Alice borrows a printed book
        cityLibrary.borrowBook("U001", "E2001");  // Alice borrows an ebook
        cityLibrary.borrowBook("U002", "A3001");  // Bob borrows an audiobook
        
        // Show current borrowed books
        user1.viewBorrowedBooks();
        user2.viewBorrowedBooks();
        
        // Show available books
        cityLibrary.displayAvailableBooks();
        
        // Return a book
        cityLibrary.returnBook("U001", "P1001");
        
        // Check updated list
        cityLibrary.displayAvailableBooks();
        
        // Demo special features per book type
        System.out.println("\n=== Book Type Special Features ===");
        
        // Printed book features
        PrintedBook printedBook = cityLibrary.getPrintedBooks().get(0);
        printedBook.updateCondition("Fair");
        printedBook.displayDetails();
        
        // EBook features 
        EBook eBook = cityLibrary.getEBooks().get(0);
        eBook.download();
        
        // AudioBook features
        AudioBook audioBook = cityLibrary.getAudioBooks().get(0);
        audioBook.playSample();
    }
}
