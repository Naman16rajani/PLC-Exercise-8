

public class AudioBook extends Book {
    private double durationHours;
    private String narrator;
    private String audioFormat; // MP3, AAC, etc.
    
    public AudioBook(String id, String title, String author, 
                    double durationHours, String narrator, String audioFormat) {
        super(id, title, author);
        this.durationHours = durationHours;
        this.narrator = narrator;
        this.audioFormat = audioFormat;
    }
    
    // Getters
    public double getDurationHours() { return durationHours; }
    public String getNarrator() { return narrator; }
    public String getAudioFormat() { return audioFormat; }
    
    // AudioBook-specific method
    public void playSample() {
        System.out.println("Playing sample of " + getTitle() + " narrated by " + narrator);
        System.out.println("Sample duration: 2 minutes, Format: " + audioFormat);
    }
    
    @Override
    public void displayDetails() {
        System.out.println("AUDIOBOOK: " + getTitle() + " by " + getAuthor());
        System.out.println("  Narrator: " + narrator + ", Duration: " + durationHours + " hours");
        System.out.println("  Format: " + audioFormat);
        System.out.println("  Status: " + (isAvailable() ? "Available" : "Borrowed"));
    }
}


