/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author jayesh
 */
public class productmodel {
    
    int pc4id,visible,sortorder;
    String title,image,AddedIp,ModifyIp;
    Date AddedDate,ModifyDate;
    producttype pct;
    Set<product> pc;

    public Set<product> getPc() {
        return pc;
    }

    public void setPc(Set<product> pc) {
        this.pc = pc;
    }

    
    public int getPc4id() {
        return pc4id;
    }

    public void setPc4id(int pc4id) {
        this.pc4id = pc4id;
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

    public producttype getPct() {
        return pct;
    }

    public void setPct(producttype pct) {
        this.pct = pct;
    }

    @Override
    public String toString() {
        return "productmodel{" + "pc4id=" + pc4id + ", visible=" + visible + ", sortorder=" + sortorder + ", title=" + title + ", image=" + image + ", AddedIp=" + AddedIp + ", ModifyIp=" + ModifyIp + ", AddedDate=" + AddedDate + ", ModifyDate=" + ModifyDate + '}';
    }
    
    
    
}
