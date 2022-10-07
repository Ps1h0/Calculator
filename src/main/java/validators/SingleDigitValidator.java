package validators;

import util.Prioritizer;

public class SingleDigitValidator implements Validator {

    private final Prioritizer prioritizer;

    {
        prioritizer = new Prioritizer();
    }

    @Override
    public boolean isValid(String expression) {
        if (expression.trim().length() == 1) {
            char symbol = expression.toCharArray()[0];
            return prioritizer.getPriority(symbol) == 0;
        }
        return true;
    }
}
