/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import java.util.ArrayList;
import java.util.List;

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
        
        D.selectionSort(d);
        
        for (int i = 0; i < 6; i++) {
            System.out.println(d[i].getA());
        }
    }
}
