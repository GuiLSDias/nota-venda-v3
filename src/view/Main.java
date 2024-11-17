package view;

import model.PaymentMethod;
import model.Sale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sale sale = new Sale();

        sale.addProduct("Arroz", 30, 2);
        sale.addProduct("Feijao", 20, 1);
        sale.addProduct("Pasta", 15, 6);

        sale.getItems().forEach(System.out::println);
        System.out.println("Total: " + sale.getTotal());

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1. Cartão de Crédito (5% de juros)");
        System.out.println("2. Cartão de Débito (sem juros ou desconto)");
        System.out.println("3. Dinheiro/Pix (5% de desconto)");
        System.out.print("Digite o número correspondente: ");
        int choice = scanner.nextInt();

        String paymentMethod;
        switch (choice) {
            case 1:
                paymentMethod = "Cartão de Crédito";
                break;
            case 2:
                paymentMethod = "Cartão de Débito";
                break;
            case 3:
                paymentMethod = "Dinheiro";
                break;
            default:
                System.out.println("Opção inválida! Usando Cartão de Débito por padrão.");
                paymentMethod = "Cartão de Débito";
        }


        double finalAmount = PaymentMethod.calculateFinalAmount(sale.getTotal(), paymentMethod);
        double difference = finalAmount - sale.getTotal();


        System.out.println("\n=== Nota de Venda ===");
        sale.getItems().forEach(System.out::println);
        System.out.printf("Total Bruto: R$ %.2f%n", sale.getTotal());
        System.out.printf("Forma de Pagamento: %s%n", paymentMethod);
        if (difference > 0) {
            System.out.printf("Juros: R$ %.2f%n", difference);
        } else if (difference < 0) {
            System.out.printf("Desconto: R$ %.2f%n", -difference);
        }
        System.out.printf("Valor Final a Pagar: R$ %.2f%n", finalAmount);
    }
}