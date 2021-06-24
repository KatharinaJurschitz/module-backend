package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonDTO save(PersonDTO personDTO) {
        Person person = dtoToPerson(personDTO);
        repository.save(person);
        return personToDto(person);
    }

    public List<PersonDTO> findAll() {
        List<Person> persons = repository.findAll();
        return persons
                .stream()
                .map(this::personToDto)
                .collect(Collectors.toList());
    }

    public void friend(Long id1, Long id2) {
        Optional<Person> oPerson1 = repository.findById(id1);
        Optional<Person> oPerson2 = repository.findById(id2);
        if (oPerson1.isEmpty() || oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);
        repository.save(person1);
        repository.save(person2);
    }

    public void unfriend(Long id1, Long id2) {
        Optional<Person> oPerson1 = repository.findById(id1);
        Optional<Person> oPerson2 = repository.findById(id2);
        if (oPerson1.isEmpty() || oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();
        person1.getFriends().remove(person2);
        person2.getFriends().remove(person1);
        repository.save(person1);
        repository.save(person2);
    }

    private PersonDTO personToDto(Person person) {
        if (person.getFriends() == null) {
            return new PersonDTO( person.getId(), person.getName(), List.of());
        }
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getFriends()
                        .stream()
                        .map(Person::getName)
                        .collect(Collectors.toList())
        );
    }

    private Person dtoToPerson(PersonDTO dto) {
        if (dto.getFriendNames() == null) {
            return new Person(dto.getId(), dto.getName(), List.of());
        }
        return new Person(
                dto.getId(),
                dto.getName(),
                dto.getFriendNames()
                        .stream()
                        .map(Person::new)
                        .collect(Collectors.toList())
        );
    }
}
