package aula.example.aula.repositories;


import aula.example.aula.model.productmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProducRepository extends JpaRepository<productmodel, UUID>{
}
