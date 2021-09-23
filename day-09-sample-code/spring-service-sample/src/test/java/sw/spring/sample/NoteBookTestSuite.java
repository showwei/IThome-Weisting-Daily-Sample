package sw.spring.sample;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import sw.spring.sample.model.NoteBook;
import sw.spring.sample.service.NoteBookSellerService;

import java.util.List;
import java.util.Map;

public class NoteBookTestSuite extends ServiceTestBase {

    @Autowired
    NoteBookSellerService noteBookSellerService;

    @Qualifier("SecondHandSeller")
    @Autowired
    NoteBookSellerService secondSellerService;

    @Test
    public void testGetAllNoteBookList() {

        List<NoteBook> noteBookList = noteBookSellerService.getAllNoteBookList();
        System.out.println(new Gson().toJson(noteBookList));
        assertEquals(noteBookList.size() ,3);
        System.out.println("Verify service all list correct ! ");
    }

    @Test
    public void testGetNoteBookById() {
        NoteBook noteBookList = noteBookSellerService.getNoteBookById("2");
        System.out.println(new Gson().toJson(noteBookList));
        assertEquals(noteBookList.getName() ,"MGOLD8888");
        System.out.println("Verify service get target by Id correct ! ");
    }


    @Test
    public void testUpdateNoteBookById() {
        List<NoteBook> noteBookList = noteBookSellerService.updateNoteBookById(new NoteBook("2","Mac Mojave","Apple","Release version on 2019/03/25"));
        System.out.println(new Gson().toJson(noteBookList));
        assertEquals(noteBookList.size(),3);
        System.out.println("Verify service update notebook by id correct ! ");
    }

    @Test
    public void testCreateNoteBook() {
        List<NoteBook> noteBookList = noteBookSellerService.createNoteBookById(new NoteBook("4","Yoga Slim 7 Pro 82MS005DTW","Lenovo","Release machine on 2020/07/16"));
        System.out.println(new Gson().toJson(noteBookList));
        assertEquals(noteBookList.size(),4);
        System.out.println("Verify service create notebook correct ! ");
    }

    @Test
    public void testGetAllNoteBookListBySecondhand() {

        List<NoteBook> noteBookList = secondSellerService.getAllNoteBookList();
        System.out.println(new Gson().toJson(noteBookList));
        System.out.println(noteBookList.size());
        assertEquals(noteBookList.size() ,4);
        System.out.println("Verify service all list by second hand correct ! ");
    }

    @Test
    public void testGetNoteBookByIdFromSecondhand() {
        NoteBook noteBookList = secondSellerService.getNoteBookById("2");
        System.out.println(new Gson().toJson(noteBookList));
        assertEquals(noteBookList.getName() ,"Mac Mojave");
        System.out.println("Verify service get target by Id from second hand correct ! ");
    }


    @Test
    public void testUpdateNoteBookByIdFromSecondhand() {
        List<NoteBook> noteBookList = secondSellerService.updateNoteBookById(new NoteBook("2","Mac Mojave","Apple","Release version on 2019/03/25"));
        System.out.println(new Gson().toJson(noteBookList));
        assertEquals(noteBookList.size(),4);
        System.out.println("Verify service update notebook by Id from second hand correct ! ");
    }

    @Test
    public void testCreateNoteBookFromSecondhand() {
        List<NoteBook> noteBookList = secondSellerService.createNoteBookById(new NoteBook("4","Yoga Slim 7 Pro 82MS005DTW","Lenovo","Release machine on 2020/07/16"));
        System.out.println(new Gson().toJson(noteBookList));
        assertEquals(noteBookList.size(),4);
        System.out.println("Verify service create notebook correct ! ");
    }
}
