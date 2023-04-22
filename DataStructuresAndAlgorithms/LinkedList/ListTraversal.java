import java.util.*;

public class ListTraversal 
{

    private static void printElements(List<Integer> list)
    {
        for(int i : list)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        printElements(list);
    }
}