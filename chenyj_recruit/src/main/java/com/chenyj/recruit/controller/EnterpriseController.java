package com.chenyj.recruit.controller;

import com.chenyj.recruit.pojo.Enterprise;
import com.chenyj.recruit.service.EnterpriseService;
import entity.PageResult;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;
	

	@GetMapping(value = "/search/hotList")
	public Result findHot(){
		List<Enterprise> enterpriseList = enterpriseService.findbyIshot("1");
		return new Result(StatusCodeEnum.SUCCESS,enterpriseList);
	}

	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(StatusCodeEnum.SUCCESS,enterpriseService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(StatusCodeEnum.SUCCESS,enterpriseService.findById(id));
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
		Page<Enterprise> pageList = enterpriseService.findSearch(searchMap, page, size);
		return  new Result(StatusCodeEnum.SUCCESS,  new PageResult<Enterprise>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(StatusCodeEnum.SUCCESS,enterpriseService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param enterprise
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Enterprise enterprise  ){
		enterpriseService.add(enterprise);
		return new Result(StatusCodeEnum.SUCCESS);
	}
	
	/**
	 * 修改
	 * @param enterprise
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Enterprise enterprise, @PathVariable String id ){
		enterprise.setId(id);
		enterpriseService.update(enterprise);		
		return new Result(StatusCodeEnum.SUCCESS);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		enterpriseService.deleteById(id);
		return new Result(StatusCodeEnum.SUCCESS);
	}
	
}
