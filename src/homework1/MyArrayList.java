/**
 * Класс - кастомный ArrayList.
 * Реализованы методы add(), get(), remove(), clear(), getSize().
 * private метод quickSort() - реализация алгоритма быстрой сортировки.
 * @autor Екатерина Кокорина
 */

package homework1;

import java.util.Comparator;

public class MyArrayList<T> {
    private T[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    /**
     * Конструктор - создание новго объекта с заданным размером DEFAULT_CAPACITY
     */
    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Добавляет в ArrayList новый элемент.
     * @param s - добавляемый элемент
     */
    public void add(T s) {
        array [size] = s;
        size++;
        if (size == array.length){
            T[] newArray =  (T[]) new Object[array.length*2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    /**
     * Добавляет в ArrayList новый элемент.
     * @param index
     * @param s - добавляемый элемент.
     */
    public void add(int index, T s) {
        if ((size+1) == array.length){
            T[] newArray = (T[]) new Object[array.length*2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        for (int i = size+1; i>index; i--){
            array[i]=array[i-1];
        }
        array[index]=s;
        size++;
    }

    /**
     * Возвращает элемент по индексу.
     * @param index
     * @return - возвращаемый элемент.
     */
    public Object get(int index) {
        return array[index];
    }

    /**
     * Удаляет элемент по индексу.
     * @param index
     */
    public void remove(int index){
        for (int i=index; i<size-1; i++){
            array[i] = array[i+1];
        }
        size--;
    }

    /**
     * Возвращает размер ArrayList.
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * Удаляет все элементы из ArrayList.
     */
    public void clear() {
        for (int to = size, i = size = 0; i < to; i++)
            array[i] = null;
    }

    /**
     * Сортирует элементы в массиве.
     * @param comparator
     */
    public void sort(Comparator<? super T> comparator) {
        quickSort(0, size - 1, comparator);
    }

    /**
     * Реализация алгоритма быстрой сортировки.
     * @param low - граница массива.
     * @param high - граница массива.
     * @param comparator - компаратор, исплользуется для задания порядка сортировки.
     */
    private void quickSort(int low, int high, Comparator comparator) {

        if (low >= high) {
            return;
        }

        T pivot = array[low + (high - low) / 2];
        int leftBound = low;
        int rightBound = high;

        while (leftBound <= rightBound) {
            while (comparator.compare(array[leftBound], pivot) < 0) {
                leftBound++;
            }
            while (comparator.compare(array[rightBound], pivot) > 0) {
                rightBound--;
            }
            if (leftBound <= rightBound) {
                T tmp = array[leftBound];
                array[leftBound] = array[rightBound];
                array[rightBound] = tmp;
                leftBound++;
                rightBound--;
            }
        }
        if (low < rightBound) {
            quickSort(low, rightBound, comparator);
        }
        if (high > leftBound) {
            quickSort(leftBound, high, comparator);
        }
    }

}


