package com.linyu.linpicturebackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linyu.linpicturebackend.model.dto.space.SpaceAddRequest;
import com.linyu.linpicturebackend.model.entity.Space;
import com.linyu.linpicturebackend.model.entity.User;
import com.linyu.linpicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 86152
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-04-26 22:22:48
*/
public interface SpaceService extends IService<Space> {

    /**
     * 用户创建空间
     *
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 校验数据空间
     *
     * @param space
     * @param add
     */
    void validSpace(Space space, boolean add);

    /**
     * 根据级别填充限额
     *
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 获取空间包装类（单条）
     *
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);
}
