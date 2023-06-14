import bookstore.Book;
import config.Config;
import controller.BookController;
import service.BookService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BookManagement {
    static Book[] bookList = BookService.bookList;
    static BookController controller = new BookController();

    public static void main(String[] args) {
        int choice = 0;
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện ");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần ");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả ");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("Nhập lựa chọn của bạn:");
            choice = Config.getScanner().nextInt();
            switch (choice) {
                case 1:
                    createBook();
                    break;
                case 2:
                    showAllBook();
                    break;
                case 3:
                    showSort();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Thoát chương trình!!!");
                    System.exit(0);

            }
        }
    }

    // Hiển thị
    static void showAllBook() {
        Book[] bookList = BookService.bookList;
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null) {
                System.out.println(bookList[i]);
            }
//        }
//        if (bookList == null) {
//            System.out.println("Chưa có sách");
        }
    }

    // Hàm tự tăng
    static int idAuto() {
        int maxId = 0;
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null && maxId < bookList[i].getBookId()) {
                maxId = bookList[i].getBookId();
            }
        }
        return maxId + 1;
    }

    // Thêm sách
    static void createBook() {
        System.out.println("Nhập số lượng sách n: ");
        int n = Config.getScanner().nextInt();
        for (int i = 0; i < n; i++) {
            int id = idAuto();
            bookList[i] = new Book();
            bookList[i].setBookId(id);
            System.out.printf("Nhap sach thu %d ", i + 1);
            System.out.println("Nhap ten sach: ");
            bookList[i].setBookName(Config.getScanner().nextLine());
            System.out.println("Nhap tac gia: ");
            bookList[i].setAuthor(Config.getScanner().nextLine());
            System.out.println("Nhap mo ta: ");
            bookList[i].setDescriptions(Config.getScanner().nextLine());
            System.out.println("Nhap gia nhap: ");
            bookList[i].setImportPrice(Config.getScanner().nextDouble());
            System.out.println("Nhap gia xuat: ");
            bookList[i].setExportPrice(Config.getScanner().nextDouble());
            bookList[i].setInterest(bookList[i].inputData());
            bookList[i].setBookStatus(true);
        }
    }

    // sắp xếp theo thứu tự tăng dần
    static void showSort() {
        Book[] books = new Book[50];
        int size = 0;
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null) {
                books[size] = bookList[i];
                size++;
            }
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (bookList[j].getInterest() > bookList[j + 1].getInterest()) {
                    Book temp = bookList[j];
                    bookList[j] = bookList[j + 1];
                    bookList[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(bookList[i]);
        }
    }

    static void deleteBook() {
        System.out.println("Nhập mã id muốn xóa: ");
        int id = Config.getScanner().nextInt();
        Book book = controller.findById(id);
        if(book == null){
            System.out.println("Không có sách để xóa.");
        } else {
            controller.deleteBook(id-1);
            return;
        }
    }
}



