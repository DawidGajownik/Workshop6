package pl.coderslab;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MockBookService implements BookService{

//    public MockBookService() {
//        list = new ArrayList<>();
//        list.add(new Book(1L, "978-3-16-148410-0", "In Search of Lost Time", "Marcel Proust", "Grasset", "Fiction"));
//        list.add(new Book(2L, "978-0-7432-7356-5", "Don Quixote", "Miguel de Cervantes", "Francisco de Robles", "Fiction"));
//        list.add(new Book(3L, "978-0-14-118280-3", "Ulysses", "James Joyce", "Shakespeare and Company", "Fiction"));
//        list.add(new Book(4L, "978-0-14-044926-6", "The Odyssey", "Homer", "Penguin Classics", "Epic Poetry"));
//        list.add(new Book(5L, "978-0-06-088328-7", "War and Peace", "Leo Tolstoy", "The Russian Messenger", "Historical Fiction"));
//        list.add(new Book(6L, "978-0-19-953556-9", "Moby Dick", "Herman Melville", "Harper & Brothers", "Adventure Fiction"));
//        list.add(new Book(7L, "978-0-19-283398-3", "The Divine Comedy", "Dante Alighieri", "Nicolò di Lorenzo", "Epic Poetry"));
//        list.add(new Book(8L, "978-0-307-74132-6", "Hamlet", "William Shakespeare", "Simon & Schuster", "Drama"));
//        list.add(new Book(9L, "978-0-679-60123-9", "The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", "Fiction"));
//        list.add(new Book(10L, "978-0-452-28423-4", "The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", "Fiction"));
//        list.add(new Book(11L, "978-0-452-28425-8", "1984", "George Orwell", "Secker & Warburg", "Dystopian Fiction"));
//        list.add(new Book(12L, "978-0-7432-7356-6", "One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Harper & Row", "Magic Realism"));
//        list.add(new Book(13L, "978-0-679-72835-6", "Crime and Punishment", "Fyodor Dostoevsky", "The Russian Messenger", "Psychological Fiction"));
//        list.add(new Book(14L, "978-0-7432-7356-7", "Madame Bovary", "Gustave Flaubert", "Revue de Paris", "Fiction"));
//        list.add(new Book(15L, "978-0-14-243723-0", "Pride and Prejudice", "Jane Austen", "T. Egerton", "Romantic Fiction"));
//        list.add(new Book(16L, "978-0-14-143947-1", "Wuthering Heights", "Emily Brontë", "Thomas Cautley Newby", "Gothic Fiction"));
//        list.add(new Book(17L, "978-0-452-28426-5", "Brave New World", "Aldous Huxley", "Chatto & Windus", "Dystopian Fiction"));
//        list.add(new Book(18L, "978-0-7432-7356-8", "The Iliad", "Homer", "Penguin Classics", "Epic Poetry"));
//        list.add(new Book(19L, "978-0-14-044926-7", "The Brothers Karamazov", "Fyodor Dostoevsky", "The Russian Messenger", "Philosophical Fiction"));
//        list.add(new Book(20L, "978-0-7432-7356-9", "Anna Karenina", "Leo Tolstoy", "The Russian Messenger", "Realist Fiction"));
//    }
    private static Long nextId = 21L;

    public List<Book> list;

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) {
        return list.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(nextId);
        list.add(book);
        nextId +=1;
    }

    @Override
    public void delete(Long id) {
        if (this.get(id).isPresent()) {
            list.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {
            list.set(list.indexOf(this.get(book.getId()).get()), book);
        }
    }
}
