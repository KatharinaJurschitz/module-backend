package academy.everyonecodes.java;

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
    public List<Invoice> getAllInvoices() {
        return service.getAllInvoices();
    }

    @PutMapping("/{id}/paid")
    public void markInvoicePaid(@RequestBody @PathVariable Long id) {
        service.markInvoicePaid(id);
    }
}
