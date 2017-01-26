package be.cegeka.secretService.domain.books;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getShortDetails(String isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                return book.getShortDetails();
            }
        }
        return null;
    }

    public List<Book> searchBookISBN(String partialISBN) {
        partialISBN = partialISBN.replaceAll("\\*", "[0-9]*-?[0-9]*");
        List<Book> booksWithPartialIsbn = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().matches(partialISBN)) {
                booksWithPartialIsbn.add(book);
            }
        }
        return booksWithPartialIsbn;
    }

    public List<Book> searchBookPartialTitle(String partialTitle) {
        partialTitle = partialTitle.replaceAll("\\*", "[^0-9]*");
        List<Book> booksWithPartialTitle = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().matches(partialTitle)) {
                booksWithPartialTitle.add(book);
            }
        }
        return booksWithPartialTitle;
    }

    public List<Book> searchBookPartialAuthor(String partialAuthor) {
        partialAuthor = partialAuthor.replaceAll("\\*", "[^0-9]*");
        List<Book> booksWithPartialAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toString().matches(partialAuthor)) {
                booksWithPartialAuthor.add(book);
            }
        }
        return booksWithPartialAuthor;
    }
}