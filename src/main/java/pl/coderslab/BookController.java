package pl.coderslab;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MockBookService bookService = new MockBookService();


    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        //prawidłowe
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
        //moje
        //return bookService.get(id).get();
    }
    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }
    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.delete(id);
    }
}