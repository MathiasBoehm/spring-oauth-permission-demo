package de.struktuhr.resourceserver.boundary;

import de.struktuhr.resourceserver.control.OrderService;
import de.struktuhr.resourceserver.control.OrganizationService;
import de.struktuhr.resourceserver.entity.Order;
import de.struktuhr.resourceserver.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoResourceController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrderService orderService;

    @PreAuthorize("isMemberOfOrganization(#id) or isAdmin()")
    @GetMapping("/organization/{id}")
    public Organization getOrganization(@PathVariable("id") String id) {
        return organizationService.getOrganization(id);
    }

    @PostAuthorize("isMemberOfOrganization(returnObject.organization) or isAdmin()")
    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") String id) {
        return orderService.getOrder(id);
    }
}
