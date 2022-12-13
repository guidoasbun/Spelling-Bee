//Programmer: Kuan Lei
package com.cs272.spellingbee.Objects.leftSideModular;

import java.io.PrintWriter;
import java.io.IOException;

public class DynamicArray<E>
{
    //INSTANT VARIABLE
    private final int INITIAL_SIZE = 10;
    private int numberOfElements;
    private E[] array;
    
    //CONSTRUCTURE
    public DynamicArray()
    {
        numberOfElements = 0;
        array = (E[])new Object[INITIAL_SIZE];
    }
    
    //INSTANT METHOD
    public void addToEnd(E element)
    {
        if(array.length == 0)
        {
            E[] largerArray = (E[]) new Object[INITIAL_SIZE];
            array = largerArray;
        }
        else if(numberOfElements == array.length)
        {
            E[] largerArray = (E[]) new Object[INITIAL_SIZE];
            
            for(int index = 0; index < array.length; index++)
            {
                largerArray[index] = array[index];
            }
            
            array = largerArray;
        }
        
        array[numberOfElements] = element;
        numberOfElements++;
    }
    
    public E get(int index)
    {
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("ArrayList index can not one" 
            + " a negative number");
        }
        else if(index >= numberOfElements)
        {
            throw new IndexOutOfBoundsException("ArrayList index exceeds" 
            + " the last element index");
        }
        else
        {
            return (E)array[index];
        }
    }
    public E remove(int index)
    {
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("ArrayList index can not one" 
            + " a negative number");
        }
        else if(index >= numberOfElements)
        {
            throw new IndexOutOfBoundsException("ArrayList index exceeds" 
            + " the last element index");
        }
        
        E removedElement = (E) array[index];
        
        for(; index < numberOfElements - 1; index++)
        {
            array[index] = array[index + 1];
        }
        
        array[numberOfElements] = null;
        numberOfElements--;
        
        return removedElement;
    }
    
    public int getNumberOfElements()
    {
        return numberOfElements;
    }
    
    public void set(int index, E element)
    {
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("ArrayList index can not one" 
            + " a negative number");
        }
        else if(index >= numberOfElements)
        {
            throw new IndexOutOfBoundsException("ArrayList index exceeds" 
            + " the last element index");
        }
        else
        {
            array[index] = element;
        }
        
    }
    
    public int occurrences(E element)
    {
        int result = 0;
        
        for(int index = 0; index < numberOfElements; index++)
        {
            if(array[index].equals(element))
            {
                result++;
            }
        }
        
        return result;
    }
    
    public void saveToFile(String filename) throws IOException
    {
        PrintWriter fileWriter = new PrintWriter(filename);
        
        for(int index = 0; index < numberOfElements; index++)
        {
            fileWriter.println(array[index]);
        }
        
        fileWriter.close();
    }
}
