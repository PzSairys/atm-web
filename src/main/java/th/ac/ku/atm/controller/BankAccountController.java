package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

//    @GetMapping
//    public String getBankAccountPage(Model model){
//        model.addAttribute("allbankaccount", bankAccountService.getBankacc());
//        return "bankaccount";
//    }
    @GetMapping
    public String getBankAccountPage(Model model){
        model.addAttribute("allbankaccount", bankAccountService.getCustomerBankAcc());
//        System.out.println(bankAccountService.getCustomerBankAcc());
        return "bankaccount";
    }

    @GetMapping("/edit/{id}")
    public String getEditBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-edit";
    }


    @PostMapping("/edit/{id}")
    public String depositAccount(@PathVariable int id,
                                 @ModelAttribute BankAccount bankAccount,
                                 Model model,@RequestParam("deposit") int amount) {
        bankAccount.setBalance(bankAccount.getBalance()+amount);
        bankAccountService.editBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getCustomerBankAcc());
        System.out.println(amount);
        return "redirect:/bankaccount";
    }




    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        bankAccountService.deleteBankAccount(bankAccount);
        model.addAttribute("bankaccounts", bankAccountService.getCustomerBankAcc());
        return "redirect:/bankaccount";
    }


    @PostMapping
    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model model){
        bankAccountService.openAccount(bankAccount);
        model.addAttribute("allbankaccount", bankAccountService.getCustomerBankAcc());
        return "redirect:bankaccount";
    }

//    @GetMapping("/deposit/{id}")
//    public String getDepositBankAccountPage(@PathVariable int id, Model model) {
//        BankAccount account = bankAccountService.getBankAccount(id);
//        model.addAttribute("bankAccount", account);
//
//        return "bankaccount-deposit";
//    }
//    @PostMapping("/deposit/{id}")
//    public String depositAccount(@PathVariable int id,@RequestParam("deposit") int amount) {
//        BankAccount bankAccount = bankAccountService.getBankAccount(id);
////        System.out.println(bankAccount.getBalance());
//        bankAccount.setBalance(bankAccount.getBalance()+amount);
//        bankAccountService.editBankAccount(bankAccount);
//        return "redirect:/bankaccount";
//    }
//
//    @GetMapping("/withdraw/{id}")
//    public String getWithdrawBankAccountPage(@PathVariable int id, Model model) {
//        BankAccount account = bankAccountService.getBankAccount(id);
//        model.addAttribute("bankAccount", account);
//
//        return "bankaccount-withdraw";
//    }
//    @PostMapping("/withdraw/{id}")
//    public String withdrawAccount(@PathVariable int id,
//                                  @ModelAttribute BankAccount bankAccount,
//                                  Model model,@RequestParam("withdraw") int amount) {
//        bankAccount.setBalance(bankAccount.getBalance() + (-1 * amount));
//        bankAccountService.editBankAccount(bankAccount);
//        model.addAttribute("bankaccounts", bankAccountService.getCustomerBankAcc());
//        return "redirect:/bankaccount";
//    }
    @PostMapping("/d/{id}")
    public String d(@PathVariable int id, @RequestParam("inputAmount") String amount) {
        BankAccount account = bankAccountService.getBankAccount(id);
        account.setBalance(account.getBalance() + Float.parseFloat(amount));
        bankAccountService.editBankAccount(account);

        return "redirect:/bankaccount/edit/{id}";
    }

    @PostMapping("/w/{id}")
    public String w(@PathVariable int id, @RequestParam("inputAmount") String amount) {
        BankAccount account = bankAccountService.getBankAccount(id);
        account.setBalance(account.getBalance() - Float.parseFloat(amount));
        bankAccountService.editBankAccount(account);

        return "redirect:/bankaccount/edit/{id}";
    }






}
