package labshopmonolith.infra;
import labshopmonolith.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class InventoryHateoasProcessor implements RepresentationModelProcessor<EntityModel<Inventory>>  {

    @Override
    public EntityModel<Inventory> process(EntityModel<Inventory> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/addproduct").withRel("addproduct"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/decreasestock").withRel("decreasestock"));

        
        return model;
    }
    
}
