package ca.ulaval.glo4002.carregistry.persistence;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ca.ulaval.glo4002.carregistry.domain.CarOwner;
import ca.ulaval.glo4002.carregistry.domain.CarRegistry;

public class HibernateCarRegistry implements CarRegistry {

  private EntityManagerProvider entityManagerProvider;

  public HibernateCarRegistry() {
    this.entityManagerProvider = new EntityManagerProvider();
  }

  @Override
  public CarOwner findOwner(int ownerId) {
    EntityManager entityManager = entityManagerProvider.getEntityManager();
    return entityManager.find(CarOwner.class, ownerId);
  }

  @Override
  public void insert(CarOwner owner) {
    EntityManager entityManager = entityManagerProvider.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    entityManager.persist(owner);

    transaction.commit();
  }

  @Override
  public void update(CarOwner owner) {
    EntityManager entityManager = entityManagerProvider.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    entityManager.merge(owner);

    transaction.commit();
  }

  @Override
  public Collection<CarOwner> findAllOwners() {
    EntityManager entityManager = entityManagerProvider.getEntityManager();
    Query query = entityManager.createQuery("SELECT e FROM CarOwner e");
    return (Collection<CarOwner>) query.getResultList();
  }

}
