package kim.christopher;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class MySetTest {

    MySet<String> mySet;
    ArrayList<String> myList;

    @Before
    public void before() {
        mySet = new MySet();
        myList = new ArrayList<String>();
        myList.add("Zipcode");
        myList.add("Wilmington");
        myList.add("2017");
    }

    @Test
    public void addTest(){
        //Given
        int expected = 1;

        //When
        boolean result = mySet.add("Stephen");
        int actual = mySet.size();

        //Then
        assertEquals("Size of set should be 1", expected, actual);
        assertTrue("The result of the add is true", result);
    }

    @Test
    public void addTestElementAlreadyThere(){
        //Given
        int expected = 1;

        //When
        mySet.add("Stephen");
        boolean result = mySet.add("Stephen");
        int actual = mySet.size();

        //Then
        assertEquals("Size of set should be 1", expected, actual);
        assertFalse("The result of the add is false", result);
    }

    @Test
    public void addAllTestThreeAdded(){
        //Given
        myList.add("Zipcode");
        myList.add("Dr. Yoo");
        mySet.add("Dr. Yoo");
        int expected = 4;

        //When
        boolean result = mySet.addAll(myList);
        int actual = mySet.size();

        //Then
        assertEquals("Size of set should be 4", expected, actual);
        assertTrue("Result of add is true", result);
    }


    @Test
    public void clearTest(){
        //Given
        int expected = 0;

        //When
        mySet.add("Paco");
        mySet.clear();
        int actual = mySet.size();

        //Then
        assertEquals("Size of set should be 0", expected, actual);
    }

    @Test
    public void removeTestFail(){
        //Given
        mySet.add("Vilena");
        mySet.add("Vidya");
        int expected = 2;

        //When
        boolean result = mySet.remove("Paco");
        int actual = mySet.size();

        //Then
        assertFalse("Paco was not in the set", result);
        assertEquals("Size of Set is still 2", expected, actual);
    }

    @Test
    public void removeTestSuccess(){
        //Given
        mySet.add("Delaware");
        mySet.add("New Jersey");
        int expected = 1;

        //When
        boolean result = mySet.remove("New Jersey");
        int actual = mySet.size();

        //Then
        assertTrue("New Jersey should have been successfully removed", result);
        assertEquals("Size of set should now be 1", expected, actual);
    }

    @Test
    public void hashCodeTest(){
        //Given
        String stephen = "Stephen";
        String paco = "Paco";
        int expected = stephen.hashCode() + paco.hashCode();
        mySet.add(stephen);
        mySet.add(paco);

        //When
        int actual = mySet.hashCode();

        //Then
        assertEquals("Hashcode of Set{Paco, Stephen} = Hashcode of Paco + Hashcode of Stephen", expected, actual);
    }

    @Test
    public void isEmptyTest(){
        //When
        boolean actual = mySet.isEmpty();

        //Then
        assertTrue("New Set is empty", actual);
    }

    @Test
    public void toArrayTest(){
        //Given
        String expected1 = "North Carolina";
        String expected2 = "Georgia";
        mySet.add(expected1);
        mySet.add(expected2);

        //When
        Object[] result = mySet.toArray();
        String actual1 = (String)result[0];
        String actual2 = (String)result[1];

        //Then
        assertEquals("result[0] should be North Carolina", expected1, actual1);
        assertEquals("result[1] should be Georgia", expected2, actual2);
    }

    @Test
    public void removeAllTest(){
        //Given
        mySet.add("Zipcode");
        mySet.add("Wilmington");
        mySet.add("2017");
        mySet.add("Cohort 3.1");
        int expected = 1;

        //When
        boolean success = mySet.removeAll(myList);
        boolean contains = mySet.contains("Cohort 3.1");
        int actual = mySet.size();

        //Then
        assertTrue("The set should only contain Cohort 3.1", contains);
        assertTrue("Result of removeAll is true", success);
        assertEquals("Size of set should be 1", expected, actual);
    }

    @Test
    public void equalsTest(){
        //Given
        mySet.add("Monday");
        mySet.add("Friday");
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("Monday");
        treeSet.add("Friday");

        //When
        boolean actual = mySet.equals(treeSet);

        //Then
        assertTrue("treeSet is equal to mySet", actual);
    }

    @Test
    public void retainAllTest(){
        //Given
        mySet.add("Zipcode");
        mySet.add("1105 N. Market St.");
        mySet.add("Paco");
        mySet.add("Wilmington");
        mySet.add("Chris");
        myList.add("Blue");
        int expected = 2;

        //When
        boolean success = mySet.retainAll(myList);
        int actual = mySet.size();
        boolean contains1 = mySet.contains("Zipcode");
        boolean contains2 = mySet.contains("Wilmington");

        //Then
        assertEquals("Size of set should be 2", expected, actual);
        assertTrue("The retain all should return true", success);
        assertTrue("Zipcode should still be in set", contains1);
        assertTrue("Wilmington should still be in set", contains2);

    }


}
