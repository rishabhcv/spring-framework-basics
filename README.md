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
