/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

/**
 *
 * @author Leeon
 */
public class MergeSort {
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }
    
    private static void exch(Comparable[] a,int i,int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public static boolean isSorted(Comparable[] a,int lo,int hi){
        for (int i = lo; i <= hi; i++) {
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
    
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert(isSorted(a,lo,mid));
        assert(isSorted(a,mid+1,hi));
        
        for (int k=lo; k<=hi; k++) {
            aux[k] = a[k];
        }
        
        int i = lo, j = mid+1;
        for (int k=lo; k<=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
        
        assert (isSorted(a, lo, hi));
    }
    
    private static void sort(Comparable[] a,Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    
    public static void main(String[] args) {
        D[] d = new D[10];
        d[0] = new D("m");
        d[1] = new D("e");
        d[2] = new D("r");
        d[3] = new D("g");
        d[4] = new D("e");
        d[5] = new D("s");
        d[6] = new D("o");
        d[7] = new D("r");
        d[8] = new D("t");
        d[9] = new D("e");
        
        D[] daux = new D[10];
        
        //merge(d, daux, 0, 4, 9);
        sort(d);
        
        for (int i = 0; i < 10; i++) {
            System.out.println(d[i].getA());
        }
    }
}
