package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ContactRepository contactRepository;

    @MockBean
    AddressRepository addressRepository;

    String url = "/contacts";

    @Test
    void save() {
        Address address = new Address("street", "postalCode");
        Contact contact = new Contact("name", address);
        restTemplate.postForObject(url, contact, Contact.class);
        Mockito.verify(contactRepository).save(contact);
        Mockito.verify(addressRepository).save(address);
    }

    @Test
    void findAll() {
        restTemplate.getForObject(url, Contact[].class);
        Mockito.verify(contactRepository).findAll();
    }

    @Test
    void findByPostalCode() {
        String nUrl = url + "/postalcodes/postalCode";
        restTemplate.getForObject(nUrl, Contact[].class);
        Mockito.verify(contactRepository).findByAddress_PostalCode("postalCode");
    }
}
