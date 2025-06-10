package com.mane.umakant.javaCore.immutable.smartCoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OurMapTest {
    public static void main(String[] args) {

        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(3);

        List<String> hobbyList=new ArrayList<>();
        hobbyList.add("Swimming_A");

        StudentAddress address=new StudentAddress("K", "Kagegaon", "Singli", "MH", 415304);

        ImmutableClass immutableClassObjectReferenceVariable=new ImmutableClass(1, "Umakant", set,hobbyList, address);
        System.out.println("Data inside ImmutableClass object:");
        System.out.println("original data inserted into obj: "+immutableClassObjectReferenceVariable);

        Set<Integer> referenceOfSetThroughReferenceObject = immutableClassObjectReferenceVariable.getSet();
        List<String> referenceOfListThroughReferenceObject  = immutableClassObjectReferenceVariable.getHobbies();
        StudentAddress referenceOfStudentAddressThroughReferenceObject  = immutableClassObjectReferenceVariable.getStudentAddress();

        System.out.println(" ");
        System.out.println("Test Case A(using getterMethod): Modify data using objectRefernceVariableOfMutableObject");

        System.out.println(" ");
        System.out.println(" ** referenceOfSetThroughReferenceObject ***");
        referenceOfSetThroughReferenceObject.add(20);
        System.out.println("referenceOfSetThroughReferenceObject: "+referenceOfSetThroughReferenceObject);
        System.out.println("referenceOfSetThroughReferenceObject through immutableClassObjectReferenceVariable: "+immutableClassObjectReferenceVariable.getSet());

        System.out.println(" Test Case A");
        System.out.println(" *** referenceOfListThroughReferenceObject ***");

        referenceOfListThroughReferenceObject.add("Cycling Case A");
        System.out.println("referenceOfListThroughReferenceObject: "+referenceOfListThroughReferenceObject);
        System.out.println("referenceOfListThroughReferenceObject through immutableClassObjectReferenceVariable: "+immutableClassObjectReferenceVariable.getHobbies());

        System.out.println(" ");
        System.out.println(" ** referenceOfStudentAddressThroughReferenceObject** ");
        referenceOfStudentAddressThroughReferenceObject.setStat("MaharastraA");;
        System.out.println("referenceOfStudentAddressThroughReferenceObject: "+referenceOfStudentAddressThroughReferenceObject);
        System.out.println("referenceOfStudentAddressThroughReferenceObject through immutableClassObjectReferenceVariable: "+immutableClassObjectReferenceVariable.getStudentAddress().getStat());
        System.out.println(" ");
        System.out.println(" ");


        System.out.println("Test Case B(using constructor): Modify data using objectRefernceVariableOfMutableObject");

        set.add(22);
        hobbyList.add("Swimming_B");
        address.setStat("State Name_B");
        System.out.println("   ");
        System.out.println("Modified data inserted into obj: "+immutableClassObjectReferenceVariable);

    }
}
