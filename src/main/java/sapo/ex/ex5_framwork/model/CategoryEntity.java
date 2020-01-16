package sapo.ex.ex5_framwork.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category", schema = "sapoproject")
public class CategoryEntity {
    private int idcategory;
    private String namecategory;
    private Date datecreated;
    private Date fixdate;


    @Id
    @Column(name = "idcategory", nullable = false)
    public int getIdcategory() {
        return idcategory;
    }

    public CategoryEntity(String namecategory, Date datecreated, Date fixdate) {
        this.namecategory = namecategory;
        this.datecreated = datecreated;
        this.fixdate = fixdate;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    @Basic
    @Column(name = "namecategory", nullable = true, length = 45)
    public String getNamecategory() {
        return namecategory;
    }

    public void setNamecategory(String namecategory) {
        this.namecategory = namecategory;
    }

    @Basic
    @Column(name = "datecreated", nullable = true)
    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    @Basic
    @Column(name = "fixdate", nullable = true)
    public Date getFixdate() {
        return fixdate;
    }

    public void setFixdate(Date fixdate) {
        this.fixdate = fixdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (idcategory != that.idcategory) return false;
        if (namecategory != null ? !namecategory.equals(that.namecategory) : that.namecategory != null) return false;
        if (datecreated != null ? !datecreated.equals(that.datecreated) : that.datecreated != null) return false;
        if (fixdate != null ? !fixdate.equals(that.fixdate) : that.fixdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategory;
        result = 31 * result + (namecategory != null ? namecategory.hashCode() : 0);
        result = 31 * result + (datecreated != null ? datecreated.hashCode() : 0);
        result = 31 * result + (fixdate != null ? fixdate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "idcategory=" + idcategory +
                ", namecategory='" + namecategory + '\'' +
                ", datecreated=" + datecreated +
                ", fixdate=" + fixdate +
                '}';
    }

    public CategoryEntity() {
    }

}
