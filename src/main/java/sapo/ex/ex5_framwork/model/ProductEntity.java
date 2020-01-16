package sapo.ex.ex5_framwork.model;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "sapoproject")
public class ProductEntity {
    private int idproduct;
    private String nameprouct;
    private Integer numberproducts;
    private String productdescription;
    private String productimagepath;
    private Integer productprice;
    private Integer sellnumber;
    private Integer idcategory;

    @Id
    @Column(name = "idproduct", nullable = false)
    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    @Basic
    @Column(name = "nameprouct", nullable = true, length = 45)
    public String getNameprouct() {
        return nameprouct;
    }

    public void setNameprouct(String nameprouct) {
        this.nameprouct = nameprouct;
    }

    @Basic
    @Column(name = "numberproducts", nullable = true)
    public Integer getNumberproducts() {
        return numberproducts;
    }

    public void setNumberproducts(Integer numberproducts) {
        this.numberproducts = numberproducts;
    }

    @Basic
    @Column(name = "productdescription", nullable = true, length = 145)
    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    @Basic
    @Column(name = "productimagepath", nullable = true, length = 45)
    public String getProductimagepath() {
        return productimagepath;
    }

    public void setProductimagepath(String productimagepath) {
        this.productimagepath = productimagepath;
    }

    @Basic
    @Column(name = "productprice", nullable = true)
    public Integer getProductprice() {
        return productprice;
    }

    public void setProductprice(Integer productprice) {
        this.productprice = productprice;
    }

    @Basic
    @Column(name = "sellnumber", nullable = true)
    public Integer getSellnumber() {
        return sellnumber;
    }

    public void setSellnumber(Integer sellnumber) {
        this.sellnumber = sellnumber;
    }

    @Basic
    @Column(name = "idcategory", nullable = true)
    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }



    @Override
    public int hashCode() {
        int result = idproduct;
        result = 31 * result + (nameprouct != null ? nameprouct.hashCode() : 0);
        result = 31 * result + (numberproducts != null ? numberproducts.hashCode() : 0);
        result = 31 * result + (productdescription != null ? productdescription.hashCode() : 0);
        result = 31 * result + (productimagepath != null ? productimagepath.hashCode() : 0);
        result = 31 * result + (productprice != null ? productprice.hashCode() : 0);
        result = 31 * result + (sellnumber != null ? sellnumber.hashCode() : 0);
        result = 31 * result + (idcategory != null ? idcategory.hashCode() : 0);
        return result;
    }
}
