package notifications.boldo.py.org.pti.controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import notifications.boldo.py.org.pti.entities.Patient;

import java.util.List;
import notifications.boldo.py.org.pti.services.PatientService;

@Path("/patient")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientController {

    @Inject
    PatientService patientService;


    @GET
    public List<Patient> getPatients() {
        return patientService.listPatients();
    }

    @GET
    @Path("/{id}")
    public Patient getPatient(@PathParam("id") Long id) {
        return patientService.find(id);
    }

    @GET
    @Path("/{patient_id}")
    public Patient getPatientByPatientId(@PathParam("patient_id") String id) {
        return patientService.findById(id);
    }

    @POST
    public Response createPatient(Patient patient) {
        patientService.create(patient); //TODO le falta el Id
        return Response.status(Response.Status.CREATED).entity(patient).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") int id, Patient patient) {
        patientService.update(patient);
        return Response.ok(patient).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") Long id) {
        patientService.delete(id);
        return Response.ok().build();
    }

}
