package model.statements;

import java.io.BufferedReader;
import java.io.IOException;

import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.IExpression;
import model.state.ProgramState;
import model.types.IntType;
import model.types.StringType;
import model.values.IValue;
import model.values.IntValue;
import model.values.StringValue;

public class ReadFileStmt implements IStmt {
    private IExpression exp;
    private String varName;

    public ReadFileStmt(IExpression e, String n) {
        this.exp = e;
        this.varName = n;
    }

    public ProgramState execute(ProgramState state) throws StatementException, ExpressionException {
        var t = state.getSymTable();
        if (!t.contains(varName)) {
            throw new StatementException("Variable name is not defined");
        }
        if (!t.get(varName).getType().equals(new IntType())) {
            throw new StatementException("Variable is not of type INT");
        }

        IValue res = exp.evaluate(state.getSymTable());

        if (!res.getType().equals(new StringType())) {
            throw new StatementException("Value read is not a string");
        }

        BufferedReader r = state.getFileTable().get(((StringValue) res).getValue());

        try {
            String readResult = r.readLine();
            if (readResult == "") {
                readResult = "0";
            }
            int parsedResult = Integer.parseInt(readResult);

            state.getSymTable().insert(varName, new IntValue(parsedResult));
            return state;

        } catch (IOException e) {
            throw new StatementException("I/O Exception trying to read file " + ((StringValue) res).getValue());
        }

    }
}
