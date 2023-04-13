package notebook.view;

import notebook.model.Memo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MemoConsoleView {

    public void showMainMenu() {
        System.out.println("Notebook menu:");
        System.out.println("1. Create memo");
        System.out.println("2. Read memo");
        System.out.println("3. Update memo");
        System.out.println("4. Delete memo");
        System.out.println("5. List all memos");
        System.out.println("0. Exit");
    }

    public Memo getNewMemoFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter memo topic:");
        String topic = scanner.nextLine();
        System.out.println("Enter memo context:");
        String context = scanner.nextLine();
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Enter event date and time or whatever:");
        String comment = scanner.nextLine();
        return new Memo(0L, topic, context, comment, currentDateTime);
    }

    public Long getNoteIdFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter note ID:");
        Long noteId = scanner.nextLong();
        scanner.nextLine();
        return noteId;
    }

    public void displayMemo(Memo memo) {
        System.out.println("Memo:");
        System.out.println("ID: " + memo.getId());
        System.out.println("Topic: " + memo.getTopic());
        System.out.println("Context: " + memo.getContext());
        System.out.println("Event Date and Time: " + memo.getComment());
        System.out.println("Creation Date and Time: " + memo.getCreationDateTime());
    }

    public void displayAllMemos(List<Memo> memos) {
        System.out.println("All memos:");
        for (Memo memo : memos) {
            displayMemo(memo);
        }
    }

    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
