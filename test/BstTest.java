import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.*;

public class BstTest {

    private Bst<String> bst; 
            
    public BstTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    } 

    @Before
    public void setUp() {
        bst = new Bst<>(); 
    }

    @After
    public void tearDown() {
    }

    // Praviloma bi morali testirati vsako funkcijo v razredu
    // torej tudi: member, insert, delete, deleteMin, getDepth, countNodes
    
    // Glede na to, da teste zasnujemo pred poznavanjem podrobnosti implementacije
    // zasnujemo teste za metode vmesnika: 
    // add, removeFirst, getFirst, size,depth, isEmpty, remove, exists
    
    
    @Test
    public void testGetFirstOne() {
        bst.add("Test");
        assertEquals("Test", bst.getFirst());
        assertEquals(1, bst.size());
        assertEquals(1, bst.depth());
    }

    @Test
    public void testGetFirstMultiple() {
        bst.add("Test2");
        assertEquals("Test2", bst.getFirst());
        assertEquals(1, bst.size());
        assertEquals(1, bst.depth());
        bst.add("Test3");
        bst.add("Test1");
        assertEquals("Test2", bst.getFirst());
        assertEquals("Test2", bst.getFirst());
        assertEquals(3, bst.size());
        assertEquals(2, bst.depth());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetFirstOnEmpty() {
        bst.getFirst();
    }

   @Test
    public void testSizeOnEmpty() {
        assertEquals(0, bst.size());
    }
    
    @Test
    public void testDepthOnEmpty() {
        assertEquals(0, bst.depth());
    }
    
    @Test
    public void testAsList(){
        bst.add("1");
        bst.add("2");
        bst.add("3");
        assertEquals("[1, 2, 3]", Arrays.toString(bst.asList().toArray()));
    }

    @Test
    public void testAsListNull(){
        assertEquals("[]", Arrays.toString(bst.asList().toArray()));
    } 
    
    // TODO
    
    @Test
    public void testAdd() {
       bst.add("Test"); 
       assertEquals("Test", bst.getFirst()); 
    }

    @Test
    public void testRemoveFirst(){
       bst.add("Test");
       bst.add("Not_this_one");
       bst.add("NotThisONeEither");
       assertEquals("Test", bst.getFirst());        
    }   
   
    @Test
    public void testSize(){
        bst.add("Number_1");
        bst.add("Number_2");
        bst.add("Number_3");
        bst.add("Number_4");
        assertEquals(4, bst.size());
    }
    
    @Test
    public void testDepth(){
        bst.add("Element1");
        bst.add("Element2");
        assertEquals(2, bst.depth());
    }
    
    @Test
    public void isEmpty(){
        assertTrue(bst.isEmpty());
    }
    
    @Test
    public void testExists(){
        bst.add("Test");
        assertTrue(bst.exists("Test"));
    }
    
    @Test(expected = java.util.NoSuchElementException.class)
    public void testRemove(){
        bst.add("Test");
        assertTrue(bst.exists("Test"));
        assertEquals("To funkcijo morate implementirati!", bst.remove("Test")); //Nism še delete naredu
    }
     
}
