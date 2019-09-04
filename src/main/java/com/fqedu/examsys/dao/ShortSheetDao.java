package com.fqedu.examsys.dao;

import org.apache.ibatis.annotations.Param;

public interface ShortSheetDao {

    /**
     *
     * @param paperId
     * @param userId
     * @param shortId
     * @param score
     */
    public void updateShortSheet(@Param("paperId") Integer paperId,
                                 @Param("userId") Integer userId,
                                 @Param("shortId") Integer shortId,
                                 @Param("score") Integer score);
}
