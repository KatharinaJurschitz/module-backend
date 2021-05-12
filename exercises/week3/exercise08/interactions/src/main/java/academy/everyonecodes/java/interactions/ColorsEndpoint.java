package academy.everyonecodes.java.interactions;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/colors")
public class ColorsEndpoint {
    private Set<String> colors = new HashSet<>();

    public ColorsEndpoint(Set<String> colors) {
        this.colors = colors;
    }

    @GetMapping
    Set<String> getColors() {
        return colors;
    }

    @GetMapping("/{name}")
    String getSpecificColor(@PathVariable String name) {
        return colors.stream()
                .filter(x -> x.equalsIgnoreCase(name))
                .findFirst()
                .orElse("The color is not available in the app.");
    }

    @PostMapping
    String addColor(@RequestBody String color) {
        colors.add(color);
        return color;
    }

    @PutMapping("/{target}")
    String replaceColor(@PathVariable String target, @RequestBody String replacement) {
        colors.remove(target);
        colors.add(replacement);
        return replacement;
    }

    @DeleteMapping
    void deleteAll() {
        colors.clear();
    }

    @DeleteMapping("/{name}")
    void deleteColor(@PathVariable String name) {
        colors.remove(name);
    }
}
