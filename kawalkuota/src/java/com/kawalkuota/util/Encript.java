/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.mail.internet.MimeUtility;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
public class Encript {

    public static byte[] encode(byte[] b) throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    OutputStream b64os = MimeUtility.encode(baos, "base64");
    b64os.write(b);
    b64os.close();
    return baos.toByteArray();
  }

  public static byte[] decode(byte[] b) throws Exception {
    ByteArrayInputStream bais = new ByteArrayInputStream(b);
    InputStream b64is = MimeUtility.decode(bais, "base64");
    byte[] tmp = new byte[b.length];
    int n = b64is.read(tmp);
    byte[] res = new byte[n];
    System.arraycopy(tmp, 0, res, 0, n);
    return res;
  }
    
    public String encriptCode(String str){
        try {
            byte res1[] = Encript.encode(str.getBytes());
            return new String(res1);
        } catch (Exception ex) {
//            Logger.getLogger(Encript.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
    public String decriptCode(String str){
        try {
            byte res1[] = str.getBytes();
            byte res2[] = Encript.decode(res1);
            return new String(res2);
        } catch (Exception ex) {
//            Logger.getLogger(Encript.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
   
}
