public class Sort {

    public void printArray(int[] arr){
        for(int data : arr){
            System.out.print(data+",");
        }
        System.out.println();
    }
    /**
     * 1. merge sort : 항상 O(n*logN), 별도의 공간 필요
     * 2. quick sort : 평균 O(n*logN) 최악 O(n^2) , 별도의 공간 필요 없음
     */
    // 1. merge sort
    public void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(tmp, arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] tmp, int[] arr, int start, int end) {

        if (end > start) {

            int mid = (start + end) / 2;
            // left
            mergeSort(tmp, arr, start, mid);
            // right
            mergeSort(tmp, arr, mid + 1, end);

            merge(tmp, arr, start, mid, end);
        }
    }

    public void merge(int[] tmp, int[] arr, int start, int mid, int end) {

        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid+1;

        int index = start;

        while(part1 <=mid && part2<=end){
            if(tmp[part1] <= tmp[part2]){
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        // if there are any values left
        for(int i=0; i<=mid-part1; i++){
            arr[index+i] = tmp[part1+i];
        }

    }


    // 2. quick sort
    public void quickSort(int[] arr){
        quickSort(arr,0, arr.length-1);
    }

    public void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr,start,end);
        if(start < part2-1){
            quickSort(arr, start, part2-1);
        }
        if(part2 < end){
            quickSort(arr, part2, end);
        }
    }

    public int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];
        while (start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start<=end){
                swap(arr,start,end);
                start++;
                end--;
            }
        }

        return start;
    }

    public void swap(int[] arr, int start, int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }


}
