package demo.service;

import demo.entity.Book;
import demo.repository.BookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    //　テスト対象メソッドから呼び出す他のクラスはMock化しておく
    @Mock
    BookRepository repository;

    // テスト対象メソッド。Mockをインジェクションしておく必要があるので@InjectMocksしておく
    @InjectMocks
    BookService testTargetService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBook() {
        // Mock化されたクラスから返却されるオブジェクトの作成
        Book book = new Book();
        book.setId("id001");
        book.setAuthor("authName");
        book.setPublisher("pub");
        book.setTags("java");
        book.setTitle("PoEAA");

        // Mock化されたクラスの実行結果として、先ほどのオブジェクトbookを返却されるようにセット
        when(repository.findById("id001")).thenReturn(java.util.Optional.of(book));

        // テスト対象メソッドの実行
        Book result = testTargetService.getBook("id001");

        // Mock化されたオブジェクトが1回だけ、指定されたメソッド、引数で呼ばれたことを確認
        verify(repository,times(1)).findById("id001");

        // テスト対象メソッド実行後の結果の確認
        assertThat(result.getAuthor(),is(book.getAuthor()));
        assertThat(result.getPublisher(),is(book.getPublisher()));
        assertThat(result.getTags(),is(book.getTags()));
        assertThat(result.getTitle(),is(book.getTitle()));

    }

    @Test
    public void getBooks() {
    }

    @Test
    public void addBook() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void deleteBook() {
    }
}