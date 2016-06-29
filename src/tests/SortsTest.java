/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Leeon
 */

class Item<Type extends Comparable<Type>> implements Comparable<Item<Type>> {

    private Type t;

    public Item() {
    }

    public Item(Type t) {
        this.t = t;
    }
    
    @Override
    public int compareTo(Item<Type> i) {
        return this.getT().compareTo(i.getT());
    }

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }
    
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }
    
    
    private static void exch(List<Item> a,int i,int j){
        Item swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }
    
    public static void testSort(List<Item> a){
        for (int i = 1; i < a.size(); i++) {
            if(less(a.get(i), a.get(i-1))){
                exch(a, i, i-1);
            }
        }
    }

}

class D implements Comparable<D> {
    private String a;

    public D() {
    }

    public D(String a) {
        this.a = a;
    }
    
    @Override
    public int compareTo(D o) {
        return a.compareTo(o.getA());
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }
    
    private static void exch(Comparable[] a,int i,int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    private static void exch(Object[] a,int i,int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])){
                return false;
            } 
        }
        return true;
    }
    
    public static void testSort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])){
                exch(a, i, i-1);
            }
        }
    }
    
    public static void selectionSort(Comparable[] a){
        for(int i=0;i<a.length-1;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(less(a[j], a[min])){
                    min=j;
                }
            }
            exch(a, i, min);
        }
    }
    
    public static void insertionSort(Comparable[] a){
        for (int i=0; i<a.length; i++) {
            for (int j=i; j>0; j--) {
                if(less(a[j], a[j-1])){
                    exch(a, j, j-1);
                }else break;
            }
        }
    }
    
    public static void shellSort(Comparable[] a){
        int n=a.length;
        int h=1;
        while(h<n/3){
            h=3*h+1;
        }
        
        while(h>=1){
            for (int i=h; i<n; i++) {
                for (int j=i; j>=h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
            }
            h=h/3;
        }
    }
    
    public static void shuffle(Object[] a){
        int n=a.length;
        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int r = rand.nextInt(i+1);
            exch(a, i, r);
        }
    }
    
}

class Point2D {
    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public static int ccw(Point2D a, Point2D b, Point2D c){
        double area2 = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
        if (area2<0) return -1; // clockwise
        else if (area2>0) return +1; // counter-clockwise
        else return 0; // collinear
    }
}

public class SortsTest {
    public static void main(String[] args) {
        
        /*Item<String> a1 = new Item<>("z");
        Item<String> a2 = new Item<>("x");
        Item<String> a3 = new Item<>("a");
        
        System.out.println(a1.compareTo(a2));
        System.out.println(a3.compareTo(a2));*/
        
        /*Item<String>[] a = (Item<String>[]) new Object[1];
        a[0] = new Item("z");
        a[1] = new Item("x");
        a[2] = new Item("c");*/
        
        /*List<Item> a = new ArrayList<>();
        a.add(new Item("z"));
        a.add(new Item("x"));
        a.add(new Item("c"));
        
        Item.testSort(a);
        
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getT());
        }*/
        
        /*D[] d = new D[3];
        d[0] = new D("z");
        d[1] = new D("x");
        d[2] = new D("c");
        
        D.testSort(d);
        
        for (int i = 0; i < 3; i++) {
            System.out.println(d[i].getA());
        }*/
        
        D[] d = new D[6];
        d[0] = new D("4");
        d[1] = new D("3");
        d[2] = new D("7");
        d[3] = new D("6");
        d[4] = new D("5");
        d[5] = new D("1");
        
        //D.selectionSort(d);
        //D.insertionSort(d);
        //D.shellSort(d);
        
        /*for (int i = 0; i < 6; i++) {
            System.out.println(d[i].getA());
        }*/
        Object[] o = new Object[5];
        o[0] = 1;
        o[1] = 2;
        o[2] = 3;
        o[3] = 4;
        o[4] = 5;
        
        D.shuffle(o);
        
        for (int i = 0; i < 5; i++) {
            System.out.println(o[i]);
        }
    }
}
