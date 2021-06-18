package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TreatmentServiceTest {
    @Autowired
    TreatmentService service;

    @MockBean
    TreatmentRepository repository;

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(List.of(new Treatment()));
        service.findAll();
        Mockito.verify(repository).findAll();
    }

    @Test
    void findByUuid_found() {
        Mockito.when(repository.findByUuid("test")).thenReturn(List.of(new Treatment()));
        service.findByUuid("test");
        Mockito.verify(repository).findByUuid("test");
    }

    @Test
    void findByUuid_notfound() {
        Mockito.when(repository.findByUuid("test")).thenReturn(List.of());
        service.findByUuid("test");
        Mockito.verify(repository).findByUuid("test");
    }

    @Test
    void saveTreatmentToPatient() {
        service.saveTreatmentToPatient(new Patient());
        Mockito.verify(repository).save(new Treatment());
    }
}
