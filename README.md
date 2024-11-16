# Português

Nesse repositório, eu realizo testes utilizando `JUnit5`, por mais que realizar testes tenha sido o foco principal, obviamente é necessário algo pra testar.

Então eu fiz 2 records, `Category` e `Customer`:

`Customer`: Seria um **cliente** desse sistema, possuindo os seguintes atributos e métodos não padrões:
```.java
int id;
String name;
String phoneNumber;
String email;
Category category;

public Customer(int id, String name, String phoneNumber, String email, Category category) //pode lançar IllegalArgumentException("id deve ser maior que 0")

//retorna o atributo discount de Category
public int getThisCustomerDiscount()

//retorna o valor inserido com desconto em porcentagem (referente a discount de Category)
public double applyDiscountPrice(double price) //pode lançar ArithmeticException("preço deve ser maior que 0") (divisão por 0)
```


`Category`: Seria equivalente a **categoria** de um cliente, possui os seguintes atributos e métodos:
```.java
int id;
String categoryName;
int discount;

public Category(int id, String categoryName, int discount) //pode lançar IllegalArgumentException("discount deve ser maior que -1 e menor que 101")
```

Além das classes dentro do `/model` temos a classe dentro de `/repository`, `ObjectInstances`. Essa classe é responsável apenas por providenciar objetos dos tipos `Customer` e `Category` para as classes de teste, e já que ela possui seus próprios métodos, eles precisaram também de testes, mas antes, abaixo está a classe com seus atributos e métodos:

```.java
private static int CUSTOMERS_ID; //usado para colocar o id nos clientes mais facilmente
private static int CATEGORIES_ID; //usado para colocar o id nas categorias mais facilmente

private final static List<Category> CATEGORIES; //lista de categorias
private final static List<Customer> CUSTOMERS; //lista de clientes
private final static Random GENERATOR = new Random(); //gerador de números aleatórios para pegar uma categoria ou um cliente aleatório

static {} //setup das listas

public static Customer fetchRandomCustomer() //pega um cliente aleatório na lista
public static Category fetchRandomCategory() //pega uma categoria aleatória na lista
public static int getRandomNumber(List<?> l) //é usado nos métodos anteriores para gerar o número aleatório
```

Já as classes de teste, o foco desse repositório possuem:

```.java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerTest {

   Customer customer;
   static Category CATEGORY;

   @BeforeAll
   static void getRandomCategory() //cria uma categoria antes de todos os testes através do fetchRandomCategory() de ObjectInstances e insere na variável de classe estática CATEGORY

   @AfterEach
   void closeCustomerInstance() //define this.customer como nulo

   @Test
   void instaceSuccessTest() //testa a instância de um Customer com os dados passados corretamente tentando não mandar nenhuma exception

   @Test
   void instanceFailTest() //testa a instância de um Customer tentando lançar a IllegalArgumentException dentro do contrutor

   @Test
   void applyDiscountPriceSuccessTest() //testa o método que aplica desconto em customer

   @Test
   void applyDiscountPriceFailTest() //testa o método que aplica desconto em customer, com o objetivo que lançar a ArithmeticException

   static Customer instanceOfCustomer() //instancia um customer para os métodos que não testam a instãncia de um
}
```

```.java
public class CategoryTest {

    Category category;
    static int id = 0; //usado para colocar o id nas categorias (não é necessariamente mais eficiente)

    @Test
    void instaceSuccessTest() //testa a instância de uma Category com os dados passados corretamente tentando não mandar nenhuma exception

    @Test
    void instanceFailTest() //testa a instância de um Category tentando lançar a IllegalArgumentException dentro do contrutor

}
```

```.java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObjectInstancesTest {

    Customer randomCus; //gera um customer aleatório
    Category randomCat; //gera uma category aleatoria

    @BeforeAll
    void beforeTests() //cria os randomCus e randomCat

    @AfterAll
    void afterTests() //torna os randomCus e randomCat nulo

    @Test
    public void fetchRandomCustomerTest() //verifica se o valor do customer não é nulo

    @Test
    public void checkCustomerInfo() //verifica se as informações de customer não são nulas e printa elas

    @Test
    public void fetchRandomCategoryTest() //verifica se o valor de category não é nulo

    @Test
    public void checkCategoryInfo() //verifica se as informações de category não são nulas e printa elas

}
```

Algumas coisas que foram feitas dentro dos testes tiveram apenas a intenção de praticar, ou achar uma outra forma de realizar a mesma operação e no fim de tudo aprender.

# English

In this repository, I create test cases using `Junit5`, although tests were the main focus, I obviously need something to test.

So I created 2 records named `Category` and `Customer`:

`Customer`: Would represent a generic **customer**, having the following fields and non-default methods:
```.java
int id;
String name;
String phoneNumber;
String email;
Category category;

public Customer(int id, String name, String phoneNumber, String email, Category category) //may throw IllegalArgumentException("id must be greater than 0")

//returns field discount from category
public int getThisCustomerDiscount()

//returns the entered value with a percentage discount (related to the category discount)
public double applyDiscountPrice(double price) //may throw ArithmeticException("price must be greater than 0") (division by 0)
```


`Category`: Would represent the customer's **category**, it has the following fields and methods:
```.java
int id;
String categoryName;
int discount;

public Category(int id, String categoryName, int discount) //may throw IllegalArgumentException("discount must be greater than -1 and lesser than 101")
```

Besides the classes inside `/model` there is a class inside `/repository`, called `ObjectInstances`. It is reponsible for providing the objects `Customer` and `Category` for the test classes, and since it also has its own methods, they must be tested as well. Thus, below is the ObjectInstances class with its fields and methods:

```.java
private static int CUSTOMERS_ID; //used for inserting the customers id more easily
private static int CATEGORIES_ID; //used for inserting the categories id more easily

private final static List<Category> CATEGORIES;
private final static List<Customer> CUSTOMERS;
private final static Random GENERATOR = new Random(); //RNG to get a category or customer randomly

static {} //Lists setup

public static Customer fetchRandomCustomer() //returns a random customer from the list
public static Category fetchRandomCategory() //returns a random category from the list
public static int getRandomNumber(List<?> l) //used for the previous methods to generate a random number
```

And the test classes, this repo's focus, are as shown below:

```.java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerTest {

   Customer customer;
   static Category CATEGORY;

   @BeforeAll
   static void getRandomCategory() //gets a category from fetchRandomCategory() of ObjectInstances and inserts it in the static field CATEGORY

   @AfterEach
   void closeCustomerInstance() //makes this.customer null

   @Test
   void instaceSuccessTest() //tests a Customer's instance passing the right values, not trying to trigger any exception

   @Test
   void instanceFailTest() //tests a Customer's instance, trying to trigger an exception

   @Test
   void applyDiscountPriceSuccessTest() //tests the method which applies the discount

   @Test
   void applyDiscountPriceFailTest() //tests the method which applies the discount, trying to trigger ArithmeticException

   static Customer instanceOfCustomer() //creates a customer for the methods which don't test instance
}
```

```.java
public class CategoryTest {

    Category category;
    static int id = 0; //used for inserting the id in the categories

    @Test
    void instaceSuccessTest() //tests a Category's instance passing the right values, not trying to trigger any exception

    @Test
    void instanceFailTest() //tests a Customer's instance, trying to trigger an exception
}
```

```.java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObjectInstancesTest {

    Customer randomCus; //generates a random customer
    Category randomCat; //generates a random category

    @BeforeAll
    void beforeTests() //creates the randomCus and randomCat

    @AfterAll
    void afterTests() //makes randomCus and randomCat null

    @Test
    public void fetchRandomCustomerTest() //check if the customer's values are not null

    @Test
    public void checkCustomerInfo() //check if the customer's info are not null, then print them

    @Test
    public void fetchRandomCategoryTest() //check if the category's values are not null

    @Test
    public void checkCategoryInfo() //check if the category's info are not null, then print them

}
```

Some thing that were made inside the tests seems unreasonable, but their objectives were to practice and understand better, or even try to find another way to make the same thing, but at the end, the objective was to learn.
