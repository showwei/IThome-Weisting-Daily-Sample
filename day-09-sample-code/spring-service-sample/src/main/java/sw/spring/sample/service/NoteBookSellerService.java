package sw.spring.sample.service;

import sw.spring.sample.model.NoteBook;

import java.util.List;

public interface NoteBookSellerService {
    List<NoteBook> getAllNoteBookList();
    NoteBook getNoteBookById(String id);
    List<NoteBook> updateNoteBookById(NoteBook noteBook);
    List<NoteBook> createNoteBookById(NoteBook noteBook);
}
