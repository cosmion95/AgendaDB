import java.util.Scanner;
import java.sql.SQLException;

public class MainMenu {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        DemoCRUDOperations dbOperations = new DemoCRUDOperations();
        int optiune = -1;
        Scanner input = new Scanner(System.in);

        do {
            afisareMeniu();
            optiune = input.nextInt();
            switch (optiune) {

                case 1:
                    {
                    dbOperations.displayAgenda();
                    break;
                }

                case 2:
                    {
                        System.out.println("-----Adaugare contact------");
                        System.out.print("Nume: ");
                        String nume = citesteString();
                        System.out.print("Telefon: ");
                        String telefon = citesteString();
                        person p = new person();
                        p.setNume(nume);
                        p.setTelefon(telefon);
                        dbOperations.adaugareAgenda(p);
                        break;
                }

                case 3:
                    {
                        dbOperations.setCheck();
                        System.out.print("Nume contact cautat: ");
                        String nume = citesteString();
                        person p = new person();
                        p.setNume(nume);
                        dbOperations.cautareNume(p);
                        if (dbOperations.isCheck()) {
                            System.out.println("\nContactul nu a fost gasit!");
                        }
                        break;
                }

                case 4:
                {
                    dbOperations.setCheck();
                    System.out.println("-----Modificare contact-----");
                    person p = new person();
                    System.out.print("Nume contact cautat: ");
                    String numeVechi = citesteString();
                    p.setNume(numeVechi);
                    dbOperations.cautareNume(p);
                    if (dbOperations.isCheck()) {
                        System.out.println("\nContactul nu a fost gasit!");
                    }
                    else {
                        System.out.print("\nNoul nume: ");
                        String numeNou = citesteString();
                        p.setNume(numeNou);
                        System.out.print("\nNr. telefon: ");
                        String telefon = citesteString();
                        p.setTelefon(telefon);
                        dbOperations.modificareContact(p, numeVechi);
                    }
                    break;
                }

                case 5:
                {
                    dbOperations.setCheck();
                    System.out.println("----Stergere contact-----");
                    person p = new person();
                    System.out.print("Nume contact: ");
                    String nume = citesteString();
                    p.setNume(nume);
                    dbOperations.stergereContact(p);
                    if (dbOperations.isCheck()) {
                        System.out.println("\nContactul nu a fost gasit!");
                    }
                    break;
                }



                default:
                    System.out.println("Ai introdus o optiune gresita.");
                    break;
            }
        }while (optiune != 0);

    }

    public static void afisareMeniu() {
        System.out.println();
        System.out.println("--------AGENDA TELEFONICA-----");
        System.out.println("1 -> Afisare contacte");
        System.out.println("2 -> Adauga contact");
        System.out.println("3 -> Cauta contact");
        System.out.println("4 -> Modifica contact");
        System.out.println("5 -> Sterge contact");
        System.out.println("0 -> Iesire");
        System.out.print("Optiunea ta: ");
    }

    public static String citesteString() {
        Scanner input = new Scanner(System.in);
        String x = input.nextLine();
        return x;
    }

}
