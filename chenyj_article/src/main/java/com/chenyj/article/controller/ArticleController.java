package com.chenyj.article.controller;

import com.chenyj.article.pojo.Article;
import com.chenyj.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private RestTemplate restTemplate;


	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(StatusCodeEnum.SUCCESS,articleService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@GetMapping(value="/{id}")
	public Result findById(@PathVariable String id){
		Article article = articleService.findById(id);
		return new Result(StatusCodeEnum.SUCCESS,article);
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Article> pageList = articleService.findSearch(searchMap, page, size);
		return  new Result(StatusCodeEnum.SUCCESS,  new PageResult<Article>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(StatusCodeEnum.SUCCESS,articleService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param article
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Article article  ){
		articleService.add(article);
		return new Result(StatusCodeEnum.SUCCESS);
	}
	
	/**
	 * 修改
	 * @param article
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Article article, @PathVariable String id ){
		article.setId(id);
		articleService.update(article);
		return new Result(StatusCodeEnum.SUCCESS);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		articleService.deleteById(id);
		return new Result(StatusCodeEnum.SUCCESS);
	}

	/**
	 * @desc: 审核
	 * @author: chenyj
	 * @date: 2019/10/27
	 * @param id
	 * @return
	 */
	@GetMapping(value="/examine/{id}")
	public Result examine(@PathVariable String id){
		return new Result(StatusCodeEnum.SUCCESS, articleService.updateState("2",id));
	}

	/**
	 * @desc:
	 * @author: chenyj
	 * @date: 2019/10/27
	 * @return
	 */
	@GetMapping(value = "/thumbup/{id}")
	public Result updateThumbup(@PathVariable String id){
		articleService.addThumbup(id);
		return new Result(StatusCodeEnum.SUCCESS);
	}
	
}
