import java.util.List;

public class Library implements IManageable{
    private List<Item> items;
    private List<Patron> patrons;

    public void registerPatron(Patron patron){
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item){
        patron.getBorrowedItems().add(item);
        item.borrowItem();
    }

    public void returnItem(Patron patron, Item item){
        patron.getBorrowedItems().remove(item);
        item.returnItem();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        for (Item item : items) {
            if(!item.isBorrowed()){
                System.out.println(item);
            }
        }
    }

    @Override
    public void listBorrowed() {
        for (Item item : items) {
            if(item.isBorrowed()){
                System.out.println(item);
            }
        }
    }

    public Library(List<Item> items, List<Patron> patrons) {
        this.items = items;
        this.patrons = patrons;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }
}
