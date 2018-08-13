# spring-loose-coupling
In this project, we have annotated our classes and some methods/properties using some Spring annotations, which work their magic 
and implement Inversion of Control. We use the IoC conatiner ApplicationContext in this case, which uses the Dependency Injection
implementation of IoC

## What did we do?
We have to ask some questions like :
 1. What are the beans? Annotate using *@Component*/*@Component("name")*
 2. What are the dependencies of a bean? Annotate using *@Autowired*
 3. Where to look for the dependencies? Annotate using *@ComponentScan(basePackages ={com.esp.algo})*. If the dependencies are in
    the same package as the Application class, which is highly unlikely, then we don't need to add the *@ComponentScan* annotation.
 4. We annotated our main class with *@SpringBootApplication* 
 5. In case of multiple beans for the same autowired object, we use *@Primary* to make a bean the primary bean for injection.

### Types of Autowiring 
There are three ways we can autowire the SortAlgo object.

  #### 1. Property Autowiring 
  (Similar to Setter Autowriring)
  
  ``` java
  @Autowired
	private SortAlgo sortAlgo;
   ```
  *log* : Autowiring by type from bean name 'binarySearchImpl' to bean named 'bubbleSort'
 
	
  #### 2. Setter Autowiring
  ``` java
  @Autowired
   public void setSortAlgo(SortAlgo sortAlgo) {
		this.sortAlgo = sortAlgo;
  }
  ```
  *log* : Autowiring by type from bean name 'binarySearchImpl' to bean named 'bubbleSort'
  
  #### 3. Contructor Autowiring
  ``` java
  @Autowired
	public BinarySearchImpl(SortAlgo sortAlgo) {
		this.sortAlgo = sortAlgo;
	}
  ```
  *log* :  Autowiring by type from bean name 'binarySearchImpl' via constructor to bean named 'bubbleSort'

  ### Ways in which we can Autowire beans
  
  #### 1. Autowiring by Name
  
  ```java
  @Autowired
	private SortAlgo quickSortAlgo;
  ```
  The above statement contains the name of the bean that needs to be autowired but in camel-case. The actual class is                   __QuickSortAlgo.java__ . Spring figures out that __quickSortAlgo__ must be referring to a bean with the name __QuickSortAlgo.java__.
  
  #### 2. Autowiring by using *@Primary* annotation
  ```java
  @Primary
  public class BubbleSort implements SortAlgo
  ```
  *@Primary* makes the bean, the primary choice for autowiring. Now the question is, what if we used *@Primary* to annotate BubbleSort      and used *quickSortAlgo* as the name of the autowired bean? The bean annotated with *@Primary*  gets the precedence.   
  
  #### 3. Autowiring by using *@Qualifier* annotation
  ##### Method A
  We can name our Spring beans while annotating them with *@Component*. This same identifier can be used with *@Qualifier* in the bean     in which it is being autowired.
  
  ```java
  @Component("quick")
  public class QuickSortAlgo implements SortAlgo
  ```
  ```java
  @Autowired
  @Qualifier("quick")
  private SortAlgo sortAlgo;
  ```
  
  ##### Method B
  We can name our Spring beans while annotating them with *@Qualifier*. This same identifier can be used with *@Qualifier* in the bean     in which it is being autowired.
  
  ```java
  @Component
  @Qualifier("quick")
  public class QuickSortAlgo implements SortAlgo
  ```
  ```java
  @Autowired
  @Qualifier("quick")
  private SortAlgo sortAlgo;
  ```
  ### Bean Scope
  A Spring bean has the following 4 scopes:
  
  __1. Singleton (Default) :__ One instance per Srping context.  
  __2. Prototype :__ New bean whenever requested.    
  __3. Request :__ One bean per HTTP request.  
  __4. Session :__ One bean per HTTP session.  
  
  __How do we define the scope explicitly?__
  
  We can use the *@Scope* annotation and it's attributes/parameters to define the scope of a bean explicitly.
  
  ```java
  @Component
  @Scope("prototype")
  public class BinarySearchImpl implements SearchAlgorithm
  ```
  The above example of hard-coding is a bad practice and should be avoided.
  
  ```java
  @Component
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public class BinarySearchImpl implements SearchAlgorithm{
  ```
  If we request two beans from the container now, we'll get two separate instances.
  
  #### The Scope Dilemma
  
  In our project under the package *com.esp.scope*, you can find two beans called __PersonDao.java__ and __JdbcConnection.java__.
  Now, we know that the default scope of both our beans will be Singelton. *JdbcConnection* is being autowired in *PersonDao*. What 
  if we explicitly made the *JdbcConnection* bean a Prototype bean? We will still get only one instance of it, even if we made two         instances of *PersonDao*. To overcome this problem we use something called *proxyMode*.
  
  ```java
  @Component
  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
  public class JdbcConnection
  ```
