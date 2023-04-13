package notebook.repository;

import java.util.List;

public interface Operations<T> {
    List<T> readAll();

    void saveAll(List<T> data);
}
