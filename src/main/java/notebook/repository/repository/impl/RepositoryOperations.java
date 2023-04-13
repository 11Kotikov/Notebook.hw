package notebook.repository.repository.impl;

import notebook.mapper.MemoMapper;
import notebook.model.Memo;
import notebook.repository.MemoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryOperations implements MemoRepository {
    private final MemoMapper mapper;
    private final FileOperation operation;

    public RepositoryOperations(FileOperation operation) {
        this.mapper = new MemoMapper();
        this.operation = operation;
    }

    @Override
    public List<Memo> findAll() {
        List<String> lines = operation.readAll();
        List<Memo> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.toOutput(line));
        }
        return notes;
    }

    private void write(List<Memo> notes) {
        List<String> lines = new ArrayList<>();
        for (Memo n : notes) {
            lines.add(mapper.toInput(n));
        }
        operation.saveAll(lines);
    }

    @Override
    public Memo create(Memo note) {
        List<Memo> notes = findAll();
        long max = 0L;
        for (Memo n : notes) {
            long id = n.getId();
            if (max < id) {
                max = id;
            }
        }
        long next = max + 1;
        note.setId(next);
        notes.add(note);
        write(notes);
        return note;
    }

    @Override
    public Optional<Memo> update(Long noteId, Memo update) {
        List<Memo> notes = findAll();
        Memo editUser = notes.stream()
                .filter(n -> n.getId() == noteId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
        editUser.setTopic(update.getTopic());
        editUser.setContext(update.getContext());
        editUser.setCreationDateTime(update.getCreationDateTime());
        editUser.setComment(update.getComment());
        return Optional.of(update);
    }

    @Override
    public Memo findById(Long noteId) {
        List<Memo> notes = findAll();
        return notes.stream()
                .filter(n -> n.getId() == (noteId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteNoteById(Long noteId) {
        List<Memo> notes = findAll();
        boolean deleteNote = notes.removeIf(n -> n.getId() == noteId);
        if (deleteNote) {
            for (int i = 0; i < notes.size(); i++) {
                notes.get(i).setId(Long.valueOf(i + 1));
            }
            write(notes);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
