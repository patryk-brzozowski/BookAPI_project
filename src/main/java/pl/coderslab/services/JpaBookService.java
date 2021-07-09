package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;

@Service
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void editBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void removeBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
