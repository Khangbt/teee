package sapo.ex.ex5_framwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "name", schema = "sapoproject")
public class NameEntity {

    private int idname;

    private String nam;

    @Id
    @Column(name = "idname", nullable = false)
    public int getIdname() {
        return idname;
    }

    public void setIdname(int idname) {
        this.idname = idname;
    }

    @Basic
    @Column(name = "nam", nullable = true, length = 45)
    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameEntity that = (NameEntity) o;

        if (idname != that.idname) return false;
        if (nam != null ? !nam.equals(that.nam) : that.nam != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idname;
        result = 31 * result + (nam != null ? nam.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NameEntity{" +
                "idname=" + idname +
                ", nam='" + nam + '\'' +
                '}';
    }
}
