package ac.cr.una.backend.service;

import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author Gabo Quesada
 */
public interface AuthorService {

    /**
     *
     * @return
     */
    public boolean deleteAll();

    /**
     *
     * @param authorContact
     * @return
     */
    public AuthorContact save(AuthorContact authorContact);

    /**
     *
     * @return
     */
    public List<AuthorContact> findAll();

    /**
     *
     * @param name
     * @return
     */
    public Author findByName(String name);
}
