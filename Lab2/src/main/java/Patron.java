import java.util.List;

public class Patron {
    private String name;
    private String ID;
    private List<Item> borrowedItems;

    public void borrowItem(Item item){
        borrowedItems.add(item);
        item.borrowItem();
    }

    public void returnItem(Item item){
        borrowedItems.remove(item);
        item.returnItem();
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", ID: " + ID +
                ", borrowedItems: " + borrowedItems + ";";
    }

    public Patron(String name, String ID, List<Item> borrowedItems) {
        this.name = name;
        this.ID = ID;
        this.borrowedItems = borrowedItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(List<Item> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }
}
