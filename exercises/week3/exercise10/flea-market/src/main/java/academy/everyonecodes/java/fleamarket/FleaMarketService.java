package academy.everyonecodes.java.fleamarket;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FleaMarketService {
    private final Set<Item> items = new HashSet<>();

    public void add(Item item) {
        items.add(item);
    }

    Set<Item> getItems() {
        return items;
    }

    Set<Item> getOne(String name) {
        return items.stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .collect(Collectors.toSet());
    }
}
