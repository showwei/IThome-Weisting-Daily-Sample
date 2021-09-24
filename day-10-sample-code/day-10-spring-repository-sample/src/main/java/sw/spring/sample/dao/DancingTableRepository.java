package sw.spring.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sw.spring.sample.annotations.PostgresqlRepository;
import sw.spring.sample.model.DanceRank;

import java.util.List;

@PostgresqlRepository
public interface DancingTableRepository extends JpaRepository<DanceRank, Integer> {
    DanceRank findByName(String name);

    List<DanceRank> findAll();
}
