import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        int option1, option2, option3;
        boolean out1 = false, out2 , out3 , out4;
        long t_inici, t_final, t_total;
        Scanner sn = new Scanner(System.in);

        Gson gson = new Gson();

        // Llegim l'arxiu JSON proporcionat
        try (Reader reader = new FileReader(".\\datasets\\dataseet40K.json")) {

            // Convert JSON File to Java Object
            Team[] teams = gson.fromJson(reader, Team[].class);

            // Primer menú on decidim que volem ordenar.
            while (!out1) {
                out1 = false; out2 = false; out3 = false; out4 = false;
                System.out.println("1. Ordenar Equips per Winrate");
                System.out.println("2. Ordenar Jugadors per Nacionalitat");
                System.out.println("3. Ordenar Jugadors per Combinació de Prioritats");
                System.out.println("4. Sortir.");
                System.out.println();
                System.out.println("Selecciona una opcio:");
                option1 = sn.nextInt();

                switch (option1) {
                    case 1: // Ordenar Equips per Winrate
                        // Escollim amb quin métode volem ordenar.
                        while (!out2) {
                            System.out.println("1. Ordenar amb Quick Sort");
                            System.out.println("2. Ordenar amb Merge Sort");
                            System.out.println("3. Ordenar amb Radix Sort");
                            System.out.println("4. Ordenar amb Bucket Sort");
                            System.out.println("5. Enrrere");
                            System.out.println("Seleccions una opcio:");
                            option2 = sn.nextInt();

                            switch (option2) {
                                case 1: // QuickSort
                                    QuickSort quick = new QuickSort();
                                    t_inici = System.currentTimeMillis();
                                    quick.QuickSortW(teams, 0, teams.length - 1);
                                    t_final = System.currentTimeMillis();
                                    for (Team Qsort_winrate : teams) {
                                        System.out.println(Qsort_winrate);
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 2: // Mergesort
                                    MergeSort merge = new MergeSort();
                                    t_inici = System.currentTimeMillis();
                                    merge.sort(teams, 0, teams.length - 1);
                                    t_final = System.currentTimeMillis();
                                    for (Team Msort_winrate : teams) {
                                        System.out.println(Msort_winrate);
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 3: // RadixSort
                                    RadixSort radix = new RadixSort();
                                    Team[] teams1 = new Team[teams.length];
                                    t_inici = System.currentTimeMillis();
                                    radix.radixsort(teams, teams.length );
                                    t_final = System.currentTimeMillis();
                                    for (int i = 0; i < teams.length; i++) {
                                        teams1[i] = teams[teams.length-1-i];
                                    }
                                    for (Team Rsort_winrate : teams1) {
                                        System.out.println(Rsort_winrate);
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 4: // Bucket Sort
                                    BucketSort bucket = new BucketSort();
                                    Team[] teams2 = new Team[teams.length];
                                    t_inici = System.currentTimeMillis();
                                    bucket.bucket_sort(teams);
                                    t_final = System.currentTimeMillis();
                                    for (int i = 0; i < teams.length; i++) {
                                        teams2[i] = teams[teams.length-1-i];
                                    }
                                    for (Team Bsort_winrate : teams2) {
                                        System.out.println(Bsort_winrate);
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 5: //Enrrere
                                    out2 = true;
                                    System.out.println();
                                    break;

                                default:
                                    System.out.println("Has d'intoduir un número del 1-5! Torna a intentar-ho.");
                                    System.out.println();
                                    break;
                            }
                        }
                        System.out.println();
                        break;


                    case 2: // Ordenar Jugadors per Nacionalitat
                        while (!out3) {
                            System.out.println("1. Ordenar amb Quick Sort");
                            System.out.println("2. Ordenar amb Merge Sort");
                            System.out.println("3. Ordenar amb Radix Sort");
                            System.out.println("4. Ordenar amb Bucket Sort");
                            System.out.println("5. Enrrere");
                            System.out.println("Seleccions una opcio:");
                            option3 = sn.nextInt();

                            switch (option3) {
                                // Hem creat un nou array per a cada Algorisme per a comprobar realment que l'ordeni
                                case 1: // QuickSort
                                    ArrayList<Jugador> jugadorsQ = new ArrayList<>(); // Creem un nou ArrayList dels jugadors.
                                    for (Team team : teams) {
                                        jugadorsQ.addAll(team.getJugadores()); // Omplim l'ArrayList de jugadors.
                                    }

                                    Jugador[] jugadorsNQ = new Jugador[jugadorsQ.size()]; // Creeum un nou Array
                                    jugadorsNQ = jugadorsQ.toArray(jugadorsNQ); // Passem l'arraylist a un array per poder utilitzar-ho com a array.

                                    QuickSort quick = new QuickSort();
                                    // Iniciem el temps per a càlcular quant tardarà en realitzar la ordenació
                                    t_inici = System.currentTimeMillis();
                                    quick.QuickSortN(jugadorsNQ, 0, jugadorsNQ.length-1);
                                    for (Jugador Qsort_nationality : jugadorsNQ) {
                                        System.out.println(Qsort_nationality);
                                    }
                                    // Ja hem acabat de ordenar l'array, fem el càlcul del temps de forma que sabrem quan hem tardat.
                                    t_final = System.currentTimeMillis();
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 2: // Mergesort
                                    ArrayList<Jugador> jugadorsM = new ArrayList<>(); // Creem un nou ArrayList dels jugadors.
                                    for (Team team : teams) {
                                        jugadorsM.addAll(team.getJugadores()); // Omplim l'ArrayList de jugadors.
                                    }

                                    Jugador[] jugadorsNM = new Jugador[jugadorsM.size()]; // Creeum un nou Array
                                    jugadorsNM = jugadorsM.toArray(jugadorsNM); // Passem l'arraylist a un array

                                    MergeSort merge = new MergeSort();
                                    t_inici = System.currentTimeMillis();
                                    merge.sortN(jugadorsNM, 0, jugadorsNM.length-1);
                                    t_final = System.currentTimeMillis();
                                    for (Jugador MSortNationality : jugadorsNM) {
                                        System.out.println(MSortNationality);
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 3: // RadixSort
                                    System.out.println("Epp! no podem ordenar els Jugadors per Nacionalitat amb aquest métode, prova un altre!");
                                    System.out.println();
                                    break;

                                case 4: // Bucket Sort
                                    ArrayList<Jugador> jugadorsB = new ArrayList<>(); // Creem un nou ArrayList dels jugadors.
                                    for (Team team : teams) {
                                        jugadorsB.addAll(team.getJugadores()); // Omplim l'ArrayList de jugadors.
                                    }
                                    Jugador[] jugadorsNB = new Jugador[jugadorsB.size()]; // Creeum un nou Array
                                    jugadorsNB = jugadorsB.toArray(jugadorsNB); // Passem l'arraylist a un array

                                    BucketSort bucket = new BucketSort();
                                    t_inici = System.currentTimeMillis();
                                    bucket.bucket_sortN(jugadorsNB);
                                    t_final = System.currentTimeMillis();
                                    for (Jugador Bsort_Nationality : jugadorsNB) {
                                        System.out.println(Bsort_Nationality);
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;
                                case 5: // Enrrere
                                    out3 = true;
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("Has d'intoduir un número del 1-5! Torna a intentar-ho.");
                                    System.out.println();
                                    break;
                            }
                        }
                        System.out.println();
                        break;

                    case 3: // Ordenar Jugadors per Combinació de Prioritats
                        while (!out4) {
                            System.out.println("1. Ordenar amb Quick Sort");
                            System.out.println("2. Ordenar amb Merge Sort");
                            System.out.println("3. Ordenar amb Radix Sort");
                            System.out.println("4. Ordenar amb Bucket Sort");
                            System.out.println("5. Enrrere");
                            System.out.println("Seleccions una opcio:");
                            option3 = sn.nextInt();

                            switch (option3) {
                                case 1: // QuickSort
                                    ArrayList<Jugador> jugadorsQ1 = new ArrayList<>(); // Creem un nou ArrayList dels jugadors.

                                    // Afegim el Winrate que té cada jugador segons l'equip en el que es troba
                                    int v=0;
                                    for (Team winrates: teams) {
                                        for (Jugador jugadorsP: winrates.getJugadores()) {
                                            jugadorsP.setWinrate(winrates.getWinrate());
                                            jugadorsQ1.add(v, jugadorsP);
                                            v++;
                                        }
                                    }
                                    Jugador[] jugadorsPQ = new Jugador[jugadorsQ1.size()]; // Creeum un nou Array
                                    for (int i = 0; i < jugadorsQ1.size(); i++) {           // Passem l'arraylist a un array
                                        jugadorsPQ[i] = jugadorsQ1.get(i);
                                    }
                                    QuickSort quick = new QuickSort();
                                    t_inici = System.currentTimeMillis();
                                    quick.QuickSortP(jugadorsPQ, 0, jugadorsPQ.length - 1);
                                    for (Jugador Qsort_Priority : jugadorsPQ) {
                                        System.out.println(Qsort_Priority +", Winrate: "+ Qsort_Priority.getWinrate() + ", KDA: " + Qsort_Priority.getKDA());
                                    }
                                    t_final = System.currentTimeMillis();
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 2: // Mergesort
                                    ArrayList<Jugador> jugadorsM1 = new ArrayList<>(); // Creem un nou ArrayList dels jugadors.

                                    // Afegim el Winrate que té cada jugador segons l'equip en el que es troba
                                    int k=0;
                                    for (Team winrates: teams) {
                                        for (Jugador jugadorsP: winrates.getJugadores()) {
                                            jugadorsP.setWinrate(winrates.getWinrate());
                                            jugadorsM1.add(k, jugadorsP);
                                            k++;
                                        }
                                    }
                                    Jugador[] jugadorsPM = new Jugador[jugadorsM1.size()]; // Creeum un nou Array
                                    Jugador[] jugadorsPM1 = new Jugador[jugadorsM1.size()]; // Creeum un nou Array
                                    for (int i = 0; i < jugadorsM1.size(); i++) {
                                        jugadorsPM[i] = jugadorsM1.get(i);
                                    } // Passem l'arraylist a un array

                                    MergeSort merge = new MergeSort();
                                    t_inici = System.currentTimeMillis();
                                    merge.sortP(jugadorsPM, 0, jugadorsPM.length-1);
                                    t_final = System.currentTimeMillis();
                                    for (int i = 0; i < jugadorsPM.length; i++) {
                                        jugadorsPM1[i] = jugadorsPM[jugadorsPM.length-1-i];
                                    }
                                    for (Jugador MSortPriority : jugadorsPM1) {
                                        System.out.println(MSortPriority + ", Winrate: " + MSortPriority.getWinrate() + ", KDA: " + MSortPriority.getKDA());
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 3: // RadixSort
                                    ArrayList<Jugador> jugadorsR1 = new ArrayList<>(); // Creem un nou ArrayList dels jugadors.

                                    // Afegim el Winrate que té cada jugador segons l'equip en el que es troba
                                    int g=0;
                                    for (Team winrates: teams) {
                                        for (Jugador jugadorsP: winrates.getJugadores()) {
                                            jugadorsP.setWinrate(winrates.getWinrate());
                                            jugadorsR1.add(g, jugadorsP);
                                            g++;
                                        }
                                    }
                                    Jugador[] jugadorsPR = new Jugador[jugadorsR1.size()]; // Creem un nou Array
                                    Jugador[] jugadorsPR1 = new Jugador[jugadorsR1.size()]; // Creem un nou Array

                                    for (int i = 0; i < jugadorsR1.size(); i++) {
                                        jugadorsPR[i] = jugadorsR1.get(i);
                                    }

                                    RadixSort radix = new RadixSort();
                                    t_inici = System.currentTimeMillis();
                                    radix.radixsortP(jugadorsPR, jugadorsPR1.length);
                                    t_final = System.currentTimeMillis();

                                    for (int i = 0; i < jugadorsPR.length; i++) {
                                        jugadorsPR1[i] = jugadorsPR[jugadorsPR.length - 1 - i];
                                    }
                                    for (Jugador Rsort_priority : jugadorsPR1) {
                                        System.out.println(Rsort_priority + ", Winrate: "+ Rsort_priority.getWinrate() + ", KDA: " + Rsort_priority.getKDA());
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;

                                case 4: // Bucket Sort
                                    ArrayList<Jugador> jugadorsB1 = new ArrayList<>(); // Creem un nou ArrayList dels jugadors.

                                    // Afegim el Winrate que té cada jugador segons l'equip en el que es troba
                                    int f=0;
                                    for (Team winrates: teams) {
                                        for (Jugador jugadorsP: winrates.getJugadores()) {
                                            jugadorsP.setWinrate(winrates.getWinrate());
                                            jugadorsB1.add(f, jugadorsP);
                                            f++;
                                        }
                                    }

                                    Jugador[] jugadorsPB = new Jugador[jugadorsB1.size()]; // Creeum un nou Array
                                    Jugador[] jugadorsPB1 = new Jugador[jugadorsB1.size()]; // Creeum un nou Array
                                    for (int i = 0; i < jugadorsB1.size(); i++) {
                                        jugadorsPB[i] = jugadorsB1.get(i);
                                    }

                                    BucketSort bucket = new BucketSort();
                                    t_inici = System.currentTimeMillis();
                                    bucket.bucket_sortP(jugadorsPB);
                                    t_final = System.currentTimeMillis();
                                    for (int i = 0; i < jugadorsPB.length; i++) {
                                        jugadorsPB1[i] = jugadorsPB[jugadorsPB.length-1-i];
                                    }
                                    for (Jugador Bsort_Priority : jugadorsPB1) {
                                        System.out.println(Bsort_Priority + ", Winrate: " + Bsort_Priority.getWinrate() + ", KDA: " + Bsort_Priority.getKDA());
                                    }
                                    t_total = t_final - t_inici;
                                    System.out.println("Tarda " + t_total + "ms");
                                    System.out.println();
                                    break;
                                case 5: // Enrrere
                                    out4 = true;
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("Has d'intoduir un número del 1-5! Torna a intentar-ho.");
                                    System.out.println();
                                    break;
                            }
                        }
                        System.out.println();
                        break;

                    case 4: // Salir
                        out1 = true;
                        System.out.println();
                        break;
                    default:
                        System.out.println("Has d'intoduir un número del 1-4! Torna a intentar-ho.");
                        System.out.println();
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}