package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author Gabo Quesada
 */
public interface BookDAO {

    /**
     *
     * @return
     */
    public boolean deleteAll();

    /**
     *
     * @param book
     * @return
     */
    public Book save(Book book);

    /**
     *
     * @return
     */
    public List<Book> findAll();
}
