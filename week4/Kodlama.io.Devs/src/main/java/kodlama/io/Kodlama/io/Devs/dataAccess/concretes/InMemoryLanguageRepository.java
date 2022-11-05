package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1,"java"));
    }
    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getById(int id) throws Exception {
        for(Language l : languages) {
            if(l.getId() == id) {
                return l;
            }
        }
        throw new Exception("no record");
    }

    @Override
    public void create(Language language) {
        languages.add(language);
    }

    @Override
    public void update(Language language) throws Exception {
        Language l = getById(language.getId());
        l.setName(language.getName());
    }

    @Override
    public void delete(int id) throws Exception {
        Language l = getById(id);
        languages.remove(l);
    }
}
