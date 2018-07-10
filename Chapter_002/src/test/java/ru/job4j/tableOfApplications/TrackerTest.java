package ru.job4j.tableOfApplications;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("testId", "testName", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = tracker.add(new Item("testId", "testName", "testDescription", 123L));
        Item next = new Item("testId1", "testName1", "testDescription1", 1234L);
        next.setId(previous.getId());
        tracker.update(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("testName1"));
    }

    @Test
    public void whenDeleteItemThenArrayWillShorter() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("testId", "testName", "testDescription", 123L));
        Item second = tracker.add(new Item("testId2", "testName2", "testDescription2", 1234L));
        Item third = tracker.add(new Item("testId3", "testName3", "testDescription3", 12345L));
        Item fourth = tracker.add(new Item("testId4", "testName3", "testDescription3", 12345L));
        tracker.delete(second.getId());
        assertThat(tracker.getAll(), arrayContainingInAnyOrder(first, third, fourth));
    }

    @Test
    public void whenArrayThreeItemsThenReturnAll() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("testId", "testName", "testDescription", 123L));
        Item second = tracker.add(new Item("testId2", "testName2", "testDescription2", 1234L));
        Item third = tracker.add(new Item("testId3", "testName3", "testDescription3", 12345L));
        Item[] result = tracker.getAll();
        assertThat(result, arrayContainingInAnyOrder(first, second, third));
    }

    @Test
    public void whenFindByNameThenFindName() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("testId", "testName", "testDescription", 123L));
        Item second = tracker.add(new Item("testId2", "testName", "testDescription2", 1234L));
        Item third = tracker.add(new Item("testId3", "otherName", "testDescription3", 12345L));
        Item[] result = tracker.findByName("testName");
        assertThat(result, arrayContainingInAnyOrder(first, second));
    }

    @Test
    public void whenFindByIdThenFindSameItem() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("testId", "testName", "testDescription", 123L));
        Item second = tracker.add(new Item("testId2", "testName", "testDescription2", 1234L));
        Item third = tracker.add(new Item("testId3", "otherName", "testDescription3", 12345L));
        Item result = tracker.findById(second.getId());
        assertThat(result, is(second));
    }
}
