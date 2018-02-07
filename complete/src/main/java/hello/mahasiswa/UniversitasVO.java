package hello.mahasiswa;

import java.util.List;

public class UniversitasVO {
    private Long id;
    private String name;
    private List<MahasiswaVO> mahasiswaList;
    public Long getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public List<MahasiswaVO> getMahasiswa(){
        return this.mahasiswaList;
    }
    public void setID(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMahasiswa(List<MahasiswaVO> mahasiswaList){
        this.mahasiswaList = mahasiswaList;
    }
}
