package kodlamaio.business;

import kodlamaio.core.logging.Logger;
import kodlamaio.dataAccess.ICategoryDao;
import kodlamaio.entities.Category;

import java.util.List;

public class CategoryManager {
    private ICategoryDao categoryDao;
    private Logger[] loggers;
    private List<Category> categories;

    public CategoryManager(ICategoryDao categoryDao, Logger[] loggers, List<Category> categories) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
        this.categories = categories;
    }

    public void add(Category category) throws Exception {
        for(Category each : categories) {
            if(category.getName().equals(each.getName())) {
                throw new Exception("category name cannot be repeated");
            }
        }

        categoryDao.add(category);
        categories.add(category);

        for (Logger logger : loggers) {
            logger.log(category.getName());
        }
    }
}
