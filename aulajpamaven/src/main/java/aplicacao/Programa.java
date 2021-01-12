package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		
		/* persistir dados no banco de dados, com JPA */
//		Pessoa p1 = new Pessoa("Carlos da Silva", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa("Joaquim Torres", "joaquim@gmail.com");
//		Pessoa p3 = new Pessoa("Ana Maria111111", "ana@gmail.com");
	
//		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();
		
		
		/* buscar dados no banco de dados, com JPA */
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		/* 
		 * remover dados no banco de dados, com JPA 
		 * para remover um dado do bd, a entidade deve estar monitorada,
		 * ou seja, deve ter acabado de ser persistida ou ter sido buscada (find)
		 * e antes do fechamento do EntityManager
		 */
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
