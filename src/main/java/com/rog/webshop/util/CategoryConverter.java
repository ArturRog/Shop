package com.rog.webshop.util;

import com.rog.webshop.model.product.Category;
import com.rog.webshop.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<Object, Category> {

    @Autowired
    CategoryService categoryService;

    /*
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Category convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Category category= categoryService.findById(id);
        System.out.println("Profile : "+category);
        return category;
    }

	/*
	 * Gets UserProfile by type
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */

//	public UserProfile convert(Object element) {
//		String type = (String)element;
//		UserProfile profile= userProfileService.findByType(type);
//		System.out.println("Profile ... : "+profile);
//		return profile;
//	}


}