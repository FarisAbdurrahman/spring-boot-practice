package hello.mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MahasiswaController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private MahasiswaService mahasiswaService;
    @RequestMapping("/mahasiswa")
    public Mahasiswa mahasiswa(@RequestParam(value="name",  defaultValue="World") String name) {
        return new Mahasiswa(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/mahasiswa/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody MahasiswaVO vo){
        String result = mahasiswaService.saveMahasiswa(vo);
        return result;
    }


    @RequestMapping(value = "/mahasiswa/delete/{id}",
            method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){
        String result = mahasiswaService.deleteMahasiswa(id);
        return result;
    }


    @RequestMapping(value = "/mahasiswa/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody MahasiswaVO vo){
        String result = mahasiswaService.updateMahasiswa(vo);
        return result;
    }


    @RequestMapping(value = "/mahasiswa/get",
            method = RequestMethod.GET)
    public List<MahasiswaVO> get(){
        List<MahasiswaVO> result = mahasiswaService.getAll();
        return result;
    }


    @RequestMapping(value = "/mahasiswa/get-by-id",
            method = RequestMethod.GET)
    public MahasiswaVO getById(@RequestParam(value="id") Long id){
        MahasiswaVO result = mahasiswaService.getGetById(id);
        return result;
    }


    @RequestMapping(value = "/mahasiswa/get-by-name",
            method = RequestMethod.GET)
    public List<MahasiswaVO> getByName( @RequestParam(value="name") String name){
        List<MahasiswaVO> result = mahasiswaService .getByName(name);
        return result;
    }
}
