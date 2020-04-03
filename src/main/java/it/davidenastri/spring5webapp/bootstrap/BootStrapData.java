package it.davidenastri.spring5webapp.bootstrap;

import it.davidenastri.spring5webapp.domain.Author;
import it.davidenastri.spring5webapp.domain.Book;
import it.davidenastri.spring5webapp.repositories.AuthorRepository;
import it.davidenastri.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(book1);

        Author sprintFrameworkFounder = new Author("Rod", "Johnson");
        Book book2 = new Book("Spring is cool beans", "321321");

        sprintFrameworkFounder.getBooks().add(book2);
        book2.getAuthors().add(sprintFrameworkFounder);

        authorRepository.save(sprintFrameworkFounder);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors:\t" + authorRepository.count());
        System.out.println("Number of Books:\t" + bookRepository.count());

    }

}
