package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private GreetingService greetingService;
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",  defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody GreetingVO vo){
        String result = greetingService.saveGreeting(vo);
        return result;
    }


    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){
        String result = greetingService.deleteGreeting(id);
        return result;
    }


    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody GreetingVO vo){
        String result = greetingService.updateGreeting(vo);
        return result;
    }


    @RequestMapping(value = "/get",
            method = RequestMethod.GET)
    public List<GreetingVO> get(){
        List<GreetingVO> result = greetingService.getAll();
        return result;
    }


    @RequestMapping(value = "/get-by-id",
            method = RequestMethod.GET)
    public GreetingVO getById(@RequestParam(value="id") Long id){
        GreetingVO result = greetingService.getGetById(id);
        return result;
    }


    @RequestMapping(value = "/get-by-content",
            method = RequestMethod.GET)
    public List<GreetingVO> getByContent( @RequestParam(value="content") String content){
        List<GreetingVO> result = greetingService .getByContent(content);
        return result;
    }
}
