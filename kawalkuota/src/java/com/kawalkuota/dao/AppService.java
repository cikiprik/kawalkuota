/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.dao;

import com.kawalkuota.entity.User;
import com.kawalkuota.util.StringUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LENOVO
 */
@Named
@Stateless
public class AppService {
      @PersistenceContext(unitName = "kawalkuotaPU")
      EntityManager emApp;
      
      public Object GetById(String entityName, int id) {
         try {
            Object data = (Object) emApp.createNamedQuery(entityName+".findById"+entityName)
                    .setParameter("id"+entityName, id)
                    .getSingleResult();
            return data;
        } catch (Exception e) {
            return null;
        }
    }
    public <T> List<T> GetBy(String entityName, String findBy, Object param, int firstResult, int maxResult) {
         try {
            List<T> data = emApp.createNamedQuery(StringUtil.Capital(entityName)+".findBy"+StringUtil.Capital(findBy))
                    .setParameter(StringUtil.unCapital(findBy), param)
                    .setFirstResult(firstResult)
                    .setMaxResults(maxResult)
                    .getResultList();
            return data;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Object GetBySingle(String entityName, String findBy, Object param) {
         try {
            Object data = (Object) emApp.createNamedQuery(StringUtil.Capital(entityName)+".findBy"+StringUtil.Capital(findBy))
                    .setParameter(StringUtil.unCapital(findBy), param)
                    .setFirstResult(0)
                    .setMaxResults(1)
                    .getSingleResult();
            return data;
        } catch (Exception e) {
            return null;
        }
    }
      
       public Object Simpan(Object o) {
        try {
            emApp.persist(o);
            emApp.flush();
        } catch (Exception err) {
            System.out.println(err);
        } finally {
            emApp.clear();
        }
        return o;
    }
       public Object Update(Object o) {
        try {
            emApp.merge(o);
            emApp.flush();
            
        } catch (Exception err) {
            System.out.println(err);
        } finally {
            emApp.clear();
        }
        return o;
    }
       public String Hapus(Object o) {
           String x = null ;
        try {
            emApp.remove(emApp.merge(o));
            emApp.flush();
            x = "sukses";
            
        } catch (Exception err) {
            System.out.println(err);
            x = "gagal";
        } finally {
            emApp.clear();
        }
        return x;
    }
}
