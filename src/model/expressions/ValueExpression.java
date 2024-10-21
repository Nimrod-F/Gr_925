package model.expressions;

import model.adt.IMyMap;
import model.values.IValue;

public class ValueExpression implements IExpression {
    private IValue value;

    public ValueExpression(IValue value) {
        this.value = value;
    }

    @Override
    public IValue evaluate(IMyMap<String, IValue> symbTml) {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
