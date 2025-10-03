package academy.devdojo.controller;

import academy.devdojo.domain.AnimeDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/animes")
@Slf4j
public class AnimeController {

    @GetMapping
    public List<AnimeDomain> getAnimes() {
        return AnimeDomain.listaAnime();

    }

    @GetMapping("/filter")
    public List<AnimeDomain> filterByName(@RequestParam(defaultValue = "") String name) {
        return AnimeDomain.listaAnime().stream().
                filter(animes -> animes.
                        getNome().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> filterById(@PathVariable Long id) {
        return AnimeDomain.listaAnime().stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Anime com id " + id + " não encontrado!"));
    }
}
