package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import java.util.List;

public interface LanguageService {
    List<Language> getAll();

    void create(Language language) throws Exception;

    Language getById(int id) throws Exception;

    void update(Language language) throws Exception;

    void delete(int id) throws Exception;
}
