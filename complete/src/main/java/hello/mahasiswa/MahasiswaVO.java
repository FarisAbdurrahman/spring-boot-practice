package hello.mahasiswa;

public class MahasiswaVO {
    private Long id;
    private String name;
    private Long universitasId;
    public Long getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Long getUniversitasId(){
        return this.universitasId;
    }
    public void setID(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setUniversitasId(Long universitasId){
        this.universitasId = universitasId;
    }
}
