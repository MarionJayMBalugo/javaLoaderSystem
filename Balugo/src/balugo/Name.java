/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balugo;

/**
 *
 * @author 2ndyrGroupC
 */
public class Name {
    private String fname;
    private String lname;

    public Name(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Name() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Name{" + "fname=" + fname + ", lname=" + lname + '}';
    }
    
}
