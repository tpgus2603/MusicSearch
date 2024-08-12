package hello.musicsearch.dto;

import hello.musicsearch.entity.FavoriteMusic;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FavoriteDto {
    private String artistName;
    private String collectionName;
    private String releaseDate;

    public FavoriteMusic toEntity() {
        FavoriteMusic music = new FavoriteMusic();
        music.setArtistName(this.artistName);
        music.setCollectionName(this.collectionName);
        music.setReleaseDate(this.releaseDate);
        return music;
    }
}
