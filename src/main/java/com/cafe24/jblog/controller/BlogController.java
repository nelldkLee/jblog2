package com.cafe24.jblog.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.LifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.service.CategoryService;
import com.cafe24.jblog.service.FileuploadService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.JSONResult;
import com.cafe24.jblog.vo.PostVo;

@Controller
@RequestMapping("/{blog_id:(?!assets|images).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping(value= {"", "/{category_no}"})
	public String blogMain(@PathVariable Optional<String> blog_id, @PathVariable Optional<Integer> category_no, ModelMap modelMap) {
		System.out.println("pathvariable check");
		System.out.println("blog_id : "  +blog_id.get());
		Integer categoryNo = 1;
		if(category_no.isPresent()) {
			categoryNo = category_no.get();
			System.out.println("category_no : "  +category_no.get());
		}
		String blogId = blog_id.get();
		modelMap.addAllAttributes(blogService.getMainList(blogId, categoryNo));
		
		return "blog/blog-main";
	}
	
	@GetMapping("/admin/basic")
	public String blogBasicAdmin(@PathVariable String blog_id, Model model) {
		BlogVo blogVo = blogService.getBlog(blog_id);
		model.addAttribute("blogId",blog_id);
		model.addAttribute("selected","basic");
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-admin-basic";
	}
	@PostMapping("/admin/basic")
	public String blogBasicAdmin(BlogVo vo,@RequestParam(value="logo-file") MultipartFile multipartFile, @PathVariable String blog_id) {
		String logoUrl = fileuploadService.restore(multipartFile);
		vo.setLogo(logoUrl);
		vo.setBlogId(blog_id);
		blogService.modify(vo);
		
		return "redirect:/" + blog_id;
	}
	
	@GetMapping("/admin/category")
	public String blogCategoryAdmin(@PathVariable String blog_id, Model model) {
		List<CategoryVo> categoryList = categoryService.getList(blog_id);
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("blogId",blog_id);
		model.addAttribute("selected","category");
		return "blog/blog-admin-category";
	}
	@PostMapping("/admin/category")
	@ResponseBody
	public  JSONResult blogCategoryAdmin(CategoryVo categoryVo, @PathVariable String blog_id) {
		boolean result = categoryService.register(categoryVo);
		return JSONResult.success(result);
	}
	@PostMapping("/admin/category/remove")
	@ResponseBody
	public  JSONResult blogCategoryAdminDelete(Integer categoryNo, @PathVariable String blog_id) {
		boolean result = categoryService.delete(categoryNo);
		return JSONResult.success(result);
	}
	
	@GetMapping("/admin/write")
	public String blogWriteAdmin(@PathVariable String blog_id, Model model) {
		model.addAttribute("blogId",blog_id);
		model.addAttribute("selected","write");
		return "blog/blog-admin-write";
	}
	@PostMapping("/admin/write")
	public String blogWriteAdmin(PostVo vo, @PathVariable String blog_id) {
		
		return "redirect:/" + blog_id;
	}
}
