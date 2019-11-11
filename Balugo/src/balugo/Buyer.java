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
public class Buyer {
    private Name name;
    private String cellnum;
    private Double Dept;

    public Buyer() {
    }

    public Buyer(Name name, String cellnum, Double Dept,String fname,String lname) {
        this.name =new Name(fname,lname);
        this.cellnum = cellnum;
        this.Dept = Dept;
    }

    public Name getName() {
        return name;
    }

    public void setName(String fname,String lname) {
        this.name =new Name(fname,lname);
    }

    public String getCellnum() {
        return cellnum;
    }

    public void setCellnum(String cellnum) {
        this.cellnum = cellnum;
    }

    public Double getDept() {
        return Dept;
    }

    public void setDept(Double Dept) {
        this.Dept = Dept;
    }

    @Override
    public String toString() {
        return "Buyer{" + "name=" + name + ", cellnum=" + cellnum + ", Dept=" + Dept + '}';
    }
    
}
