/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author ASUS
 */
public class Employee implements Comparable<Employee>{
    private String id;
    private String employeeName;
    private int level;

    public Employee(String id, String employeeName, int level) {
        this.id = id;
        this.employeeName = employeeName;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int compareTo(Employee t) {
        return t.id.compareTo(this.id);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", employeeName=" + employeeName + ", level=" + level + '}';
    }

}
