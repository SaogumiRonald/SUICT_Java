public class DVD extends Item{
    private int duration;

    void borrowItem() {
        setBorrowed(true);
    }

    void returnItem() {
        setBorrowed(false);
    }

    @Override
    public String toString() {
        return "unique ID: " + getUniqueID() +
                ", title: " + getTitle() +
                ", isBorrowed: " + isBorrowed() +
                ", duration: " + duration + ";";
    }

    public DVD(String title, String uniqueID, boolean isBorrowed, int duration) {
        super(title, uniqueID, isBorrowed);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
