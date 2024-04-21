package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> Toxa = new ArrayList<>();
        boolean allEqual = false;
        int count = 0;
        Array[] Linkin;
        Array[] NeKit;
        Array[] Ziks;
        Array[] Vanya;
        Array[] Chepushilo;

        Random kubi = new Random();
        while (!allEqual) {
            Toxa.clear();
            count = count + 1;

            for (int i = 0; i < 6; i++) {
                Toxa.add(kubi.nextInt(6));
            }

            allEqual = true;

            // Сравниваем каждый элемент с первым элементом
            for (int i = 1; i < Toxa.size(); i++) {
                if (!Objects.equals(Toxa.get(i), Toxa.get(0))) {
                    allEqual = false;
                    break; // Если найдено несовпадение, выходим из цикла
                }
            }

        }
        if (allEqual) {
            System.out.println("Все числа в массиве одинаковые.");
        }

        System.out.println(Toxa);
        System.out.println(count);
    }
}