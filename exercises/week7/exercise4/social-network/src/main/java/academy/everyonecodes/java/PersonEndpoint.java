package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonEndpoint {
    private final PersonService service;

    public PersonEndpoint(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public PersonDTO save(@RequestBody PersonDTO personDTO) {
        return service.save(personDTO);
    }

    @GetMapping
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id1}/friend/{id2}")
    public void friend(@RequestBody @PathVariable Long id1, @RequestBody @PathVariable Long id2) {
        service.friend(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    public void unfriend(@RequestBody @PathVariable Long id1, @RequestBody @PathVariable Long id2) {
        service.unfriend(id1, id2);
    }
}
