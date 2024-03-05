public class Book {
    private String isbn_code;
    private String book_name;
    private String book_desc;
    private String author_name;
    private String subject_name;
    private Integer units_available;

    public Book() {

    }

    public Book (String isbn_code, String book_name, String book_desc, String author_name, String subject_name, Integer units_available) {
        this.isbn_code = isbn_code;
        this.book_name = book_name;
        this.book_desc = book_desc;
        this.author_name = author_name;
        this.subject_name = subject_name;
        this.units_available = units_available;
    }

    public String getIsbn_code () {
        return isbn_code;
    }

    public void setIsbn_code (String isbn_code) {
        this.isbn_code = isbn_code;
    }

    public String getBook_name () {
        return book_name;
    }

    public void setBook_name (String book_name) {
        this.book_name = book_name;
    }

    public String getBook_desc () {
        return book_desc;
    }

    public void setBook_desc (String book_desc) {
        this.book_desc = book_desc;
    }

    public String getAuthor_name () {
        return author_name;
    }

    public void setAuthor_name (String author_name) {
        this.author_name = author_name;
    }

    public String getSubject_name () {
        return subject_name;
    }

    public void setSubject_name (String subject_name) {
        this.subject_name = subject_name;
    }

    public Integer getUnits_available () {
        return units_available;
    }

    public void setUnits_available (Integer units_available) {
        this.units_available = units_available;
    }
}
