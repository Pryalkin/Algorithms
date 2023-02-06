package arrays;

public class HighArray {

    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey){
        int j;
        for(j=0; j<nElems; j++)
            if(a[j] == searchKey) break;
        if(j == nElems)
            return false;
        else
            return true;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j]) break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public long removeMax(){
        long maxValue = a[0];
        for (int j = 1; j < nElems; j++)
            if (maxValue < a[j])
                maxValue = a[j];
        delete(maxValue);
        return maxValue;
    }

    public void display(){
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    public int getMax(){
        return nElems == 0 ? -1 : nElems;
    }
}

class HighArrayApp{
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);

        if (arr.getMax() == -1)
            System.out.println("Array is empty");
        else
            System.out.println("Array has size " + arr.getMax());

        arr.insert(77); // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        if (arr.getMax() == -1)
            System.out.println("Array is empty");
        else
            System.out.println("Array has size " + arr.getMax());

        arr.display();

        int searchKey = 35;
        if(arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        searchKey = 22;
        if(arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        if (arr.getMax() == -1)
            System.out.println("Array is empty");
        else
            System.out.println("Array has size " + arr.getMax());

        arr.display();

        System.out.println("Max value: " + arr.removeMax());

        arr.display();
    }
}
