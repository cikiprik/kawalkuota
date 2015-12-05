/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.dao;

import com.kawalkuota.entity.User;
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
      
      public User GetUser(int o) {
         try {
            User data = (User) emApp.createNamedQuery("User.findByIdUser")
                    .setParameter("idUser", o)
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
            emApp.remove(o);
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
