package pl.coderslab;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/books")
@RequiredArgsConstructor

public class ManageBookController {

    private final BookService bookService;

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "ShowPosts";
    }
    @GetMapping("/add")
    public String add (Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }
    @PostMapping("/save")
    public String save (@ModelAttribute Book book)  {
        if (book.getId()==null){
            bookService.add(book);
        } else {
            bookService.update(book);
        }
        return "redirect:/books/all";
    }
    @GetMapping("/details/{id}")
    @ResponseBody
    public String showBook (@PathVariable Long id) throws NotFoundException {
        Optional<Book> bookOptional = bookService.get(id);
        if (bookOptional.isEmpty()){
            throw new NotFoundException("Book not found");
        }
        Book book = bookOptional.get();
        return book.toString();
    }
    @GetMapping("/update/{id}")
    public String update (@PathVariable Long id, Model model) throws NotFoundException {
        Optional<Book> bookOptional = bookService.get(id);
        if (bookOptional.isEmpty()){
            throw new NotFoundException("Book not found");
        }
        Book book = bookOptional.get();
        model.addAttribute("book",book);
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id) throws NotFoundException {
        Optional<Book> bookOptional = bookService.get(id);
        if (bookOptional.isEmpty()){
            throw new NotFoundException("Book not found");
        }
        Book book = bookOptional.get();
        bookService.delete(id);
        return "redirect:/books/all";
    }
}
