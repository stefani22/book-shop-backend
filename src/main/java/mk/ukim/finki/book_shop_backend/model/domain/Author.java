package mk.ukim.finki.book_shop_backend.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends BaseAuditableEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name="country_id", nullable = false)
    private Country country;

    public Author(Country country, String name, String surname) {
        this.country = country;
        this.name = name;
        this.surname = surname;
    }

    public Author() {
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
