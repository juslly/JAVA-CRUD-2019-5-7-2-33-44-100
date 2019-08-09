package com.employee.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudApplicationTests {

	@Test
	public void contextLoads() {
		
   @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    /*
     * @ApiOperation：注解来给API增加方法说明。
     * */
    @GetMapping
    @ApiOperation(value = "查询用户", notes = "查询接口")
    public User findUser(int id,int r) {
        User user = userService.findUser(id);
        System.out.println(user);
//        redisTemplate.opsForValue().set("id",user);
        return user;
    }


    @PostMapping
    @ApiOperation(value = "增加用户",notes = "新增接口")
    public User insertUser(User user) {
        userService.insertUser(user);
        return user;
    }

    @PutMapping
    @ApiOperation(value = "更新用户信息",notes = "更新接口")
    public User updateUser(User user) {
        userService.updateUser(user);
        return user;
    }


    @DeleteMapping
    @ApiOperation(value = "删除用户",notes = "删除接口")
    public Integer deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return id ;
    }

    @DeleteMapping("/delete")
//     List<Integer> ids
    @ApiOperation(value = "删除多个用户",notes = "删除多个用户接口")
    public String  deleteUser(Integer [] ids) {
        userService.deleteUserByList(ids);
        return "ok" ;
    }

}
