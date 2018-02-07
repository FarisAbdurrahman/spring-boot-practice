package hello.mahasiswa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversitasRepository extends CrudRepository<Universitas, Long> {
    Universitas findById(Long id);
    List<Universitas> findAll();
    List<Universitas> findByNameContaining(String name);
}
