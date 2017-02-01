package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.BookTypeDAOImpl;
import ac.cr.una.backend.model.BookType;
import ac.cr.una.backend.service.BookTypeService;
import ac.cr.una.backend.service.BookTypeServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Gabo Quesada
 */
@Path("booktypes")
public class BookTypeWebservice {

    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;
    @Context
    private UriInfo context;

    public BookTypeWebservice() {
    }

   

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookType getPacientebyName(@PathParam("name") String name) {
        BookType student = null;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        student = bookTypeService.findByName(name);

        return student;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookType createStudent(BookType student) {

        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        student = bookTypeService.save(student);

        return student;
    }
    
    @DELETE
    @Path("/")
    public boolean deleteStudent() {
        boolean result;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        result= bookTypeService.deleteAll();
      

        return result;
    }
}
