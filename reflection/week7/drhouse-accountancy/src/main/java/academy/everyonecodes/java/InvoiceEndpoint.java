package academy.everyonecodes.java;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceEndpoint {
    private final PatientService service;

    public InvoiceEndpoint(PatientService service) {
        this.service = service;
    }

    @GetMapping
    @Secured("ROLE_ACCOUNTANT")
    public List<Invoice> getAllInvoices() {
        return service.getAllInvoices();
    }

    @PutMapping("/{id}/paid")
    @Secured("ROLE_ACCOUNTANT")
    public void markInvoicePaid(@RequestBody @PathVariable Long id) {
        service.markInvoicePaid(id);
    }
}
