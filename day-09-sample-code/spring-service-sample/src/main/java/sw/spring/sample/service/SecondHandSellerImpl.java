package sw.spring.sample.service;

import sw.spring.sample.annotations.UniversalService;
import sw.spring.sample.model.NoteBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UniversalService("SecondHandSeller")
public class SecondHandSellerImpl implements NoteBookSellerService {
    static List<NoteBook> noteBookList = new ArrayList<NoteBook>();

    static {
        noteBookList =  new ArrayList<NoteBook>(Arrays.asList(
                new NoteBook("1","ZenBook 14 UX425EA","ASUS","Release version on 2021 ! "),
                new NoteBook("2","M1X MacBook Pro","APPLE","Release version on 2021 ! "),
                new NoteBook("3","SF514-55TA","ACER","Release version on 2021 ! ")
        ));
    }
    @Override
    public List<NoteBook> getAllNoteBookList() {
        return noteBookList;
    }

    @Override
    public NoteBook getNoteBookById(String id) {
        return noteBookList
                .stream()
                .filter(noteBook -> noteBook.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<NoteBook> updateNoteBookById(NoteBook noteBook) {
        noteBookList = noteBookList
                .stream()
                .map(noteBookByArrs -> noteBookByArrs.getId().equalsIgnoreCase(noteBook.getId()) ? noteBook : noteBookByArrs)
                .collect(Collectors.toList());
        return noteBookList;
    }

    @Override
    public List<NoteBook> createNoteBookById(NoteBook noteBook) {
        noteBookList.add(noteBook);
        return noteBookList;
    }
}
