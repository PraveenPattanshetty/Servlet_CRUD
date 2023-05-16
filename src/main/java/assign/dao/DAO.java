package assign.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import assign.dto.DTO;

public class DAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(DTO dto) {
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();
	}

	public DTO fetch(int id) {
		return entityManager.find(DTO.class, id);
	}

	public void delete(DTO dto) {
		entityTransaction.begin();
		entityManager.remove(dto);
		entityTransaction.commit();
	}

	public List<DTO> fetchAll() {
		return entityManager.createQuery("select x from DTO x").getResultList();
	}

	public void update(DTO dto) {
		entityTransaction.begin();
		entityManager.merge(dto);
		entityTransaction.commit();

	}

	public DTO fetch(String name) {
		List<DTO> listdto = entityManager.createQuery("select x from DTO x where name=?1").setParameter(1, name)
				.getResultList();
		if (listdto.isEmpty()) {
			return null;
		} else {
			return listdto.get(0);
		}
	}

}
