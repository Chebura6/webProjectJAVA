package org.pancakes.exceptions;

public class ProductException extends Exception {
    private ProductException(String message) {
        super(message);
    }

    public static ProductException NotValidProductNameException() {
        return new ProductException("Неверное имя");
    }

    public static ProductException NotValidProductPriceException() {
        return new ProductException("Неверная цена");
    }
}
