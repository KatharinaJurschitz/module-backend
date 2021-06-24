package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactEndpoint {
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public ContactEndpoint(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    @PostMapping
    public Contact save(@RequestBody Contact contact) {
        addressRepository.save(contact.getAddress());
        contactRepository.save(contact);
        return contact;
    }

    @GetMapping
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @GetMapping("/postalcodes/{postalCode}")
    public List<Contact> findByPostalCode(@PathVariable String postalCode) {
        return contactRepository.findByAddress_PostalCode(postalCode);
    }
}
