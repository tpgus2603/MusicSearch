package hello.musicsearch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="favoriteMusic")
@Getter
@Setter
public class FavoriteMusic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=32) private String collectionId;
    private String artistName;
    private String collectionName;
    private String releaseDate;

}
