package notifications.boldo.py.org.pti.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import notifications.boldo.py.org.pti.JsonWebToken;
import notifications.boldo.py.org.pti.entities.Device;
import notifications.boldo.py.org.pti.services.DeviceService;

@Path("/device")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeviceController {
    JsonWebToken jwt;

    @Inject
    DeviceService deviceService;


    //@HeaderParam("Authorization")
    //public void setJwt(String header) {
    //    this.jwt = new JsonWebToken(header);
    //}

    @GET
    public List<Device> getDevices() {
        return deviceService.listDevices();
    }

    @GET
    @Path("/{id}")
    public Device getDevice(@PathParam("id") Long id) {
        return deviceService.find(id);
    }

    @GET
    @Path("/patient/{patient_id}")
    public List<Device> getDeviceByPatientFhierId(@PathParam("patient_id") String id) {
        return deviceService.findByFhierId(id);
    }

    @POST
    public Response createDevice(Device patient) {
        deviceService.create(patient); //TODO le falta el Id
        return Response.status(Response.Status.CREATED).entity(patient).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDevice(@PathParam("id") int id, Device patient) {
        deviceService.update(patient);
        return Response.ok(patient).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDevice(@PathParam("id") Long id) {
        deviceService.delete(id);
        return Response.ok().build();
    }
}
