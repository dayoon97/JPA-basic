package com.mycom.hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
//			Member findMember = em.find(Member.class, 1L);
			
			List<Member> result = em.createQuery("select m from Member as m", Member.class)
					//조회 시작위치(0부터 시작)
					.setFirstResult(5)
					//조회할 데이터 수
					.setMaxResults(8)
					.getResultList();
			
			for (Member member: result) {
				System.out.println("member.name = " + member.getName());
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
			emf.close();
		
	}

}
