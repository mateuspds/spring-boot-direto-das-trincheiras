package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimeDomain {
    private Long id;
    private String nome;

    public AnimeDomain(String nome, long id) {
        this.id = id;
        this.nome = nome;
    }

    public static List<AnimeDomain> listaAnime() {
        return Arrays.asList(
                new AnimeDomain("Naruto", 1),
                new AnimeDomain("Dragon Ball",2),
                new AnimeDomain("One Piece",3),
                new AnimeDomain("Bleach",4)
        );
    }
}