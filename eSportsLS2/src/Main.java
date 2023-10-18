import Model.Campeon;
import Model.Comida;
import Model.Team;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
            int option1;
        boolean out1 = false;
        long t_inici, t_final, t_total;

        Scanner sn = new Scanner(System.in);
        Gson gson = new Gson();

        // Llegim l'arxiu JSON proporcionat
        try (Reader reader1 = new FileReader(".\\datasets\\dataset_Champ.json")) {
            // Convert JSON File to Java Object
            Campeon[] campeones = gson.fromJson(reader1, Campeon[].class);
            try (Reader reader2 = new FileReader(".\\datasets\\datasetP18.json")) {
                // Convert JSON File to Java Object
                Team[] teams = gson.fromJson(reader2, Team[].class);
                try (Reader reader3 = new FileReader(".\\datasets\\dataset50.json")) {
                    // Convert JSON File to Java Object
                    Comida[] comidas = gson.fromJson(reader3, Comida[].class);

                    while (!out1){
                        System.out.println("1. Backtracking (Menu más equilibrado)");
                        System.out.println("2. Branch & Bound + Greedy (Fase de Grupos)");
                        System.out.println();
                        System.out.println("Selecciona una opció:");
                        option1 = sn.nextInt();

                        switch (option1) {
                            case 1: // Backtraking
                                int k = 0, totalkc = 0;
                                float totalfat = 0;
                                // Array de booleans per saber si els plats estan visitats o no
                                boolean[] v = new boolean[comidas.length];
                                Comida[] menu = new Comida[5];
                                Backtraking backT = new Backtraking();
                                t_inici = System.currentTimeMillis();
                                backT.menuMasEquilibrado(comidas, menu, k, totalkc, totalfat, v);
                                t_final = System.currentTimeMillis();
                                t_total = t_final - t_inici;
                                System.out.println("Tarda " + t_total + "ms");
                                System.out.println();
                                break;

                            case 2: // Branch&Bound + Greedy
                                // GREEDY
                                System.out.println();
                                System.out.println("///////////////////////////////////////////////////////////////////");
                                System.out.println("GREEDY");
                                System.out.println("///////////////////////////////////////////////////////////////////");

                                Greedy greedy = new Greedy();
                                t_inici = System.currentTimeMillis();
                                greedy.faseDeGruposG(teams, campeones);
                                t_final = System.currentTimeMillis();
                                t_total = t_final - t_inici;
                                System.out.println("Greedy tarda " + t_total + "ms");

                                // BRANCH & BOUND
                                System.out.println();
                                System.out.println();
                                System.out.println("///////////////////////////////////////////////////////////////////");
                                System.out.println("BRANCH & BOUND");
                                System.out.println("///////////////////////////////////////////////////////////////////");
                                System.out.println();
                                k = 0;
                                Team[] equipsGrup = new Team[teams.length];
                                int counters = 0;
                                BranchNBound branchNBound = new BranchNBound();
                                // Primerament hem fet una funció per ordenar-nos els equips:
                                equipsGrup = branchNBound.equipOrdenar(teams, equipsGrup);
                                t_inici = System.currentTimeMillis();
                                branchNBound.faseDeGrupos(teams, equipsGrup, k, campeones, counters);
                                t_final = System.currentTimeMillis();
                                t_total = t_final - t_inici;
                                System.out.println("B&B tarda " + t_total + "ms");
                                System.out.println();
                                break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}