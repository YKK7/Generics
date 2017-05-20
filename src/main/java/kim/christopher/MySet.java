package kim.christopher;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class MySet<E> {

    private Object[] theArray;
    private int sizeOfSet;

    public MySet() {
        theArray = (E[]) new Object[0];
        sizeOfSet = 0;
    }

    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }
        if (theArray.length == sizeOfSet)
            theArray = Arrays.copyOf(theArray, theArray.length + 1);
        theArray[sizeOfSet++] = element;
        return true;
    }

    boolean addAll(Collection<? extends E> collection) {
        boolean result = false;
        for (E element : collection) {
            if (add(element))
                result = true;
        }
        return result;
    }

    public void clear() {
        theArray = (E[]) new Object[0];
        sizeOfSet = 0;
    }

    public boolean contains(Object obj) {
        for (int i = 0; i < sizeOfSet; i++) {
            if (theArray[i].equals(obj))
                return true;
        }
        return false;
    }

    //containsAll

    public boolean equals(Object obj) {
        return false;
    }

    public int hashCode(){
        int result = 0;
        for(int i = 0; i < sizeOfSet; i++)
            result += theArray[i].hashCode();
        return result;
    }

    public boolean isEmpty() {
        return sizeOfSet == 0;
    }

    //iterator

    public boolean remove(Object obj) {
        boolean result = false;
        for (int i = 0; i < sizeOfSet; i++) {
            if(theArray[i].equals(obj)){
                shiftLeft(i);
                result = true;
            }
        }
        return result;
    }

    private void shiftLeft(int start){
        for(int i = start; i < sizeOfSet - 1; i++){
            theArray[i] = theArray[i+1];
        }
        theArray = Arrays.copyOf(theArray, theArray.length - 1);
        sizeOfSet--;
    }

    boolean removeAll(Collection<?> collection){
        boolean result = false;
        for(Object element: collection){
            if(remove(element))
                result = true;
        }
        return result;
    }

    public boolean retainAll(Collection<?> collection){
        boolean result = false;
        for(int i = 0; i < sizeOfSet; i++){
            if(!collection.contains(theArray[i])){
                remove(theArray[i]);
                result = true;
                i--;
            }
        }
        return result;
    }



    public int size() {
        return sizeOfSet;
    }

    public Object[] toArray() {
        Object[] result = new Object[sizeOfSet];
        for (int i = 0; i < sizeOfSet; i++) {
            result[i] = theArray[i];
        }
        return result;
    }

//    public <T> T[] toArray(T[] theArray){
//        return (T[]) new Object[0];
//    }


}
