package ca.ulaval.glo4002.carregistry.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.ulaval.glo4002.carregistry.services.RegistryService;
import ca.ulaval.glo4002.carregistry.services.dto.CarOwnerDto;

@Path("/owners")
@Produces(MediaType.APPLICATION_JSON)
public class CarOwnerResource {
  private RegistryService registryService;

  public CarOwnerResource(RegistryService registryService) {
    this.registryService = registryService;
  }

  @GET
  public List<CarOwnerDto> getCarOwners() {
    return registryService.getCarOwners();
  }

}
