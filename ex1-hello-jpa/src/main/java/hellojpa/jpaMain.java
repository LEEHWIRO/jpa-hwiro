package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // insert
            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloB");
//
            // 영속

//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();

//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (findMember1 == findMember2)); // true

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
            System.out.println("-----------------------------");


            // select
//            Member findMember = em.find(Member.class, 1L);

            // update
//            findMember.setName("HelloJPA");

            // delete
//            em.remove(findMember);

            //JPQL
//            List<Member> reult = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : reult) {
//                System.out.println("member.name = " + member.getName());
//            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
