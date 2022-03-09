import datastruct.EmptyListException;
import datastruct.MyUnsortedList;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyUnsortedListTest {
    @Test
    public void testCreateEmptyList() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue("La liste a été nouvellement créée. Elle devrait donc être vide.", list.isEmpty());
    }

    @Test
    public void testSizeEmptyList() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertEquals("La liste a été nouvellement créée. Elle devrait donc être vide et donc la taille doit être égale à 0.", 0, list.size());
    }

    @Test
    public void testCreateListVarargs() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list = MyUnsortedList.of(element1, element2, element3);
        assertFalse("La liste a été créée avec 3 éléments. La liste ne doit pas être vide.", list.isEmpty());
        assertEquals("La liste a été créée avec 3 éléments. La taille de la liste doit donc être de 3.", 3, list.size());
    }

    @Test
    public void testCreateListEmptyIterable() {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        MyUnsortedList<Integer> list = MyUnsortedList.of(elements);

        assertTrue("La liste a été créée sans élements. La liste doit être vide.", list.isEmpty());
        assertEquals("La liste a été créée vide. La taille de la liste doit donc être de 0.", 0, list.size());
    }

    @Test
    public void testCreateListIterable() {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        elements.add(5);
        elements.add(8);
        elements.add(-1);

        MyUnsortedList<Integer> list = MyUnsortedList.of(elements);

        assertFalse("La liste a été créée avec 3 éléments. La liste ne doit pas être vide.", list.isEmpty());
        assertEquals("La liste a été créée avec 3 éléments. La taille de la liste doit donc être de 3.", 3, list.size());
    }

    @Test
    public void testPrependPopOneElementInEmptyList() {
        int element = 3;

        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue("La liste a été créée sans élements. La liste doit être vide.", list.isEmpty());
        assertEquals("La liste a été créée vide. La taille de la liste doit donc être de 0.", 0, list.size());

        list.prepend(element);
        assertFalse("Un élément a été ajouté. La liste ne doit plus être vide.", list.isEmpty());
        assertEquals("Un élément a été ajouté dans la liste vide. La taille doit donc être de 1.", 1, list.size());

        int elementPopped = list.pop();
        assertEquals("L'élément retiré doit être le même que l'élément originellement ajouté", element, elementPopped);
        assertTrue("L'élément a été retiré et la liste doit être vide.", list.isEmpty());
        assertEquals("La liste doit être vide et donc la taille doit être de 0.", 0, list.size());
    }

    @Test
    public void testPrependPopLastOneElementInEmptyList() {
        int element = 3;

        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue("La liste a été créée sans élements. La liste doit être vide.", list.isEmpty());
        assertEquals("La liste a été créée vide. La taille de la liste doit donc être de 0.", 0, list.size());

        list.prepend(element);
        assertFalse("Un élément a été ajouté. La liste ne doit plus être vide.", list.isEmpty());
        assertEquals("Un élément a été ajouté dans la liste vide. La taille doit donc être de 1.", 1, list.size());

        int elementPopped = list.popLast();
        assertEquals("L'élément retiré doit être le même que l'élément originellement ajouté", element, elementPopped);
        assertTrue("L'élément a été retiré et la liste doit être vide.", list.isEmpty());
        assertEquals("La liste doit être vide et donc la taille doit être de 0.", 0, list.size());
    }

    @Test
    public void testAppendPopOneElementInEmptyList() {
        int element = 3;

        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue("La liste a été créée sans élements. La liste doit être vide.", list.isEmpty());
        assertEquals("La liste a été créée vide. La taille de la liste doit donc être de 0.", 0, list.size());

        list.append(element);
        assertFalse("Un élément a été ajouté. La liste ne doit plus être vide.", list.isEmpty());
        assertEquals("Un élément a été ajouté dans la liste vide. La taille doit donc être de 1.", 1, list.size());

        int elementPopped = list.pop();
        assertEquals("L'élément retiré doit être le même que l'élément originellement ajouté", element, elementPopped);
        assertTrue("L'élément a été retiré et la liste doit être vide.", list.isEmpty());
        assertEquals("La liste doit être vide et donc la taille doit être de 0.", 0, list.size());
    }

    @Test
    public void testAppendPopLastOneElementInEmptyList() {
        int element = 3;

        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue("La liste a été créée sans élements. La liste doit être vide.", list.isEmpty());
        assertEquals("La liste a été créée vide. La taille de la liste doit donc être de 0.", 0, list.size());

        list.append(element);
        assertFalse("Un élément a été ajouté. La liste ne doit plus être vide.", list.isEmpty());
        assertEquals("Un élément a été ajouté dans la liste vide. La taille doit donc être de 1.", 1, list.size());

        int elementPopped = list.popLast();
        assertEquals("L'élément retiré doit être le même que l'élément originellement ajouté", element, elementPopped);
        assertTrue("L'élément a été retiré et la liste doit être vide.", list.isEmpty());
        assertEquals("La liste doit être vide et donc la taille doit être de 0.", 0, list.size());
    }

    @Test(expected = EmptyListException.class)
    public void testPopOnEmptyList() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        list.pop();
    }

    @Test(expected = EmptyListException.class)
    public void testPopLastOnEmptyList() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        list.popLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertNegativePosition() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list = MyUnsortedList.of(element1, element2, element3);
        list.insert(3, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAboveSize() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list = MyUnsortedList.of(element1, element2, element3);
        list.insert(3, list.size() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativePosition() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list = MyUnsortedList.of(element1, element2, element3);
        list.remove( -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAboveSize() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list = MyUnsortedList.of(element1, element2, element3);
        list.remove(list.size());
    }

    @Test
    public void testInsertRemoveAt0InEmptyList() {
        int element = 3;

        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue("La liste a été créée sans élements. La liste doit être vide.", list.isEmpty());
        assertEquals("La liste a été créée vide. La taille de la liste doit donc être de 0.", 0, list.size());

        list.insert(element, 0);
        assertFalse("Un élément a été ajouté. La liste ne doit plus être vide.", list.isEmpty());
        assertEquals("Un élément a été ajouté dans la liste vide. La taille doit donc être de 1.", 1, list.size());

        int elementRemoved = list.remove(0);
        assertEquals("L'élément retiré doit être le même que l'élément originellement ajouté", element, elementRemoved);
        assertTrue("L'élément a été retiré et la liste doit être vide.", list.isEmpty());
        assertEquals("La liste doit être vide et donc la taille doit être de 0.", 0, list.size());
    }

    @Test
    public void testInsertRemoveAtEndInEmptyList() {
        int element = 3;

        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue("La liste a été créée sans élements. La liste doit être vide.", list.isEmpty());
        assertEquals("La liste a été créée vide. La taille de la liste doit donc être de 0.", 0, list.size());

        list.insert(element, list.size());
        assertFalse("Un élément a été ajouté. La liste ne doit plus être vide.", list.isEmpty());
        assertEquals("Un élément a été ajouté dans la liste vide. La taille doit donc être de 1.", 1, list.size());

        int elementRemoved = list.remove(list.size() - 1);
        assertEquals("L'élément retiré doit être le même que l'élément originellement ajouté", element, elementRemoved);
        assertTrue("L'élément a été retiré et la liste doit être vide.", list.isEmpty());
        assertEquals("La liste doit être vide et donc la taille doit être de 0.", 0, list.size());
    }

    @Test
    public void testInsertAt0() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        int elementToInsert = -9;
        MyUnsortedList<Integer> list = MyUnsortedList.of(element1, element2, element3);

        list.insert(elementToInsert, 0);
        assertEquals("On doit retirer l'élément inséré.", elementToInsert, (int) list.pop());
        assertEquals("On doit retirer l'ancien premier élément.", element1, (int) list.pop());
        assertEquals("On doit retirer l'ancien deuxième élément.", element2, (int) list.pop());
        assertEquals("On doit retirer l'ancien troisième élément.", element3, (int) list.pop());
    }

    @Test
    public void testManyPrependPopLast() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(1);
        assertEquals("On a ajouté un élément. La taille devrait avoir augmenté.", 1, list.size());

        list.prepend(9);
        assertEquals("On a ajouté un élément. La taille devrait avoir augmenté.",2, list.size());

        list.prepend(-3);
        assertEquals("On a ajouté un élément. La taille devrait avoir augmenté.",3, list.size());

        assertEquals("La taille initiale devrait être de 3.", 3, list.size());

        assertEquals("L'élément retiré n'est pas le bon", 1, (int) list.popLast());
        assertEquals("On a retiré un élément. La taille devrait avoir diminué.", 2, list.size());

        assertEquals("L'élément retiré n'est pas le bon.", 9, (int) list.popLast());
        assertEquals("On a retiré un élément. La taille devrait avoir diminué.",1, list.size());

        assertEquals("L'élément retiré n'est pas le bon.", -3, (int) list.popLast());
        assertEquals("On a retiré un élément. La taille devrait avoir diminué.",0, list.size());
    }

    @Test
    public void testEquals2Lists() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list1 = MyUnsortedList.of(element1, element2, element3);
        MyUnsortedList<Integer> list2 = MyUnsortedList.of(element1, element2, element3);

        assertEquals("The two lists should be the same", list1, list2);
        assertTrue("The two lists should be the same", list1.equals(list2));
    }

    @Test
    public void testEqualsListAndInteger() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list1 = MyUnsortedList.of(element1, element2, element3);
        int elementTested = 123;

        assertNotEquals("The two lists should be the same", list1, elementTested);
        assertFalse("The two lists should be the same", list1.equals(elementTested));
    }

    @Test
    public void testEquals2ListsNotTheSameSize() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list1 = MyUnsortedList.of(element1, element2, element3);
        MyUnsortedList<Integer> list2 = MyUnsortedList.of(element1, element3);

        assertNotEquals("The two lists should not have the same size", list1.size(), list2.size());
        assertNotEquals("The two lists should not be the same", list1, list2);
        assertFalse("The two lists should not be the same", list1.equals(list2));
    }

    @Test
    public void testEquals2ListsSameSizeDifferentElements() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        MyUnsortedList<Integer> list1 = MyUnsortedList.of(element1, element2, element3);
        MyUnsortedList<Integer> list2 = MyUnsortedList.of(element1, element3, element2);

        assertNotEquals("The two lists should not be the same", list1, list2);
        assertFalse("The two lists should not be the same", list1.equals(list2));
    }

    @Test
    public void testEquals2ListsSameSizeDifferentTypesElements() {
        int element1 = 5;
        int element2 = 8;
        int element3 = -1;

        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        MyUnsortedList<Integer> list1 = MyUnsortedList.of(element1, element2, element3);
        MyUnsortedList<String> list2 = MyUnsortedList.of(s1, s2, s3);

        assertNotEquals("The two lists should not be the same", list1, list2);
        assertFalse("The two lists should not be the same", list1.equals(list2));
    }
}
