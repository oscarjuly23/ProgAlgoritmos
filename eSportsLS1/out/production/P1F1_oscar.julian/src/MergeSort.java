public class MergeSort {

    // ORDENACIÓ D'EQUIPS PER WINRATE

    void MSortWinrate(Team array[], int primer, int mig, int segon) {
        // Dimensionem els arrays
        int dim1 = mig - primer + 1;
        int dim2 = segon - mig;

        // Creem dos arrays temporals
        Team arrT1[] = new Team [dim1];
        Team arrT2[] = new Team [dim2];

        // Omplim els arrays temporals
        for (int i = 0; i < dim1; ++i)
            arrT1[i] = array[primer + i];

        for (int j = 0; j < dim2; ++j)
            arrT2[j] = array[mig + 1 + j];

        int left=0;
        int right=0;

        // Ara ordenarem els arrays temporals
        int full = primer;
        while (left < dim1 && right < dim2) {
            // Com ordenem de gran a petit hem de mirar que el valor del primer array temporal sigui més gran
            // que el valor del segon array temporal. Si és així, posem el valor en la posició que apuntem (full).
            // Després seguim recorrent l'array per comprobar el següent valor.
            if (arrT1[left].getWinrate() >= arrT2[right].getWinrate()) {
                array[full] = arrT1[left];
                left++;
            } else {
                array[full] = arrT2[right];
                right++;
            }
            full++;
        }

        while (left < dim1) {
            array[full] = arrT1[left];
            left++;
            full++;
        }

        while (right < dim2) {
            array[full] = arrT2[right];
            right++;
            full++;
        }
    }



    // ORDENACIÓ DE JUGADORS PER NACIONALITAT (+ nom)

    void MSortNationality(Jugador array[], int primer, int mig, int segon) {
        int dim1 = mig - primer + 1;
        int dim2 = segon - mig;

        Jugador arrT1[] = new Jugador [dim1];
        Jugador arrT2[] = new Jugador [dim2];

        for (int i = 0; i < dim1; ++i)
            arrT1[i] = array[primer + i];

        for (int j = 0; j < dim2; ++j)
            arrT2[j] = array[mig + 1 + j];

        int left=0;
        int right=0;

        int full = primer;
        while (left < dim1 && right < dim2) {
            if (arrT1[left].getNationality().toLowerCase().compareTo(arrT2[right].getNationality().toLowerCase()) == 0) {
                if (arrT1[left].getName().toLowerCase().compareTo(arrT2[right].getName().toLowerCase()) > 0) {
                    array[full] = arrT2[right];
                    right++;
                } else {
                    array[full] = arrT1[left];
                    left++;
                }
            } else if (arrT1[left].getNationality().toLowerCase().compareTo(arrT2[right].getNationality().toLowerCase()) < 0) {
                array[full] = arrT1[left];
                left++;
            } else {
                array[full] = arrT2[right];
                right++;
            }
            full++;
        }

        while (left < dim1) {
            array[full] = arrT1[left];
            left++;
            full++;
        }

        while (right < dim2) {
            array[full] = arrT2[right];
            right++;
            full++;
        }
    }



    // ORDENACIÓ DE JUGADORS PER COMBINACIÓ DE PRIORITATS

    void MSortPriority(Jugador array[], int primer, int mig, int segon) {
        int dim1 = mig - primer + 1;
        int dim2 = segon - mig;

        Jugador arrT1[] = new Jugador [dim1];
        Jugador arrT2[] = new Jugador [dim2];

        for (int i = 0; i < dim1; ++i)
            arrT1[i] = array[primer + i];

        for (int j = 0; j < dim2; ++j)
            arrT2[j] = array[mig + 1 + j];

        int left=0;
        int right=0;

        int full = primer;
        while (left < dim1 && right < dim2) {
            if (arrT1[left].getWinrate() == arrT2[right].getWinrate()) {
                if (arrT1[left].getKDA() > arrT2[right].getKDA()) {
                    array[full] = arrT2[right];
                    right++;
                } else {
                    array[full] = arrT1[left];
                    left++;
                }
            } else if (arrT1[left].getWinrate() < arrT2[right].getWinrate()) {
                array[full] = arrT1[left];
                left++;
            } else {
                array[full] = arrT2[right];
                right++;
            }
            full++;
        }

        while (left < dim1) {
            array[full] = arrT1[left];
            left++;
            full++;
        }

        while (right < dim2) {
            array[full] = arrT2[right];
            right++;
            full++;
        }
    }

    // Cridarem la mateixa funció recursivament fins que arribem a un punt on el tamany del array sigui de 1.
    void sort(Team array[], int primer, int segon) {
        if (primer < segon) {
            int mig = (primer+segon)/2;

            sort(array, primer, mig);
            sort(array, mig+1, segon);

            MSortWinrate(array, primer, mig, segon);
        }
    }

    void sortN(Jugador array[], int primer, int segon) {
        if (primer < segon) {
            int mig = (primer+segon)/2;

            sortN(array, primer, mig);
            sortN(array, mig+1, segon);

            MSortNationality(array, primer, mig, segon);
        }
    }

    void sortP(Jugador array[], int primer, int segon) {
        if (primer < segon) {
            int mig = (primer+segon)/2;

            sortP(array, primer, mig);
            sortP(array, mig+1, segon);

            MSortPriority(array, primer, mig, segon);
        }
    }
}