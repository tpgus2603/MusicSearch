package hello.musicsearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.musicsearch.dto.FavoriteDto;
import hello.musicsearch.dto.MusicList;
import hello.musicsearch.entity.FavoriteMusic;
import hello.musicsearch.repository.FavoriteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MusicService {

    private final FavoriteRepository albumsRepo;
    RestTemplate restTemplate=new RestTemplate();

    public MusicList searchMusic(String name) {
        //https://itunes.apple.com/search?term=aespa&entity=album
        String url ="https://itunes.apple.com/search?term="+name+"&entity=album";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response, MusicList.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new MusicList();
        }
    }
    public int saveFavorite(FavoriteDto favoriteDto) {
        FavoriteMusic favoriteMusic = favoriteDto.toEntity();
        albumsRepo.save(favoriteMusic);
        return 1;
    }
    public List<FavoriteMusic> getLikes() {
        return albumsRepo.findAll();
    }
    public void deleteFavorite(String id) {
        try {
            albumsRepo.deleteById(id);
        } catch (DataAccessException e) {

            throw new RuntimeException("Failed to delete the favorite with ID: " + id, e);
        }
    }
}
