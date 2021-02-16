package argin.io.controller;


import argin.io.entity.Family;
import argin.io.entity.QueryPage;
import argin.io.entity.R;
import argin.io.service.IFamilyService;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author argin
 * @since 2021-02-16
 */
@RestController
public class FamilyController {

    @Resource
    private IFamilyService service;

    @PostMapping("/save")
    public R save(@RequestBody Family family) {
        family.now();
        service.save(family);
        return R.ok().message("新增成功");
    }

    @GetMapping("/remove/{id}")
    public R remove(@PathVariable String id) {
        service.removeById(id);
        return R.ok().message("删除成功");
    }

    @PostMapping("/update")
    public R update(@RequestBody Family family) {
        family.now();
        service.updateById(family);
        return R.ok().message("修改成功");
    }

    @PostMapping("/list")
    public R list(@RequestBody QueryPage queryPage) {
        Page<Family> page;
        try {
            String queryString = queryPage.getQueryString();
            if (queryString != null && queryString.length() > 0){
                page = new LambdaQueryChainWrapper<>(service.getBaseMapper())
                        .like(Family::getCard, queryString)
                        .or()
                        .like(Family::getName, queryString)
                        .page(new Page<>(queryPage.getCurrentPage(), queryPage.getPageSize()));
            } else {
                page = new LambdaQueryChainWrapper<>(service.getBaseMapper())
                        .page(new Page<>(queryPage.getCurrentPage(), queryPage.getPageSize()));
            }
            return R.ok().data(page.getRecords()).total(page.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

}
