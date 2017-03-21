/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Objects;

/**
 *
 * @author jayesh
 */
public class orderitems {
    
    int Or_id,Qty;
    double Price,Total;
    String Tax;
    product p;
    
    
    public int getOr_id() {
        return Or_id;
    }

    public void setOr_id(int Or_id) {
        this.Or_id = Or_id;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getTax() {
        return Tax;
    }

    public void setTax(String Tax) {
        this.Tax = Tax;
    }

    public product getP() {
        return p;
    }

    public void setP(product p) {
        this.p = p;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final orderitems other = (orderitems) obj;
        if (this.Or_id != other.Or_id) {
            return false;
        }
        if (this.Qty != other.Qty) {
            return false;
        }
        if (Double.doubleToLongBits(this.Price) != Double.doubleToLongBits(other.Price)) {
            return false;
        }
        if (Double.doubleToLongBits(this.Total) != Double.doubleToLongBits(other.Total)) {
            return false;
        }
        if (!Objects.equals(this.Tax, other.Tax)) {
            return false;
        }
        if (!Objects.equals(this.p, other.p)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orderitems{" + "Or_id=" + Or_id + ", Qty=" + Qty + ", Price=" + Price + ", Total=" + Total + ", Tax=" + Tax + '}';
    }
 
}
