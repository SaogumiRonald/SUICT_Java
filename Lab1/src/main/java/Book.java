public class Book {
    private String title;
    private String author;
    private String isbn;
    private int yearOfPublication;

    public Book(String title, String author, String isbn, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", author: " + author +
                ", isbn: " + isbn +
                ", year of publication: " + yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
