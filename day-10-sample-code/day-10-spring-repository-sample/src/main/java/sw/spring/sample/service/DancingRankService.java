package sw.spring.sample.service;

import sw.spring.sample.model.DanceRank;

import java.util.List;

public interface DancingRankService {
    DanceRank getDanceRank(String name);
    List<DanceRank> listAllDanceRank();
    DanceRank insertDanceRank(DanceRank danceRank);
}
