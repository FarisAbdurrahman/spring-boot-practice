package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//pengolahan pada greeting, tapi data dikirim lewat VO
@Service
public class GreetingService {
    @Autowired
    GreetingRepository greetingRepository;
    public String saveGreeting(GreetingVO vo){
        Greeting greeting = new Greeting();
        greeting.setContent(vo.getContent());
        greetingRepository.save(greeting);
        return "success";
    }
    public String updateGreeting(GreetingVO vo) {
        try {
            Greeting greeting = greetingRepository.findById(vo.getId());
            greeting.setContent(vo.getContent());
            greetingRepository.save(greeting);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
    public String deleteGreeting(long id){
        greetingRepository.delete(id);
        return "success";
    }
    public List<GreetingVO> getAll(){
        List<Greeting> listResult = greetingRepository.findAll();
        List<GreetingVO> listVo = new ArrayList<>();
        for (Greeting greeting : listResult){
            GreetingVO vo = new GreetingVO();
            vo.setId(greeting.getId());
            vo.setContent(greeting.getContent());
            listVo.add(vo);
        }
        return listVo;
    }
    public GreetingVO getGetById(Long id){
        Greeting result = greetingRepository.findById(id);
        GreetingVO vo = new GreetingVO();
        vo.setId(result.getId());
        vo.setContent(result.getContent());
        return vo;
    }
    public List<GreetingVO> getByContent(String content){
        List<Greeting> listResult = greetingRepository .findByContentContaining(content);
        List<GreetingVO> listVo = new ArrayList<>();
        for (Greeting greeting : listResult){
            GreetingVO vo = new GreetingVO();
            vo.setId(greeting.getId());
            vo.setContent(greeting.getContent());
            listVo.add(vo);
        }
        return listVo;
    }
}

