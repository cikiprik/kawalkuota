/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.servlet.ServletContext;



/**
 *
 * @author ahsanfile
 */
public class AppConfig {
    
    public static String getAppsProperty(ServletContext ctx, String propertyName) {
        try {
            Properties prop = new Properties();
            File appsPropertyFile = new File(ctx.getRealPath("WEB-INF/apps.properties"));
            prop.load(new FileInputStream(appsPropertyFile));
            return prop.getProperty(propertyName);
        } catch (Exception e) {
            return "";
        }
    }

}
