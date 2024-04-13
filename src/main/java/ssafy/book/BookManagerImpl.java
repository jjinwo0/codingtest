package ssafy.book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManagerImpl implements IBookManager{

    List<Book> books;

    private static IBookManager instance = new BookManagerImpl();

    private BookManagerImpl() {

        books = new ArrayList<>();
        loadData();
    }

    public static IBookManager getInstance() {

        return instance;
    }

    private void validBook(Book book) {

        if(book == null)
            throw new NullPointerException("null 불가");
    }

    @Override
    public void add(Book book) {

        validBook(book);

        books.add(book);
    }

    @Override
    public void remove(String isbn) {


    }

    @Override
    public Book[] getList() {

        return books.stream().toArray(Book[]::new);
    }

    @Override
    public Book searchByIsbn(String isbn) {

        Book result = books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .collect(Collectors.toList()).get(0);

        if(result == null)
            throw new ISBNNotFoundException(isbn);

        return result;
    }

    @Override
    public Book[] searchByTitle(String title) {

        Book[] result = books.stream()
                .filter(b -> b.getTitle().equals(title))
                .toArray(Book[]::new);

        return result;
    }

    @Override
    public Magazine[] getMagazines() {

        Magazine[] result = books.stream()
                .filter(b -> b.getClass().equals(Magazine.class))
                .toArray(Magazine[]::new);
        return result;
    }

    @Override
    public Book[] getBooks() {

        Book[] result = books.stream()
                .filter(b -> !b.getClass().equals(Magazine.class))
                .toArray(Book[]::new);
        return result;
    }

    @Override
    public int getTotalPrice() {

        int sum = 0;

        for(Book b : books) {

            sum += b.getPrice();
        }

        return sum;
    }

    @Override
    public double getPriceAvg() {

        int sum = 0;

        for(Book b : books) {

            sum += b.getPrice();
        }

        return sum / books.size();
    }

    @Override
    public void sell(String isbn, int quantity) {

        Book findBook = searchByIsbn(isbn);

        if (findBook.getQuantity() < quantity)
            throw new QuantityException();

        findBook.setQuantity(findBook.getQuantity()-quantity);
    }

    @Override
    public void buy(String isbn, int quantity) {

        Book findBook = searchByIsbn(isbn);

        findBook.setQuantity(findBook.getQuantity()+quantity);
    }

    private void loadData() {

        File dir = new File("src/data");
        if (!dir.exists())
            dir.mkdirs();

        File file = new File("src/data/book.dat");

        if (file.exists() && file.isFile() && file.canRead()) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                books = (List<Book>) input.readObject();  // 파일에서 movieList를 불러옴.
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("[ERROR] 파일 로드 중 오류 발생");
            }
        } else {
            books = new ArrayList<>();  // 파일이 없을 경우, 새로운 리스트를 생성.
        }
    }

    @Override
    public void saveData() {

        File fileName = new File("src/data");

        if (!fileName.exists())
            fileName.mkdir();

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/data/book.dat"))){
            output.writeObject(books);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("[ERROR] 파일 저장 중 문제 발생");
        }
    }

}

