package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    //
    private static Livre[] livres = new Livre[999];
    private static Lecteur[] lecteurs = new Lecteur[999];
    private static Bienfaiteur[] bienfaiteurs = new Bienfaiteur[999];

    //
    public static void main(String[] args) {
        menu();
    }

    //
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int choix = -1;
        while (choix != 0) {
            System.out.println("===| MENU |===\nSelectionnez une classe :\n1: Livre.\n2: Lecteur.\n3: Bienfaiteur.\n0: Quitter");
            System.out.print("Choix : ");
            choix = sc.nextInt();
            if (choix >= 1 && choix <= 3) {
                int choix2 = -1;
                while (choix2 != 0) {
                    System.out.println("***|choisissez une op�ration |***\n1: Ajouter.\n2: Modifier.\n3: Supprimer.\n4: Rechercher.\n5: Afficher.");
                    System.out.println("0: Pr�c�dent.");
                    System.out.print("Choix: ");
                    choix2 = sc.nextInt();
                    switch (choix2) {
                        case 0:
                            break;
                        case 1:
                            ajouter(choix);
                            break;
                        case 2:
                            modifier(choix);
                            break;
                        case 3:
                            supprimer(choix);
                            break;
                        case 4:
                            rechercher(choix);
                            break;
                        case 5:
                            afficher(choix);
                            break;
                        default:
                            System.out.println("---\nChoix invalide!\n---");
                    }
                }
            } else if (choix != 0)
                System.out.println("---\nChoix invalide!\n---");
        }
        System.out.println("Programme arr�t�");
    }

    //
    public static void ajouter(int choix) {
        Scanner sc = new Scanner(System.in);
        switch (choix) {
            case 1:
                if (bienfaiteurs[0] != null) {
                    System.out.print("Titre : ");
                    String titre = sc.nextLine();
                    //
                    System.out.print("Edition : ");
                    String edition = sc.nextLine();
                    //
                    System.out.print("Date d'�dition (jj/mm/aaaa) : ");
                    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
                    Date date;
                    Calendar dateEdition = Calendar.getInstance();
                    try {
                        date = format.parse(sc.nextLine());
                        dateEdition = format.getCalendar();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //
                    System.out.println("Choisir un bienfaiteur :");
                    int pos = 1;
                    for (Bienfaiteur bienfaiteur : bienfaiteurs) {
                        if (bienfaiteur == null)
                            break;
                        System.out.printf("%d: %s\n", pos, bienfaiteur.getSurnom());
                        pos++;
                    }
                    System.out.println("---\n0: Annuler");
                    int choixB = -1;
                    while (choixB != 0) {
                        System.out.print("Choix : ");
                        choixB = sc.nextInt();
                        if (choixB != 0) {
                            if (bienfaiteurs[choixB - 1] != null && bienfaiteurs.length > choixB - 1) {
                                int idB = bienfaiteurs[choixB - 1].getIdentifiant();
                                //
                                livres[arraySize(livres)] = new Livre(titre, edition, idB, dateEdition);
                                System.out.println("Livre ajout� avec succ�s.");
                                choixB = 0;
                            } else
                                System.out.println("---\nChoix invalide!\n---");
                        }
                    }
                } else System.out.println("Ajouter un bienfaiteur d'abord");
                break;
            case 2:
                System.out.print("Nom : ");
                String nom = sc.nextLine();
                System.out.print("Prenom : ");
                String prenom = sc.nextLine();
                System.out.print("Num�ro de t�l�phone : ");
                int numTel = sc.nextInt();
                System.out.print("Adresse email : ");
                String mail_L = sc.next();
                //
                lecteurs[arraySize(lecteurs)] = new Lecteur(nom, prenom, numTel, mail_L);
                System.out.println("Lecteur ajout� avec succ�s.");
                break;
            case 3:
                System.out.print("Surnom : ");
                String surnom = sc.nextLine();
                System.out.print("Adresse email : ");
                String mail_B = sc.nextLine();
                //
                bienfaiteurs[arraySize(bienfaiteurs)] = new Bienfaiteur(surnom, mail_B);
                System.out.println("Bienfaiteur ajout� avec succ�s.");
                break;
        }
    }

    //
    public static void modifier(int choix) {
        Scanner sc = new Scanner(System.in);
        displayData(choix);
        System.out.println("---\n0: Annuler");
        switch (choix) {
            case 1:
                int choix_L = -1;
                while (choix_L != 0) {
                    System.out.print("Choix : ");
                    choix_L = sc.nextInt();
                    //
                    if (choix_L != 0) {
                        if (livres[choix_L - 1] != null && livres.length > choix_L - 1) {
                            System.out.println("_** Laissez le champ vide si vous ne voulez pas le modifier **_");
                            //
                            System.out.print("Titre : ");
                            String titre = sc.nextLine();
                            //
                            System.out.print("Edition : ");
                            String edition = sc.nextLine();
                            //
                            System.out.print("Date d'�dition (jj/mm/aaaa) : ");
                            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
                            Date date;
                            Calendar dateEdition = Calendar.getInstance();
                            try {
                                date = format.parse(sc.nextLine());
                                dateEdition = format.getCalendar();
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            //
                            System.out.println("Choisir un bienfaiteur :");
                            int pos = 1;
                            for (Bienfaiteur bienfaiteur : bienfaiteurs) {
                                if (bienfaiteur == null)
                                    break;
                                System.out.printf("%d: %s\n", pos, bienfaiteur.getSurnom());
                                pos++;
                            }
                            System.out.println("---\n-1: valeur par d�faut.\n0: Annuler");
                            int choixB = -1;
                            while (choixB != 0) {
                                System.out.print("Choix : ");
                                choixB = sc.nextInt();
                                if (choixB != 0) {
                                    if (choixB == -1) {
                                        livres[choix_L - 1].modifier(titre, edition, -1, dateEdition);
                                        System.out.println("Livre modifi� avec succ�s.");
                                        choixB = 0;
                                    } else if (bienfaiteurs[choixB - 1] != null && bienfaiteurs.length > choixB - 1) {
                                        int idB = bienfaiteurs[choixB - 1].getIdentifiant();
                                        //
                                        livres[choix_L - 1].modifier(titre, edition, idB, dateEdition);
                                        System.out.println("Livre modifi� avec succ�s.");
                                        choixB = 0;
                                    } else
                                        System.out.println("---\nChoix invalide!\n---");
                                }
                            }
                            choix_L = 0;
                        } else System.out.println("---\nChoix invalide!\n---");
                    }
                }
                break;
            case 2:
                int choix_LT = -1;
                while (choix_LT != 0) {
                    System.out.print("Choix : ");
                    choix_LT = sc.nextInt();
                    //
                    if (choix_LT != 0) {
                        if (lecteurs[choix_LT - 1] != null && lecteurs.length > choix_LT - 1) {
                            System.out.println("_** Ecrire '*' si vous ne voulez pas modifier le champ **_");
                            System.out.print("Nom : ");
                            String nom = sc.next();
                            System.out.print("Prenom : ");
                            String prenom = sc.next();
                            System.out.print("Num�ro de t�l�phone : ");
                            String strNumTel = sc.next();
                            int numTel = 0;
                            if (!strNumTel.equals("*"))
                                numTel = Integer.parseInt(strNumTel);
                            System.out.print("Adresse email : ");
                            String mail_L = sc.next();
                            //
                            lecteurs[choix_LT - 1].modifier(nom, prenom, numTel, mail_L);
                            System.out.println("Lecteur modifi� avec succ�s.");
                            //
                            choix_LT = 0;
                        } else System.out.println("---\nChoix invalide!\n---");
                    }
                }
                break;
            case 3:
                int choix_B = -1;
                while (choix_B != 0) {
                    System.out.print("Choix : ");
                    choix_B = sc.nextInt();
                    //
                    if (choix_B != 0) {
                        if (bienfaiteurs[choix_B - 1] != null && bienfaiteurs.length > choix_B - 1) {
                            System.out.println("_** Laissez le champ vide si vous ne voulez pas le modifier **_");
                            System.out.print("Surnom : ");
                            String surnom = sc.nextLine();
                            System.out.print("Adresse email : ");
                            String mail_B = sc.nextLine();
                            //
                            bienfaiteurs[choix_B - 1].modifier(surnom, mail_B);
                            System.out.println("Bienfaiteur modifi� avec succ�s.");
                            //
                            choix_B = 0;
                        } else System.out.println("---\nChoix invalide!\n---");
                    }
                }
                break;
        }
    }

    //
    public static void supprimer(int choix) {
        displayData(choix);
        System.out.println("---\n0: Annuler");
        int choix_D = -1;
        Scanner sc = new Scanner(System.in);
        while (choix_D != 0) {
            System.out.print("Choix : ");
            choix_D = sc.nextInt();
            if (choix_D != 0) {
                switch (choix) {
                    case 1:
                        if (arraySize(livres) > choix_D - 1 && choix_D > 0) {
                            System.out.print("Etes-vous s�r de supprimer cette �l�ment ? (oui(O) / non(N))");
                            String confirmD_l = sc.next().toLowerCase();
                            if (confirmD_l.equals("oui") || confirmD_l.equals("o")) {
                                for (int i = choix_D - 1; i < arraySize(livres); i++) {
                                    livres[i] = livres[i + 1];
                                }
                                System.out.println("Livre supprim� avec succ�s");
                            }
                            choix_D = 0;
                        } else System.out.println("---\nChoix invalide!\n---");
                        break;
                    case 2:
                        if (arraySize(lecteurs) > choix_D - 1 && choix_D > 0) {
                            System.out.print("Etes-vous s�r de supprimer cette �l�ment ? (oui(O) / non(N))");
                            String confirmD_lc = sc.next().toLowerCase();
                            if (confirmD_lc.equals("oui") || confirmD_lc.equals("o")) {
                                for (int i = choix_D - 1; i < arraySize(lecteurs); i++) {
                                    lecteurs[i] = lecteurs[i + 1];
                                }
                                System.out.println("Lecteur supprim� avec succ�s");
                            }
                            choix_D = 0;
                        } else System.out.println("---\nChoix invalide!\n---");
                        break;
                    case 3:
                        if (arraySize(bienfaiteurs) > choix_D - 1 && choix_D > 0) {
                            System.out.print("Etes-vous s�r de supprimer cette �l�ment ? (oui(O) / non(N))");
                            String confirmD_b = sc.next().toLowerCase();
                            if (confirmD_b.equals("oui") || confirmD_b.equals("o")) {
                                for (int i = choix_D - 1; i < arraySize(bienfaiteurs); i++) {
                                    bienfaiteurs[i] = bienfaiteurs[i + 1];
                                }
                                System.out.println("Bienfaiteur supprim� avec succ�s");
                            }
                            choix_D = 0;
                        } else System.out.println("---\nChoix invalide!\n---");
                        break;
                }
            }
        }
    }

    //
    public static void afficher(int choix) {
        switch (choix) {
            case 1:
                System.out.printf("Nombre total des livres disponibles : %d\n", arraySize(livres));
                break;
            case 2:
                int nbLecteurF = 0;
                for (Lecteur lecteur : lecteurs) {
                    if (lecteur == null)
                        break;
                    else {
                        if (!lecteur.getCarteFidelite().getStatu().equals("non fid�le"))
                            nbLecteurF++;
                    }
                }
                //
                System.out.printf("Nombre total des lecteurs : %d, nombre total des lecteurs fid�les: %d\n", arraySize(lecteurs), nbLecteurF);
                break;
            case 3:
                int nbBienfaiteurF = 0;
                for (Bienfaiteur bienfaiteur : bienfaiteurs) {
                    if (bienfaiteur == null)
                        break;
                    else {
                        if (bienfaiteur.getCarteFidelite().getStatu().equals("super-fid�le"))
                            nbBienfaiteurF++;
                    }
                }
                System.out.printf("Nombre total des bienfaiteurs : %d, nombre total des bienfaiteurs super-fid�les : %d\n", arraySize(bienfaiteurs), nbBienfaiteurF);
                break;
        }
        displayData(choix);
        System.out.println("---");
    }

    //
    public static void rechercher(int choix) {
        System.out.print("---\nIdentifiant : ");
        Scanner sc = new Scanner(System.in);
        int idC = sc.nextInt();
        //
        switch (choix) {
            case 1:
                int exists_livre = -1;
                for (int i = 0; i < arraySize(livres); i++) {
                    if (livres[i].getIdentifiant() == idC) {
                        exists_livre = i;
                        break;
                    }
                }
                if (exists_livre != -1)
                    System.out.printf("Livre trouv�e :\n%s\n", livres[exists_livre].toString());
                else
                    System.out.println("Livre non trouv� !");
                break;
            case 2:
                int exists_lecteur = -1;
                for (int i = 0; i < arraySize(lecteurs); i++) {
                    if (lecteurs[i].getIdentifiant() == idC) {
                        exists_lecteur = i;
                        break;
                    }
                }
                if (exists_lecteur != -1)
                    System.out.printf("Lecteur trouv�e :\n%s\n", lecteurs[exists_lecteur].toString());
                else
                    System.out.println("Lecteur non trouv� !");
                break;
            case 3:
                int exists_bienfaiteur = -1;
                for (int i = 0; i < arraySize(bienfaiteurs); i++) {
                    if (bienfaiteurs[i].getIdentifiant() == idC) {
                        exists_bienfaiteur = i;
                        break;
                    }
                }
                if (exists_bienfaiteur != -1)
                    System.out.printf("Bienfaiteur trouv�e :\n%s\n", bienfaiteurs[exists_bienfaiteur].toString());
                else
                    System.out.println("Bienfaiteurs non trouv� !");
                break;
        }
    }

    //
    //
    //
    public static int arraySize(Livre[] array) {
        int pos = 0;
        for (Livre livre : array) {
            if (livre != null)
                pos++;
            else break;
        }
        //
        return pos;
    }

    public static int arraySize(Lecteur[] array) {
        int pos = 0;
        for (Lecteur lecteur : array) {
            if (lecteur != null)
                pos++;
            else break;
        }
        //
        return pos;
    }

    public static int arraySize(Bienfaiteur[] array) {
        int pos = 0;
        for (Bienfaiteur bienfaiteur : array) {
            if (bienfaiteur != null)
                pos++;
            else break;
        }
        //
        return pos;
    }

    //
    public static void displayData(int choix) {
        int pos = 0;
        switch (choix) {
            case 1:
                for (Livre livre : livres) {
                    if (livre != null) {
                        pos++;
                        System.out.printf("%d : %s\n", pos, livre.toString());
                    } else break;
                }
                break;
            case 2:
                for (Lecteur lecteur : lecteurs) {
                    if (lecteur != null) {
                        pos++;
                        System.out.printf("%d : %s\n", pos, lecteur.toString());
                    } else break;
                }
                break;
            case 3:
                for (Bienfaiteur bienfaiteur : bienfaiteurs) {
                    if (bienfaiteur != null) {
                        pos++;
                        System.out.printf("%d : %s\n", pos, bienfaiteur.toString());
                    } else break;
                }
                break;
        }
    }
}

