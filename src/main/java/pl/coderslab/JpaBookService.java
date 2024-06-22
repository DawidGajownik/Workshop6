package pl.coderslab;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Primary
@Service
@Transactional
public class JpaBookService implements BookService {

    @PersistenceContext
    private EntityManager entityManager;
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void add(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void delete(Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        Book book = bookOpt.get();
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }
}