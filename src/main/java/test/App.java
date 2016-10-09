package test;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Hello world!
 *
 */
@Controller
public class App //extends AbstractController
{
    @Autowired
    private BranchDAO branchDAO;

    @Autowired
    private ProviderDAO providerDAO;

    @Autowired
    private PositionDAO positionDAO;

    @Autowired
    private EmployerDAO employerDAO;

    @Autowired
    private MedicineDAO medicineDAO;

    @Autowired
    private SaleDAO saleDAO;

    @Autowired
    private BranchProviderDAO branchProviderDAO;

    @Autowired
    private TypeDAO typeDAO;

    @RequestMapping(value="/index")
    public String home( )
    {
        return "index";
    }

    @RequestMapping(value="/displayBranches", method = RequestMethod.GET)
    public ModelAndView displayBr(Model model)
    {
        List<BranchEntity> branches= branchDAO.list();
        ModelAndView mav = new ModelAndView("displayBranches", "advs", branches);
        return mav;
    }

    @RequestMapping(value="/add_branch", method = RequestMethod.POST)
    public ModelAndView addNewBr(){
        ModelAndView mav = new ModelAndView("addNewBranch");
        return mav;
    }

    @RequestMapping(value = "/add_save", method = RequestMethod.POST)
    public ModelAndView addAdv(@RequestParam(value="branchName") String branchname,
                               @RequestParam(value="phone") Integer phone,
                               HttpServletRequest request,
                               HttpServletResponse response)
    {
            BranchEntity branch = new BranchEntity(branchname, phone);
            branchDAO.add(branch);
            return new ModelAndView("displayBranches", "advs", branchDAO.list());
    }

    @RequestMapping(value ="/displayProviders", method=RequestMethod.GET)
    public ModelAndView displayPrd(Model model){
        ModelAndView mav = new ModelAndView("displayProviders", "prds", providerDAO.list());
        return mav;
    }

    @RequestMapping (value = "/add_provider", method = RequestMethod.POST)
    public ModelAndView addNewProv(){
        ModelAndView mav = new ModelAndView("addNewProvider");
        return mav;
    }

    @RequestMapping(value = "/provider_save", method = RequestMethod.POST)
    public ModelAndView savePrd(@RequestParam(value="providerName") String providerName,
                                @RequestParam(value="providerPhone") Integer providerPhone,
                                HttpServletRequest request,
                                HttpServletResponse response
                                ){
        ProviderEntity provider = new ProviderEntity(providerName, providerPhone);
        providerDAO.add(provider);
        ModelAndView mav = new ModelAndView("displayProviders", "prds", providerDAO.list());
        return mav;
    }

    @RequestMapping( value ="/displayPositions", method = RequestMethod.GET)
    public ModelAndView displayPos(Model model){
        ModelAndView mav = new ModelAndView("displayPositions", "psns", positionDAO.list());
        return mav;
    }

    @RequestMapping(value="/add_position", method = RequestMethod.POST)
    public ModelAndView addNewPos(){
        ModelAndView mav = new ModelAndView("addNewPosition");
        return mav;
    }

    @RequestMapping(value = "/position_save", method=RequestMethod.POST)
    public ModelAndView savePosition(@RequestParam(value="positionName") String positionName,
                                     @RequestParam(value = "salary") Integer salary,
                                     HttpServletRequest request,
                                     HttpServletResponse response){
        PositionEntity position = new PositionEntity(positionName, salary);
        positionDAO.add(position);
        ModelAndView mav = new ModelAndView("displayPositions", "psns", positionDAO.list());
        return mav;
    }

    @RequestMapping(value="/displayEmployers", method=RequestMethod.GET)
    public ModelAndView displayEmp(Model model){
        ModelAndView mav = new ModelAndView("displayEmployers", "emps", employerDAO.list());
        return mav;
    }

    @RequestMapping(value="/add_employer", method = RequestMethod.POST)
    public ModelAndView addNewEmp(){
        ModelAndView mav = new ModelAndView("addNewEmployer");
        mav.addObject("brns", branchDAO.list());
        mav.addObject("psns", positionDAO.list());
        return mav;
    }

    @RequestMapping(value = "/employer_save", method = RequestMethod.POST)
    public ModelAndView saveEmployer(@RequestParam(value="firstName") String firstName,
                                     @RequestParam(value="secondName") String secondName,
                                     @RequestParam (value="patronymic") String patronymic,
                                     @RequestParam (value = "inn") Integer inn,
                                     @RequestParam (value = "serialOfPassport") Integer serialOfPassport,
                                     @RequestParam (value="numberOfPassport") Integer numberOfPassport,
                                     HttpServletRequest request,
                                     HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        Integer branchID = Integer.parseInt(request.getParameter("branchAddress"));
        Integer positionID = Integer.parseInt(request.getParameter("positionName"));
        BranchEntity branchEntity = branchDAO.getBranchById(branchID.intValue());
        PositionEntity positionEntity = positionDAO.getPositionById(positionID.intValue());
        EmployerEntity employer = new EmployerEntity(firstName, secondName,patronymic,inn,
                serialOfPassport,numberOfPassport,branchEntity,positionEntity);
        employerDAO.add(employer);
        ModelAndView mav = new ModelAndView("displayEmployers", "emps", employerDAO.list());
        return mav;
    }

    @RequestMapping(value = "/displayMedicines", method = RequestMethod.GET)
    public ModelAndView displayMed(Model model){
        ModelAndView mav = new ModelAndView("displayMedicines", "mdns", medicineDAO.list());
        return mav;
    }

    @RequestMapping(value ="/add_medicine", method = RequestMethod.POST)
    public ModelAndView addNewMed(){
        ModelAndView mav = new ModelAndView("addNewMedicine", "types", typeDAO.list());
        return mav;
    }

    @RequestMapping(value = "/medicine_save", method = RequestMethod.POST)
    public ModelAndView saveMedicine(
            @RequestParam(value="medicineName") String medicinename,
            @RequestParam(value="price") Double price,
            @RequestParam(value="country") String country,
            @RequestParam(value="type") Integer type,
            HttpServletRequest request,
            HttpServletResponse response

    ){
        TypeofmedicineEntity typeE = typeDAO.getTypeById(type.intValue());
        MedicineEntity medicine = new MedicineEntity(medicinename, price, country, typeE);
        medicineDAO.add(medicine);
        ModelAndView mav = new ModelAndView("displayMedicines", "mdns", medicineDAO.list());
        return mav;
    }

    @RequestMapping(value = "/displayTypes", method = RequestMethod.GET)
    public ModelAndView displayType(Model model){
        ModelAndView mav = new ModelAndView("displayTypes", "types", typeDAO.list());
        return mav;
    }

    @RequestMapping(value ="/add_type", method = RequestMethod.POST)
    public ModelAndView addNewType(){
        ModelAndView mav = new ModelAndView("addNewType");
        return mav;
    }

    @RequestMapping(value = "/type_save", method = RequestMethod.POST)
    public ModelAndView saveMedicine(
            @RequestParam(value="typeName") String typename,
            HttpServletRequest request,
            HttpServletResponse response

    ){
        TypeofmedicineEntity type = new TypeofmedicineEntity(typename);
        typeDAO.add(type);
        ModelAndView mav = new ModelAndView("displayTypes", "types", typeDAO.list());
        return mav;
    }

    @RequestMapping(value = "/displaySales", method=RequestMethod.GET)
    public ModelAndView displaySales(Model model){
        ModelAndView mav = new ModelAndView("displaySales", "sales", saleDAO.list());
        return mav;
    }

    @RequestMapping(value = "/add_sale", method = RequestMethod.POST)
    public ModelAndView addNewSale(){
        ModelAndView mav = new ModelAndView("addNewSale");
        mav.addObject("brns", branchDAO.list());
        mav.addObject("mdns", medicineDAO.list());
        return mav;
    }

    @RequestMapping(value="/sale_save", method = RequestMethod.POST)
    public ModelAndView saveSale(@RequestParam(value = "inStock") Integer inStock,
                                 @RequestParam(value="sold") Integer sold,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        Integer branchID = Integer.parseInt(request.getParameter("branchAddress"));
        Integer medicineID = Integer.parseInt(request.getParameter("medicineName"));
        BranchEntity branchEntity = branchDAO.getBranchById(branchID.intValue());
        MedicineEntity medicineEntity = medicineDAO.getMedicineById(medicineID.intValue());
        SalesEntity salesEntity = new SalesEntity(inStock, sold, branchEntity, medicineEntity);
        salesEntity.setIdBranch(branchEntity.getIdBranch());
        salesEntity.setIdMedicine(medicineEntity.getIdMedicine());
        saleDAO.add(salesEntity);
        ModelAndView mav = new ModelAndView("displaySales", "sales", saleDAO.list());
        return mav;
    }

    @RequestMapping(value="/displayBranchProviders", method = RequestMethod.GET)
    public ModelAndView displayBrnchProvider(Model model){
        ModelAndView mav = new ModelAndView("displayBranchProviders", "bpds", branchProviderDAO.list());
        return mav;
    }

    @RequestMapping(value = "/add_branchProvider", method = RequestMethod.POST)
    public ModelAndView addNewBranchProvider(){
        ModelAndView mav = new ModelAndView("addNewBranchProvider");
        mav.addObject("brns", branchDAO.list());
        mav.addObject("prds", providerDAO.list());
        return mav;
    }

    @RequestMapping(value="/branchProvider_save", method = RequestMethod.POST)
    public ModelAndView saveSale(@RequestParam(value = "dayOfBilievery") String dayOfBilievery,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        Integer branchID = Integer.parseInt(request.getParameter("branchAddress"));
        Integer providerID = Integer.parseInt(request.getParameter("providerName"));
        BranchEntity branchEntity = branchDAO.getBranchById(branchID.intValue());
        ProviderEntity providerEntity = providerDAO.getProviderById(providerID.intValue());
        BranchProviderEntity branchProviderEntity = new BranchProviderEntity(dayOfBilievery,branchEntity, providerEntity);
        branchProviderEntity.setIdBranch(branchEntity.getIdBranch());
        branchProviderEntity.setIdProvider(providerEntity.getIdProvider());
        branchProviderDAO.add(branchProviderEntity);
        ModelAndView mav = new ModelAndView("displayBranchProviders", "bpds", branchProviderDAO.list());
        return mav;
    }

    @RequestMapping(value="/edit_branch", method = RequestMethod.POST)
    public ModelAndView editBranch(@RequestParam(value = "editId") Integer id){
        BranchEntity branch = branchDAO.getBranchById(id);
        ModelAndView mav = new ModelAndView("editBranch", "brn", branch);
        return mav;
    }

    @RequestMapping(value="/save_branch", method = RequestMethod.POST)
    public ModelAndView saveBranch(@RequestParam(value="editId") Integer id,
                                   @RequestParam(value="branchName") String address,
                                   @RequestParam(value="phone") Integer phone){
        BranchEntity branch = new BranchEntity( phone, address,id);
        branchDAO.save(branch);
        return new ModelAndView("displayBranches", "advs", branchDAO.list());
    }

    @RequestMapping(value="/edit_type", method=RequestMethod.POST)
    public ModelAndView editType(@RequestParam(value = "editId") Integer id){
        TypeofmedicineEntity type = typeDAO.getTypeById(id);
        ModelAndView mav = new ModelAndView("editType", "type", type);
        return mav;
    }

    @RequestMapping(value="/save_edit_type", method = RequestMethod.POST)
    public ModelAndView saveType(@RequestParam(value="editTypeId") Integer id,
                                 @RequestParam(value="typeName") String typeName){
        TypeofmedicineEntity type = new TypeofmedicineEntity(id, typeName);
        typeDAO.save(type);
        return new ModelAndView("displayTypes", "types", typeDAO.list());
    }

    @RequestMapping(value="/edit_position", method = RequestMethod.POST)
    public ModelAndView editPosition(@RequestParam(value="editId") Integer id){
        PositionEntity position = positionDAO.getPositionById(id);
        ModelAndView mav= new ModelAndView("editPosition", "psn", position);
        return mav;
    }

    @RequestMapping(value="/position_edit_save", method = RequestMethod.POST)
    public ModelAndView savePosition(@RequestParam(value = "editPositionId") Integer id,
                                     @RequestParam(value="positionName") String positionName,
                                     @RequestParam(value="salary") Integer salary){
        PositionEntity position = new PositionEntity(id, positionName, salary);
        positionDAO.save(position);
        return new ModelAndView("displayPositions", "psns", positionDAO.list());
    }

    @RequestMapping(value="/edit_provider", method=RequestMethod.POST)
    public ModelAndView editProvider(@RequestParam(value="editId") Integer id){
        ProviderEntity provider = providerDAO.getProviderById(id);
        ModelAndView mav= new ModelAndView("editProvider", "prd", provider);
        return mav;
    }

    @RequestMapping(value = "/provider_edit_save", method = RequestMethod.POST)
    public ModelAndView saveProvider(@RequestParam(value="editProviderId") Integer id,
                                     @RequestParam(value="providerName") String providerName,
                                     @RequestParam(value="providerPhone") Integer phone){
        ProviderEntity provider = new ProviderEntity(id,providerName, phone);
        providerDAO.save(provider);
        return new ModelAndView("displayProviders", "prds", providerDAO.list());
    }

}
