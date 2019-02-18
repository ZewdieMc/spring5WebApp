package mc.springframework.spring5WebApp.bootstrap;

import mc.springframework.spring5WebApp.model.Author;
import mc.springframework.spring5WebApp.model.Book;
import mc.springframework.spring5WebApp.model.Publisher;
import mc.springframework.spring5WebApp.repositories.AuthorRepository;
import mc.springframework.spring5WebApp.repositories.BookRepository;
import mc.springframework.spring5WebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

private AuthorRepository authorRepository;
private BookRepository bookRepository;
private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher gpublisher = new Publisher("pubOne","address one");

        gpublisher.setName("foo");

        publisherRepository.save(gpublisher);

        Publisher zpublisher = new Publisher("pubtwo","Address two");
        zpublisher.setName("bar");

        publisherRepository.save(zpublisher);
    //zewdie
        Author zewdie = new Author("Zewdie","Habtie");
        Book ddd = new Book("Domain Driven Design","1234",gpublisher) ;
        zewdie.getBooks().add(ddd);//add the ddd to the list of books written by zewdie
        ddd.getAuthors().add(zewdie);// add zewdie to the list of authors of the book ddd

        authorRepository.save(zewdie);
        bookRepository.save(ddd);

    //Genet
        Author genet = new Author("Genet","Worku");
        Book noEJB = new Book("J2EE Development without EJB","2344",zpublisher);
        genet.getBooks().add(noEJB);

        authorRepository.save(genet);
        bookRepository.save(noEJB);
    }
}
