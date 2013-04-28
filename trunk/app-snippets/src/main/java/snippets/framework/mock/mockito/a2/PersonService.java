package snippets.framework.mock.mockito.a2;

public class PersonService {
    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(Integer personId, String name) {
        Person person = personDao.fetchPerson(personId);
        if (person != null) {
            Person updatedPerson = new Person(person.getId(), name);
            personDao.update(updatedPerson);
            return true;
        } else {
            return false;
        }
    }
}
