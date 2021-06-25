package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;

    public PatientService(PatientRepository patientRepository, InvoiceRepository invoiceRepository) {
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public PatientDTO createInvoice(PatientDTO dto) {
        Patient patient = null;
        Optional<Patient> oPatient = patientRepository.findByUuid(dto.getUuid());
        if (oPatient.isEmpty()) {
            patient = new Patient(dto.getUuid(), dto.getName(), dto.getSymptoms(), dto.getDiagnosis(), dto.getTreatment());
            patientRepository.save(patient);
        } else {
            patient = oPatient.get();
        }
        Invoice invoice = new Invoice(90.0, false, patient);
        invoiceRepository.save(invoice);
        return dto;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public void markInvoicePaid(Long id) {
        Invoice invoice = null;
        Optional<Invoice> oInvoice = invoiceRepository.findById(id);
        if (oInvoice.isPresent()) {
            invoice = oInvoice.get();
            invoice.setPaid(true);
            invoiceRepository.save(invoice);
        }
    }
}
