package de.struktuhr.resourceserver.control;

import de.struktuhr.resourceserver.entity.Organization;
import de.struktuhr.resourceserver.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class OrganizationService {

    private Map<String, Organization> map;

    public OrganizationService() {
        initData();
    }

    public Organization getOrganization(String id)  {
        if (!map.containsKey(id)) {
            throw new NotFoundException("Cannot find Organization with id " + id);
        }
        return map.get(id);
    }

    private void initData() {
        map = new LinkedHashMap<>();
        map.put("0500", new Organization("0500", "Organization 0500"));
        map.put("1522", new Organization("1522", "Organization 1522"));
    }
}
