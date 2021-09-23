package sw.spring.sample.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sw.spring.sample.model.NoteBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Primary
@Service
public class NoteBookSellerServiceImpl implements NoteBookSellerService {
    static List<NoteBook> noteBookList = new ArrayList<NoteBook>();

    static {
        noteBookList =  new ArrayList<NoteBook>(Arrays.asList(
                new NoteBook("1","A8460","ASUS","Release on future by Asus ! "),
                new NoteBook("2","MGOLD8888","APPLE","Release on future by Apple ! "),
                new NoteBook("3","HI9999","ACER","Release on future by Acer ! ")
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
