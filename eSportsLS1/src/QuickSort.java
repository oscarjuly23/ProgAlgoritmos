public class QuickSort {

     // ORDENACIÓ D'EQUIPS PER WINRATE

    int QSortWinrate(Team array[], int gran, int petit) {
        // Guardem just la posició del array que està al mig.
        int mig = (petit+gran)/2;
        // El nostre punt de pivot serà el mig de l'array.
        Team pivot = array[mig];
            // Fem un while fins trobar que l'element gran sigui més petit o igual que l'element petit.
            // Quan ens trobem aquest punt vol dir que ja hem recorregut tot l'array i està ordenat.
            while (gran <= petit) {
                // Recorrem l'array d'esquerra a dreta i busquem un element que sigui més petit que el pivot.
                while (array[gran].getWinrate() > pivot.getWinrate()) {
                    gran++;
                }
                // Recorrem l'array de dreta a esquerra i busquem un element que sigui més gran que el pivot.
                while (array[petit].getWinrate() < pivot.getWinrate()) {
                    petit--;
                }
                // A partir d'aquí mirarem els seus valors, si el valor de 'gran' és més petit que el de 'petit'
                // El que fem és intercanviar els seus valors.
                if (gran < petit) {
                    Team tmp = array[gran];
                    array[gran] = array[petit];
                    array[petit] = tmp;
                    // Quan ja hem intercanviat els seus valors hem de seguir recorrent l'array, tant de esquerra
                    // a dreta com de dreta a esquerra.
                    gran++;
                    petit--;
                    // Si trobem que el valor de gran i petit es el mateix els deixarem on són i seguirem buscant.
                } else if (gran == petit) {
                    gran++;
                    petit--;
                }
            }
        return gran;
    }

    void QuickSortW(Team array[], int petit, int gran) {
        int nou_mig = QSortWinrate(array, petit, gran);
        if (petit < gran) {
            QuickSortW(array, petit, nou_mig -1);
            QuickSortW(array, nou_mig, gran);
        }
    }


    // ORDENACIÓ DE JUGADORS PER NACIONALITAT (+ nom)

    // La estructura principal és la mateixa que en la Ordenació per Winrate
    int QSortNacionalitat(Jugador array[], int gran, int petit) {
        int mig = (petit + gran) / 2;
        Jugador pivot = array[mig];
        while (gran <= petit) {
            // Com en aquest cas comparem Strings i no Floats necessitarem utilitzar un booleà amb el .compareTo
            // Important també comprovem si la nacionalitat es la mateixa hem de ordenar per nom.
            // Hem passat tot a minúsculas per ordenar-ho tot correctament

            while (((array[gran].getNationality().toLowerCase().compareTo(pivot.getNationality().toLowerCase()) == 0 && array[gran].getName().toLowerCase().compareTo(pivot.getName().toLowerCase()) < 0)) || (array[gran].getNationality().toLowerCase().compareTo(pivot.getNationality().toLowerCase()) < 0))  {
                gran++;
            }
            while ((array[petit].getNationality().toLowerCase().compareTo(pivot.getNationality().toLowerCase()) == 0 && array[petit].getName().toLowerCase().compareTo(pivot.getName().toLowerCase()) > 0) || (array[petit].getNationality().toLowerCase().compareTo(pivot.getNationality().toLowerCase()) > 0)) {
                petit--;
            }

            if (gran < petit) {
                Jugador tmp = array[gran];
                array[gran] = array[petit];
                array[petit] = tmp;
                gran++;
                petit--;
            } else if (gran == petit) {
                gran++;
                petit--;
            }
        }
        return gran;
    }

    void QuickSortN(Jugador array[], int petit, int gran) {
        int nou_mig = QSortNacionalitat(array, petit, gran);
        if (petit < gran) {
            QuickSortN(array, petit, nou_mig-1);
            QuickSortN(array, nou_mig, gran);
        }
    }


    // ORDENACIÓ DE JUGADORS PER COMBINACIÓ DE PRIORITATS

    int QSortPriority(Jugador array[], int gran, int petit) {
        int mig = (petit+gran)/2;
        Jugador pivot = array[mig];

        while (gran <= petit) {
            while ((array[gran].getWinrate() == pivot.getWinrate() && array[gran].getKDA() > pivot.getKDA()) || (array[gran].getWinrate() > pivot.getWinrate())) {
                gran++;
            }
            while ((array[petit].getWinrate() == pivot.getWinrate() && array[petit].getKDA() < pivot.getKDA()) || (array[petit].getWinrate() < pivot.getWinrate())) {
                petit--;
            }

            if (gran < petit) {
                Jugador tmp = array[gran];
                array[gran] = array[petit];
                array[petit] = tmp;
                gran++;
                petit--;
            } else if (gran == petit) {
                gran++;
                petit--;
            }
        }
        return gran;
    }

    void QuickSortP(Jugador array[], int petit, int gran) {
        int nou_mig = QSortPriority(array, petit, gran);
        if (petit < gran) {
            QuickSortP(array, petit, nou_mig -1);
            QuickSortP(array, nou_mig, gran);
        }
    }
}