public class Book extends Item {
    private String author;

    @Override
    void borrowItem() {
        setBorrowed(true);
    }

    @Override
    void returnItem() {
        setBorrowed(false);
    }

    @Override
    public String toString() {
        return "unique ID: " + getUniqueID() +
                ", title: " + getTitle() +
                ", isBorrowed: " + isBorrowed() +
                ", author: " + getAuthor() + ";";
    }

    public Book(String title, String uniqueID, boolean isBorrowed, String author) {
        super(title, uniqueID, isBorrowed);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
