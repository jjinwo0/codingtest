package ssafy.book;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {

    public static void main(String[] args) {

        IBookManager manager = BookManagerImpl.getInstance();

        Book[] list = manager.getList();

        System.out.println("===불러온 도서 전체 목록===");
        if (list.length < 1)
            System.out.println("등록된 도서가 없습니다.");

        Book b1 = new Book("1", "title1", "author1", "pub1", 10000, "desc1", 2);
        Magazine m1 = new Magazine("2", "title1", "author1", "pub1", 10000, "desc1", 3, 2020, 5);

        manager.add(b1);
        manager.add(m1);

        manager.saveData();

        list = manager.getList();

        System.out.println("===불러온 도서 전체 목록===");

        for (int i=0; i<list.length; i++){
            System.out.println(list[i].toString());
        }
    }

}

