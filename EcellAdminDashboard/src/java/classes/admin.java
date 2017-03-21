/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
//import java.util.Objects;

/**
 *
 * @author neal
 */
public class admin extends person {

  
    String mshost,msusername,mspass,modifyip;
    Date backupdt;
    public admin(int Id,String Name, String Password, String Email) {
        super();
    }

    public admin() {
        super();
//        this.aid = aid;
//        this.mshost = mshost;
//        this.msusername = msusername;
//        this.mspass = mspass;
//        this.backupdt = backupdt;
    }

   

    public String getModifyip() {
        return modifyip;
    }

    public void setModifyip(String modifyip) {
        this.modifyip = modifyip;
    }

    

    public String getMshost() {
        return mshost;
    }

    public void setMshost(String mshost) {
        this.mshost = mshost;
    }

    public String getMsusername() {
        return msusername;
    }

    public void setMsusername(String msusername) {
        this.msusername = msusername;
    }

    public String getMspass() {
        return mspass;
    }

    public void setMspass(String mspass) {
        this.mspass = mspass;
    }

    public Date getBackupdt() {
        return backupdt;
    }

    public void setBackupdt(Date backupdt) {
        this.backupdt = backupdt;
    }

    @Override
    public String toString() {
        return "admin{" + ", mshost=" + mshost + ", msusername=" + msusername + ", mspass=" + mspass + ", backupdt=" + backupdt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final admin other = (admin) obj;
//        
//        if (!Objects.equals(this.mshost, other.mshost)) {
//            return false;
//        }
//        if (!Objects.equals(this.msusername, other.msusername)) {
//            return false;
//        }
//        if (!Objects.equals(this.mspass, other.mspass)) {
//            return false;
//        }
//        if (!Objects.equals(this.backupdt, other.backupdt)) {
//            return false;
//        }
//        return true;
//    }

   
   
    
}
