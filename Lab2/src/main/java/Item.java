public abstract class Item {
    private String title;
    private String uniqueID;
    private boolean isBorrowed;

    abstract void borrowItem();
    abstract void returnItem();

    @Override
    public String toString() {
        return "unique ID: " + uniqueID +
                ", title: " + title +
                ", isBorrowed: " + isBorrowed + ";";
    }

    public Item(String title, String uniqueID, boolean isBorrowed) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
