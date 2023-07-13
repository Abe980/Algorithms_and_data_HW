import Solution.HeapSort;

public class App {
    public static void main(String[] args) throws Exception {
        // создаем массив
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        // сортируем массив
        HeapSort.heapSort(sortArr);
        // печатаем массив
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + ", ");
        }
    }
}
