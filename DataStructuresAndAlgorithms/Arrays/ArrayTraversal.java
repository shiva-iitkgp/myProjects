public class ArrayTraversal 
{

    private static void printElements(int[] arr)
    {
        for(int i : arr)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args)
    {
        int [] arr = {1,2,3};
        printElements(arr);
    }
}