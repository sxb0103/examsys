package com.fqedu.examsys.service;



public interface ShortSheetService {

    /**
     *
     * @param paperId
     * @param userId
     * @param shortId
     * @param score
     */
    public void updateShortSheet(Integer paperId, Integer userId, Integer shortId, Integer score);
}
