package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetAllTechnologiesRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class TechnologiesControllers {
    private TechnologyService technologyService;

    @Autowired
    public TechnologiesControllers(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getAllTechnologiesByLanguageId")
    public List<GetAllTechnologiesResponse> getAllByLanguageId(GetAllTechnologiesRequest getAllTechnologiesRequest) throws Exception {
        return technologyService.getAllByLanguageId(getAllTechnologiesRequest);
    }

    @PostMapping("/addTechnologyByLanguageId")
    public void create(CreateTechnologyRequest createTechnologyRequest) {
        technologyService.create(createTechnologyRequest);
    }

    @PutMapping("/updateTechnology")
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        technologyService.update(updateTechnologyRequest);
    }

    @DeleteMapping("/deleteTechnology")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        technologyService.delete(deleteTechnologyRequest);
    }
}
