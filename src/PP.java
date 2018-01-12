import java.util.ArrayList;
import java.util.List;

public class PP {

    List<person> agenda = new ArrayList<>();

    private void afisareContacte() {
        for (person p : agenda
             ) {
            System.out.println(p.getNume());
            System.out.println(p.getTelefon());
        }
    }

    private void adaugare (String nume, String telefon) {
        person p  = new person();
        p.setNume(nume);
        p.setTelefon(telefon);

        agenda.add(p);
    }

    private void stergere(int index) {
        agenda.remove(index);
    }

    private void modificare() {

    }
}
