package notebook.controller;

import notebook.model.Memo;
import notebook.repository.MemoRepository;
import notebook.repository.repository.impl.FileOperation;
import notebook.repository.repository.impl.RepositoryOperations;
import notebook.service.MemoService;
import notebook.view.MemoConsoleView;
import static notebook.util.DbCreator.DB_PATH;
import static notebook.util.DbCreator.createDB;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MemoController {
    private static final Logger logger = LogManager.getLogger(MemoController.class);
    MemoConsoleView view = new MemoConsoleView();
    FileOperation createdDb = new FileOperation(DB_PATH);
    MemoRepository memoRepository = new RepositoryOperations(createdDb);
    MemoService facade = new MemoService(memoRepository);
    Scanner input = new Scanner(System.in);

    public void runApp() {
        createDB();
        while (true) {
            view.showMainMenu();
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    Memo memo = view.getNewMemoFromUserInput();
                    facade.saveMemo(memo);
                    logger.info("New memo saved with ID {}", memo.getId());
                }
                case 2 -> {
                    Long id = view.getNoteIdFromUserInput();
                    Memo readMemo = facade.readMemo(id);
                    if (readMemo != null) {
                        view.displayMemo(readMemo);
                    } else {
                        view.showErrorMessage("Memo with ID " + id + " not found.");
                        logger.warn("Memo with ID {} not found", id);
                    }
                }
                case 3 -> {
                    Long updateId = view.getNoteIdFromUserInput();
                    Memo updateMemo = facade.findById(updateId);
                    if (updateMemo != null) {
                        Memo newMemo = view.getNewMemoFromUserInput();
                        newMemo.setId(updateId);
                        facade.updateMemo(updateId, newMemo);
                    } else {
                        view.showErrorMessage("Memo with ID " + updateId + " not found.");
                    }
                }
                case 4 -> {
                    Long deleteId = view.getNoteIdFromUserInput();
                    facade.deleteMemo(deleteId);
                }
                case 5 -> {
                    List<Memo> memos = facade.getAllMemos();
                    view.displayAllMemos(memos);
                }
                case 0 -> System.exit(0);
                default -> view.showErrorMessage("Invalid choice.");
            }
        }
    }
}


