package test;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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

    @RequestMapping(value = "/index")
    public String home( )
    {
        return "index";
    }

    @RequestMapping(value = "/displayBranches", method = RequestMethod.GET)
    public ModelAndView displayBr()
    {
        List<BranchEntity> branches= branchDAO.list();
        ModelAndView mav = new ModelAndView("displayBranches", "advs", branches);
        return mav;
    }

    @RequestMapping(value = "/add_branch", method = RequestMethod.POST)
    public ModelAndView addNewBr(){
        ModelAndView mav = new ModelAndView("addNewBranch");
        return mav;
    }

    @RequestMapping(value = "/add_save", method = RequestMethod.POST)
    public String addAdv(@RequestParam(value="branchName") String branchname,
                               @RequestParam(value="phone") Long phone,
                               HttpServletRequest request,
                               HttpServletResponse response)
    {
            BranchEntity branch = new BranchEntity(branchname, phone);
            branchDAO.add(branch);
            return "redirect:/displayBranches";
    }

    @RequestMapping(value = "/displayProviders", method=RequestMethod.GET)
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
    public String savePrd(@RequestParam(value="providerName") String providerName,
                                @RequestParam(value="providerPhone") Long providerPhone,
                                HttpServletRequest request,
                                HttpServletResponse response
                                ){
        ProviderEntity provider = new ProviderEntity(providerName, providerPhone);
        providerDAO.add(provider);
        return "redirect:/displayProviders";
    }

    @RequestMapping( value = "/displayPositions", method = RequestMethod.GET)
    public ModelAndView displayPos(Model model){
        ModelAndView mav = new ModelAndView("displayPositions", "psns", positionDAO.list());
        return mav;
    }

    @RequestMapping(value = "/add_position", method = RequestMethod.POST)
    public ModelAndView addNewPos(){
        ModelAndView mav = new ModelAndView("addNewPosition");
        return mav;
    }

    @RequestMapping(value = "/position_save", method=RequestMethod.POST)
    public String savePosition(@RequestParam(value="positionName") String positionName,
                                     @RequestParam(value = "salary") Double salary,
                                     HttpServletRequest request,
                                     HttpServletResponse response){
        PositionEntity position = new PositionEntity(positionName, salary);
        positionDAO.add(position);
        return "redirect:/displayPositions";
    }

    @RequestMapping(value = "/displayEmployers", method=RequestMethod.GET)
    public ModelAndView displayEmp(Model model){
        ModelAndView mav = new ModelAndView("displayEmployers", "emps", employerDAO.list());
        return mav;
    }

    @RequestMapping(value = "/add_employer", method = RequestMethod.POST)
    public ModelAndView addNewEmp(){
        ModelAndView mav = new ModelAndView("addNewEmployer");
        mav.addObject("brns", branchDAO.list());
        mav.addObject("psns", positionDAO.list());
        return mav;
    }

    @RequestMapping(value = "/employer_save", method = RequestMethod.POST)
    public String saveEmployer(@RequestParam(value="firstName") String firstName,
                                     @RequestParam(value="secondName") String secondName,
                                     @RequestParam (value="patronymic") String patronymic,
                                     @RequestParam (value = "inn") Long inn,
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
        return "redirect:/displayEmployers";
    }

    @RequestMapping(value = "/displayMedicines", method = RequestMethod.GET)
    public ModelAndView displayMed(Model model){
        ModelAndView mav = new ModelAndView("displayMedicines", "mdns", medicineDAO.list());
        return mav;
    }

    @RequestMapping(value = "/add_medicine", method = RequestMethod.POST)
    public ModelAndView addNewMed(){
        ModelAndView mav = new ModelAndView("addNewMedicine", "types", typeDAO.list());
        return mav;
    }

    @RequestMapping(value = "/medicine_save", method = RequestMethod.POST)
    public String saveMedicine(
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
        return "redirect:/displayMedicines";
    }

    @RequestMapping(value = "/displayTypes", method = RequestMethod.GET)
    public ModelAndView displayType(Model model){
        ModelAndView mav = new ModelAndView("displayTypes", "types", typeDAO.list());
        return mav;
    }

    @RequestMapping(value = "/add_type", method = RequestMethod.POST)
    public ModelAndView addNewType(){
        ModelAndView mav = new ModelAndView("addNewType");
        return mav;
    }

    @RequestMapping(value = "/type_save", method = RequestMethod.POST)
    public String saveMedicine(
            @RequestParam(value="typeName") String typename,
            HttpServletRequest request,
            HttpServletResponse response

    ){
        TypeofmedicineEntity type = new TypeofmedicineEntity(typename);
        typeDAO.add(type);
        return "redirect:/displayTypes";
    }

    @RequestMapping(value = "/displaySales", method=RequestMethod.GET)
    public ModelAndView displaySales(){
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

    @RequestMapping(value = "/sale_save", method = RequestMethod.POST)
    public @ResponseBody JsonResponse saveSale(@RequestParam(value = "inStock") Integer inStock,
                                 @RequestParam(value="sold") Integer sold,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Integer branchID = Integer.parseInt(request.getParameter("branchAddress"));
        Integer medicineID = Integer.parseInt(request.getParameter("medicineName"));
        BranchEntity branchEntity = branchDAO.getBranchById(branchID.intValue());
        MedicineEntity medicineEntity = medicineDAO.getMedicineById(medicineID.intValue());
        SalesEntity check = saleDAO.getSaleByIds(branchID, medicineID);
        if(check==null){
            SalesEntity salesEntity = new SalesEntity(inStock, sold, branchEntity, medicineEntity);
            salesEntity.setIdBranch(branchEntity.getIdBranch());
            salesEntity.setIdMedicine(medicineEntity.getIdMedicine());
            saleDAO.add(salesEntity);
            return new JsonResponse("SUCCESS","displaySales");
        } else {
            return new JsonResponse("FAIL","Запись для этого филиала и выбранного лекарства уже существует. Проверьте введенные данные.");
        }
    }
    @RequestMapping(value = "/displayBranchProviders", method = RequestMethod.GET)
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

    @RequestMapping(value = "/branchProvider_save", method = RequestMethod.POST)
    public @ResponseBody JsonResponse saveBrProvider(@RequestParam(value = "dayOfBilievery") String dayOfBilievery,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Integer branchID = Integer.parseInt(request.getParameter("branchAddress"));
        Integer providerID = Integer.parseInt(request.getParameter("providerName"));
        BranchEntity branchEntity = branchDAO.getBranchById(branchID.intValue());
        ProviderEntity providerEntity = providerDAO.getProviderById(providerID.intValue());
        BranchProviderEntity check = branchProviderDAO.getBrProviderByIds(branchID, providerID);
        if(check==null) {
            BranchProviderEntity branchProviderEntity = new BranchProviderEntity(dayOfBilievery, branchEntity, providerEntity);
            branchProviderEntity.setIdBranch(branchEntity.getIdBranch());
            branchProviderEntity.setIdProvider(providerEntity.getIdProvider());
            branchProviderDAO.add(branchProviderEntity);
            return new JsonResponse("SUCCESS","displayBranchProviders");

        } else {
            return new JsonResponse("FAIL","Запись для этого филиала и выбранного поставщика уже существует. Проверьте введенные данные.");
        }
    }

    @RequestMapping(value = "/edit_branch", method = RequestMethod.POST)
    public ModelAndView editBranch(@RequestParam(value = "editId") Integer id){
        BranchEntity branch = branchDAO.getBranchById(id);
        ModelAndView mav = new ModelAndView("editBranch", "brn", branch);
        return mav;
    }

    @RequestMapping(value = "/save_branch", method = RequestMethod.POST)
    public String saveBranch(@RequestParam(value="editId") Integer id,
                                   @RequestParam(value="branchName") String address,
                                   @RequestParam(value="phone") Long phone){
        BranchEntity branch = new BranchEntity( phone, address,id);
        branchDAO.save(branch);
        return "redirect:/displayBranches";
    }

    @RequestMapping(value = "/edit_type", method=RequestMethod.POST)
    public ModelAndView editType(@RequestParam(value = "editId") Integer id){
        TypeofmedicineEntity type = typeDAO.getTypeById(id);
        ModelAndView mav = new ModelAndView("editType", "type", type);
        return mav;
    }

    @RequestMapping(value = "/save_edit_type", method = RequestMethod.POST)
    public String saveType(@RequestParam(value="editTypeId") Integer id,
                                 @RequestParam(value="typeName") String typeName){
        TypeofmedicineEntity type = new TypeofmedicineEntity(id, typeName);
        typeDAO.save(type);
        return "redirect:/displayTypes";
    }

    @RequestMapping(value = "/edit_position", method = RequestMethod.POST)
    public ModelAndView editPosition(@RequestParam(value="editId") Integer id){
        PositionEntity position = positionDAO.getPositionById(id);
        ModelAndView mav= new ModelAndView("editPosition", "psn", position);
        return mav;
    }

    @RequestMapping(value = "/position_edit_save", method = RequestMethod.POST)
    public String savePosition(@RequestParam(value = "editPositionId") Integer id,
                                     @RequestParam(value="positionName") String positionName,
                                     @RequestParam(value="salary") Double salary){
        PositionEntity position = new PositionEntity(id, positionName, salary);
        positionDAO.save(position);
        return "redirect:/displayPositions";
    }

    @RequestMapping(value = "/edit_provider", method=RequestMethod.POST)
    public ModelAndView editProvider(@RequestParam(value="editId") Integer id){
        ProviderEntity provider = providerDAO.getProviderById(id);
        ModelAndView mav= new ModelAndView("editProvider", "prd", provider);
        return mav;
    }

    @RequestMapping(value = "/provider_edit_save", method = RequestMethod.POST)
    public String saveProvider(@RequestParam(value="editProviderId") Integer id,
                                     @RequestParam(value="providerName") String providerName,
                                     @RequestParam(value="providerPhone") Long phone){
        ProviderEntity provider = new ProviderEntity(id,providerName, phone);
        providerDAO.save(provider);
        return "redirect:/displayProviders";
    }

    @RequestMapping(value = "/edit_medicine", method=RequestMethod.POST)
    public ModelAndView editMedicine(@RequestParam(value="editId") Integer id){
        MedicineEntity medicine = medicineDAO.getMedicineById(id);
        ModelAndView mav= new ModelAndView("editMedicine", "mdn", medicine);
        mav.addObject("types", typeDAO.list());
        return mav;
    }

    @RequestMapping(value = "/medicine_edit_save", method=RequestMethod.POST)
    public String saveMedicine(@RequestParam(value="editMedicineId") Integer id,
                                     @RequestParam(value="medicineName") String medicinename,
                                     @RequestParam(value="price") Double price,
                                     @RequestParam(value="country") String country,
                                     @RequestParam(value="type") Integer type){
        TypeofmedicineEntity typeE = typeDAO.getTypeById(type.intValue());
        MedicineEntity medicine = new MedicineEntity(id, medicinename, price, country, typeE);
        medicineDAO.save(medicine);
        return "redirect:/displayMedicines";

    }

    @RequestMapping(value = "/edit_employer", method=RequestMethod.POST)
    public ModelAndView editEmployer(@RequestParam(value="editId") Integer id){
        EmployerEntity employer = employerDAO.getEmployerById(id);
        ModelAndView mav= new ModelAndView("editEmployer", "emp", employer);
        mav.addObject("brns", branchDAO.list());
        mav.addObject("psns", positionDAO.list());
        return mav;
    }

    @RequestMapping(value = "/employer_edit_save", method=RequestMethod.POST)
    public String saveMedicine(@RequestParam(value="editEmployerId") Integer id,
                                     @RequestParam(value="firstName") String firstName,
                                     @RequestParam(value="secondName") String secondName,
                                     @RequestParam (value="patronymic") String patronymic,
                                     @RequestParam (value = "inn") Long inn,
                                     @RequestParam (value = "serialOfPassport") Integer serialOfPassport,
                                     @RequestParam (value="numberOfPassport") Integer numberOfPassport,
                                     @RequestParam (value="branchAddress") Integer branchId,
                                     @RequestParam (value="positionName") Integer positionId){
        PositionEntity position = positionDAO.getPositionById(positionId);
        BranchEntity branch = branchDAO.getBranchById(branchId);
        EmployerEntity employer = new EmployerEntity(id, firstName, secondName, patronymic, inn, serialOfPassport,numberOfPassport, branch, position);
        employerDAO.save(employer);
        return "redirect:/displayEmployers";

    }

    @RequestMapping(value = "/edit_sale", method = RequestMethod.POST)
    public ModelAndView editSale(@RequestParam(value="editId") String ids){
        SalesEntity sale = saleDAO.getSaleByIds(Integer.parseInt(ids.substring(0, ids.indexOf(";"))),
                Integer.parseInt(ids.substring(ids.indexOf(";") + 1, ids.length())));
        ModelAndView mav = new ModelAndView("editSale", "sls", sale);
        mav.addObject("brn", sale.getBranch());
        mav.addObject("mdn", sale.getMedicine());
        return mav;
    }

    @RequestMapping(value = "/sale_edit_save", method=RequestMethod.POST)
    public String saveSale(@RequestParam(value="editBranchId") Integer idBranch,
                                 @RequestParam(value="editMedicineId") Integer idMedicine,
                                 @RequestParam(value = "inStock") Integer inStock,
                                 @RequestParam(value="sold") Integer sold){
        SalesEntity sale = new SalesEntity(idBranch, idMedicine, inStock, sold);
        saleDAO.save(sale);
        return "redirect:/displaySales";
    }

    @RequestMapping(value = "/edit_branch_provider", method = RequestMethod.POST)
    public ModelAndView editBranchProvider(@RequestParam(value="editId") String ids) {
        BranchProviderEntity branchProvider = branchProviderDAO.getBrProviderByIds(Integer.parseInt(ids.substring(0, ids.indexOf(";"))),
                Integer.parseInt(ids.substring(ids.indexOf(";") + 1, ids.length())));
        ModelAndView mav = new ModelAndView("editBranchProvider", "bpr", branchProvider);
        List<String> days = new ArrayList<String>();
        days.add("Понедельник");
        days.add("Вторник");
        days.add("Среда");
        days.add("Четверг");
        days.add("Пятница");
        days.add("Суббота");
        days.add("Воскресение");
        mav.addObject("bpss", days);
        mav.addObject("brn", branchProvider.getBranch());
        mav.addObject("prd", branchProvider.getProvider());
        return mav;
    }

    @RequestMapping(value = "/branchProvider_edit_save", method=RequestMethod.POST)
    public String saveBranchProvider(@RequestParam(value="editBranchId") Integer idBranch,
                           @RequestParam(value="editProviderId") Integer idProvider,
                           @RequestParam(value = "dayOfBilievery") String dayOfBilievery){
        BranchProviderEntity branchProvider = new BranchProviderEntity(idBranch, idProvider, dayOfBilievery);
        branchProviderDAO.save(branchProvider);
        return "redirect:/displayBranchProviders";
    }

    @RequestMapping(value = "/delete_branch", method = RequestMethod.POST)
    public ModelAndView deleteBranch(@RequestParam(value="editIds[]") Integer[] ids){
        for(int id : ids) {
            branchDAO.delete(id);
        }
        return new ModelAndView(new RedirectView("displayBranches"), "advs", branchDAO.list());
    }

    @RequestMapping(value = "/delete_type", method = RequestMethod.POST)
    public ModelAndView deleteType(@RequestParam(value="editIds[]") Integer[] ids){
        for(int id : ids) {
            typeDAO.delete(id);
        }
        return new ModelAndView(new RedirectView("displayTypes"), "types", typeDAO.list());
    }

    @RequestMapping(value = "/delete_position", method = RequestMethod.POST)
    public ModelAndView deletePosition(@RequestParam(value="editIds[]") Integer[] ids){
        for(int id : ids) {
            positionDAO.delete(id);
        }
        return new ModelAndView(new RedirectView("displayPositions"), "psns", positionDAO.list());
    }
    @RequestMapping(value = "/delete_provider", method = RequestMethod.POST)
    public ModelAndView deleteProvider(@RequestParam(value="editIds[]") Integer[] ids){
        for(int id : ids) {
            providerDAO.delete(id);
        }
        return new ModelAndView(new RedirectView("displayPositions"), "prds", providerDAO.list());
    }
    @RequestMapping(value = "/delete_medicine", method = RequestMethod.POST)
    public ModelAndView deleteMediciner(@RequestParam(value="editIds[]") Integer[] ids){
        for(int id : ids) {
            medicineDAO.delete(id);
        }
        return new ModelAndView(new RedirectView("displayPositions"), "mdns", medicineDAO.list());
    }
    @RequestMapping(value = "/delete_employer", method = RequestMethod.POST)
    public ModelAndView deleteEmployer(@RequestParam(value="editIds[]") Integer[] ids){
        for(int id : ids) {
            employerDAO.delete(id);
        }
        return new ModelAndView(new RedirectView("displayPositions"), "emps", employerDAO.list());
    }
    @RequestMapping(value = "/delete_sale", method = RequestMethod.POST)
    public ModelAndView deleteEmployer(@RequestParam(value="editIds[]") String[] ids){
        for(String id : ids) {
            saleDAO.delete(Integer.parseInt(id.substring(0, id.indexOf(";"))),
                    Integer.parseInt(id.substring(id.indexOf(";") + 1, id.length())));
        }
        return new ModelAndView(new RedirectView("displayPositions"), "emps", saleDAO.list());
    }
    @RequestMapping(value = "/delete_branch_provider", method = RequestMethod.POST)
    public ModelAndView deleteBranchProvider(@RequestParam(value="editIds[]") String[] ids){
        for(String id : ids) {
            branchProviderDAO.delete(Integer.parseInt(id.substring(0, id.indexOf(";"))),
                    Integer.parseInt(id.substring(id.indexOf(";") + 1, id.length())));
        }
        return new ModelAndView(new RedirectView("displayPositions"), "emps", branchProviderDAO.list());
    }
}
