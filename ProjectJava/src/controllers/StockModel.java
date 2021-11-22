
package controllers;


public class StockModel 
{
    String p_id,name,vendor,p_date,e_date,qnty,price;

    public StockModel(String p_id, String name, String vendor, String p_date, String e_date, String qnty, String price) {
        this.p_id = p_id;
        this.name = name;
        this.vendor = vendor;
        this.p_date = p_date;
        this.e_date = e_date;
        this.qnty = qnty;
        this.price = price;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }

    public String getE_date() {
        return e_date;
    }

    public void setE_date(String e_date) {
        this.e_date = e_date;
    }

    public String getQnty() {
        return qnty;
    }

    public void setQnty(String qnty) {
        this.qnty = qnty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
}
