package com.chenyj.qa.controller;

import com.chenyj.qa.client.LabelClient;
import com.chenyj.qa.pojo.Problem;
import com.chenyj.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;

	@Autowired
	private LabelClient labelClient;

	@Autowired
	private HttpServletRequest request;

	@GetMapping("/label/{labelId}")
	public Result labelId(@PathVariable("labelId")String labelId){
		System.out.println("Authorization"+request.getHeader("authorization1"));
		return labelClient.findById(labelId);
	}

	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(StatusCodeEnum.SUCCESS,problemService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(StatusCodeEnum.SUCCESS,problemService.findById(id));
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
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return  new Result(StatusCodeEnum.SUCCESS, new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(StatusCodeEnum.SUCCESS,problemService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param problem
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Problem problem  ){
		problemService.add(problem);
		return new Result(StatusCodeEnum.SUCCESS);
	}
	
	/**
	 * 修改
	 * @param problem
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Problem problem, @PathVariable String id ){
		problem.setId(id);
		problemService.update(problem);		
		return new Result(StatusCodeEnum.SUCCESS);
	}


	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		problemService.deleteById(id);
		return new Result(StatusCodeEnum.SUCCESS);
	}

	/**
	 * @desc:
	 * @author: chenyj
	 * @date: 2019/10/26
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "/newList/{pageNumber}/{pageSize}")
	public Result newList(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
		Page<Problem> page=problemService.newList("1", pageNumber, pageSize);
		return new Result(StatusCodeEnum.SUCCESS, new PageResult<Problem>(page.getTotalElements(),page.getContent()));
	}

	/**
	 * @desc:
	 * @author: chenyj
	 * @date: 2019/10/26
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "/hotList/{pageNumber}/{pageSize}")
	public Result hotList(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
		Page<Problem> page=problemService.hotList("1", pageNumber, pageSize);
		return new Result(StatusCodeEnum.SUCCESS, new PageResult<Problem>(page.getTotalElements(),page.getContent()));
	}

	/**
	 * @desc:
	 * @author: chenyj
	 * @date: 2019/10/26
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "/waitList/{pageNumber}/{pageSize}")
	public Result waitList(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
		Page<Problem> page=problemService.waitList("1", pageNumber, pageSize);
		return new Result(StatusCodeEnum.SUCCESS, new PageResult<Problem>(page.getTotalElements(),page.getContent()));
	}
}
