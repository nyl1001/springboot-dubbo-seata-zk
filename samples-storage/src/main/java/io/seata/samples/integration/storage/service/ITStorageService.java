package io.seata.samples.integration.storage.service;

import com.baomidou.mybatisplus.service.IService;
import io.seata.samples.integration.common.dto.CommodityDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.storage.entity.TStorage;

/**
 * 仓库服务
 *
 * * @author nieyinliang
 * @since 2022-02-08
 */
public interface ITStorageService extends IService<TStorage> {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
