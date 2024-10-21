package model.state;

import java.io.BufferedReader;

import model.adt.*;
import model.statements.*;
import model.values.IValue;

public class ProgramState {
    IMyStack<IStmt> exeStack;
    IMyMap<String, IValue> symTable;
    IMyList<IValue> out;
    IMyMap<String, BufferedReader> fileTable;
    IStmt originalProgram;

    ProgramState(IMyStack<IStmt> stk, IMyMap<String, IValue> symtbl, IMyList<IValue> out, IStmt prg,
            IMyMap<String, BufferedReader> fMap) {
        this.exeStack = stk;
        this.symTable = symtbl;
        this.out = out;
        this.originalProgram = prg.deepCopy();
        this.fileTable = fMap;
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

    public IMyMap<String, BufferedReader> getFileTable() {
        return this.fileTable;
    }

}
