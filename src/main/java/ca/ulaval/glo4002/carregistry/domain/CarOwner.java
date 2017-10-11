package ca.ulaval.glo4002.carregistry.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CarOwner {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn
  private List<Car> cars = new LinkedList<>();

  public CarOwner() {
  }

  public CarOwner(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void addCar(Car car) {
    cars.add(car);
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "CarOwner [id=" + id + ", name=" + name + ", cars=" + cars + "]";
  }

}
