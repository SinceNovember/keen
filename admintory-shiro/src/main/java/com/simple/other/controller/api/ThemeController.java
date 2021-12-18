package com.simple.other.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.constant.Strings;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.other.model.dto.ThemeDTO;
import com.simple.other.model.entity.Theme;
import com.simple.other.model.params.ThemeParam;
import com.simple.other.model.vo.ThemeCondition;
import com.simple.other.service.ThemeService;
import lombok.NonNull;
import org.apache.shiro.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/api/other/theme")
public class ThemeController {

    @Resource
    private ThemeService themeService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取主题列表失败")
    public ResponseData listTheme(ThemeCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<ThemeDTO> configIPage = themeService.pageTheme(condition, pageNumber, pageSize);
        return Response.ok(configIPage);
    }

    @GetMapping
    @ControllerEndpoint(exceptionMessage = "获取主题失败")
    public ResponseData getTheme(@NonNull Integer id){
        ThemeDTO configDTO = themeService.convertTo(themeService.getById(id));
        return Response.ok(configDTO);
    }

    @PostMapping
    @ControllerEndpoint(operation = "新增主题", exceptionMessage = "新增主题失败")
    public ResponseData addTheme(@NonNull @RequestBody ThemeParam configParam){
        Theme theme = configParam.convertTo();
        theme.setCreateTime(new Date());
        themeService.save(theme);
        return Response.ok();
    }

    @PutMapping
    @ControllerEndpoint(operation = "修改主题", exceptionMessage = "修改主题")
    public ResponseData updateTheme(@NonNull @RequestBody ThemeParam configParam){
        Theme Theme = configParam.convertTo();
        themeService.updateById(Theme);
        return Response.ok();
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除主题", exceptionMessage = "删除主题")
    public ResponseData removeRole(@NonNull  @RequestParam("ids") String ids) {
        themeService.removeByIds(StringUtils.splitToSet(ids, Strings.COMMA));
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }

}
