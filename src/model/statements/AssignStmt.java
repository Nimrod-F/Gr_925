package model.statements;

import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.IExpression;
import model.state.ProgramState;
import model.types.IType;
import model.values.IValue;

public class AssignStmt implements IStmt{
    private String variable;
    private IExpression exp;

    public AssignStmt(String variable, IExpression exp) {
        this.variable = variable;
        this.exp = exp;
    }

    public ProgramState execute(ProgramState state) throws ExpressionException, StatementException {
        if (!state.getSymTable().contains(this.variable)) {
            throw new ExpressionException("The variable is not defined.");
        }


        IValue evalValue = this.exp.evaluate(state.getSymTable());
        IType type = state.getSymTable().get(this.variable).getType();

        if (evalValue.getType().equals(type)) {
            state.getSymTable().insert(this.variable, evalValue);
        } else {
            throw new StatementException("The values do not match.");
        }

        return state;
    }

    public String toString(){
        return variable + " = " + exp.toString();
    }
}
