package kim.christopher;

import java.util.Arrays;

public class MyArrayList<E> {

    private Object[] theList;
    private int listSize;

    public MyArrayList(){
        theList = (E[]) new Object[0];
        listSize = 0;
    }

    public MyArrayList(int initialCapacity){
        theList = (E[]) new Object[initialCapacity];
        listSize = 0;
    }

    public void add(E element){
        if(listSize == theList.length){
            theList = Arrays.copyOf(theList, theList.length + 10);
        }
        theList[listSize++] = element;
    }

    public void add(int index, E element){
        if(listSize == theList.length){
            theList = Arrays.copyOf(theList, theList.length + 10);
        }
        for(int i = theList.length - 2; i >= index; i--){
            theList[i + 1] = theList[i];
        }
        theList[index] = element;
        listSize++;
    }


    public E get(int index){
        return (E) theList[index];
    }

    public int size(){
        return listSize;
    }

    public E remove(int index){
        E result = (E) theList[index];
        for(int i = index; i < listSize - 1; i++){
            theList[i] = theList[i + 1];
        }
        if(listSize < theList.length - 10){
            theList = Arrays.copyOf(theList, listSize);
        }
        listSize--;
        return result;
    }

    public E set(int index, E element){
        E result = (E) theList[index];
        theList[index] = element;
        return result;
    }

    public void clear(){
        theList = (E[]) new Object[10];
        listSize = 0;
    }

    public boolean isEmpty(){
        return listSize == 0;
    }

    public boolean contains(Object obj){
        for(int i = 0; i < listSize; i++){
            if(theList[i].equals(obj)){
                return true;
            }
        }
        return false;
    }

}
