package Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import exceptions.RepoException;
import model.state.ProgramState;

public class Repository {

    private List<ProgramState> states;
    private int currentStatePosition;
    private String fileName;

    public Repository(String file) {
        states = new ArrayList<ProgramState>();
        currentStatePosition = 0;
        fileName = file;

    }

    public void add(ProgramState p) {
        states.add(p);

    }

    public ProgramState getCurrent() {
        return states.get(currentStatePosition);

    }

    public void logPrgStateExec() throws RepoException {

        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            writer.println(getCurrent());
            writer.close();

        } catch (IOException io) {
            throw new RepoException("CANNOT WRITE IN THE FILE");
        }

    }

}
