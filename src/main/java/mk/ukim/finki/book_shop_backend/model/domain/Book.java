package mk.ukim.finki.book_shop_backend.model.domain;

import jakarta.persistence.*;
import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;

@Entity
@Table(name = "books")
@NamedEntityGraph(
        name = "book-author-country-graph",
        attributeNodes = {
                @NamedAttributeNode("author"),
                @NamedAttributeNode(value = "author", subgraph = "author-country")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "author-country",
                        attributeNodes = @NamedAttributeNode("country")
                )
        }
)
public class Book extends BaseAuditableEntity{

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "available_copies")
    private int availableCopies;

    public Book(Author author, int availableCopies, Category category, String name, State state) {
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = category;
        this.name = name;
        this.state = state;
    }

    public Book() {
    }

    public Author getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }
}
