package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Gabo Quesada
 */
public class AuthorContactDAOImpl implements AuthorContactDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public boolean deleteAll() {
        boolean isDeleted = false;

        session.beginTransaction();

        Collection BookType = session.createCriteria(AuthorContact.class).list();

        for (Iterator i = BookType.iterator(); i.hasNext();) {
            session.beginTransaction();
            AuthorContact book = (AuthorContact) i.next();
            session.delete(book);
            session.getTransaction().commit();

        }
        isDeleted = true;

        return isDeleted;
    }

    @Override
    public AuthorContact save(AuthorContact authorContact) {
        session.beginTransaction();
        session.save(authorContact);
        session.getTransaction().commit();

        return authorContact;
    }

    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> pacienteList = new ArrayList<>();

        pacienteList = session.createCriteria(AuthorContact.class).list();

        return pacienteList;
    }
}
