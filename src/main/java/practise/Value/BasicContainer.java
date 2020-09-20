package src.practise.Value;

import java.util.*;

public class BasicContainer {
    public static void main(String[] args){
        Collection c=new HashSet();
        c.add("hello");
        c.add(new Name("f1","l1"));
        c.add(new Integer(100));
        c.remove("hello");
        c.remove(new Integer(100));
        System.out.println(c.remove(new Name("f1","l1")));
        System.out.println(c);

        List l1=new LinkedList();
        l1.add(new Name("Karl","M"));
        l1.add(new Name("Steven","Lee"));
        l1.add(new Name("John","O"));
        l1.add(new Name("Tom","M"));
        l1.add(new Name("Karsa","Fu"));
        l1.add(new Name("Vn","AN"));
        System.out.println(l1);
        Collections.sort(l1);
        System.out.println(l1);

        Name vn=new Name("v","n");
        System.out.println(vn.getFirstName());
        System.out.println(vn.getLastName());
    }
}

 class Name implements Comparable{
    private String firstName,lastName;
     public Name(String firstName,String lastName){
         this.firstName=firstName;
         this.lastName=lastName;
     }

     public Name() {

     }

     public String getFirstName() {
         return firstName;
     }

     public String getLastName() {
         return lastName;
     }

     @Override
     public String toString() {
         return "Name{" +
                 "firstName='" + firstName + '\'' +
                 ", lastName='" + lastName + '\'' +
                 '}';
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Name name = (Name) o;

         if (firstName != null ? !firstName.equals(name.firstName) : name.firstName != null) return false;
         return lastName != null ? lastName.equals(name.lastName) : name.lastName == null;
     }

     @Override
     public int hashCode() {
         int result = firstName != null ? firstName.hashCode() : 0;
         result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
         return result;
     }

     @Override
     public int compareTo(Object o) {
         Name n= (Name) o;
         int lastCmp=lastName.compareTo(n.lastName);
         return
                 (lastCmp!=0?lastCmp:firstName.compareTo(n.firstName));
     }
 }
