// Programmer: Kuan Lei
package com.cs272.spellingbee.Objects.leftSideModular;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class DynamicStack<E>
{
    // INSTANT VARIABLE
    private DynamicArray<E> stack;
    
    // CONSTRUCTURE
    public DynamicStack()
    {
        stack = new DynamicArray<E>();
    }
    
    // INSTANT METHOD
    public void push(E element)
    {
        stack.addToEnd(element);
    }
    
    public boolean empty()
    {
        if(stack.getNumberOfElements() == 0)
            return true;
        else
        return false;
    }
    
    public E peek()
    {
        if(stack.getNumberOfElements() == 0)
        {
            throw new RuntimeException("Caused By Dynamic Stack Peek Method");
        }
        else
        {
            return stack.get(stack.getNumberOfElements() - 1);
        }
    }
    
    public E pop()
    {
        if(stack.getNumberOfElements() == 0)
        {
            throw new RuntimeException("Caused By Dynamic Stack Pop Method");
        }
        else
        {
            return stack.remove(stack.getNumberOfElements() - 1);
        }
    }
    
    public void saveToFile(String filename) throws IOException
    {
        PrintWriter fileWriter = new PrintWriter(filename);
        
        for(int index = 0; index < stack.getNumberOfElements(); index++)
        {
            fileWriter.println(stack.get(index));
        }
        
        fileWriter.close();
    }
}
