import Model.Campeon;
import Model.Player;
import Model.Team;

import java.util.ArrayList;

public class Greedy {

    static void faseDeGruposG(Team[] teams, Campeon[] campeons) {
        Team[] six = new Team[7];
        Team español = new Team();
        int countersTotals = 0;
        int pos = 0;
        boolean esp = false;

        // Recorrem tots els equips
        for (int i=0; i < teams.length; i++) {
            // Primer mirem si ja tenim els sis equips guardats.
            // Si ja els tenim i ja els hem mostrat tots doncs reiniciem les nostres variables.
            if (pos == six.length-1) {
                // Calculem els counters del equip Español en el seu grup.
                // L'equip amb nacionalitat española sempre es trova en la primera posicio [0] del array.
                Team equip1 = six[0];
                Team equip2;
                for (int j = 1; j < six.length-1; j++) {
                    // D'aquesta manera minem la resta d'equips del grup.
                    equip2 = six[j];
                    countersTotals = countersTotals + calculateCounters(equip1, equip2, campeons);
                }
                System.out.println("Counters: " + countersTotals);
                // Tercer grup counters --> 1
                System.out.println("--------------------------------------");
                pos = 0;
                esp = false;
                countersTotals=0;
                six = new Team[7];
            // Si encara no tenim 6 equips i ja tenim un equip español (per tant no n'afegirem més):
            } else if (pos < six.length-1 && esp == true) {
                // Hem de mirar si aquest equip es d'España:
                if (!teams[i].getNationality().equals("España")) {
                    // Si no ho és l'afegim i passem a la següent posició.
                    six[pos] = teams[i];
                    System.out.println("Model.Team: '" + six[pos].getTeam() + "', Nacionalitat: '" + six[pos].getNationality() + "'");
                    pos++;
                // Si l'equip sí que es de España, el guardarem per a poder posar-lo al següent grup.
                } else {
                    español = teams[i];
                }
                // Si encara no tenim 6 equips i no tenim equip español l'afegim i passem a la següent posició.
            } else if (pos < six.length-1 && esp == false) {
                // Si no tenim cap equip Español i anteriorment no hem trobat cap:
                if (español.getTeam() == null) {
                    six[pos] = teams[i];
                    System.out.println("Model.Team: '" + six[pos].getTeam() + "', Nacionalitat: '" + six[pos].getNationality() + "'");
                    // Si aquest es d'España, el marquem que ja tenim un Español en el bloc.
                    if (six[pos].getNationality().equals("España")) {
                        esp = true;
                    }
                    pos++;
                // En canvi si anteriormen hem guardat un equip d'España, l'utilitzarem ja que ens fa falta un equip español.
                // L'afegim, marquem com que ja tenim un equip español i passem a la següent posició:
                } else {
                    esp = true;
                    six[pos] = español;
                    System.out.println("Model.Team: '" + six[pos].getTeam() + "', Nacionalitat: '" + six[pos].getNationality() + "'");
                    español = null;
                    pos++;
                    // Com que estem reutilitzant un equip, ens hem saltat dos Teams per llegir així que hem de retrocedir dos posicions.
                    i = i -2;
                }
            }
        }
    }

    public static int calculateCounters(Team equip1, Team equip2, Campeon[] campeons) {
        // He comprovat que el primer grup l'equip español tindrà 2 counter, el segon no en té cap i el tercer 1.
        String campioCounter = null;
        int counters = 0;
        ArrayList<Player> players1 = equip1.getPlayers();
        ArrayList<Player> players2 = equip2.getPlayers();

        // Recorrem els jugadors de l' 'equip1' que és l'equip español.
        for (int i = 0; i < players1.size(); i++) {
            // Ens guardem el campió que utilitza el jugador actual.
            String campioUtilitzat = players1.get(i).getMain_champion().get(0).getName();
            // Recorrem tots els campions.
            for (int j = 0; j < campeons.length; j++) {
                // Si el nom del campio actual coincideix amb el campio que utilitza el nostre jugador actual:
                if (campioUtilitzat.equals(campeons[j].getName())) {
                    // Guardem ell seu Counter.
                    campioCounter = campeons[j].getCounter_picks();
                    break;
                }
            }
            // Recorrem els jugadors de l' 'equip2', aquest equip va variant i van passant tots els demés equips del Grup.
            for (int j = 0; j < players2.size(); j++) {
                // De la mateixa manera ens guardem el campio que utilitza el jugador actual.
                String campio2 = players2.get(j).getMain_champion().get(0).getName();
                // Si aquest campió coincideix amb el counter que hem guardat previament del nostre jugador español, counters +1;
                if (campio2.equals(campioCounter)) {
                    counters++;
                    break;
                }
            }
        }
        // Finalment aquesta variable ens retornarà cuants counters té l'equip español en el seu grup.
        return counters;
    }
}