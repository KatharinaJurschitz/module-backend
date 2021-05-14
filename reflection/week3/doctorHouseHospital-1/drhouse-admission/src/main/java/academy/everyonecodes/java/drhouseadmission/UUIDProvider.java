package academy.everyonecodes.java.drhouseadmission;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDProvider {
    private HashMap<String, UUID> cache;

    public UUIDProvider(HashMap<String, UUID> cache) {
        this.cache = cache;
    }

    public void provideUUID(Patient patient) {
        if (cache.containsKey(patient.getName())) {
            patient.setUuid(cache.get(patient.getName()).toString());
        } else {
            UUID uuid = UUID.randomUUID();
            patient.setUuid(uuid.toString());
            cache.put(patient.getName(), uuid);
        }
    }

    public HashMap<String, UUID> getCacheSnapshot() {
        return new HashMap<>(cache);
    }

    public Optional<UUID> findUUID(String name) {
        if (cache.containsKey(name)) {
            return Optional.of(cache.get(name));
        }
        return Optional.empty();
    }

}
