package dao;

import domain.Home;

import javax.persistence.EntityTransaction;
import java.util.List;

public class HomeDao {
    public static List<Home> getHomes(){
        return Manager.getManagerInstance().createQuery("Select h From Home h", Home.class).getResultList();
    }

    public static Home getHomeById(int id){
        return Manager.getManagerInstance().createQuery("Select h From Home h where h.id=:id", Home.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public static Boolean createHome(Home home){
        EntityTransaction tx = Manager.getManagerInstance().getTransaction();
        tx.begin();
        try {
            Manager.getManagerInstance().persist(home);
        } catch (Exception e) {
            return false;
        }
        tx.commit();
        return true;
    }
}
