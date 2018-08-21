package com.radix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;


public class Radix {
    private int length = -1; //-1 porque no existen mas posiciones a revisar
    public int length_end = -1;
    public Stack<Integer> items;

    //funcion para obtener datos necesarios
    public void setUp(Stack<Integer> items){
        this.items = items;

        //obtener el mayor length
        this.getLengthMax();

    }



    public boolean orderItems(){
         Stack<Integer> new_items = new Stack<Integer>();//vacio, para "La Nueva Orden" :v

        //evaluar si aun existen lugares para ordenar
        if(this.length < 0){
            return false;
        }

        //obtener cada valor segun el index
        int init = 0;//index inicial
        int[][] content = new int[this.items.size()][2];//array que guardara el valor y el index
        for(int item: this.items){

            //obtener el digito
            int value = Integer.valueOf( Character.toString( String.format("%0"+(this.length_end+1)+"d", item).charAt(this.length) ));

            content[init][0] = init;//index
            content[init][1] = value;//valor
            init+=1;

        }

        //okay, ordenar segun el valor
        content = sortbyColumn(content, 1);


        //rearmar array y asignar como nuevo
        Stack<Integer> edited_items = this.items;
        for(int[] item_temp: content){
            new_items.push(this.items.get(item_temp[0]));
        }
        this.items = new_items;




        this.length-=1;
        return true;
    }


    // funcion para organizar segun columna
    public static int[][] sortbyColumn(int[][] arr, int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // revisar entradas yXy
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // el '>=' operador para permitir iguales (puede que choquen si no se permiten iguales)
                if (entry1[col] >= entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  //fin
        return arr;
    }



    //funcion para obtener la longitud mas grande
    private void getLengthMax(){
        int temp_number = 0;
        for(int temp: this.items){
            //comparar cada item hasta encontrar el mas alto
            if(temp > temp_number){
                temp_number = temp;//temp_number ahora guarda el mas alto
            }
        }

        //asignar el lenght
        this.length = String.valueOf(temp_number).length() - 1;
        this.length_end = this.length;
    }

}
