package calculator.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum Operations {
    PLUS('+') {
        @Override
        public BigDecimal perform(BigDecimal a, BigDecimal b) {
            return a.add(b);
        }
    },
    MINUS('-') {
        @Override
        public BigDecimal perform(BigDecimal a, BigDecimal b) {
            return a.subtract(b);
        }
    },
    MULT('*') {
        @Override
        public BigDecimal perform(BigDecimal a, BigDecimal b) {
            return a.multiply(b);
        }
    },
    DIV('/') {
        @Override
        public BigDecimal perform(BigDecimal a, BigDecimal b) {
            if (a.equals(BigDecimal.valueOf(0))) {
                System.err.println("Деление на ноль");
                return BigDecimal.valueOf(0);
            }
            return a.divide(b);
        }
    };
    private final char symbolOfOperation;

    public abstract BigDecimal perform(BigDecimal a, BigDecimal b);

    public static Operations getOperationBySymbol(char symbolOfOperation) {
        for (Operations v : values()) {
            if (symbolOfOperation == v.symbolOfOperation) {
                return v;
            }
        }
        throw new RuntimeException("Неизвестная операция");
    }
}
