package com.furkan.trendyoliki.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkan.trendyoliki.entity.Category;
import com.furkan.trendyoliki.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categorys")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/categorys/{categoryId}")
    public Category findById( @PathVariable int categoryId){


        return categoryService.findById(categoryId);
    }

    @PostMapping("/categorys")
    public Category save(@RequestBody Category category ){
        Category item =categoryService.save(category);
        return  item;
    }
    @PutMapping("/categorys")
    public Category update(@RequestBody Category category){
        Category item =categoryService.save(category);
        return item;

    }
    @DeleteMapping("/categorys/{id}")
    public void delete(@PathVariable int id){

        categoryService.deleteById(id);
    }

}
