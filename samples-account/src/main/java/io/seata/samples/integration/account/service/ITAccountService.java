package io.seata.samples.integration.account.service;

import com.baomidou.mybatisplus.service.IService;
import io.seata.samples.integration.account.entity.TAccount;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.response.ObjectResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * * @author nieyinliang
 * @since 2022-02-08
 */
public interface ITAccountService extends IService<TAccount> {

    /**
     * 扣用户钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
