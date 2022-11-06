package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetAllTechnologiesRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologiesResponse> getAllByLanguageId(GetAllTechnologiesRequest getAllTechnologiesRequest) throws Exception;

    void create(CreateTechnologyRequest createTechnologyRequest);

    void update(UpdateTechnologyRequest updateTechnologyRequest);

    void delete(DeleteTechnologyRequest deleteTechnologyRequest);
}
