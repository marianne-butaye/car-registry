package ca.ulaval.glo4002.carregistry.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ca.ulaval.glo4002.carregistry.domain.Car;
import ca.ulaval.glo4002.carregistry.services.RegistryService;
import ca.ulaval.glo4002.carregistry.services.dto.CarCreationRequest;

@Path("/owners/{ownerId}/cars/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

  private RegistryService registry;

  public CarResource(RegistryService registryService) {
    registry = registryService;
  }

  @POST
  public Response createCar(@PathParam("ownerId") int ownerId, CarCreationRequest request) {
    Car car = registry.addCar(ownerId, request);
    return Response.created(URI.create("/owners/" + ownerId + "/cars/" + car.getId())).build();
  }

}
