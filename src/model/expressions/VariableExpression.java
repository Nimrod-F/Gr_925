package model.expressions;

import exceptions.ExpressionException;
import model.adt.IMyMap;
import model.values.IValue;

public class VariableExpression implements IExpression {
    private String variable;

    public VariableExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public IValue evaluate(IMyMap<String, IValue> symbTml) throws ExpressionException {
        return symbTml.get(variable);
    }

    @Override
    public String toString() {
        return variable;
    }
}
