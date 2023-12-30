package jpabook.jpashop.web;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class ItemController {
 /**
 * 상품 수정 폼
 */
 @GetMapping(value = "/items/{itemId}/edit")
 public String updateItemForm(@PathVariable("itemId") Long itemId, Model
model) {
 Book item = (Book) itemService.findOne(itemId);
 BookForm form = new BookForm();
 form.setId(item.getId());
 form.setName(item.getName());
 form.setPrice(item.getPrice());
 form.setStockQuantity(item.getStockQuantity());
 form.setAuthor(item.getAuthor());
 form.setIsbn(item.getIsbn());
 model.addAttribute("form", form);
 return "items/updateItemForm";
 }
 /**
 * 상품 수정
 */
 @PostMapping(value = "/items/{itemId}/edit")
 public String updateItem(@ModelAttribute("form") BookForm form) {
 Book book = new Book();
 book.setId(form.getId());
 book.setName(form.getName());
 book.setPrice(form.getPrice());
 book.setStockQuantity(form.getStockQuantity());
 book.setAuthor(form.getAuthor());
 book.setIsbn(form.getIsbn());
 itemService.saveItem(book);
 return "redirect:/items";
 }
}
