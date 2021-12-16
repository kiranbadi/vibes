package com.vibes.kb.model;

import java.util.List;
import java.util.Objects;

public class PersonModel {

    private String personName;
    private List<String> personMobile;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public List<String> getPersonMobile() {
        return personMobile;
    }

    public void setPersonMobile(List<String> personMobile) {
        this.personMobile = personMobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonModel)) return false;
        PersonModel that = (PersonModel) o;
        return personName.equals(that.personName) && personMobile.equals(that.personMobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, personMobile);
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "personName='" + personName + '\'' +
                ", personMobile=" + personMobile +
                '}';
    }
}
