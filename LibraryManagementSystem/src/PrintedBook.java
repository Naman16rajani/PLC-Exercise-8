
public class PrintedBook extends Book {
    private String condition; // New, Good, Fair, Poor
    private String coverType; // Hardcover or Paperback
    private int edition;
    
    public PrintedBook(String id, String title, String author, 
                       String condition, String coverType, int edition) {
        super(id, title, author);
        this.condition = condition;
        this.coverType = coverType;
        this.edition = edition;
    }
    
    // Getters
    public String getCondition() { return condition; }
    public String getCoverType() { return coverType; }
    public int getEdition() { return edition; }
    
    // Method to update condition (specific to printed books)
    public void updateCondition(String newCondition) {
        System.out.println("Updating condition from " + this.condition + " to " + newCondition);
        this.condition = newCondition;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("PRINTED BOOK: " + getTitle() + " by " + getAuthor());
        System.out.println("  Edition: " + edition + ", Cover: " + coverType + ", Condition: " + condition);
        System.out.println("  Status: " + (isAvailable() ? "Available" : "Borrowed"));
    }
}
