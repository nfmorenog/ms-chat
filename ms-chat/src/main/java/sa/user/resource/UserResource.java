package sa.user.resource;

import sa.user.model.User;
import sa.user.service.UserService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/users")
public class UserResource {

    @Context
    UriInfo uriInfo;

    @EJB
    UserService userService;

    @GET
    public List<User> getAllUsers(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return userService.getAllUsers(first, maxResult);
    }

    @GET
    @Path("{id}")
    public User getUserById(@PathParam("id") int id) {
        return userService.getUserById(id);
    }

    @POST
    public Response createUser(User user) {
        userService.createUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id, User user) {
        userService.updateUser(id, user);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        userService.deleteUser(id);
        return Response.status(Response.Status.OK).build();
    }
}
