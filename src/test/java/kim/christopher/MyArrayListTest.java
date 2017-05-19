package kim.christopher;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest {

    MyArrayList<String> myList;
    MyArrayList<Integer> myIntegerList;


    @Before
    public void initialize() {
        myList = new MyArrayList<String>();
        myIntegerList = new MyArrayList<Integer>();
    }

    @Test
    public void addTestCheckForSizeAndContents(){
        int expectedSize = 1;
        String expectedContents = "Testing";

        //When
        myList.add("Testing");
        int actualSize = myList.size();
        String actualContents = myList.get(0);

        //Then
        assertEquals("Size should be 1", expectedSize, actualSize);
        assertEquals("Element at 0 should be \"Testing\"", expectedContents, actualContents);
    }

    @Test
    public void addAtIndexTest(){

        //Given
        myList.add("Chris");
        myList.add("Kim");
        myList.add(1, "Testing");
        int expectedSize = 3;
        String expected1 = "Testing";
        String expected2 = "Kim";


        //When

        int actualSize = myList.size();
        String actual1 = myList.get(1);
        String actual2 = myList.get(2);

        //Then
        assertEquals("Size should be 3", expectedSize, actualSize);
        assertEquals("Element at 1 should be Testing", expected1, actual1);
        assertEquals("Element at 2 should be Kim", expected2, actual2);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void getTestInvalidIndex(){
        //Given
        myList.add("Chris");
        myList.add("Kim");
        myList.add(1, "Testing");

        //When
        String result = myList.get(3);
    }

    @Test
    public void removeTest(){
        //Given
        myIntegerList.add(1);
        myIntegerList.add(3);
        myIntegerList.add(1,2);
        Integer expected = 2;

        //When
        Integer actual = myIntegerList.remove(1);

        //Then
        assertEquals("Value of removed object should be 2", expected, actual);
    }

    @Test
    public void setTest(){
        //Given
        myIntegerList.add(1);
        myIntegerList.add(3);
        myIntegerList.add(1,2);
        Integer expected = 42;
        Integer expected2 = 2;

        //When
        Integer actual2 = myIntegerList.set(1, 42);
        Integer actual = myIntegerList.get(1);


        //Then
        assertEquals("Integer at index 1 should now be 42", expected, actual);
        assertEquals("The old element was 2", expected2, actual2);
    }

    @Test
    public void clearTest(){
        //Given
        myIntegerList.add(1);
        myIntegerList.add(3);
        myIntegerList.add(1,2);
        int expected = 0;

        //When
        myIntegerList.clear();
        int actual = myIntegerList.size();

        //Then
        assertEquals("Size should be zero", expected, actual);
    }

    @Test
    public void isEmptyTestFalse(){
        //Given
        myList.add("Hello");

        //When
        boolean actual = myList.isEmpty();

        //Then
        assertFalse(actual);
    }

    @Test
    public void isEmptyTestTrue(){

        //When
        boolean actual = myList.isEmpty();

        //Then
        assertTrue(actual);
    }

    @Test
    public void containsTestTrue(){
        //Given
        myIntegerList.add(1);
        myIntegerList.add(3);
        myIntegerList.add(1,2);

        //When
        boolean actual = myIntegerList.contains(2);

        //Then
        assertTrue("The list does contain 2", actual);
    }

    @Test
    public void containsTestFalse(){
        //Given
        myIntegerList.add(1);
        myIntegerList.add(3);
        myIntegerList.add(1,2);

        //When
        boolean actual = myIntegerList.contains(4);

        //Then
        assertFalse("The list does not contain 4", actual);
    }

}
