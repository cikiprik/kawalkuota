package com.kawalkuota.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.sessions.Session;

public class SuperCtr {

    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("kawalkuotaPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public <T> List<T> getData(String eQuery) {
        List<T> o = new ArrayList<T>();
        try {
            o = em.createNamedQuery(eQuery + ".findAll").getResultList();
        } catch (Exception ex) {
            ex.getMessage();
        }

        return o;

    }

    public <T> List<T> getData(String eQuery, int start, int stop) {
        try {
            Query d = em.createNamedQuery(eQuery + ".findAll");
            if (start >= 0 && stop >= 0) {
                d.setFirstResult(start);
                d.setMaxResults(stop);
            }
            return d.getResultList();
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    public <T> List<T> getDataById(String eQuery, String by, String param, String paramValue, int start, int stop) {
        try {
            Query d = em.createNamedQuery(eQuery + ".findBy" + by).setParameter(param, paramValue);
            if (start >= 0 && stop >= 0) {
                d.setFirstResult(start);
                d.setMaxResults(stop);
            }
            return d.getResultList();
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }

    }

    public <T> List<T> getDataFromDto(String nativeQuery) {
        try {
            Query d = em.createNativeQuery(nativeQuery);
            return d.getResultList();
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }

    }

    public int getCount(String nameTb) {
        try {
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM " + nameTb + " c", Long.class);
            Long countryCount = query.getSingleResult();
            return (int) (long) countryCount;
        } catch (Exception ex) {
            ex.getMessage();
            return 0;
        }
    }

//tester
    public <T> void showAtribute(Class<T> entityClass) {
        Session session = ((EntityManagerImpl) em.getDelegate()).getSession();
        List<DatabaseMapping> datamap = (List) session.getDescriptor(entityClass).getMappings();
        for (DatabaseMapping dm : datamap) {
            System.out.println(" Attribute name : " + dm.getAttributeName());    // Class field name 
            System.out.println(" Column name : " + dm.getField().getName());     // Database Column name                    
        }
    }

    public <T> String getTableNameEntity(Class<T> entityClass) {
        Metamodel meta = em.getMetamodel();
        EntityType<T> entityType = meta.entity(entityClass);
        Table t = entityClass.getAnnotation(Table.class);
        String tableName = (t == null)
                ? entityType.getName().toUpperCase()
                : t.name();
        return tableName;
    }

    public String getAllTable() {
        String ename = "";
        Set<EntityType<?>> entities = em.getMetamodel().getEntities();
        for (EntityType entity : entities) {
            ename = ename + " - " + entity.getName();
        }
        return ename;
    }


    public boolean save(Object o) {
        boolean isSuccess = false;
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            isSuccess = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.getMessage();
        }
        return isSuccess;
    }

    public boolean update(Object o) {
        boolean isSuccess = false;
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
            isSuccess = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.getLocalizedMessage();
        }
        return isSuccess;
    }

    public boolean delete(Object o) {
        boolean isSuccess = false;
        try {
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();

            isSuccess = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.getMessage();
        }
        return isSuccess;
    }
}
