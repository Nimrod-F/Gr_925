package model.expressions;

import exceptions.ExpressionException;
import model.adt.IMyMap;
import model.values.IValue;

public interface IExpression {
    IValue evaluate(IMyMap<String, IValue> symbTml) throws ExpressionException;
}
