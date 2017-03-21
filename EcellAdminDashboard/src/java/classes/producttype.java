/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class producttype {
    int pc3id,visible,sortorder;
    String title,image,AddedIp,ModifyIp;
    Date AddedDate,ModifyDate;
    productsubcat pcsc;
    Set<productmodel> pcmd;

    
    public Set<productmodel> getPcmd() {
        return pcmd;
    }

    public void setPcmd(Set<productmodel> pcmd) {
        this.pcmd = pcmd;
    }

    public int getPc3id() {
        return pc3id;
    }

    public void setPc3id(int pc3id) {
        this.pc3id = pc3id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public productsubcat getPcsc() {
        return pcsc;
    }

    public void setPcsc(productsubcat pcsc) {
        this.pcsc = pcsc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "producttype{" + "pc3id=" + pc3id + ", visible=" + visible + ", sortorder=" + sortorder + ", title=" + title + ", image=" + image + ", AddedIp=" + AddedIp + ", ModifyIp=" + ModifyIp + ", AddedDate=" + AddedDate + ", ModifyDate=" + ModifyDate + '}';
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
        final producttype other = (producttype) obj;
        if (this.pc3id != other.pc3id) {
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
        if (!Objects.equals(this.image, other.image)) {
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
        if (!Objects.equals(this.pcsc, other.pcsc)) {
            return false;
        }
        if (!Objects.equals(this.pcmd, other.pcmd)) {
            return false;
        }
        return true;
    }
    
    
    
}
