package com.example.ex1_manager_product_thymeleaf.controllers;

import com.example.ex1_manager_product_thymeleaf.models.Product;
import com.example.ex1_manager_product_thymeleaf.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("product") Product product,
                       RedirectAttributes redirectAttributes) {
        product.setId((long) (Math.random() * 10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Them moi thanh cong");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product,
                         RedirectAttributes redirectAttributes) {
        Product updatedProduct = productService.findById(product.getId());
        if (updatedProduct == null) {
            redirectAttributes.addFlashAttribute("message", "thao tac that bai");
        } else {
            updatedProduct.setName(product.getName());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setQuantity(product.getQuantity());
            productService.update(product);
            redirectAttributes.addFlashAttribute("message", "Thao tác thanh cong");
        }
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String detailForm(Model model, @ModelAttribute("product") Product product) {
        Product detailProduct = productService.findById(product.getId());
        model.addAttribute("product", detailProduct);
        return "/detail";
    }

    @GetMapping("/{id}/delete")
    public String deleteForm(Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping("delete")
    public String delete(RedirectAttributes redirectAttributes,
                         @ModelAttribute("product") Product product) {
        Product deletedProduct = productService.findById(product.getId());
        if (deletedProduct == null) {
            redirectAttributes.addFlashAttribute("message", "thao tac that bai");
        }else{
            productService.deleteById(product.getId());
            redirectAttributes.addFlashAttribute("message", "Thao tac thanh cong");
        }
        return "redirect:/product";
    }
}
