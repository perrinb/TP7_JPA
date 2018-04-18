package dao;

import domain.Person;

import javax.persistence.EntityTransaction;
import java.util.List;

public class PersonDao {
    public static List<Person> getPersons(){
        return Manager.getManagerInstance().createQuery("Select p From Person p", Person.class).getResultList();
    }

    public static Person getPersonById(int id){
        return Manager.getManagerInstance().createQuery("Select p From Person p where p.id=:id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public static Boolean createPerson(Person person){
        EntityTransaction tx = Manager.getManagerInstance().getTransaction();
        tx.begin();
        try {
            Manager.getManagerInstance().persist(person);
        } catch (Exception e) {
            return false;
        }
        tx.commit();
        return true;
    }
}
