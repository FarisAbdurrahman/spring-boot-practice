package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//table asli, untuk di-refer bukan dikirim
@Entity
public class Greeting { 
     @Id
     @GeneratedValue(strategy= GenerationType.AUTO)
     private long id;
     private String content;
     public Greeting() {
     }
     public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
     public long getId() {
        return id;
    }
     public void setId(long id) {
        this.id = id;
    }
     public String getContent() {
        return content;
    }
     public void setContent(String content) {
        this.content = content;
    }
} 
