package model.state;
import com.sun.jdi.Value;
import model.adt.*;
import model.statements.*;
import model.values.IValue;

public class ProgramState {
    IMyStack<IStmt> exeStack;
    IMyMap<String, IValue> symTable;
    IMyList<IValue> out;
    IStmt originalProgram;

    ProgramState(IMyStack<IStmt> stk, IMyMap<String, IValue> symtbl, IMyList<IValue> out, IStmt prg)
    {
        this.exeStack = stk;
        this.symTable = symtbl;
        this.out = out;
        this.originalProgram = prg;
        exeStack.push(prg);
    }

    public IMyStack<IStmt> getExeStack() {
        return this.exeStack;
    }

    public IMyMap<String, IValue> getSymTable() {
        return this.symTable;
    }

    public IMyList<IValue> getOut() {
        return this.out;
    }

}
