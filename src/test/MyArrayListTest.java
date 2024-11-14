package test;
import homework1.MyArrayList;
import org.junit.jupiter.api.*;

import java.util.Comparator;

public class MyArrayListTest {

    private MyArrayList<String> stringTest;
    private MyArrayList<Integer> integerTest;

    @BeforeEach
    void set() {
        stringTest = new MyArrayList<>();
        integerTest = new MyArrayList<>();
    }

    @AfterEach
    void remove() {
        stringTest = null;
        integerTest = null;
    }

    @Test
    void addTest() {
        for(int i = 0; i<100000; i++){
            stringTest.add(i + " line");
            integerTest.add(i);
        }
        for(int i = 0; i<100000; i++){
            Assertions.assertEquals(i + " line", stringTest.get(i));
            Assertions.assertEquals(i, integerTest.get(i));
        }
    }

    @Test
    void addByIndexTest(){
        stringTest.add("line0");
        stringTest.add("line1");
        stringTest.add(0, "line2");
        integerTest.add(0);
        integerTest.add(1);
        integerTest.add(0,2);
        Assertions.assertEquals("line2", stringTest.get(0));
        Assertions.assertEquals(2, integerTest.get(0));
    }

    @Test
    void getSizeTest(){
        for(int i = 0; i<10; i++){
            stringTest.add(i + " line");
            integerTest.add(i);
        }
        Assertions.assertEquals(10, stringTest.getSize());
        Assertions.assertEquals(10, integerTest.getSize());
    }

    @Test
    void getTest(){
        for(int i = 0; i<10; i++){
            stringTest.add(i + " line");
            integerTest.add(i);
        }
        Assertions.assertEquals("0 line", stringTest.get(0));
        Assertions.assertEquals("3 line", stringTest.get(3));
        Assertions.assertEquals(0, integerTest.get(0));
        Assertions.assertEquals(3, integerTest.get(3));
    }

    @Test
    void removeTest(){
        stringTest.add("line0");
        stringTest.add("line1");
        stringTest.add("line2");

        for(int i = 0; i<10; i++){
            integerTest.add(i);
        }

        Assertions.assertEquals(3, stringTest.getSize());
        stringTest.remove(1);
        Assertions.assertEquals(2, stringTest.getSize());

        Assertions.assertEquals(10, integerTest.getSize());
        integerTest.remove(2);
        Assertions.assertEquals(9, integerTest.getSize());
    }

    @Test
    void clearTest(){
        for(int i = 0; i<10; i++){
            stringTest.add(i + " line");
            integerTest.add(i);
        }
        stringTest.clear();
        integerTest.clear();
        for(int i = 0; i<10; i++){
            Assertions.assertNull(stringTest.get(i));
            Assertions.assertNull(stringTest.get(i));
        }

    }

    @Test
    void sortTest(){
        stringTest.add("bca");
        stringTest.add("cba");
        stringTest.add("acb");

        stringTest.sort(Comparator.naturalOrder());
        Assertions.assertEquals("bca", stringTest.get(1));
        Assertions.assertEquals("cba", stringTest.get(2));

        integerTest.add(4);
        integerTest.add(2);
        integerTest.add(5);

        integerTest.sort(Comparator.reverseOrder());
        Assertions.assertEquals(2, integerTest.get(2));
        Assertions.assertEquals(5, integerTest.get(0));
    }


}
