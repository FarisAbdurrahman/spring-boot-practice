package hello.mahasiswa;

import javax.persistence.*;

@Entity
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn
    private Universitas universitasId;
    public Mahasiswa(){

    }
    public Mahasiswa(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public Long getID(){
        return this.id;
    }
    public Universitas getUniversitasId(){
        return this.universitasId;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setUniversitasId(Universitas universitasId){
        this.universitasId = universitasId;
    }
}
