package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookService {

    @Inject
    private BookRepository bookRepository = new BookRepository();

    @Inject
    private AuthorRepository authorRepository = new AuthorRepository();

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    public void addBook(String isbn, String title, String firstName, String lastName) {
        Author author = authorRepository.getAuthor(firstName, lastName);
        if (author == null){
            author = authorRepository.addAuthor(firstName, lastName);
        }

        bookRepository.addBook(new Book(isbn, title, author));
    }

    public String returnBookInfo(String isbn){
        return bookRepository.getShortDetails(isbn);
    }

    public List<Book> searchBook(String partialIsbn) {
        return bookRepository.searchBookISBN(partialIsbn);
    }
    public List<Book> searchBookPartialTitle(String partialTitle) {
        return bookRepository.searchBookPartialTitle(partialTitle);
    }

    public List<Book> searchBookPartialAuthor(String partialAuthor) {
        return bookRepository.searchBookPartialAuthor(partialAuthor);
    }


}