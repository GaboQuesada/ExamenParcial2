package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.BookType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Gabo Quesada
 */
public class BookTypeDAOImpl implements BookTypeDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public boolean deleteAll() {

        boolean isDeleted = false;

        session.beginTransaction();

        Collection BookType = session.createCriteria(BookType.class).list();

        for (Iterator i = BookType.iterator(); i.hasNext();) {
            session.beginTransaction();
            BookType book = (BookType) i.next();
            session.delete(book);
            session.getTransaction().commit();

        }
        isDeleted = true;

        return isDeleted;
    }

    @Override
    public BookType save(BookType bookType) {
        session.beginTransaction();
        session.save(bookType);
        session.getTransaction().commit();

        return bookType;
    }

    @Override
    public BookType findByName(String name) {
        BookType bookType = null;
        Query query = session.createQuery("from BookType where type = :type ");
        query.setParameter("type", name);

        if (query.list().size() > 0) {
            bookType = (BookType) query.list().get(0);
        }

        return bookType;
    }

}
