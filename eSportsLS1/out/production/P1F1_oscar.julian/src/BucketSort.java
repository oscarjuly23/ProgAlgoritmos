import java.util.ArrayList;
import static java.util.Collections.swap;

public class BucketSort {


    // ORDENACIÓ D'EQUIPS PER WINRATE

    public static void bucket_sort(Team[] arr) {
        // Creem i inicialitzem les 10 buckets
        Bucket[] buckets = new Bucket[11];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        // Posem els valors en cada bucket (agafem nomes el winrate).
        for (Team n: arr) {
            int bucketIndex = (int) (n.getWinrate()/ 10);
            buckets[bucketIndex].bucket.add(n);
        }

        // Un cop tinguem tots els valors en les nostres 'buckets' hem de ordenar aquets
        // buckets, ho he fet mitjançant un métode força simple implementant un insertionSort.
        int index = 0;
        for (Bucket n: buckets) {
            insertionSort(n.bucket);
            //Posem els valors ja ordenats en un nou array
            for (Team num: n.bucket) {
                arr[index] = num;
                index++;
            }
        }
    }

    public static void insertionSort(ArrayList<Team> arr){
        for (int i = 0; i < arr.size()-1; i++) {
            int place = i;
            while (place >= 0 && arr.get(place).getWinrate() > arr.get(place+1).getWinrate()) {
                swap(arr,place,place+1);
                place--;
            }
        }
    }

    static class Bucket {
        ArrayList<Team> bucket = new ArrayList<Team>();
    }


    // ORDENACIÓ DE JUGADORS PER NACIONALITAT (+ nom)

    // Tornem a implementar el métode ara per ordenar els jugadors per nacionalitats.
    public static void bucket_sortN(Jugador[] arr) {
        // Creem i inicialitzem les 27 Buckets (un per cada lletra del abecedari)
        BucketN[] buckets = new BucketN[28];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new BucketN();
        }
        // Posem els valors en cada bucket.
        for (Jugador n: arr) {
            int bucketIndex = (n.getNationality().toLowerCase().charAt(0) -96);
            buckets[bucketIndex].bucketN.add(n);
        }
        // Un cop tinguem tots els valors en les nostres 'buckets' hem de ordenar aquets
        // buckets, ho he fet mitjançant un métode força simple implementant un insertionSort.
        int index = 0;
        for (BucketN n: buckets) {
            insertionSortN(n.bucketN);
            //Posem els valors ja ordenats en un nou array
            for (Jugador num: n.bucketN) {
                arr[index] = num;
                index++;
            }
        }
    }

    public static void insertionSortN(ArrayList<Jugador> arr) {
        for (int i = 0; i < arr.size()-1; i++){
            int place = i;
            while ((place >= 0 && arr.get(place).getNationality().toLowerCase().compareTo(arr.get(place+1).getNationality().toLowerCase()) > 0) || (place >= 0 && arr.get(place).getName().toLowerCase().compareTo(arr.get(place+1).getName().toLowerCase()) > 0 && arr.get(place).getNationality().toLowerCase().compareTo(arr.get(place+1).getNationality().toLowerCase()) == 0)) {
                swap(arr,place,place+1);
                place--;
                }
        }
    }

    static class BucketN {
        ArrayList<Jugador> bucketN = new ArrayList<>();
    }


    // ORDENACIÓ DE JUGADORS PER COMBINACIÓ DE PRIORITATS

    public static void bucket_sortP(Jugador[] arr) {

        // Creem i inicialitzem les 10 buckets
        BucketP[] buckets = new BucketP[11];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new BucketP();
        }

        // Posem els valors en cada bucket (agafem nomes el winrate).
        for (Jugador n: arr) {
            int bucketIndex = (int) (n.getWinrate() * 10 / arr.length);
            buckets[bucketIndex].bucketP.add(n);
        }

        // Un cop tinguem tots els valors en les nostres 'buckets' hem de ordenar aquets
        // buckets, ho he fet mitjançant un métode força simple implementant un insertionSort.
        int index = 0;
        for (BucketP n: buckets) {
            insertionSortP(n.bucketP);
            //Posem els valors ja ordenats en un nou array
            for (Jugador num: n.bucketP) {
                arr[index] = num;
                index++;
            }
        }
    }

    public static void insertionSortP(ArrayList<Jugador> arr){
        for (int i = 0; i < arr.size()-1; i++){
            int place = i;
            while ((place >= 0 && arr.get(place).getWinrate() > arr.get(place+1).getWinrate()) || (place >= 0 && (arr.get(place).getWinrate() == arr.get(place+1).getWinrate() && arr.get(place).getKDA() > arr.get(place+1).getKDA()))) {
                swap(arr,place,place+1);
                place--;
            }
        }
    }

    static class BucketP {
        ArrayList<Jugador> bucketP = new ArrayList<>();
    }

}