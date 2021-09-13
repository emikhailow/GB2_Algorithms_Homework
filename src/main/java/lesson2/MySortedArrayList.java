package lesson2;

public class MySortedArrayList<T extends Comparable<T>> extends MyArrayList<T>{

    @Override
    public void add(T item){

        if(item == null){
            return;
        }
        int i = 0;
        while(i < getSize() && item.compareTo(get(i)) >= 0){
            i++;
        }
        super.add(i, item);
    }

    @Override
    public void add(int index, T item) {
        add(item);
    }

    public int binaryFind(T item){
        int low = 0;
        int high = getSize() - 1;
        while(low <= high){
            int middle =  low + (high - low) / 2;
            if(item.compareTo((T)get(middle)) > 0){
                low = middle + 1;
            }else if(item.compareTo((T)get(middle)) > 0){
                high = middle - 1;
            }else
            {
                return middle;
            }
        }
        return -1;
    }
}

