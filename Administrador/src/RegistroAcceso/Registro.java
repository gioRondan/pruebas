/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RegistroAcceso;

/**
 *
 * @author giovani.rondan
 */
public class Registro {
    private String ip;
    private String url;
    private String browser;
    private String so;

    public Registro(String ip, String url, String browser, String so) {
        this.ip = ip;
        this.url = url;
        this.browser = browser;
        this.so = so;
    }

    public String getIp() {
        return ip;
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getSo() {
        return so;
    }
    
}
