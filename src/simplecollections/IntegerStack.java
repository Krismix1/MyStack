package simplecollections;

import java.util.EmptyStackException;

/**
 * Created by Chris on 16-Feb-17.
 */
public class IntegerStack implements IStack
{
    private StackNode top;
    private int size;

    public boolean push(int el)
    {
        StackNode newNode = new StackNode(el);
        if (top == null)
        {
            top = newNode;
            size++;
            return true;
        }
        newNode.previous = top;
        top = newNode;
        size++;
        return true;
    }

    public int peak()
    {
        return top.data;
    }

    public int pop()
    {
        if (top != null)
        {
            StackNode tail = top;
            top = top.previous;
            size--;
            return tail.data;
        }
        throw new EmptyStackException();
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public boolean clear()
    {
        top = null;
        size = 0;
        return true;
    }

    public int size()
    {
        return size;
    }

    public int search(int el)
    {
        StackNode current = top;
        int index = 1;
        while (current != null)
        {
            if (current.data == el)
            {
                return index;
            }
            index++;
            current = current.previous;
        }
        return -1;
    }

    private class StackNode
    {
        int data;
        StackNode previous;

        private StackNode(int data)
        {
            this(data, null);
        }

        private StackNode(int data, StackNode previous)
        {
            this.data = data;
            this.previous = previous;
        }

        public String toString()
        {
            return data + "";
        }
    }

    public String toString()
    {
        if (size == 0 && top == null)
        {
            return "[]";
        }
        StackNode current = top;
        String toReturn = "[" + current.toString();
        current = current.previous;
        while (current != null)
        {
            toReturn += ", " + current.toString();
            current = current.previous;
        }
        toReturn += "]";
        return toReturn;
    }

    public static void main(String[] args)
    {
        IntegerStack test = new IntegerStack();
        test.push(5);
        test.push(4);
        test.push(3);
        test.push(2);
        test.push(1);

        System.out.println(test);
    }
}
