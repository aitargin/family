package argin.io.service.impl;

import argin.io.entity.Family;
import argin.io.mapper.FamilyMapper;
import argin.io.service.IFamilyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author argin
 * @since 2021-02-16
 */
@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family> implements IFamilyService {

}
