/**
 * Created by ricardoramos on 6/1/16.
 */
import javax.persistence.*;
import java.sql.SQLException;
import java.sql.Statement;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "USERNAME", length = 50)
    private String username;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "LAST_NAME", length = 100)
    private String last_name;

    @Column(name = "PASSWORD", length = 20)
    private String password;

    @Column(name = "COUNTRY", length = 100)
    private String country;

    @Column(name = "BIRTHDAY", length = 100)
    private String birthday;

    @Column(name = "BIRTHPLACE", length = 100)
    private String birthplace;

    @Column(name = "STUDYPLACE", length = 100)
    private String studyplace;

    @Column(name = "WORKPLACE", length = 100)
    private String workplace;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getStudyplace() {
        return studyplace;
    }

    public void setStudyplace(String studyplace) {
        this.studyplace = studyplace;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Usuario(){

    }
    public Usuario(String username, String name, String password, boolean admin, boolean author) {

        this.setUsername(username);
        this.setName(name);
        this.setPassword(password);
    }

    public Usuario(String username, String name, String pass) {
        this.setUsername(username);
        this.setPassword(pass);
        this.setName(name);
    }




}

