package ra.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.springboot.entity.Category;
import ra.springboot.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("list", list);
        return "category/index";
    }

    @GetMapping("/create")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category) {
        if (categoryService.save(category) != null) {
            return "redirect:/category";
        }
        return "category/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit")
    public String editCate(@ModelAttribute("category") Category category) {
        if (categoryService.save(category) != null) {
            return "redirect:/category";
        }
        return "category/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Category category = categoryService.findById(id);
        categoryService.delete(category.getCategoryId());
        return "redirect:/category";
    }
}
