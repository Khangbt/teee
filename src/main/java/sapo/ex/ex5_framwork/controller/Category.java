//package sapo.ex.ex5_framwork.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import sapo.ex.ex5_framwork.model.CategoryEntity;
//import sapo.ex.ex5_framwork.model.ProductEntity;
//import sapo.ex.ex5_framwork.service.CategoryService;
//import sapo.ex.ex5_framwork.service.ProductService;
//
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//@Component
//public class Category {
//    @Autowired
//    private CategoryService categoryService;
//    @Autowired
//    private ProductService productService;
//    public Scanner scanner = new Scanner(System.in);
//
//    public void menu() {
//        int i = 0;
//
//        while (i < 3) {
//
//            System.out.println("nhap yeu cau");
//            System.out.println("1 :show thong tin bang Category");
//            System.out.println("2 :show thong tin san phamm");
////        System.out.println("3 :them moi 1 danh muc");
////        System.out.println("4 :them mo 1 san pham");
//             i = scanner.nextInt();
//            if (i == 1) {
//                showCategory();
//            }
//            if (i == 2) {
//                showProuct();
//            }
//            if (i >= 3) {
//                break;
//            }
//        }
//
//    }
//
//    public void showCategory() {
//        ArrayList<CategoryEntity> entities = (ArrayList<CategoryEntity>) categoryService.getAll();
//        for (CategoryEntity entity : entities) {
//            System.out.println("ten " + entity.getNamecategory());
//            System.out.println("ngay tao " + entity.getDatecreated().toString());
//            System.out.println("ngay tra " + entity.getFixdate().toString());
//        }
//    }
//
//    public void showProuct() {
//        ArrayList<ProductEntity> entities = (ArrayList<ProductEntity>) productService.getAll();
//        for (ProductEntity entity : entities) {
//            System.out.println("ten " + entity.getNameprouct());
//            System.out.println(".......................");
//            System.out.println("mo ta " + entity.getProductdescription());
//        }
//    }
//
//}
