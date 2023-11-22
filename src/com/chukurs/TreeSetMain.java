package com.chukurs;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        //can use NavigableSet and SortedSet interface

        //NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> mySort = Comparator.comparing((s)-> s.getName());
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        //elements MUST implement 'comparable'
        sorted.forEach((s)-> System.out.println(s));
        /*
        class com.chukurs.Contact cannot be cast to class java.lang.Comparable (com.chukurs.Contact is in unnamed
        module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
        */
        //can bypass this by passing 'comparator' to constructor


        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach((s)->justNames.add(s.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        System.out.println("-".repeat(20));
        fullSet.forEach(System.out::println);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
       fullList.sort(sorted.comparator());
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(20));
        fullList.forEach(System.out::println);

        System.out.println("-".repeat(20)+ " min max");
        //requires comparable for contact.
        Contact min = Collections.min(fullSet,mySort);
        Contact max = Collections.max(fullSet,mySort);
        System.out.println(min);
        System.out.println(max);
        System.out.println("-".repeat(20)+ " first last");
        Contact first = fullSet.first();
        Contact last = fullSet.last();
        System.out.println(first);
        System.out.println(last);

        //create a copy of set
        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First elem: " + copiedSet.pollFirst());
        System.out.println("Last elem: " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("-".repeat(20));


    }
}
