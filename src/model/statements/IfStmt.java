package model.statements;

import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.IExpression;
import model.state.ProgramState;
import model.types.BoolType;
import model.values.BoolValue;
import model.values.IValue;

public class IfStmt implements IStmt {
    private IExpression exp;
    private IStmt thenS;
    private IStmt elseS;

    IfStmt(IExpression exp, IStmt thenS, IStmt elseS) {
        this.exp = exp;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public String toString() {
        return "IF(" + exp.toString() + ") THEN {" + thenS.toString() +
                "}ELSE {" + elseS.toString() +"}";
    }

    public ProgramState execute(ProgramState state) throws StatementException, ExpressionException {
        IValue expVal = this.exp.evaluate(state.getSymTable());
        if (!(expVal.getType() instanceof BoolType)) {
            throw new StatementException(expVal.toString() + " is not a boolean");
        }
        if (((BoolValue)expVal).getValue()) {
            state.getExeStack().push(thenS);
        } else {
            state.getExeStack().push(elseS);
        }

        return null;
    }
}
