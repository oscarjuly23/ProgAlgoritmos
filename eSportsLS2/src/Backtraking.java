import Model.Comida;

public class Backtraking {
    // Algorisme de BACKTRACKING implementat per a MENÚ MÁS EQUILIBRADO
    private static int millorkc = 0;
    private static float millorfat = Float.MAX_VALUE;

    // Funció auxiliar per printar un menú equilibrat (solució o no)
    private static void printAll(Comida[] menu, int k, boolean isSolution) {
        System.out.print(k + ": [");
        for (int i = 0; i <= k; i++) {
            System.out.print(menu[i] + ", ");
        }
        System.out.print("]");
        if (isSolution) {
            System.out.println(" (SOL)");
        } else {
            System.out.println();
        }
    }

    static void menuMasEquilibrado(Comida[] comidas, Comida[] menu, int k, int totalkc, float totalfat, boolean[] v) {
        int actualkc = 0;
        float actualfat = 0;
        // Recorrem tots els plats
        for (int i = 0; i < comidas.length; i++) {
            menu[k] = comidas[i];
            // No podem repetir plats així que amb aquesta variable ens asegurem
            // si ja els hem visitat, si no, fem los següent
            if (!v[i]) {
                // MARCATGE - Agafem els valors que necessitem.
                // primerament el marquem com a visitat.
                v[i] = true;
                actualkc = comidas[i].getEnergetic_value();
                actualfat = comidas[i].getFat();
                totalkc = actualkc + totalkc;
                totalfat = actualfat + totalfat;
                // Un cop tenim 5 plats acumulats per poder formar un menú:
                if (k == 4) {
                    // SOLUCIÓ -- si la funció menuBo cumpleix les condicions, per tant és true
                    if (menuBo(totalkc, totalfat)) {
                        // Mirem si la solució que hem obtingut és la més òptima
                        // Han de tenir el màxim de Kc amb el mínim de %grasa (dins dels límits)
                           if (totalkc >  millorkc && totalfat < millorfat) {
                               millorkc = totalkc;
                               millorfat = totalfat;
                               printAll(menu, k, true);
                                System.out.println("Millor Solució! - KC: " + millorkc + " fat: " + millorfat);
                            }
                    }
                } else {
                    //printAll(menu, k, true);
                    // Completa (no solució):
                    // Si encara no tenim els 5 plats, passem al següent.
                    if (menuBo(totalkc, totalfat)) {
                        menuMasEquilibrado(comidas, menu, k + 1, totalkc, totalfat, v);
                    }
                }
                // DESMARCATGE -- Reiniciem els nostres valors o els descrementem.
                v[i] = false;
                totalkc = totalkc - actualkc;
                totalfat = totalfat - actualfat;
            }
        }
    }

    // Funció que poda les solucions amb les següents condicions:
    // Menu Equip Bo -- 1000 <kilocalorias< 3000  + 20% < grasas kc > 35%
    private static boolean menuBo(int totalkc, float totalfat) {
            if (totalkc < 3000 && (totalkc*0.2) < totalfat && (totalkc*0.35) > totalfat) {
                return true;
            }
        return false;
    }
}