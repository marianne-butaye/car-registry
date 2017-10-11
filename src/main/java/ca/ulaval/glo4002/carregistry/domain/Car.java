package ca.ulaval.glo4002.carregistry.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String plate;

  public Car() {
  }

  public Car(String plate) {
    this.plate = plate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  @Override
  public String toString() {
    return "Car [id=" + id + ", plate=" + plate + "]";
  }

}
