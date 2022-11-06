package kodlama.io.Kodlama.io.Devs.business.concretes;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetAllTechnologiesRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;
    private LanguageRepository languageRepository;

    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAllByLanguageId(GetAllTechnologiesRequest getAllTechnologiesRequest) throws Exception {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologiesResponse> technologiesResponses = new ArrayList<GetAllTechnologiesResponse>();

        for(Technology t : technologies) {
            GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
            boolean flag = false;
            if(getAllTechnologiesRequest.getId() == t.getLanguage().getId()) {
                responseItem.setId(t.getId());
                responseItem.setName(t.getName());
                technologiesResponses.add(responseItem);
                flag = true;
            }
            if(!flag) {
                throw new Exception("there is not language with this id");
            }
        }
        return technologiesResponses;
    }

    @Override
    public void create(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();
        Language language = languageRepository.findById(createTechnologyRequest.getId()).get();

        technology.setName(createTechnologyRequest.getName());
        technology.setLanguage(language);
        this.technologyRepository.save(technology);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        Language language = languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();
        Technology technology = technologyRepository.findById(updateTechnologyRequest.getTechnologyId()).get();

        technology.setName(updateTechnologyRequest.getTechnologyName());
        technology.setLanguage(language);
        this.technologyRepository.save(technology);
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        Language language = languageRepository.findById(deleteTechnologyRequest.getLanguageId()).get();
        Technology technology = technologyRepository.findById(deleteTechnologyRequest.getTechnologyId()).get();

        technology.setLanguage(language);
        this.technologyRepository.delete(technology);
    }
}
