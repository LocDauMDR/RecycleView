package vn.edu.ntu.quangloc.controller;

import java.util.List;

import vn.edu.ntu.quangloc.model.Product;

public interface ICartController {
    public List<Product> getAllProduct();
    public boolean addToCart(Product p);
    public List<Product> getShoppingCart();
    public void clearShoppingCart();
}
