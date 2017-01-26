package be.cegeka.secretService.domain.books;

public class Book {

    private final String isbn;
    private final String title;
    private final Author author;


    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getShortDetails(){
        return String.format("%s (%s)", title, isbn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!isbn.equals(book.isbn)) return false;
        if (!title.equals(book.title)) return false;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = isbn.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "isbn: " + isbn +  ", title: " + title + ", author: " + author + ".";
    }
}