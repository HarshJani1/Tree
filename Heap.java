/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treemain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author 91987
 */
public class Heap {

    List<Integer> heap;
    int size;

    Heap() {
        heap = new ArrayList<>();
        heap.add(-1);
        size = 0;
    }

    public void insert(int val) {
        size++;
        heap.add(val);

        int index = size;

        while (index > 1) {

            if (heap.get(index) > heap.get(index / 2)) {
                int temp = heap.get(index / 2);
                heap.set(index / 2, heap.get(index));
                heap.set(index, temp);
                index = index / 2;
            } else {
                break;
            }

        }
    }

    public int peek() {
        if (heap.isEmpty()) {
            return -1;
        }
        return heap.get(1);
    }

    public void delete() {
        int last = heap.get(size);
        heap.set(1, last);
        heap.remove(size);
        size--;
        heapify(1);
    }

    public void heapify(int i) {
        int largest = i;
        int l = 2 * i;
        int r = 2 * i + 1;

        if (l <= size && heap.get(l) > heap.get(largest)) {
            largest = l;
        }
        if (r <= size && heap.get(r) > heap.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            heapify(largest);
        }
    }

    public void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(" " + heap.get(i));
        }
    }

    public void heapSort() {
        int originalSize = size;
        for (int i = originalSize; i > 0; i--) {
            int temp = heap.get(1);
            heap.set(1, heap.get(size));
            heap.set(size, temp);
            size--;
            heapify(1);
        }
        size = originalSize;
    }

}
