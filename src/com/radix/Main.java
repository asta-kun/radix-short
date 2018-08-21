package com.radix;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int expected_numbers;
        Stack<Integer> items = new Stack<Integer>();

        //iniciar Radix
        Radix radix = new Radix();

        print("Numeros de elementos a ingresar:\n");
        expected_numbers = getNumber();



        //obtener items
        for(int x = 0; x < expected_numbers; x+=1)
        {
            print(">>> Numero #"+(x+1)+"\n");
            items.push(getNumber());
        }

        //pasar items a radix
        radix.setUp(items);

        //mostrar items iniciales
        print("Elementos base: \n");
        showItems(radix);



        int count = 1;
        while(radix.orderItems()){
            print(">>> Pasada #"+count+"\n");
            print("Elementos:\n");
            showItems(radix);
            count+=1;
        }




    }


    private static void showItems(Radix radix){
        for(int x: radix.items){
            print( String.format("%0"+(radix.length_end+1)+"d"+"\n", x) );

        }
    }






    //funcion para imprimir
    private static void print(String temp){
        System.out.print(temp);
    }



    //funcion para obtener numeros
    private static int getNumber(){
        String temp = null;
        Scanner sc = new Scanner(System.in);

        //obtener numeros
        do {
            System.out.println("Ingrese valor numerico: ");
            temp =  sc.nextLine();

        }while (!isNumeric(temp));



        return Integer.valueOf(temp);
    }


    //funcion para revisar si es numerico
    private static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
