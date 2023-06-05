package com.simple.keen.system.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.system.model.query.DeptQuery;
import com.simple.keen.system.service.IDeptService;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门controller
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api/system/dept")
public class DeptController {

    private final IDeptService deptService;

    @GetMapping("page")
    public Response pageDept(DeptQuery deptQuery) {
        return Response.ok(deptService.pageDept(deptQuery));
    }

    @GetMapping
    public Response getDept(@NotNull Integer id) {
        return Response.ok(deptService.getDeptById(id));
    }

    @GetMapping("user")
    public Response listDeptWithUser(DeptQuery deptQuery) {
        return Response.ok(deptService.listDeptWithUser(deptQuery));
    }

    @GetMapping("tree")
    public Response listTreeModel() {
        return Response.ok(deptService.listDeptTreeModel());
    }

    @PostMapping
    public Response addOrUpdateDept(@Validated @RequestBody DeptQuery deptQuery) {
        deptService.addOrUpdateDept(deptQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteDept(@NotNull @RequestBody DeptQuery deptQuery) {
        deptService.deleteDept(deptQuery.getIds());
        return Response.ok();
    }
}
