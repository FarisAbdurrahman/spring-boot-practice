package hello.mahasiswa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MahasiswaRepository extends CrudRepository<Mahasiswa, Long> {
    Mahasiswa findById(Long id);
    List<Mahasiswa> findAll();
    List<Mahasiswa> findByNameContaining(String name);
    //dia jadi findByUniversitasIdId karena di field table mahasiswa nama kolomnya universitas_id_id
    //universitas_id_id karena variable di class Mahasiswa namanya universitasId harusnya universitas aja
    List<Mahasiswa> findByUniversitasIdId(Long id);
}
