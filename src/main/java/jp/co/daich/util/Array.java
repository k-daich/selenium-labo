/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util;

/**
 *
 * @author USER
 * @param <E>
 */
public class Array<E> {

    /**
     * Constructor
     */
    public Array() {
        // none
    }

    /**
     * reverse argArray
     * @param array
     * @param reversedArray
     * @return reversed argArray
     */
    public E[] reverse(E[] array, E[] reversedArray) {
        int currentIndex = array.length;

        for(E element : array) {
            reversedArray[--currentIndex] = element;
        }
        return reversedArray;
    }
}
