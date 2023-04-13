package notebook.mapper;

public interface Mapper<M, S> {
    S toInput(M model);
    M toOutput(S source);
}

