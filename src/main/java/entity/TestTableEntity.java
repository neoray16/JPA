package entity;

import jakarta.persistence.*;

import java.util.List;

@NamedQuery(name = "select",query = "SELECT e from TestTableEntity  e")
@Entity
@Table(name = "test_table", schema = "public", catalog = "Test")
public class TestTableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcolum")
    private int idcolum;

    @Override
    public String toString() {
        return "TestTableEntity{" +
                "idcolum=" + idcolum +
                ", nameTest='" + nameTest + '\'' +
                '}';
    }

    @Basic
    @Column(name = "name_test")
    private String nameTest;

    public int getIdcolum() {
        return idcolum;
    }

    public void setIdcolum(int idcolum) {
        this.idcolum = idcolum;
    }

    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestTableEntity that = (TestTableEntity) o;

        if (idcolum != that.idcolum) return false;
        if (nameTest != null ? !nameTest.equals(that.nameTest) : that.nameTest != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcolum;
        result = 31 * result + (nameTest != null ? nameTest.hashCode() : 0);
        return result;
    }
    public void update(List<TestTableEntity> l, int id,String change){
        for (TestTableEntity e:l) {
            if(e.getIdcolum() == id){
                e.setNameTest(change);
            }
        }
    }
}
