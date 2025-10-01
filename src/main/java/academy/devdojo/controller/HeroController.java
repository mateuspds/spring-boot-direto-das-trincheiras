package academy.devdojo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vi/heroes")
public class HeroController {
    private static final List<String> HEROES = List.of("guts", "zoro", "kakashi");

    @GetMapping
    public List<String> getHeros() {
        return HEROES;
    }

    @GetMapping("filter")
    public List<String> listAllHerosParam(@RequestParam(defaultValue = "") String name) {
        return HEROES.stream().filter(hero -> hero.equalsIgnoreCase(name)).toList();
    }

    @GetMapping("filter/list")
    public List<String> listAllHerosParamlistas(@RequestParam List<String> names) {
        return HEROES.stream().filter(names::contains).toList();
    }

    @GetMapping("{name}")
    public String pathVariavbleheros(@PathVariable String name) {
        return HEROES.stream().filter(
                names -> name.equalsIgnoreCase(names)
                ).findFirst().orElse("");
    }


}
