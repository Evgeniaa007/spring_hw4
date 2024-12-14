package com.example.seminar4_hw.model;

import lombok.Data;

import java.util.Objects;
@Data
public class User {

    private int id;
    private String firstName;
    private String lastName;
}
// ломбок взял всё это на себя
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return id == user.id && Objects.equals(firstName, user.getFirstName()) && Objects.equals(lastName, user.getLastName());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstName, lastName);
//    }


    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String fisrtName) {
//        this.firstName = fisrtName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }



