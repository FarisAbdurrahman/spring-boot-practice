package hello.mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UniversitasController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private UniversitasService universitasService;
    @RequestMapping("/universitas")
    public Universitas universitas(@RequestParam(value="name",  defaultValue="World") String name) {
        return new Universitas(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/universitas/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody UniversitasVO vo){
        String result = universitasService.saveUniversitas(vo);
        return result;
    }


    @RequestMapping(value = "/universitas/delete/{id}",
            method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){
        String result = universitasService.deleteUniversitas(id);
        return result;
    }


    @RequestMapping(value = "/universitas/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody UniversitasVO vo){
        String result = universitasService.updateUniversitas(vo);
        return result;
    }


    @RequestMapping(value = "/universitas/get",
            method = RequestMethod.GET)
    public List<UniversitasVO> get(){
        List<UniversitasVO> result = universitasService.getAll();
        return result;
    }


    @RequestMapping(value = "/universitas/get-by-id",
            method = RequestMethod.GET)
    public UniversitasVO getById(@RequestParam(value="id") Long id){
        UniversitasVO result = universitasService.getGetById(id);
        return result;
    }


    @RequestMapping(value = "/universitas/get-by-name",
            method = RequestMethod.GET)
    public List<UniversitasVO> getByName( @RequestParam(value="name") String name){
        List<UniversitasVO> result = universitasService .getByName(name);
        return result;
    }

    @RequestMapping(value = "/universitas/get-mahasiswa-by-id", method = RequestMethod.GET)
    public List<MahasiswaVO> getMahasiswaById(@RequestParam(value = "id") Long id){
        List<MahasiswaVO> result = universitasService.getMahasiswaById(id);
        return result;
    }
}
