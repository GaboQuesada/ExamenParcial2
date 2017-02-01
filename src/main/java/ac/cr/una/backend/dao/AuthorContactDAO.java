package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author Gabo Quesada
 */
public interface AuthorContactDAO {

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
}
