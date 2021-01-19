package bean;

public class Book {
    private Integer id;
    private String author;
    private String name;

    public Book(Integer id, String author, String name) {
        this.id = id;
        this.author = author;
        this.name = name;
    }

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
