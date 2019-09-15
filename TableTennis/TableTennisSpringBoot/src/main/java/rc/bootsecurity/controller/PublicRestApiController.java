package rc.bootsecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import rc.bootsecurity.db.AdminAuthenticationRepo;
import rc.bootsecurity.db.PlayerRepo;
import rc.bootsecurity.db.ScoreHistoryRepo;
import rc.bootsecurity.db.ScoreTableRepo;
import rc.bootsecurity.db.TeamRepo;
import rc.bootsecurity.db.TodayMatchRepo;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.AdminAuthenticationModel;
import rc.bootsecurity.model.PlayerModel;
import rc.bootsecurity.model.ScoreHistoryModel;
import rc.bootsecurity.model.ScoreTableModel;
import rc.bootsecurity.model.TeamModel;
import rc.bootsecurity.model.TodayMatchModel;
import rc.bootsecurity.model.User;

@RestController
// we dont need to specify crossorigin as we have define cors for whole spring boot application in package security SecurityConfiguration
//@CrossOrigin                //(origins = "http://localhost:3000") by specifying this the only request from port 3000 will work
public class PublicRestApiController {
   @Autowired	
   UserRepository userRepository;

//    public PublicRestApiController(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
    
     
	@Autowired
	TeamRepo repo;
	
    @Autowired
	PlayerRepo playerRepo;
	
	
	@Autowired
	TodayMatchRepo todayMatchRepo;
	
	@Autowired
	ScoreTableRepo scoreTableRepo;
	
	@Autowired
	ScoreHistoryRepo scoreHistoryRepo;
	
	@Autowired
	AdminAuthenticationRepo adminAuthenticationRepo;
	
	@RequestMapping("/")
	public String addAlien() {
//		repo.save();
		return "home.jsp"; 
	} 
	
//	   @PostMapping("/login")
//	   @CrossOrigin(origins = "*", allowedHeaders = "*")
//	   public  void login() 
//	   {
//	   }
	
   @RequestMapping("/team")
   @ResponseBody
   public List<TeamModel>  getTeam() {
	    return repo.findAll();
	   
   }
   

   @RequestMapping("/team/{id}")
   @ResponseBody
   public Optional<TeamModel>  getTeam(@PathVariable("id")int id) {
	   return repo.findById(id);  
   }	
   
   
   
   @RequestMapping("/player")
   @ResponseBody
   public List<PlayerModel>  getPlayer() {
	    return playerRepo.findAll(); 
   }
   
   
   @RequestMapping("/player/{id}")
   @ResponseBody
   public Optional<PlayerModel>  getPlayer(@PathVariable("id")int id) {
	   return playerRepo.findById(id);  
   }
   
   
   @PutMapping(path="/update",consumes= {"application/json"})
   public TodayMatchModel saveOrUpdateTodayMatch(@RequestBody TodayMatchModel obj) 
   {
	   todayMatchRepo.save(obj);
	    return obj;
   }
   
   
   
   
   
   //WILL POST TODAY MATCH DETAIL IN SQL
   @PostMapping("/postTodayMatch")
   @ResponseBody   @CrossOrigin(origins = "*", allowedHeaders = "*")
   public  TodayMatchModel addTodayMatch(@RequestBody TodayMatchModel obj) 
   {
	   todayMatchRepo.save(obj);
	    return obj;
   }
   
   
   //WILL POST win and lose DETAIL IN SQL
   @PostMapping("/postScore")
   @ResponseBody   @CrossOrigin(origins = "*", allowedHeaders = "*")
   public  ScoreHistoryModel postScore(@RequestBody ScoreHistoryModel obj) 
   {
	   scoreHistoryRepo.save(obj);
	    return obj;
   }
   
   //WILL GET ALL MATCH history FROM SQL
   @GetMapping("/history")
   @ResponseBody
   public List<ScoreHistoryModel>  getMatchHistory() 
   {
	    return scoreHistoryRepo.findAll();
   }
   
   
   
   //WILL GET ALL MATCH DETAIL FROM SQL
   @GetMapping("/getAllMatch")
   @ResponseBody
   public List<TodayMatchModel>  getTodayMatch() 
   {
	    return todayMatchRepo.findAll();
   }
   
   
   
   
   //WILL GET PARTICULAR DATE MATCH DETAIL FROM SQL
   @RequestMapping("/getMatch/{id}")
   @ResponseBody
   public List<TodayMatchModel>  getTodayMatch(@PathVariable("id")String date) 
   {
	   return todayMatchRepo.findByDate(date);  
   }
 
   //WILL GET PARTICULAR DATE MATCH Score Table DETAIL FROM SQL
   @RequestMapping("/getScore")
   @ResponseBody
   public List<ScoreTableModel>  getAllScore() 
   {
   return scoreTableRepo.findAll();  
   } 
   
   
 //WILL GET PARTICULAR DATE MATCH Score Table DETAIL FROM SQL
   @RequestMapping("/getScore/{date}")
   @ResponseBody
   public List<ScoreTableModel>  getScore(@PathVariable("date")String date) 
   {
   return scoreTableRepo.findByDate(date);  
   }  

   
   @PutMapping(path="/updateScore",consumes= {"application/json"})
   public ScoreTableModel saveOrUpdateScoreTable(@RequestBody ScoreTableModel obj) 
   {
   scoreTableRepo.save(obj);
    return obj;
   }
   
   @RequestMapping("/adminAuthentication/{adminName}/{adminPassword}")
   @ResponseBody
   public List<AdminAuthenticationModel>  getAdminAuthentication(@PathVariable("adminName")String adminName,@PathVariable("adminPassword")String adminPassword) {
	   return adminAuthenticationRepo.adminAuthentication(adminName,adminPassword);  
   }
   

    // Available to all authenticated users
    @GetMapping("test")
    public String test1(){
        return "API Test";
    }

    // Available to managers
    @GetMapping("management/reports")
    public String reports(){
        return "Some report data";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
    
//    @Configuration
//    public class MyConfiguration {
//
//        @Bean
//        public WebMvcConfigurer corsConfigurer() {
//            return new WebMvcConfigurerAdapter() {
//                @Override
//                public void addCorsMappings(CorsRegistry registry) {
//                    registry.addMapping("/**")
//                    .allowedMethods("GET", "POST","PUT","DELETE");
//                }
//            };
//        }
//    } 
    
    
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/login");
//            }
//        };
//    }
}
