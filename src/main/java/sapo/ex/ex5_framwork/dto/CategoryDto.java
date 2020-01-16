package sapo.ex.ex5_framwork.dto;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class CategoryDto {
    @NotNull(message = "ko dc null")
    private int idcategory;
    @NotNull(message = "ko dc null")
    private String namecategory;
    @NotNull(message = "ko dc null")
    private Date datecreated;
    @NotNull(message = "ko dc null")
    private Date fixdate;



    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getNamecategory() {
        return namecategory;
    }

    public void setNamecategory(String namecategory) {
        this.namecategory = namecategory;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getFixdate() {
        return fixdate;
    }

    public void setFixdate(Date fixdate) {
        this.fixdate = fixdate;
    }

}
