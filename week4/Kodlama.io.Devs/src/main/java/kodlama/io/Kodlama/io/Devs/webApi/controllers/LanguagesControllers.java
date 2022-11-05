package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
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
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/getById")
    public Language getById(int id) throws Exception {
        return languageService.getById(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody Language language) throws Exception {
        languageService.create(language);
    }

    @PutMapping("/update")
    public void update(@RequestBody Language language) throws Exception {
        languageService.update(language);
    }

    @DeleteMapping("/deleteById")
    public void delete(int id) throws Exception {
        languageService.delete(id);
    }
}
