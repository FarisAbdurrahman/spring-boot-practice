package hello.mahasiswa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Universitas {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "universitasId")
    private List<Mahasiswa> mahasiswaList;
    public Universitas(){

    }
    public Universitas(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public Long getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public List<Mahasiswa> getMahasiswa(){
        return this.mahasiswaList;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMahasiswa(List<Mahasiswa> mahasiswaList){
        this.mahasiswaList = mahasiswaList;
    }
}
