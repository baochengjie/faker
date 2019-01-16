package com.bcj.faker.dto;

import com.bcj.faker.model.CustomJob;
import com.bcj.faker.model.CustomJobDetail;
import lombok.Data;

/**
 * @ClassName CustomJob
 * @Description TODO
 * @Author baochengjie
 * @Date 2019/1/16 13:57
 * @Version 1.0
 **/
@Data
public class JobMessage {
    private CustomJob customJob;
    private CustomJobDetail customJobDetail;

    public JobMessage() {
    }
}
