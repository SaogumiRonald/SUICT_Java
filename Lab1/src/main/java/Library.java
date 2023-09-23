import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public void addBook(Book book){
        bookList.add(book);
    }

    public void showBookList(){
        for (Book book : bookList){
            System.out.println(book);
        }
    }

    public Book findBook(String title){
        for(Book book : bookList){
            if(book.getTitle().equalsIgnoreCase(title)){
                System.out.println("\nBook found with the title (" + title + "): ");
                System.out.println(book + "\n");
                return book;
            }
        }

        System.out.println("No book found with the title (" + title + ").\n");
        return null;
    }

    public void deleteBook(Book book){
        if(bookList.contains(book)){
            bookList.remove(book);
        } else{
            System.out.println("The specified book was not found in the list.\n");
        }
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}
