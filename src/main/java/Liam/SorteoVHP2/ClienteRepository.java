package Liam.SorteoVHP2;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    boolean existsByDni(String dni);
}