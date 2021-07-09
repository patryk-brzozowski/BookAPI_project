package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.services.BookService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/{id}")
    public String showSingleBook(Model model, @PathVariable long id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("books", Arrays.asList(book));
        return "/books/all";
    }

    @RequestMapping("/add")
    public String getForm(Model model){
        model.addAttribute("book", new Book());
        return "/books/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAuthor(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "/books/form";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "/books/form";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBookForm(@PathVariable long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "/books/delete";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "/books/form";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteBook(@RequestParam long id) {
        bookService.removeBookById(id);
        return "redirect:/admin/books/all";
    }

    @ModelAttribute("categories")
    public List<String> categories() {
        return Arrays.asList("Dystopian", "Horror", "Fantasy", "Science fiction", "Thriller & Suspense", "Romance", "Biography", "History", "Science & Technology");
    }

    @ModelAttribute("publishers")
    public List<String> publishers() {
        return Arrays.asList("Egmont", "Amber", "Rebis", "Zysk i S-ka", "Capital", "Fronda", "Fijorr Publishing");
    }
}