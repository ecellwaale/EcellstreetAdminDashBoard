/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;



/**
 *
 * @author neal
 */
public class person {
    int Id;
    String Name,Password,Email;

    public person() {
//        this.Id = Id;
//        this.Name = Name;
//        this.Password = Password;
//        this.Email = Email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "person{" + "Id=" + Id + ", Name=" + Name + ", Password=" + Password + ", Email=" + Email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

   
    
    
}
