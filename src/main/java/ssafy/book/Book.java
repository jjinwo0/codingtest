package ssafy.book;
/**
 * 도서 정보를 나타내는 클래스
 */
public class Book {

    private String isbn;

    private String title;

    private String author;

    private String publisher;

    private int price;

    private String desc;

    private int quantity;

    public Book() {}

    public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
//		super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%-12s", isbn)).append("\t|");
        sb.append(String.format("%-12s", title)).append("\t|");
        sb.append(String.format("%-12s", author)).append("\t|");
        sb.append(String.format("%-12s", publisher)).append("\t|");
        sb.append(String.format("%-12s", price)).append("\t|");
        sb.append(String.format("%-12s", desc)).append("\t|");
        sb.append(String.format("%-12s", quantity)).append("\t|");
        return sb.toString();
    }
}
