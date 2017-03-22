/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Utility.specialoffer;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


public class product {
    int pid,visible,Isfeatured,OnSale,inventory,views,rating,sortorder,cod;
    String Title,skucode,topcat1,topcat2,topcat3,topcat4,compatible_device,Description,AddedIp,ModifyIp;
    double costprice,discount,sellprice;
    Date AddedDate,ModifyDate;
    productmodel pcmd;
    Set<product_images> pci;
    Set<orderitems> odi;
    Set<specialoffer> spo;

    public Set<specialoffer> getSpo() {
        return spo;
    }

    public void setSpo(Set<specialoffer> spo) {
        this.spo = spo;
    }

    public Set<orderitems> getOdi() {
        return odi;
    }

    public void setOdi(Set<orderitems> odi) {
        this.odi = odi;
    }
    
    
    public String getAddedIp() {
        return AddedIp;
    }

    public void setAddedIp(String AddedIp) {
        this.AddedIp = AddedIp;
    }
    

    @Override
    public String toString() {
        return "product{" + "pid=" + pid + ", visible=" + visible + ", Isfeatured=" + Isfeatured + ", OnSale=" + OnSale + ", inventory=" + inventory + ", views=" + views + ", rating=" + rating + ", sortorder=" + sortorder + ", cod=" + cod + ", Title=" + Title + ", skucode=" + skucode + ", topcat1=" + topcat1 + ", topcat2=" + topcat2 + ", topcat3=" + topcat3 + ", topcat4=" + topcat4 + ", compatible_device=" + compatible_device + ", Description=" + Description + ", ModifyIp=" + ModifyIp + ", costprice=" + costprice + ", discount=" + discount + ", sellprice=" + sellprice + ", AddedDate=" + AddedDate + ", ModifyDate=" + ModifyDate + '}';
    }
    
    public Set<product_images> getPci() {
        return pci;
    }

    public void setPci(Set<product_images> pci) {
        this.pci = pci;
    }
    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getIsfeatured() {
        return Isfeatured;
    }

    public void setIsfeatured(int Isfeatured) {
        this.Isfeatured = Isfeatured;
    }

    public int getOnSale() {
        return OnSale;
    }

    public void setOnSale(int OnSale) {
        this.OnSale = OnSale;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSortorder() {
        return sortorder;
    }

    public void setSortorder(int sortorder) {
        this.sortorder = sortorder;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getSkucode() {
        return skucode;
    }

    public void setSkucode(String skucode) {
        this.skucode = skucode;
    }

    public String getTopcat1() {
        return topcat1;
    }

    public void setTopcat1(String topcat1) {
        this.topcat1 = topcat1;
    }

    public String getTopcat2() {
        return topcat2;
    }

    public void setTopcat2(String topcat2) {
        this.topcat2 = topcat2;
    }

    public String getTopcat3() {
        return topcat3;
    }

    public void setTopcat3(String topcat3) {
        this.topcat3 = topcat3;
    }

    public String getTopcat4() {
        return topcat4;
    }

    public void setTopcat4(String topcat4) {
        this.topcat4 = topcat4;
    }

    public String getCompatible_device() {
        return compatible_device;
    }

    public void setCompatible_device(String compatible_device) {
        this.compatible_device = compatible_device;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getModifyIp() {
        return ModifyIp;
    }

    public void setModifyIp(String ModifyIp) {
        this.ModifyIp = ModifyIp;
    }

    public double getCostprice() {
        return costprice;
    }

    public void setCostprice(double costprice) {
        this.costprice = costprice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSellprice() {
        return sellprice;
    }

    public void setSellprice(double sellprice) {
        this.sellprice = sellprice;
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

    public productmodel getPcmd() {
        return pcmd;
    }

    public void setPcmd(productmodel pcmd) {
        this.pcmd = pcmd;
    }
    
    
    
    
}