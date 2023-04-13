package notebook.repository;

import notebook.model.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    List<Memo> findAll();

    Memo create(Memo note);

    Memo findById(Long noteId);

    Optional<Memo> update(Long noteId, Memo update);

    void deleteNoteById(Long noteId);
}
