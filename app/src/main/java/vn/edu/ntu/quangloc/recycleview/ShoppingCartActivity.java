package vn.edu.ntu.quangloc.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.quangloc.controller.ICartController;
import vn.edu.ntu.quangloc.model.Product;

public class ShoppingCartActivity extends AppCompatActivity  implements View.OnClickListener {

    TextView txtShoppingCart;
    Button btnSubmit, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addViews();
    }

    private void addViews() {
        txtShoppingCart = findViewById(R.id.txtShoppingCart);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        showShoppingCart();
    }
    private void showShoppingCart() {
        ICartController controller = (ICartController) getApplication();
        List<Product> shoppingCart = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder();
        for (Product p:shoppingCart) {
            builder.append(p.getName())
                    .append("\t\t\t")
                    .append(p.getPrice())
                    .append("\n");
        }

        if (builder.toString().length()>0)
            txtShoppingCart.setText(builder.toString());
        else
            txtShoppingCart.setText("Không có mặt hàng nào trong giỏ hàng");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnCancel:
                cancel();
                break;
            case R.id.btnSubmit:
                submit();
                break;
        }
    }

    private void submit() {
        txtShoppingCart.setText("Đã đặt hàng thành công !!!");
    }

    private void cancel() {
        txtShoppingCart.setText("Không có mặt hàng nào trong giỏ hàng");
    }

}
