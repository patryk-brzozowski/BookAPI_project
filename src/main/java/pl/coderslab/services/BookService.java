package pl.coderslab.services;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public Book getBookById(Long id);

    public void addBook(Book book);

    public void editBook(Book book);

    public void removeBookById(Long id);
}
