/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.client.config.filter.impl;

import com.alibaba.nacos.api.config.filter.IConfigContext;
import com.alibaba.nacos.api.config.filter.IConfigRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Config Request
 *
 * @author Nacos
 * @updateTime 2020-5-25 13:57:01
 */
public class ConfigRequest implements IConfigRequest {

    // 主要四个参数 tenant 承租人 dataId group content
    private Map<String, Object> param = new HashMap<String, Object>();

    private IConfigContext configContext = new ConfigContext();

    // tenant 实际上是 namespace
    public String getTenant() {
        return (String) param.get("tenant");
    }

    public void setTenant(String tenant) {
        param.put("tenant", tenant);
    }

    public String getDataId() {
        return (String) param.get("dataId");
    }

    public void setDataId(String dataId) {
        param.put("dataId", dataId);
    }

    public String getGroup() {
        return (String) param.get("group");
    }

    public void setGroup(String group) {
        param.put("group", group);
    }

    public String getContent() {
        return (String) param.get("content");
    }

    public void setContent(String content) {
        param.put("content", content);
    }

    @Override
    public Object getParameter(String key) {
        return param.get(key);
    }

    @Override
    public IConfigContext getConfigContext() {
        return configContext;
    }

}
