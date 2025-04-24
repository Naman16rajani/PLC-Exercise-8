

public class EBook extends Book {
    private String format; // PDF, EPUB, etc.
    private String downloadLink;
    private double fileSizeMB;
    
    public EBook(String id, String title, String author, 
                String format, String downloadLink, double fileSizeMB) {
        super(id, title, author);
        this.format = format;
        this.downloadLink = downloadLink;
        this.fileSizeMB = fileSizeMB;
    }
    
    // Getters
    public String getFormat() { return format; }
    public String getDownloadLink() { return downloadLink; }
    public double getFileSizeMB() { return fileSizeMB; }
    
    // eBook-specific method
    public void download() {
        if (isAvailable()) {
            System.out.println("Downloading eBook: " + getTitle() + " (" + format + ")");
            System.out.println("Download started from: " + downloadLink);
        } else {
            System.out.println("This eBook is currently unavailable for download.");
        }
    }
    
    @Override
    public void displayDetails() {
        System.out.println("EBOOK: " + getTitle() + " by " + getAuthor());
        System.out.println("  Format: " + format + ", Size: " + fileSizeMB + "MB");
        System.out.println("  Status: " + (isAvailable() ? "Available" : "Borrowed"));
    }
}
