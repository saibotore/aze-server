package de.tgehring.aze.server.servlet;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import de.tgehring.aze.server.entities.Person;
import de.tgehring.aze.server.entities.WorkingTime;
import de.tgehring.aze.server.service.CRUDService;

@Path("/crud")
public class CRUDServlet {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/person")
    public Response createPerson(JAXBElement<Person> person) {
        CRUDService.getInstance().createPerson(person.getValue());
        String result = "Person saved : " + person.getValue();
        return Response.status(201).entity(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/person")
    public Response updatePerson(JAXBElement<Person> person) {
        CRUDService.getInstance().updatePerson(person.getValue());
        String result = "Person edited : " + person.getValue();
        return Response.status(201).entity(result).build();
    }

    @DELETE
    @Path("/person/{id}")
    public Response deletePerson(@PathParam("id") long id) {
        CRUDService.getInstance().deletePerson(id);
        String result = "Person deleted : ID=" + id;
        return Response.status(201).entity(result).build();
    }

    @GET
    @Produces("application/json")
    @Path("/person/{id}")
    public Person readPerson(@PathParam("id") long id) {
        return CRUDService.getInstance().readPerson(id);
    }

    @GET
    @Produces("application/json")
    @Path("/person")
    public List<Person> readPerson() {
        return CRUDService.getInstance().readPerson();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/workingtime")
    public Response createWorkingTime(JAXBElement<WorkingTime> workingtime) {
        CRUDService.getInstance().createWorkingTime(workingtime.getValue());
        String result = "WorkingTime saved : " + workingtime.getValue();
        return Response.status(201).entity(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/workingtime")
    public Response updateWorkingTime(JAXBElement<WorkingTime> workingtime) {
        CRUDService.getInstance().updateWorkingTime(workingtime.getValue());
        String result = "WorkingTime edited : " + workingtime.getValue();
        return Response.status(201).entity(result).build();
    }

    @DELETE
    @Path("/workingtime/{id}")
    public Response deleteWorkingTime(@PathParam("id") long id) {
        CRUDService.getInstance().deleteWorkingTime(id);
        String result = "WorkingTime deleted : ID=" + id;
        return Response.status(201).entity(result).build();
    }

    @GET
    @Produces("application/json")
    @Path("/workingtime/{id}")
    public WorkingTime readWorkingTime(@PathParam("id") long id) {
        return CRUDService.getInstance().readWorkingTime(id);
    }

    @GET
    @Produces("application/json")
    @Path("/workingtime")
    public List<WorkingTime> readWorkingTime() {
        return CRUDService.getInstance().readWorkingTime();
    }
}
