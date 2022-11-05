package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();

    Language getById(int id) throws Exception;

    void create(Language language);

    void update(Language language) throws Exception;

    void delete(int id) throws Exception;
}
