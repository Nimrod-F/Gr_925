package Repository;

import exceptions.RepoException;
import model.state.ProgramState;

public interface IRepository {
    void add(ProgramState p);

    ProgramState getCurrent();

    void logPrgStateExec() throws RepoException;
}
