package service;

import bookstore.Book;

public class BookService {

    public static Book[] bookList = new Book[50];

    public boolean saveBook(Book book) {
        if (book == null) {
            return false;
        }
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] == null) {
                bookList[i] = book;
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(int id) {
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i].getBookId() == id || bookList[i] != null) {
                bookList[i] = null;
                return true;
            }
        }
        return false;
    }

    public Book findById(int id) {
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i].getBookId() == id) {
                return bookList[i];
            }
        }
        return null;
    }
}
