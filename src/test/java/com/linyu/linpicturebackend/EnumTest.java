package com.linyu.linpicturebackend;

import com.linyu.linpicturebackend.model.enums.PictureReviewStatusEnum;
import org.junit.jupiter.api.Test;

class EnumTest {
    @Test
    void test() {
        System.out.println(PictureReviewStatusEnum.getEnumByValue(0));
    }
}
