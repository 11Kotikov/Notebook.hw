package notebook.util;

import java.io.File;

public class DbCreator {
    public static final String DB_PATH = "MyNoteBook.txt";
    public static void createDB() {
        try {
            File db = new File(DB_PATH);
            if (db.createNewFile()) {
                System.out.println("DB created");
            }
            else {
                System.out.println("DB already exists");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
