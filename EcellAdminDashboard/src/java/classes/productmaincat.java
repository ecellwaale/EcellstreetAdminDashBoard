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
public class productmaincat {
    int pc1id,visible,sortorder;
    String title,image,AddedIp,ModifyIp;
    Date AddedDate,ModifyDate;
    Set<productsubcat> pcsc;

    public Set<productsubcat> getPcsc() {
        return pcsc;
    }

    public void setPcsc(Set<productsubcat> pcsc) {
        this.pcsc = pcsc;
    }

   

    public int getPc1id() {
        return pc1id;
    }

    public void setPc1id(int pc1id) {
        this.pc1id = pc1id;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final productmaincat other = (productmaincat) obj;
        if (this.pc1id != other.pc1id) {
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
        return true;
    }

    @Override
    public String toString() {
        return "productmaincat{" + "pc1id=" + pc1id + ", visible=" + visible + ", sortorder=" + sortorder + ", title=" + title + ", image=" + image + ", AddedIp=" + AddedIp + ", ModifyIp=" + ModifyIp + ", AddedDate=" + AddedDate + ", ModifyDate=" + ModifyDate + '}';
    }
    
   
    
}
