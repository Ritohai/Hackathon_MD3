package controller;

import bookstore.Book;
import service.BookService;

public class BookController {
    private BookService service = new BookService();

    public boolean createBook(Book book) {
        return service.saveBook(book);
    }
    public Book findById(int id){
        return service.findById(id);
    }
    public boolean deleteBook(int id) {
        return service.deleteBook(id);
    }
}
