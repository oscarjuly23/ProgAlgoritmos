import Model.Campeon;
import Model.Team;

import java.util.ArrayList;
import java.util.Comparator;

public class BranchNBound {
    private static int millor = Integer.MAX_VALUE;  // Mínim número de counters.
    private static Team[] millorX;  // Equip amb menys counters

    // S'HA DE FER BE EL PRINTALL
    // Funció auxiliar per printar un menú equilibrat (solució o no)
    private void printAll(Team[] config, int k, boolean isSolution) {
        System.out.print(k + ": [");
        System.out.println();
        for (int i = 0; i <= config.length-1; i++) {
            System.out.print(config[i].getTeam() + ", " + config[i].getNationality() + ", " + config[i].getCountersTotals());
            System.out.println();
            if (i==5 || i==11){
                System.out.println("------------------------");
            }
        }
        System.out.print("]");
        if (isSolution) {
            System.out.println(" (SOL)");
        } else {
            System.out.println();
        }
    }

    public void faseDeGrupos(Team[] teams, Team[] equipsGrup, int k, Campeon[] campeons, int counters) {
        // Primer de tot generem els succesors:
        ArrayList<Team> s = Successors(teams, equipsGrup, campeons, k);
        // Ordenem per minimitzar i poder podar més:
        s.sort(Comparator.comparingInt(Team::getCountersTotals)); // Ordenem per menys counters.

        for (int i = 0; i < s.size(); i++) {
            // Per mirar les posicions on no estan els equips españols hem de mirar les posicions (k+1+(k/5)
            // De aquesta manera evitem la 0 i els multiples de 6 (0, 6, 12).
            // MARCATGE
            // Per a marcar els equips que ja hem afegit a un grup hem afegit un atribut boleà a la classe de teams.
            s.get(i).setV(true);
            equipsGrup[k+1+(k/5)] = s.get(i);
            equipsGrup[k+1+(k/5)].setV(true);
            counters = counters + equipsGrup[k+1+(k/5)].getCountersTotals();
            // Quan ja tinguem tots els quips afegits als grups:
            if (k+equipsGrup.length/6 == equipsGrup.length - 1) {
                // SOLUCIÓ:
                if (counters < millor) {
                    millor = counters;
                    System.out.println("MILLOR");
                    millorX = equipsGrup;
                    printAll(millorX, k, true);
                }
            // Cas no solució
            } else {
                // Counters ha de ser menor a millor sino no cal continuar.
                if (counters < millor) {
                    faseDeGrupos(teams, equipsGrup, k + 1, campeons, counters);
                }
            }
            // DESMARCATGE
            equipsGrup[k+1+(k/5)].setV(false);
            counters = counters - equipsGrup[i].getCountersTotals();
            s.get(i).setV(true);
        }
    }

    // Aquesta funció genera els posibles successors en cada grup. També calcula el número de counters.
    private ArrayList<Team> Successors(Team[] teams, Team[] equipsGrup, Campeon[] campeons, int k) {
        ArrayList<Team> equips = new ArrayList<>();
        // Recorro els equips
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].isV() == false) {
                // Afegim els counters dels equips españols que tenen cada equip del grup.
                // Com la posició dels equips són els múltiples de 6 fem grup[k/6*6]
                teams[i].setCountersTotals(Greedy.calculateCounters(equipsGrup[k / 6 * 6], teams[i], campeons));
                // Els afegim al arraylist de manera que tindrem tots els successors (equips no espanyols).
                equips.add(teams[i]);
            }
        }
        return equips;
    }

    // Aquesta funció serveix per ordenar els equips que passarem al BnB:
    public Team[] equipOrdenar(Team[] teams, Team[] equipsGrup){
        int pos = 0;
        // Necessito tenir els Españols en les posicions inicials.
        // Recorro els equips
        for (int i = 0; i < teams.length; i++) {
            // Com a successors valids només seran aquells que encara no tenen grup assignat.
            if (teams[i].getNationality().equals("España")) {
                equipsGrup[pos] = teams[i];
                // Marquem com a visitats ja que els equips españols no es mouran, nomes comprobarem els successors.
                teams[i].setV(true);
                // Quan afegim un equip español augmentem la posició on volem afegir el següent equip español en 6.
                // D'aquesta manera ens asegurem de afegir-lo al següent grup (ja que els grups son de 6 equips).
                pos = pos+6;
                if (pos >= teams.length) {
                    break;
                }
            }
        }
        return equipsGrup;
    }
}