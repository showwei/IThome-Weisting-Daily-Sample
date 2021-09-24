package sw.spring.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import sw.spring.sample.annotations.TransactionalService;
import sw.spring.sample.dao.DancingTableRepository;
import sw.spring.sample.model.DanceRank;

import java.util.List;

@TransactionalService
public class DancingRankServiceImpl implements DancingRankService{
    private final DancingTableRepository repository;

    @Autowired
    public DancingRankServiceImpl(DancingTableRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DanceRank> listAllDanceRank() {
        long start = System.currentTimeMillis();
        List<DanceRank> danceRankList = this.repository.findAll();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return danceRankList;
    }

    public DanceRank getDanceRank(String name) {
        return this.repository.findByName(name);
    }

    public DanceRank insertDanceRank(DanceRank danceRank) {
        return this.repository.save(new DanceRank(danceRank.getName(),danceRank.getRank()));

    }
}
