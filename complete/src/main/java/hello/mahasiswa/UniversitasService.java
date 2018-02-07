package hello.mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversitasService {
    @Autowired
    UniversitasRepository universitasRepository;
    @Autowired
    MahasiswaRepository mahasiswaRepository;
    public String saveUniversitas(UniversitasVO vo){
        Universitas universitas = new Universitas();
        universitas.setName(vo.getName());
        universitasRepository.save(universitas);
        return "success";
    }
    public String updateUniversitas(UniversitasVO vo) {
        try {
            Universitas universitas = universitasRepository.findById(vo.getID());
            universitas.setName(vo.getName());
            universitasRepository.save(universitas);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
    public String deleteUniversitas(Long id){
        universitasRepository.delete(id);
        return "success";
    }
    public List<UniversitasVO> getAll(){
        List<Universitas> listResult = universitasRepository.findAll();
        List<UniversitasVO> listVo = new ArrayList<>();
        for (Universitas universitas : listResult){
            UniversitasVO vo = new UniversitasVO();
            vo.setID(universitas.getID());
            vo.setName(universitas.getName());
            List<Mahasiswa> listMahasiswaResult = mahasiswaRepository.findByUniversitasIdId(universitas.getID());
            List<MahasiswaVO> listMahasiswaVo = new ArrayList<>();
            for (Mahasiswa mahasiswa : listMahasiswaResult){
                MahasiswaVO mahasiswaVo = new MahasiswaVO();
                mahasiswaVo.setID(mahasiswa.getID());
                mahasiswaVo.setName(mahasiswa.getName());
                mahasiswaVo.setUniversitasId(mahasiswa.getUniversitasId().getID());
                listMahasiswaVo.add(mahasiswaVo);
            }
            vo.setMahasiswa(listMahasiswaVo);
            listVo.add(vo);
        }
        return listVo;
    }
    public UniversitasVO getGetById(Long id){
        Universitas result = universitasRepository.findById(id);
        UniversitasVO vo = new UniversitasVO();
        vo.setID(result.getID());
        vo.setName(result.getName());
        return vo;
    }
    public List<UniversitasVO> getByName(String name){
        List<Universitas> listResult = universitasRepository.findByNameContaining(name);
        List<UniversitasVO> listVo = new ArrayList<>();
        for (Universitas universitas : listResult){
            UniversitasVO vo = new UniversitasVO();
            vo.setID(universitas.getID());
            vo.setName(universitas.getName());
            listVo.add(vo);
        }
        return listVo;
    }
    public List<MahasiswaVO> getMahasiswaById(Long id){
        Universitas result = universitasRepository.findById(id);
        List<MahasiswaVO> listVo = new ArrayList<>();
        for (Mahasiswa mahasiswa : result.getMahasiswa()){
            MahasiswaVO mahasiswaVo = new MahasiswaVO();
            mahasiswaVo.setID(mahasiswa.getID());
            mahasiswaVo.setName(mahasiswa.getName());
            mahasiswaVo.setUniversitasId(mahasiswa.getUniversitasId().getID());
            listVo.add(mahasiswaVo);
        }
        return listVo;
    }
}
