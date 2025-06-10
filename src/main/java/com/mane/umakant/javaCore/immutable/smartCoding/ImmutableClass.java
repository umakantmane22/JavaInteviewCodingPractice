//https://www.youtube.com/watch?v=lO5r8EBdvYo/**/
package com.mane.umakant.javaCore.immutable.smartCoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// immutable class should be final because it can not be extendible
public final class ImmutableClass {
    // All variable should be final because of contents  can not be changed.
    private final int id;
    private final String name;
    private final Set<Integer> set;
    private final List<String> hobbies;
    private final StudentAddress studentAddress;

    // provide parameterised constructor
    public ImmutableClass(int id, String name, Set<Integer> set, List<String> hobbies, StudentAddress studentAddress) {
        this.id = id;
        this.name = name;

        // Case A:
        //this.set = set;
        //this.hobbies = hobbies;
        //this.studentAddress = studentAddress;

        //  Case B:
        this.set=new HashSet<>(set);
        this.hobbies=new ArrayList<>(hobbies);
        this.studentAddress=new StudentAddress(studentAddress);
    }
    // dont provide setter methods. Only provide getter methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Integer> getSet() {
        return set;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", set=" + set +
                ", hobbies=" + hobbies +
                ", studentAddress=" + studentAddress +
                '}';
    }
}
