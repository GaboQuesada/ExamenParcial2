package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Gabo Quesada
 */
public class BookDAOImpl implements BookDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public boolean deleteAll() {

        boolean isDeleted = false;

        session.beginTransaction();

        Collection Book = session.createCriteria(Book.class).list();

        for (Iterator i = Book.iterator(); i.hasNext();) {
            session.beginTransaction();
            Book book = (Book) i.next();
            session.delete(book);
            session.getTransaction().commit();

        }
        isDeleted = true;

        return isDeleted;
    }

    @Override
    public Book save(Book book) {
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> pacienteList = new ArrayList<>();

        pacienteList = session.createCriteria(Book.class).list();

        return pacienteList;
    }

}
