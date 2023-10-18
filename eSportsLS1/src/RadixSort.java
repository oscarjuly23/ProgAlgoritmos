import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    // Només podem ordenar números (no aplica en Nacionalitats)

    // Primer comparem la primera xifra (la de l'esquerra) i ordenem a partir d'això
    // Un cop tenim aquest nou array, mirarem la segona xifra i tornarem a ordenar.
    // De manera dinàmica podrem saber quan hem acabat de ordenar tot l'array. (getMax)


    // ORDENACIÓ D'EQUIPS PER WINRATE

    // Necessitem una funció amb la que obtindrem el valor màxim del nostre Array
        static float getMax(Team[] arr, int n) {
            Team mx = arr[0];
            for (int i = 1; i < n; i++)
                if (arr[i].getWinrate()*100 > mx.getWinrate()*100)
                    mx = arr[i];
            return mx.getWinrate()*100;
        }

        // ordenem el nostre array que tenim guardat en el auxiliar (exp)
        static void countSort(Team[] arr, int n, float exp) {
            Team output[] = new Team[n]; // output array
            int i;
            float count[] = new float[10];
            Arrays.fill(count, 0);
            // Guardem els valors en un nou array per tal de ordenar-los
            for (i = 0; i < n; i++) {
                count[(int) ((arr[i].getWinrate()*100 / exp) % 10)]++;
            }
            // Canviem el valor que teniem guardat per al valor que tenim en la posició actual.
            for (i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            // Omplim el nostre nou array
            for (i = n - 1; i >= 0; i--) {
                output[(int) (count[(int) ((arr[i].getWinrate()*100/exp)%10)] - 1)] = arr[i];
                count[(int) ((arr[i].getWinrate()*100/exp)%10)]--;
            }
            // Finalment posem els valors que tenim en el array que teniem en el nostre array original
            // Ara ja tenim els valors ordenats de la manera que voliem
            for (i = 0; i < n; i++) {
                arr[i] = output[i];
            }
        }

        // Radix Sort
        static void radixsort(Team arr[], int n) {
            // Busquem el maxim nombre per saber el número de dígits
            float m = getMax(arr, n);
            // Ordenem amb l'anterior mètode cada dígit que tenim. la variable EXP es 10^i
            // Ho anem dividint per anar comprovant dígit per dígit.
            for (float exp = 1; m/exp > 0; exp *= 10)
                countSort(arr, n, exp);
        }



    // ORDENACIÓ DE JUGADORS PER COMBINACIÓ DE PRIORITATS

    static int getMaxP(Jugador[] arr, int n) {
        Jugador mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i].getWinrate()*100 > mx.getWinrate()*100)
                mx = arr[i];
        return (int) mx.getWinrate() * 100;
    }

    // ordenem el nostre array que tenim guardat en el auxiliar (exp)
    static void countSortP(Jugador[] arr) {
            int n = 10;
        //Jugador output[] = new Jugador[n]; // output array
        List<Jugador>[] count = new ArrayList[10];
        // Inicialitzem els buckets
        for (int i = 0; i < count.length; i++) {
            count[i] = new ArrayList<>();
        }
        boolean final1 = false;
        float index = 1;
        // Si no hem arribat al final
        while (!final1) {
            final1 = true;
            for (int i = 0; i < arr.length; i++) {
                float num = ((arr[i].getWinrate()*100/index));
                count[(int) (num % 10)].add(arr[i]);
                // Hem de comprobar si arribem a final
                if (final1 && num > 0) {
                    final1 = false;
                }
            }

            // Omplim el nostre nou array
            for (int i = n - 1; i >= 0; i--) {
                Jugador[] array = new Jugador[count[i].size()];
                for (int j = 0; j < count[i].size(); j++) {
                    array[j] = count[i].get(j);
                }
                MergeSort mergeSort = new MergeSort();
                if (count[i].size() != 0) {
                    mergeSort.sortP(array, 0, array.length-1);
                    count[i] = new ArrayList<>(Arrays.asList(array));
                }
            }
            // Finalment posem els valors que tenim en el array que teniem en el nostre array original
            // Ara ja tenim els valors ordenats de la manera que voliem
            int pos = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < count[i].size(); j++) {
                    arr[pos] = count[i].get(j);
                    pos++;
                }
                count[i].clear();
            }
            index *= n;
        }
    }

    // Radix Sort
    static void radixsortP(Jugador arr[], int n) {
        // Busquem el maxim nombre per saber el número de dígits
        int m = getMaxP(arr, n);
        // Ordenem amb l'anterior mètode cada dígit que tenim. la variable EXP es 10^i
        // Ho anem dividint per anar comprovant dígit per dígit.
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSortP(arr);
    }
}