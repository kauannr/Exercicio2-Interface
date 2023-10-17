import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.Contrato;
import model.entities.Parcela;
import model.entities.Paypal;
import model.services.ServicoContrato;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Numero: ");
        Integer numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Data do contrato (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.nextLine(), formato);
        System.out.print("Valor do contrato: ");
        Double valor = sc.nextDouble();
        sc.nextLine();
        Contrato obj = new Contrato(numero, data, valor);

        System.out.print("Numero de parcelas: ");
        Integer numParcelas = sc.nextInt();
        sc.nextLine();

        ServicoContrato servicoContrato = new ServicoContrato(new Paypal());

        servicoContrato.processarContrato(obj, numParcelas);
        System.out.println("PARCELAS: ");
        for (Parcela parcela : obj.getparcelas()) {
            System.out.println(parcela);
        }

        sc.close();
    }
}
