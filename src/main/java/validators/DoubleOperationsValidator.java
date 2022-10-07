package validators;

import util.Prioritizer;

public class DoubleOperationsValidator implements Validator {

    private final Prioritizer prioritizer;

    {
        prioritizer = new Prioritizer();
    }

    @Override
    public boolean isValid(String expression) {
        for (int i = 0; i < expression.length() - 1; i++) {
            if (prioritizer.getPriority(expression.charAt(i)) > 1 && prioritizer.getPriority(expression.charAt(i + 1)) > 1) {
                return false;
            }
        }
        return true;
    }
}
