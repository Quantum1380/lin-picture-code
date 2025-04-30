package com.linyu.linpicturebackend.controller;

import com.linyu.linpicturebackend.annotation.AuthCheck;
import com.linyu.linpicturebackend.common.BaseResponse;
import com.linyu.linpicturebackend.common.ResultUtils;
import com.linyu.linpicturebackend.exception.BusinessException;
import com.linyu.linpicturebackend.exception.ErrorCode;
import com.linyu.linpicturebackend.exception.ThrowUtils;
import com.linyu.linpicturebackend.manage.auth.annotation.SaSpaceCheckPermission;
import com.linyu.linpicturebackend.manage.auth.model.SpaceUserPermissionConstant;
import com.linyu.linpicturebackend.model.dto.space.SpaceUpdateRequest;
import com.linyu.linpicturebackend.model.entity.Space;
import com.linyu.linpicturebackend.model.entity.SpaceUser;
import com.linyu.linpicturebackend.model.enums.UserConstant;
import com.linyu.linpicturebackend.model.vo.SpaceUserVO;
import com.linyu.linpicturebackend.service.SpaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    /**
     * 更新
     *
     * @param spaceUpdateRequest
     * @return
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateSpace(@RequestBody SpaceUpdateRequest spaceUpdateRequest) {
        if (spaceUpdateRequest == null || spaceUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 将实体类和 DTO 进行转换
        Space space = new Space();
        BeanUtils.copyProperties(spaceUpdateRequest, space);
        // 自动填充数据
        spaceService.fillSpaceBySpaceLevel(space);
        // 数据校验
        spaceService.validSpace(space, false);
        // 判断是否存在
        long id = spaceUpdateRequest.getId();
        Space oldSpace = spaceService.getById(id);
        ThrowUtils.throwIf(oldSpace == null, ErrorCode.NOT_FOUND_ERROR);
        // 操作数据库
        boolean result = spaceService.updateById(space);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(true);
    }
}