package model;

public class PaymentMethod {
    public static double calculateFinalAmount(double total, String paymentMethod) {
        switch (paymentMethod.toLowerCase()) {
            case "cartão de crédito":
                return total * 1.05; // 5% de juros
            case "dinheiro":
            case "pix":
                return total * 0.95; // 5% de desconto
            case "cartão de débito":
                return total; // Sem juros ou desconto
            default:
                throw new IllegalArgumentException("Forma de pagamento inválida!");
        }
    }
}
