package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetByIdLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguagesResponse> getAll();

    void create(CreateLanguageRequest createLanguageRequest) throws Exception;

    GetByIdLanguageResponse getById(GetByIdLanguageRequest getByIdLanguageRequest) throws Exception;

    void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;

    void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;
}
