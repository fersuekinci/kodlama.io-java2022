package kodlama.io.Kodlama.io.Devs.business.concretes;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    public void create(Language language) throws Exception {
        if(language.getName().isEmpty()) {
            throw new Exception("name cannot be empty");
        }
        for(Language l: getAll()) {
            if(l.getName().equals(language.getName())) {
                throw new Exception("language already exists");
            }
        }
        languageRepository.create(language);
    }

    @Override
    public Language getById(int id) throws Exception {
        return languageRepository.getById(id);
    }

    @Override
    public void update(Language language) throws Exception {
        languageRepository.update(language);
    }

    @Override
    public void delete(int id) throws Exception {
        languageRepository.delete(id);
    }
}
