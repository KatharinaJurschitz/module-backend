package academy.everyonecodes.java.drhouseadmission;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/uuids")
public class UuidCacheEndpoint {
    private UUIDProvider provider;

    public UuidCacheEndpoint(UUIDProvider provider) {
        this.provider = provider;
    }

    @GetMapping
    HashMap<String, UUID> get() {
        return provider.getCacheSnapshot();
    }

    @GetMapping("/{patientName}")
    UUID getUUID(@PathVariable String patientName) {
        if (provider.findUUID(patientName).isPresent()) {
            return  provider.findUUID(patientName).get();
        }
        return null;
    }
}
