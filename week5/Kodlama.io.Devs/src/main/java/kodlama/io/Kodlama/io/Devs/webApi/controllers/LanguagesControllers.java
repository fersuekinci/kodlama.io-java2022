package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetByIdLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesControllers {
    private LanguageService languageService;

    @Autowired
    public LanguagesControllers(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAll")
    public List<GetAllLanguagesResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdLanguageResponse getById(GetByIdLanguageRequest getByIdLanguageRequest) throws Exception {
        return languageService.getById(getByIdLanguageRequest);
    }

    @PostMapping("/add")
    public void create(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        languageService.create(createLanguageRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
        languageService.update(updateLanguageRequest);
    }

    @DeleteMapping("/deleteById")
    public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        languageService.delete(deleteLanguageRequest);
    }
}