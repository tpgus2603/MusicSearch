package hello.musicsearch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="favortieMusic")
@Getter
@Setter
@ToString
public class FavoriteMusic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=32) private String collectionId;
    @Column private String collectionType;
    @Column private String artistId;
    @Column private String artistName;
    @Column private String artistViewUrl;
    @Column private String collectionName;
    @Column private String collectionViewUrl;

}
