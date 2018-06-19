package _2_BookShop;

public class Book {

    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        setAuthor(author);
        setTitle(title);
        setPrice(price);
    }

    protected void setTitle(String title) {
        if(title==null||title.trim().length()<3){
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected void setAuthor(String author) {

        if(author==null||author.trim().matches("^[^\\s]+\\s+\\d+.*")){
            throw new IllegalArgumentException("Author not valid!");
        }

        this.author = author;
    }

    protected void setPrice(double price) {
        if(price<=0){
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    private String getTitle() {
        return title;
    }

    protected String getAuthor() {
        return author;
    }

    protected double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("Type: ").append(this.getClass().getSimpleName())

                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());

        return sb.toString();
    }
}
