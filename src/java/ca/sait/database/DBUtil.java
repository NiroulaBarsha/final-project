package ca.sait.database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("FinalPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
