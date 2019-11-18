package com.chenyj.user.controller;

import com.chenyj.user.pojo.Admin;
import com.chenyj.user.pojo.User;
import com.chenyj.user.service.UserService;
import entity.PageResult;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
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
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@GetMapping
	public Result findAll(){
		return new Result(StatusCodeEnum.SUCCESS,userService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@GetMapping(value="/{id}")
	public Result findById(@PathVariable String id){
		return new Result(StatusCodeEnum.SUCCESS,userService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@PostMapping(value="/search/{page}/{size}")
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<User> pageList = userService.findSearch(searchMap, page, size);
		return  new Result(StatusCodeEnum.SUCCESS,  new PageResult<User>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @PostMapping(value="/search")
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(StatusCodeEnum.SUCCESS,userService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param user
	 */
	@PostMapping
	public Result add(@RequestBody User user){
		userService.add(user);
		return new Result(StatusCodeEnum.SUCCESS,"增加成功");
	}
	
	/**
	 * 修改
	 * @param user
	 */
	@PutMapping(value="/{id}")
	public Result update(@RequestBody User user, @PathVariable String id ){
		user.setId(id);
		userService.update(user);		
		return new Result(StatusCodeEnum.SUCCESS,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping(value="/{id}")
	public Result delete(@PathVariable String id ){
		try {
			userService.deleteById(id, request);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(StatusCodeEnum.SUCCESS,e.getMessage());
		}
		return new Result(StatusCodeEnum.SUCCESS,"删除成功");
	}

	/**
	 * 发送短信验证码
	 * @param mobile
	 * @return
	 */
	@PostMapping(value = "/sendSms/{mobile}")
	public Result sendSms(@PathVariable String mobile){
		return new Result(StatusCodeEnum.SUCCESS,userService.sendSms(mobile));
	}

	/**
	 * 验证短信验证码
	 * @param code
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/checkCode/{code}")
	public Result checkCode(@PathVariable String code, @RequestBody User user){
		Result result;
		String message=userService.checkCode(user.getMobile(),code);
		if (StringUtils.isEmpty(message)){
			result=new Result(StatusCodeEnum.SUCCESS);
			return result;
		}
		result=new Result(StatusCodeEnum.FAIL,message);
		return result;
	}


}
