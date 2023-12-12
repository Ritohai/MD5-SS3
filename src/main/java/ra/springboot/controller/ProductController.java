package ra.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.springboot.entity.Category;
import ra.springboot.entity.Product;
import ra.springboot.service.CategoryService;
import ra.springboot.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> product = productService.findAll();
        model.addAttribute("products", product);
        List<Category> category = categoryService.findAll();
        model.addAttribute("category", category);
        return "product/index";
    }

    @GetMapping("/create")
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("category", categoryService.findAll());
        return "product/add";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product) {
        if (productService.save(product) != null) {
            return "redirect:/product";
        }
        return "product/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id);
        List<Category> categories = categoryService.findAll();
        if (product != null) {
            model.addAttribute("editProduct", product);
            model.addAttribute("categoryList",categories);
            return "product/edit";
        }
        return "redirect:/product";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product){
        Product newProduct=productService.save(product);
        if (newProduct!=null){
            return "redirect:/product";
        }
        return "product/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        productService.delete(id);
        return "redirect:/product";
    }

}
