package com.sam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @ClassName: ApiController
 * @Description: test
 * @author sam
 * @date 2018-07-27 14:06:18
 */
@Api(value = "API Controller", tags = { "用户管理" })
@Controller
@RequestMapping("/api")
public class ApiController {

	@ApiOperation(value = "获取用户信息", notes = "注意问题点")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "操作成功"), 
			@ApiResponse(code = 500, message = "服务器内部异常"),
			@ApiResponse(code = 403, message = "权限不足") })
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public String getUser(@ApiParam(required = true, name = "start", value = "开始索引") Integer start,
			@ApiParam(required = true, name = "limit", value = "每页行数") Integer limit,
			@ApiParam(required = false, name = "userName", value = "名称模糊查询") String userName) {
		return "user";
	}

	@ApiOperation(value = "删除用户", notes = "删除用户为伪删除!")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "操作成功"), 
			@ApiResponse(code = 500, message = "服务器内部异常"),
			@ApiResponse(code = 403, message = "权限不足") })
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "信息id", required = true) })
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	@ResponseBody
	public String deleteUser(Long id) {
		return "user";
	}

	@ApiOperation("更改用户信息")
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public int updateUser(@RequestBody  @ApiParam(name = "用户对象", value = "传入json格式", required = true) User user) {
		return 1;
	}

}
