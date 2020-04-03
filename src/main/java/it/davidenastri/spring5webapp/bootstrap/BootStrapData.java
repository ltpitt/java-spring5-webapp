package it.davidenastri.spring5webapp.bootstrap;

import it.davidenastri.spring5webapp.domain.Author;
import it.davidenastri.spring5webapp.domain.Book;
import it.davidenastri.spring5webapp.domain.Publisher;
import it.davidenastri.spring5webapp.repositories.AuthorRepository;
import it.davidenastri.spring5webapp.repositories.BookRepository;
import it.davidenastri.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("US");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book1);

        book1.getAuthors().add(eric);
        book1.setPublisher(publisher);

        publisher.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(publisher);


        Author sprintFrameworkFounder = new Author("Rod", "Johnson");
        Book book2 = new Book("Spring is cool beans", "321321");
        book2.setPublisher(publisher);

        publisher.getBooks().add(book2);

        sprintFrameworkFounder.getBooks().add(book2);
        book2.getAuthors().add(sprintFrameworkFounder);

        authorRepository.save(sprintFrameworkFounder);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Number of Publishers:\t" + publisherRepository.count());
        System.out.println("Number of books published by " + publisher.getName() + ":\t" + publisher.getBooks().size());
        System.out.println("Number of Authors:\t" + authorRepository.count());
        System.out.println("Number of Books:\t" + bookRepository.count());

    }

}
