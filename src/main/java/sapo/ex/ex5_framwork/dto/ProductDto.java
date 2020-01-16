package sapo.ex.ex5_framwork.dto;

import org.hibernate.validator.constraints.Length;
import sapo.ex.ex5_framwork.annotation.Test;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDto {
    @NotNull(message = "ko dc null")
    private int idProduct;

    @NotNull(message = "ko dc null")
    @Size(min = 2, max = 50, message = "kích thước ko hợp lê")
    private String nameprouct;
    @NotNull(message = "ko dc null")
    @Size(min = 2, max = 50, message = "kích thước ko hợp lê")
    private String productimagePath;
    @NotNull(message = "ko dc null")
//    @Size(min = 10,max = 50,message = "1333256431313")
    @Test
    @NotNull(message = "dsadadas")
    private Integer productprice;
    @NotNull(message = "ko dc null")

    private Integer numberproducts;
    @NotNull(message = "ko dc null")

    private Integer sellnumber;
    @NotNull(message = "ko dc null")
    @Size(max = 50, message = "1333256431313")
    private String productdescription;

    private int idCategory=1;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameprouct() {
        return nameprouct;
    }

    public void setNameprouct(String nameprouct) {
        this.nameprouct = nameprouct;
    }

    public String getProductimagePath() {
        return productimagePath;
    }

    public void setProductimagePath(String productimagePath) {
        this.productimagePath = productimagePath;
    }

    public Integer getProductprice() {
        return productprice;
    }

    public void setProductprice(Integer productprice) {
        this.productprice = productprice;
    }

    public Integer getNumberproducts() {
        return numberproducts;
    }

    public void setNumberproducts(Integer numberproducts) {
        this.numberproducts = numberproducts;
    }

    public Integer getSellnumber() {
        return sellnumber;
    }

    public void setSellnumber(Integer sellnumber) {
        this.sellnumber = sellnumber;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
