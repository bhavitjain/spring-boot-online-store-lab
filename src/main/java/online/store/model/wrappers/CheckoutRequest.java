package online.store.model.wrappers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String shippingAddress;
    private String creditCard;
    private List<ProductInfo> products;
}
