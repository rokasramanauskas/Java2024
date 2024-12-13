/*Parašyti programą, kuri nustato,
ar loterijos bilietas yra laimingas. Loterijos bilieto šešiaženklis
numeris laikomas laimingu, jei jo pirmų trijų
Skaičių suma yra lygi paskutinių trijų skaičių sumai, o visi
skaitmenys biliete yra skirtingi.
        1. Bilieto numerį perduokite komandinėje eilutėje. Pvz: 628745
        2. Generuokite skaicius tol, kol rasite pirmą laimingą skaičių bei
atspausdinkite, kiek reikėjo bandymų.*/


import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        System.out.println("Loterijos bilietai");
        System.out.println();
        int min = 100000, max = 999999;

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Bilieta ivesti ranka: \n" + "2. Generuoti daug atsitiktinu bilietu");

        int option = sc.nextInt();

        int counter = 1;

        switch (option) {
            case 1:

                int ivestis = sc.nextInt();

                int sestas1 = ivestis % 10;
                int penktas1 = (ivestis / 10) % 10;
                int ketvirtas1 = (ivestis / 100) % 10;     //pasidalinam i skirtingus digitus
                int trecias1 = (ivestis / 1000) % 10;
                int antras1 = (ivestis / 10000) % 10;
                int pirmas1 = ivestis / 100000;
                int[] skaiciusArray1 = {pirmas1, antras1, trecias1, ketvirtas1, penktas1, sestas1};

                if (ivestis > min && ivestis < max) {
                    if(areSumsEqual(skaiciusArray1) && areDigitsUnique(ivestis)){
                        System.out.println("BILIETAS LAIMINGAS!");
                    }
                    else{
                        System.out.println("BILIETAS neLAIMINGAS!");
                    }

                }
                break;
            case 2:

                boolean a = true;
                while(a){

                    int skaicius = rand.nextInt(max - min + 1) + min; //issukam random skaiciu

                    int sestas = skaicius % 10;
                    int penktas = (skaicius / 10) % 10;
                    int ketvirtas = (skaicius / 100) % 10;
                    int trecias = (skaicius / 1000) % 10;
                    int antras = (skaicius / 10000) % 10;
                    int pirmas = skaicius / 100000;
                    int[] skaiciusArray = {pirmas, antras, trecias, ketvirtas, penktas, sestas};

                    if((areSumsEqual(skaiciusArray)) && (areDigitsUnique(skaicius))){
                        System.out.println("BILIETAS LAIMINGAS!");
                        System.out.println("LAIMINGAS BILIETAS = " + skaicius + " ,reikejo: " + counter + " bilietu");
                        a = false;
                    }
                    else{
                        System.out.println(skaicius + " = BILIETAS neLAIMINGAS!");
                        counter++;
                    }
                }
                break;
        }

    }

    public static boolean areDigitsUnique(int number) {
        boolean[] digitSeen = new boolean[10];

        while (number > 0) {
            int digit = number % 10;
            if (digitSeen[digit]) {
                return false; //
            }
            digitSeen[digit] = true;
            number /= 10;
        }
        return true;
    }

    public static boolean areSumsEqual(int[] masyvas){

        int suma1 = masyvas[0] + masyvas[1] + masyvas[2];
        int suma2 = masyvas[3] + masyvas[4] + masyvas[5];

        return suma1 == suma2;
    }

}
