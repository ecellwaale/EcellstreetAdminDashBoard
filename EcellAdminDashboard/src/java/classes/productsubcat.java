/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author jayesh
 */
public class productsubcat {
    int pc2id,visible,sortorder;
    String title,AddedIp,ModifyIp;
    Date AddedDate,ModifyDate;
    productmaincat pcmc;
    Set<producttype> pct;

    public int getPc2id() {
        return pc2id;
    }

    public void setPc2id(int pc2id) {
        this.pc2id = pc2id;
    }

    
    public Set<producttype> getPct() {
        return pct;
    }

    public void setPct(Set<producttype> pct) {
        this.pct = pct;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getSortorder() {
        return sortorder;
    }

    public void setSortorder(int sortorder) {
        this.sortorder = sortorder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddedIp() {
        return AddedIp;
    }

    public void setAddedIp(String AddedIp) {
        this.AddedIp = AddedIp;
    }

    public String getModifyIp() {
        return ModifyIp;
    }

    public void setModifyIp(String ModifyIp) {
        this.ModifyIp = ModifyIp;
    }

    public Date getAddedDate() {
        return AddedDate;
    }

    public void setAddedDate(Date AddedDate) {
        this.AddedDate = AddedDate;
    }

    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date ModifyDate) {
        this.ModifyDate = ModifyDate;
    }

    public productmaincat getPcmc() {
        return pcmc;
    }

    public void setPcmc(productmaincat pcmc) {
        this.pcmc = pcmc;
    }

    @Override
    public String toString() {
        return "productsubcat{" + "pc2id=" + pc2id + ", visible=" + visible + ", sortorder=" + sortorder + ", title=" + title + ", AddedIp=" + AddedIp + ", ModifyIp=" + ModifyIp + ", AddedDate=" + AddedDate + ", ModifyDate=" + ModifyDate + '}';
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
        final productsubcat other = (productsubcat) obj;
        if (this.pc2id != other.pc2id) {
            return false;
        }
        if (this.visible != other.visible) {
            return false;
        }
        if (this.sortorder != other.sortorder) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.AddedIp, other.AddedIp)) {
            return false;
        }
        if (!Objects.equals(this.ModifyIp, other.ModifyIp)) {
            return false;
        }
        if (!Objects.equals(this.AddedDate, other.AddedDate)) {
            return false;
        }
        if (!Objects.equals(this.ModifyDate, other.ModifyDate)) {
            return false;
        }
        if (!Objects.equals(this.pcmc, other.pcmc)) {
            return false;
        }
        return true;
    }
    
    
    
}
