package com.example.cashwise.api.responses;

import com.example.cashwise.api.domain.Expense;
import com.example.cashwise.api.domain.ExpenseId;
import com.example.cashwise.api.domain.ExpensesService;
import com.example.cashwise.api.requests.RegisterExpenseRequest;
import com.example.cashwise.api.requests.UpdateExpenseRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Optional;

import static com.example.cashwise.api.responses.ExpensesController.EXPENSES_BASE_PATH;

@Slf4j
@RestController  //domyślnie wrzuca wszystkie nagłówki i parsuje na odpoweidni content type, czyli pliki json
@RequestMapping(EXPENSES_BASE_PATH)  //możmey podać tu wszytsko co jest base path, czyli wszystko to co jest po porcie
class ExpensesController {  //controllery nie muszą być publiczne
    static final String EXPENSES_BASE_PATH = "/expenses";  //deklaracja stringa żeby nie wprowadzać co za każdym razem, musi być static
    private final ExpensesService expensesService; //do controller wstrzykujemy tylko interface'y

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }
//te metody kontrolera odpowiadaja na zapytania odpowiedniej sciezki i sa do nich przypisane konkretne metody http (get,post,put,delete)
    //sa wywyolywane w momencie odpowiendiego zapytania do serwera
    //zbieraja wszytskie dane wyslane wraz z zapytaniem i zlecaja wykoanie pracy serwisowi
    //na koniec zwracjaa odpowiedz
    //najprosciej zwrocic obiekt jako rezultat, zosatnie on przekonwertowany do formatu json i wstawiony do ciala odp 9body response), statusy i naglowki zosatan ustawione na domyslne
    //aby miec pelna kontrole nad cala odpowiedzia (body+status+headers) tworzymy specjalny obiekt response entity i ustawiomy w nim wszytskie info na temat odp i wstawiamy zwracany obiekt do srodka jako jego body


    @GetMapping("/{rawExpenseId}")
//nie podajemy wartści, skorzytsa z base path
    ResponseEntity<ExpenseResponseDto> getSingleExpense(
            @PathVariable String rawExpenseId   //RE- zawiera status jakie są odp, jakie są nagłwóki,
    ) {
        //log.debug(rawExpenseId);
        Optional<Expense> expenseById = expensesService.getExpenseById(new ExpenseId(rawExpenseId));  //optional pozwala na to żeby nie pisac ifów
        return ResponseEntity.of(expenseById.map(ExpenseResponseDto::fromDomain));           //of sprawia, że albo zwróci OK albo NotFound //map wywolana będzie tylko jak ExpanseById bedzie nullem

    }

    @PostMapping
    ResponseEntity<ExpenseResponseDto> registerNewExpense(
            @RequestBody RegisterExpenseRequest request //@RequestBody możemy podać obiekt który chcemy żeby był z zewnątrz przyjmowany
    ) {
        Expense newExpense = expensesService.registerNewExpense(request.title(), request.amount());
        ExpenseResponseDto expenseResponseDto = ExpenseResponseDto.fromDomain(newExpense);
        return ResponseEntity.created(URI.create("/expenses/" + expenseResponseDto.expnseId())).body(expenseResponseDto);

    }
/*
    @PutMapping("/{rawExpenseId}")
    ResponseEntity<ExpenseResponseDto> updateExpense(
            @PathVariable String rawExpenseId,
            @RequestBody UpdateExpenseRequest request
    ) {
        ExpenseId updateExpense = new ExpenseId(rawExpenseId);
        expensesService.updateExpense(request.title(), request.amount(),request.expenseId());
        return  ResponseEntity.of(ExpenseResponseDto.fromDomain(new ExpenseId(rawExpenseId, )));
      }

 */

    @DeleteMapping("/{rawExpenseId}")
    ResponseEntity<Void> deleteExpense(
            @PathVariable String rawExpenseId) {
        expensesService.deleteExpense(new ExpenseId(rawExpenseId));
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{rawExpenseId}")
    public ResponseEntity<ExpenseResponseDto> updateExpense(
            @PathVariable String rawExpenseId,
            @RequestBody UpdateExpenseRequest request
    ) {
        ExpenseId expenseId = new ExpenseId(rawExpenseId);
        return ResponseEntity.ok(ExpenseResponseDto.fromDomain(
                expensesService.updateExpense(request.title(), request.amount(), expenseId)));
    }



















   /* @PatchMapping("/{id}")
    ResponseEntity<ExpenseResponseDto> updateUser(@PathVariable String id, @Valid @RequestBody PatchExpenseRequest request) {
        return ResponseEntity.of(expensesService.updateExpense(id, request.amout(), request.title(), request.expenseId())
                .map(ExpenseResponseDto::fromDomain));
    }

    */


}
