package notebook.service;

import notebook.model.Memo;
import notebook.repository.MemoRepository;

import java.util.List;
import java.util.Objects;

public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public void saveMemo(Memo memo) {
        memoRepository.create(memo);
    }

    public Memo readMemo(Long noteId) {
        List<Memo> notes = memoRepository.findAll();
        for (Memo note : notes) {
            if (Objects.equals(note.getId(), noteId)) {
                return note;
            }
        }
        throw new IllegalArgumentException("Note not found");
    }

        public void updateMemo(Long noteId, Memo update){
            update.setId(noteId);
            memoRepository.update(noteId, update);
        }

        public void deleteMemo (Long id){
            memoRepository.deleteNoteById(id);
        }

        public List<Memo> getAllMemos () {
            return memoRepository.findAll();
        }
    public Memo findById(long noteId) {
        return memoRepository.findById(noteId);
    }
}
