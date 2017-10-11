package ca.ulaval.glo4002.carregistry.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import ca.ulaval.glo4002.carregistry.domain.Car;
import ca.ulaval.glo4002.carregistry.domain.CarFactory;
import ca.ulaval.glo4002.carregistry.domain.CarOwner;
import ca.ulaval.glo4002.carregistry.domain.CarRegistry;
import ca.ulaval.glo4002.carregistry.services.dto.CarCreationRequest;
import ca.ulaval.glo4002.carregistry.services.dto.CarOwnerDto;

public class RegistryService {

  private CarRegistry carRegistry;
  private CarFactory carFactory;
  private CarOwnerAssember carOwnerAssember;

  public RegistryService(CarRegistry carRegistry) {
    this.carRegistry = carRegistry;
    this.carFactory = new CarFactory();
    this.carOwnerAssember = new CarOwnerAssember();
  }

  public Car addCar(int ownerId, CarCreationRequest request) {
    CarOwner owner = this.carRegistry.findOwner(ownerId);

    Car car = this.carFactory.createNewCar(request.carPlate);
    owner.addCar(car);

    carRegistry.update(owner);
    return car;

  }

  public List<CarOwnerDto> getCarOwners() {
    Collection<CarOwner> carOwners = this.carRegistry.findAllOwners();
    return carOwners.stream().map(carOwnerAssember::toDto).collect(Collectors.toList());
  }

}
