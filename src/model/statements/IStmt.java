package model.statements;

import exceptions.ExpressionException;
import exceptions.StatementException;
import model.state.ProgramState;

public interface IStmt {
    ProgramState execute(ProgramState state) throws StatementException, ExpressionException;
}
