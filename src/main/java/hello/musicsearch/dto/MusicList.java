package hello.musicsearch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class MusicList {
    private Integer resultCount;
    private List<Map<String, Object>> results;
}

