package notebook.mapper;

import notebook.model.Memo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemoMapper implements Mapper<Memo, String> {
    private final String separator;

    public MemoMapper(String separator) {
        this.separator = separator;
    }

    public MemoMapper() {
        this("; ");
    }

    @Override
    public String toInput(Memo memo) {
        return String.format("%d%s%s%s%s%s%s%s%s",
                memo.getId(), separator,
                memo.getTopic(), separator,
                memo.getContext(), separator,
                memo.getComment(), separator,
                memo.getCreationDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Override
    public Memo toOutput(String s) {
        String[] lines = s.split(separator);
        int id;
        if (isDigit(lines[0])) {
            id = Integer.parseInt(lines[0]);
            String comment = lines[3];
            LocalDateTime creationDateTime = LocalDateTime.parse(lines[4]);
            return new Memo(id, lines[1], lines[2], comment, creationDateTime);
        }
        throw new NumberFormatException("Id must be an integer");
    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


