package com.chenyj.friend.service.impl;

import com.chenyj.friend.service.FriendService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/20 22:50
 * 陈银杰专属测试
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FriendServiceImpl implements FriendService {
}
