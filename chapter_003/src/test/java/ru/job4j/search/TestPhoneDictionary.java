package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestPhoneDictionary {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Anton", "Gorbachev", "1356599", "Tula")
        );
        List<Person> persons = phones.find("Anton");
        assertThat(persons.iterator().next().getPhone(), is("1356599"));
    }
}