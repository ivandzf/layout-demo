package com.greenlabs.layoutdemo.core.entity;

import java.io.Serializable;

/**
 * Created by Ivan on 10/6/17
 */
public class UserRole extends BaseEntity implements Serializable {

    private String name;

    @Override
    public String toString() {
        return "UserRole{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        return name != null ? name.equals(userRole.name) : userRole.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
