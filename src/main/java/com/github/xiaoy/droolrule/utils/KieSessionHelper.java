package com.github.xiaoy.droolrule.utils;

import com.github.xiaoy.droolrule.init.InitRuleLoader;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * KieSession助手类
 *
 * @author billow
 * @Date 2021/1/10 16:38
 **/
@Slf4j
@Component
public class KieSessionHelper {

    @Autowired
    private InitRuleLoader initRuleLoader;

    /**
     * 获取KieSession
     *
     * @param groupId 分组ID
     * @return KieSession
     */
    public KieSession getKieSessionByGroupId(long groupId) {
        KieSession kieSession = initRuleLoader.getKieContainerByGroupId(groupId).getKieBase().newKieSession();
        kieSession.setGlobal("logger", log);
        return kieSession;
    }
}