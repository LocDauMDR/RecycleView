package vn.edu.ntu.quangloc.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangloc.model.Product;

public class CartController extends Application implements ICartController {

    List<Product> listProducts = new ArrayList<>();
    List<Product> shoppingCart = new ArrayList<>();

    public CartController() {
        listProducts.add(new Product("Khoai Lang",25000, "Khoai lang theo tiêu chuẩn VietGap"));
        listProducts.add(new Product("Khoai Sọ",75000, "Khoai sọ trồng tại Ninh Hòa"));
        listProducts.add(new Product("Khoai Tím",65000, "Khoai tím màu đỏ đỏ tươi"));
        listProducts.add(new Product("Sầu Riêng",95000, "Sầu riêng Khánh Sơn loại 1"));
        listProducts.add(new Product("Bưởi da xanh",45000, "Bưởi da xanh Khánh Sơn loại 1"));
        listProducts.add(new Product("Bưởi da vàng",35000, "Bưởi da vàng Khánh Sơn loại 1"));
    }

    @Override
    public List<Product> getAllProduct() {
        return listProducts;
    }

    @Override
    public boolean addToCart(Product p) {
        if (shoppingCart.contains(p))
        return false;
        shoppingCart.add(p);
        return true;
    }

    @Override
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }
}
