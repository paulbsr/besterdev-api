package ie.bester.besterdevapi.repository;

import ie.bester.besterdevapi.entity.EntityOne;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface RepoOne extends JpaRepository<EntityOne, Integer>{
    public Optional<EntityOne> findById (int ID);

}