package hello.mahasiswa;

import org.apache.tomcat.util.collections.ManagedConcurrentWeakHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MahasiswaService {
    @Autowired
    MahasiswaRepository mahasiswaRepository;
    @Autowired
    UniversitasRepository universitasRepository;
    public String saveMahasiswa(MahasiswaVO vo){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setName(vo.getName());
        Universitas universitas = universitasRepository.findById(vo.getUniversitasId());
        mahasiswa.setUniversitasId(universitas);
        mahasiswaRepository.save(mahasiswa);
        return "success";
    }
    public String updateMahasiswa(MahasiswaVO vo) {
        try {
            Mahasiswa mahasiswa = mahasiswaRepository.findById(vo.getID());
            mahasiswa.setName(vo.getName());
            Universitas universitas = universitasRepository.findById(vo.getUniversitasId());
            mahasiswa.setUniversitasId(universitas);
            mahasiswaRepository.save(mahasiswa);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
    public String deleteMahasiswa(Long id){
        mahasiswaRepository.delete(id);
        return "success";
    }
    public List<MahasiswaVO> getAll(){
        List<Mahasiswa> listResult = mahasiswaRepository.findAll();
        List<MahasiswaVO> listVo = new ArrayList<>();
        for (Mahasiswa mahasiswa : listResult){
            MahasiswaVO vo = new MahasiswaVO();
            vo.setID(mahasiswa.getID());
            vo.setName(mahasiswa.getName());
            vo.setUniversitasId(mahasiswa.getUniversitasId().getID());
            listVo.add(vo);
        }
        return listVo;
    }
    public MahasiswaVO getGetById(Long id){
        Mahasiswa result = mahasiswaRepository.findById(id);
        MahasiswaVO vo = new MahasiswaVO();
        vo.setID(result.getID());
        vo.setName(result.getName());
        vo.setUniversitasId(result.getUniversitasId().getID());
        return vo;
    }
    public List<MahasiswaVO> getByName(String name){
        List<Mahasiswa> listResult = mahasiswaRepository.findByNameContaining(name);
        List<MahasiswaVO> listVo = new ArrayList<>();
        for (Mahasiswa mahasiswa : listResult){
            MahasiswaVO vo = new MahasiswaVO();
            vo.setID(mahasiswa.getID());
            vo.setName(mahasiswa.getName());
            vo.setUniversitasId(mahasiswa.getUniversitasId().getID());
            listVo.add(vo);
        }
        return listVo;
    }
}
