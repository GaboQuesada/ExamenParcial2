
package ac.cr.una.backend.service;

import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author Gabo Quesada
 */


public interface BookService {
    
    public boolean deleteAll();
    public Book save(Book book);
    public List<Book> findAll();
    public Float totalPriceAll();
}
