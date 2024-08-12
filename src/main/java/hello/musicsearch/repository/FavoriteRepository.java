package hello.musicsearch.repository;

import hello.musicsearch.entity.FavoriteMusic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<FavoriteMusic,String> {
}
