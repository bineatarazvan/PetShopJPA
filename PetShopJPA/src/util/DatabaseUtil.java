package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;
import model.PersonalMedical;
import model.Programare;

public class DatabaseUtil {
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;

	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("PetShopJPA");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void saveAnimal(Animal animal) {
		entityManager.persist(animal);
	}

	public void deleteAnimal(Animal animal) {
		Animal currentAnimal =animal;
		if (!entityManager.contains(animal)) {
		    currentAnimal = entityManager.merge(animal);
		}
		entityManager.remove(currentAnimal);
	}

	
	public void saveProgramare(Programare programare) {
		entityManager.persist(programare);
	}
	

	public void deleteProgramare(Programare programare) {
		entityManager.remove(programare);
	}
	public void savePersonalMedical(PersonalMedical personalMedical) {
		entityManager.persist(personalMedical);
	}

	public void deletePersonalMedical(PersonalMedical personalMedical) {
		entityManager.remove(personalMedical);
	}
	public void startTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	public void closeEntityManager() {
		entityManager.close();
	}


	public void printAllAnimalsFromDB() {
		List<Animal>results = entityManager.createNativeQuery("Select * from PetShop.Animal", Animal.class).getResultList();
		for (Animal animal : results) {
			System.out.println("Animal :" + animal.getName() + " has ID: "+ animal.getIdAnimal());
		}
	}
	public void printAllProgramariFromDB() {
		List<Programare>results = entityManager.createNativeQuery("Select * from PetShop.Programare", Programare.class).getResultList();
		for (Programare programare : results) {
			System.out.println("Programarea din data de :" + programare.getDataProgramare() +"de  la ora" + programare.getOraProgramare() +" has ID: "+ programare.getIdProgramare());
		}
	}
	public void printAllPersonalMedicalFromDB() {
		List<PersonalMedical>results = entityManager.createNativeQuery("Select * from PetShop.PersonalMedical", PersonalMedical.class).getResultList();
		for (PersonalMedical personalMedical : results) {
			System.out.println("Doctorul :" + personalMedical.getFirstName() + " has ID: "+ personalMedical.getIdPersonalMedical());
		}
	}
}
