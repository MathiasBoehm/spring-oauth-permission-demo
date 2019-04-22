package de.struktuhr.resourceserver.control;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserInfoService {

    private Map<String, String> map;

    public UserInfoService() {
        initData();
    }

    public String getOrganizationId(String user) {
        return map.get(user);
    }

    private void initData() {
        map = new LinkedHashMap<>();
        map.put("user_0500", "0500");
        map.put("user_1522", "1522");
        map.put("admin", "0500");
    }
}
