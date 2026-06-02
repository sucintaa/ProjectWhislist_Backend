/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wishlist;

/**
 *
 * @author palan
 */
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

    private final List<WishlistItemRequest> items = new ArrayList<>();

    public void addItem(WishlistItemRequest item) {
        items.add(item);
    }

    public List<WishlistItemRequest> getItems() {
        return items;
    }
}
