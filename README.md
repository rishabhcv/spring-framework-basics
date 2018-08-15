# Spring Boot Introduction
To understand what we're getting into, please read this article by Ranga Karanam:
[Spring Boot vs. Spring MVC vs. Spring: How Do They Compare?](https://dzone.com/articles/spring-boot-vs-spring-mvc-vs-spring-how-do-they-compare)        

In this project, we have annotated our classes and some methods/properties using some Spring annotations, which work their magic 
and implement Inversion of Control. We use the IoC container ApplicationContext in this case, which uses the Dependency Injection
implementation of IoC.

## What did we do?
We have to ask some questions like :
 1. What are the beans in our project? Annotate using *@Component*/*@Component("name")*
 2. What are the dependencies of a bean? Annotate using *@Autowired*
 3. Where to look for the dependencies? Annotate using *@ComponentScan(basePackages ={com.esp.algo})*. If the dependencies are in
    the same package as the Application class, which is highly unlikely, then we don't need to add the *@ComponentScan* annotation.
 4. How to make the class with the main method, a Spring Boot Application? We annotated our main class with *@SpringBootApplication*   
 5. In case of multiple beans for the same autowired object, how do we tell Spring which bean to use? We use *@Primary* to make a bean       the primary bean for injection. We can also use *@Qualifier* to do the same. 

### Types of Autowiring 
In the BinarySearchImpl example, there are three ways we can autowire the SortAlgo object.

  #### 1. Property/Type Autowiring 
  (Similar to Setter Autowiring)
  
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
  
  #### 3. Constructor Autowiring
  ``` java
  @Autowired
	public BinarySearchImpl(SortAlgo sortAlgo) {
		this.sortAlgo = sortAlgo;
	}
  ```
  *log* :  Autowiring by type from bean name 'binarySearchImpl' via constructor to bean named 'bubbleSort'

  ### Ways in which we can Autowire Beans
  
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
  
  __1. Singleton (Default) :__ One instance per Spring context. This is different than the Singleton design pattern, where only a single        instance is created per JVM.  
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
  *The above example of hard-coding is a bad practice and should be avoided.*       
  
  ```java
  @Component
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public class BinarySearchImpl implements SearchAlgorithm{
  ```
  If we request two beans from the container now, we'll get two separate instances.
  
  #### The Scope Dilemma
  
  In our project under the package *com.esp.scope*, you can find two beans called __PersonDao.java__ and __JdbcConnection.java__.
  Now, we know that the default scope of both our beans will be Singleton. *JdbcConnection* is being autowired in *PersonDao*. What 
  if we explicitly made the *JdbcConnection* bean a Prototype bean? We will still get only one instance of it, even if we made two         instances of *PersonDao*. To overcome this problem we use something called *proxyMode*.
  
  ```java
  @Component
  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
  public class JdbcConnection
  ```
  #### *@PostConstruct* and *@PreDestroy* Annotations With CDI Managed Bean Classes
  
  __1. To Initialize a Managed Bean Using the *@PostConstruct* Annotation__      
       _javax.annotation.PostConstruct_       
       In the managed bean class or any of its superclasses, define a method that performs the initialization that you require. When the        managed bean is injected into a component, CDI calls the method after all injection has occurred and after all                          initializers have been called.
       
       ```java
       	@PostConstruct
	public void init() {
	  log.info("init method called");
	}       
       ```
  
  __2. To Prepare for the Destruction of a Managed Bean Using the *@PreDestroy* Annotation__        
       _javax.annotation.PreDestroy_         
       Preparing for the destruction of a managed bean specifies the lifecycle call back method that signals that an application                component is about to be destroyed by the container. In this method, perform any cleanup that is required before the bean is            destroyed, such as releasing a resource that the bean has been holding.
       
        ```java
	@PreDestroy
	public void destruct() {
	  log.info("destruct method called");
	}
       
        ```
   #### Using CDI (Contexts and Dependency Injection) Annotations
   CDI is a set of services that, used together, make it easy for developers to use enterprise beans along with JavaServer Faces            technology in web applications. *Spring provides an implementation for CDI just like Hibernate does for JPA.* So CDI is a guideline or    an interface. The most fundamental services provided by CDI are as follows:                  
   Contexts: The ability to bind the lifecycle and interactions of stateful components to well-defined but extensible lifecycle contexts  
   Dependency injection: The ability to inject components into an application in a typesafe way, including the ability to choose at        deployment time which implementation of a particular interface to inject. Adding the dependency in your pom.xml:        
  
       <dependency>
	      <groupId>javax.inject</groupId>
	      <artifactId>javax.inject</artifactId>
	      <version>1</version>
       </dependency>
       
   ##### CDI Annotations
   These annotations can be used in conjunction with the Spring annotations. There's an example using a couple of these annotations in      this repository which is just meant to give us an idea about what CDI is and how Spring is based around it.     
   
   __1. *@Named* :__ It's similar to *@Component* & *@Qualifier*.     
   __2. *@Inject* :__ It's the equivalent of *@Autowired*.    
   __3. *@Singelton* :__ It's equivalent to the Singleton scope type in Spring.       
   __4. *@Scope* :__ It's similar to *@Scope* in Spring.       
   
