package ac.cr.una.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Gabo Quesada
 */
@Entity
@Table(name = "book", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "idBook")})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBook", unique = true, nullable = false)
    private int idBook;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor", nullable = false)
    private Author idauthor;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idType", nullable = false)
    private BookType idType;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "dateRelease", unique = true, nullable = false)
    private Date dateRelease;
    @Column(name = "price", unique = true, nullable = false)
    private Float price;
    
    /**
     *
     */
    public Book() {
    }

    /**
     *
     * @param idBook
     * @param idauthor
     * @param idType
     * @param name
     * @param dateRelease
     * @param price
     */
    public Book(int idBook, Author idauthor, BookType idType, String name, Date dateRelease, Float price) {
        this.idBook = idBook;
        this.idauthor = idauthor;
        this.idType = idType;
        this.name = name;
        this.dateRelease = dateRelease;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getIdBook() {
        return idBook;
    }

    /**
     *
     * @param idBook
     */
    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    /**
     *
     * @return
     */
    public Author getIdauthor() {
        return idauthor;
    }

    /**
     *
     * @param idauthor
     */
    public void setIdauthor(Author idauthor) {
        this.idauthor = idauthor;
    }

    /**
     *
     * @return
     */
    public BookType getIdType() {
        return idType;
    }

    /**
     *
     * @param idType
     */
    public void setIdType(BookType idType) {
        this.idType = idType;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Date getDateRelease() {
        return dateRelease;
    }

    /**
     *
     * @param dateRelease
     */
    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    /**
     *
     * @return
     */
    public Float getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idBook;
        hash = 59 * hash + Objects.hashCode(this.idauthor);
        hash = 59 * hash + Objects.hashCode(this.idType);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.dateRelease);
        hash = 59 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.idBook != other.idBook) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.idauthor, other.idauthor)) {
            return false;
        }
        if (!Objects.equals(this.idType, other.idType)) {
            return false;
        }
        if (!Objects.equals(this.dateRelease, other.dateRelease)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", idauthor=" + idauthor + ", idType=" + idType + ", name=" + name + ", dateRelease=" + dateRelease + ", price=" + price + '}';
    }

   
}
