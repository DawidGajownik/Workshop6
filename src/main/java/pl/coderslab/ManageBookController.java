package pl.coderslab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/books")
@RequiredArgsConstructor

public class ManageBookController {

    private final BookService bookService;
    private final ServletRequest httpServletRequest;

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
        log.info(book.toString());
        if (book.getId()==null){
            bookService.add(book);
        } else {
            bookService.update(book);
        }
        return "redirect:/books/all";
    }
    @GetMapping("/details/{id}")
    @ResponseBody
    public String showBook (@PathVariable Long id) {
        return bookService.get(id).get().toString();
    }
    @GetMapping("/update/{id}")
    public String update (@PathVariable Long id, Model model) {
        model.addAttribute("book",bookService.get(id).get());
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books/all";
    }
}
