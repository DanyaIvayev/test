package test.util;


import model.BranchProviderEntity;
import model.ProviderEntity;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import test.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by Дамир on 11.09.2016.
 */
@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{

//    @PersistenceContext(unitName = "persistenceUnit", type = PersistenceContextType.EXTENDED)
//    private EntityManager entityManager;
//
//    @Bean
//    public EntityManager entityManager() {
//
//        EntityManagerFactory factory = Persistence.
//                createEntityManagerFactory("persistenceUnit", System.getProperties());
//
//        entityManager = factory.createEntityManager();
//        return entityManager;
//    }

   /* @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
*/
    /*@Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/index");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }
*/


//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
//        configurer.enable();
//    }

    @Bean
    public BranchDAO branchDAO(){
        return new BranchDAOImpl();
    }

    @Bean
    public ProviderDAO providerDAO() {return new ProviderDAOImpl();}

    @Bean
    public PositionDAO positionDAO() {return new PositionDAOImpl();}

    @Bean
    public EmployerDAO employerDAO() {return new EmployerDAOImpl();}

    @Bean
    public MedicineDAO medicineDAO(){return new MedicineDAOImpl();}

    @Bean
    public SaleDAO saleDAO(){return new SaleDAOImpl();}

    @Bean
    public BranchProviderDAO branchProviderDAO() {return new BranchProviderDAOImpl();}

    @Bean TypeDAO typeDAO(){ return new TypeDAOImpl();}

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
}
