package kodlama.io.Kodlama.io.Devs.business.concretes;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetByIdLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();

        for(Language language : languages) {
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());
            languagesResponse.add(responseItem);
        }
        return languagesResponse;
    }

    @Override
    public void create(CreateLanguageRequest createLanguageRequest) throws Exception {
        Language language = new Language();
        language.setName(createLanguageRequest.getName());

        if(language.getName().isEmpty()) {
            throw new Exception("name cannot be empty");
        }
        for(GetAllLanguagesResponse l: getAll()) {
            if(l.getName().equals(language.getName())) {
                throw new Exception("language already exists");
            }
        }
        this.languageRepository.save(language);
    }

    @Override
    public GetByIdLanguageResponse getById(GetByIdLanguageRequest getByIdLanguageRequest) throws Exception {
        Language language = languageRepository.findById(getByIdLanguageRequest.getId()).get();
        GetByIdLanguageResponse languageResponse = new GetByIdLanguageResponse();
        languageResponse.setId(language.getId());
        languageResponse.setName(language.getName());
        return languageResponse;
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
        Language language = new Language();

        for(GetAllLanguagesResponse l: getAll()) {
            if(l.getId() == updateLanguageRequest.getId()) {
                language.setId(updateLanguageRequest.getId());
                language.setName(updateLanguageRequest.getName());
            }
        }
        this.languageRepository.save(language);
    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        this.languageRepository.deleteById(deleteLanguageRequest.getId());
    }
}
