package pl.coderslab;

import lombok.*;

import javax.persistence.*;



@Getter
@Setter
@Entity
@Table(name = "books")
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String title;
    private String author;
    private String publisher;

//    public Book(String isbn, String title, String author, String publisher, String type) {
//        this.isbn = isbn;
//        this.title = title;
//        this.author = author;
//        this.publisher = publisher;
//        this.type = type;
//    }

    private String type;
}
