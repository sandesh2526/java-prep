# Hibernate AND JPA

### What is Hibernate, ORM and JPA?

Hibernate is a Java framework that simplifies the development of Java application to interact with the database. It is an open source, lightweight, ORM (Object Relational Mapping) tool. Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.

ORM - An ORM tool simplifies the data creation, data manipulation and data access. It is a programming technique that maps the object to the data stored in the database.

JPA - Java Persistence API (JPA) is a Java specification that provides certain functionality and standard to ORM tools. The javax.persistence package contains the JPA classes and interfaces.

### Session And Transaction

What is session?
-> Session is a lighweight object which is instantiated each time we need to interact with the database.

### First Level Cache vs Second Level Cache: 

The first-level cache is a transactional cache that exists per Hibernate session and is not shared among threads. This cache makes use of Hibernate’s own caching mechanism. The first-level cache stores all the entities known by a specific session. When you close the session or perform the “clear” method, the first-level cache gets cleared.

The second-level cache is a full shared cache that survives beyond a Hibernate session and can be shared among threads. This cache can be configured on a per-class and per-collection basis and is mainly responsible for caching objects across sessions. You can use a caching implementation that comes with Hibernate like EHCache or something else like JBossCache for this cache.

In summary, the first-level cache is the cache per Hibernate session and is a mandatory cache through which all requests must pass and this cache is not shared among threads. The second-level cache can be configured on a per-class and per-collection basis and is mainly responsible for caching objects across sessions.

## What are entities?

An entity is a object or thing i real world which can be distinguished from all other objects.  

Entities in JPA are nothing but POJOs representing data that can be persisted in the database. Here when we persist we mean maps the data from the database to the java pojo's. For e.g. we can have a student table containing students which can be mapped to a Student class's object in java.

How can we define a class as entity in java?

We can declare a java class as entity by annotating it with the @Entity . The annotation also accepts a parameter name which can be used to define the name of the table in the database. For e.g. 

```java
@Entity(name="student")
public class Student {
    
    // fields, getters and setters
    
}
```

We can also use the @Table to define the table name that is stored in the database. 

```java
@Entity(name="student")
@Table(name="stud")
public class Student {
    // fields, getters and setters
}
```
while writing queries you have to use the name given in `@Entity` and the name given in `@Table` will be used to name the table in the DB.

So in HQL your `student` will refer to `stud` in the DB.

If we don’t use the `@Table` annotation, the name of the table will be the name of the entity.

### How can we define a primary key in the among our entity variable(Normal class's variable)?

We can use the `@Id` annotation to mark a field as  primary key. 

If we want to automatically generate the primary key value, we can add the `@GeneratedValue` annotation

### Why do we need the different strategy for a primary key?

primary key: 

Surrogate vs natural  : 
Surrogate keys are created just to make each record in the table have a unique value which can identify it uniquely.
Natural keys are the fields which are the fields that are useful in the table and can also act as the a key to uniquely identify the record as well. 

So to generate a surrogate key we can use a `@GenetatedValue(SomeStrategy)`

`@GeneratedValue` is used to define the strategy for the keys to generate automatically 
`@GeneratedValue(strategy = GenerationType.strategy)`

strategies are of following types : 

`AUTO` - This Generates the automatic id for the entity. Type can be numerical or UUID. String and other types are prohibited

`IDENTITY` - Set the id to the 1 for the first entry and so on. String is not allowed only numerical values.

`SEQUENCE` - You can define a sequence generator and add initial values, increment_size and other custumizations. 

`TABLE` - uses values stored inside the table to generate a sequence, we can customize it using table generator.

```java
    @Id
    @GenerateType( strategy = "AUTO" )
    long id;

    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String name;
```

The name element specifies the `name` of the column in the table. The `length` element specifies its length. The `nullable` element specifies whether the column is nullable or not, and the unique element specifies whether the column is unique



`@Transient`

If you want some field of the class to be not persisted in the database(will not be created by the database or maintained by the database) then we can define that field as transient. 

```java
public class Student {
    @Id
    long id;
    @Column(name = "student_name", nullable = false, length = 50, unique = false)
    String name;
    @Column(name = "department_name", nullable = false, length = 40, unique = false)
    String deptName;
    @Column(name = "total_credits", nullable = false)
    int totCred;
    @Transient
    @Column(name = "student_age")
    int age;
}
```

`@Temporal`

Temporal data types means time related data types such as date,calender etc. @Temporal annotation is used for mapping temporal data types in Java, such as java.util.Date and java.util.Calendar, to SQL types, such as DATE, TIME and TIMESTAMP. 

why we cannot map the temporal data types in java to the SQL data types?

-> In Java JPA is because the Java API does not define the temporal precision of time. This means that the Java classes that represent date and time, such as java.util.Date and java.util.Calendar, do not specify how precise the time value is. For example, a java.util.Date object can represent a date, a time, or both, but it does not indicate which one it is.

On the other hand, the SQL standard defines different types of temporal data, such as DATE, TIME, and TIMESTAMP, with different levels of precision. For example, a DATE value only contains the year, month, and day, while a TIMESTAMP value also contains the hour, minute, second, and fraction of second. Therefore, to map a Java date or time object to a SQL temporal type, we need to specify the expected precision in the database.

The @Temporal annotation in JPA is used to fine-tune the mapping between Java date and time types and SQL temporal types. It can have one of the following three values: TemporalType.DATE, TemporalType.TIME, and TemporalType.TIMESTAMP

`@Enumerated(EnumType.Type)`

-> The @Enumerated annotation is used to map enum values to database columns in Java JPA. It has two possible values: EnumType.ORDINAL and EnumType.STRING. Depending on the value, the annotation will store the enum value as either its ordinal number or its name. For example, if you have an enum like this:

```java 
public enum Status { OPEN, REVIEW, APPROVED, REJECTED; }
```

And you annotate it with @Enumerated(EnumType.ORDINAL), then the database column will store the values 0, 1, 2, and 3 for each enum value. However, if you annotate it with @Enumerated(EnumType.STRING), then the database column will store the values “OPEN”, “REVIEW”, “APPROVED”, and “REJECTED” for each enum value


### States of the entities in Hibernate

`transient` — This instance isn’t, and never was, attached to a Session. This instance has no corresponding rows in the database; it’s usually just a new object that we created to save to the database.

`persistent` — This instance is associated with a unique Session object. Upon flushing the Session to the database, this entity is guaranteed to have a corresponding consistent record in the database.

`detached` — This instance was once attached to a Session (in a persistent state), but now it’s not. An instance enters this state if we evict it from the context, clear or close the Session, or put the instance through serialization/deserialization process.

[ States of in the hibernate ](https://www.baeldung.com/wp-content/uploads/2016/07/2016-07-11_13-38-11-1024x551.png) 


### Value object

An enntity has meaning on its own. For a value object it has meaning only because of its parent. For example a person object can contain the address object which refers to the person's address but do not give us any value if a particular person does not exist. So in this case we can say that the address is embedded inside the person object.

We can do this using the @Embeddable along with @Embedded 
So in above example we can declare a class as Address and mark it as Embeddable. And then import that class in our person class by annotating it with @Embedded

```java
@Entity
class Person {
    @Id
    String emailId;
    @Embedded    
    Address address;
}

@Embeddable
class Address {
    String City;
    String Country;
}
```

This creates a table Person table inside which it creates the Address fields such as city and country so the person table in the database has columns,  `emailId, city, country` 

### Can we embed two fields with same class without any additional configuration? if not then how can we embed a person class with two different fields like homeAddress and officeAddress which are derived from the embeddable Address class?

No, we can not embed two fields in an entity with same class without additional configuration. Because if we have to embedded entities with same class then we can not differentiate between the columns as they will have same name. We can configure the fields using the @AttributeOverrides annotation. 

```java
@Entity
class Person {
    @Id
    String emailId;
    @Embedded
    @AttributeOverrides ({
        @AttributeOverride (name="city", column=@Column(name="HOME_City")),
        @AttributeOverride (name="country", column=@Column(name="HOME_Country")),
    })
    Address homeAddress;
    @Embedded 
    Address officeAddress;
}

@Embeddable
class Address {
    String city;
    String country;
}
```

Here we define a `@AttributeOverrides` annotation which contains a 'object' of the different attributes that are overriden using the `@AttributeOverride(name="fieldToOverride", column=@Column(name="newNameForTheField"))`

### How can we have a combined columns as primary key of the table(candidate key), how will we use these fields as primary key?

We can create a class which defines these attributes and then we can use that class as the primary key using the annotation @EmbeddedId
this declares that the columns defined by the columns in embedded table as primary key, so all embedded columns are declared to form together as primary key(`primary key (col1, col2...)`). 

For e.g. the person class can be uniquely identified using his name and a id together then to identify this person seperately we need to put both parameters as primary key hence we have to declare `primary key (name, id)`

```java
@Entity
class Person {
    @EmbeddedId
    EmbeddedKey embeddedKey;
    @Embedded
    @AttributeOverrides ({
        @AttributeOverride (name="city", column=@Column(name="HOME_City")),
        @AttributeOverride (name="country", column=@Column(name="HOME_Country")),    
    })
    Address homeAddress;
    @Embedded 
    Address officeAddress;
}

@Embeddable
class EmbeddedKey implements Serializable {
    String name;
    String id;

	@Override
	public int hashCode() {
		// return hash here
	}
}
```

As we can see the embedded key class must implement the serializable interface as it is being used as a secondary cache. 

It is also a good practice that each entity class should override the `hashCode` and `equals` method. 

### How can you persist a collection in hibernate entity?

We can persist a collection in hibernate using the  `@ElementCollection` 

It will create a new table in the database consisting of the all the values in the collection. These values then can be referred by the main entity using the forign keys which will be set to the primary key of the table. So if a person entity has a primary key as a id and we want to store different addresses for that person using a collection then we can do so by adding the collection. This collection will be marked as `@ElementCollection` which will be created as a new table with foreign key as id in the person table. Now if we want to list all the addresses for a particular student we can do so by calling select query on the newly created table with the student's id. 

```java
@Entity
public class Person {
    @Id
    Long id;
    @ElementCollection // creates a table with name Person_addresses
    List<Address> addresses;
}
@Embeddable
class Address {
    String City;
    String Country;
}
```

The name of the newly created table for the collection will be `EntityName_variableNameForCollectionInEntity`(in this case, `Person_addresses`) along with the name of the foreign key will be `Entity_variableNameOfPrimaryKeyOfEntity` (In this case, `Person_id`)

So if we want to change these names specified by the Hibernate we can use the `@JoinTable` annotation along with the argument `joinColumns=@JoinColumn(name="user_id")` to change the name of the table and the column. 

We can use the `@JoinTable` as follows: 

```java
@Entity
public class Person {
    @Id
    Long id;
    @ElementCollection // creates a table with name Person_addresses
    @JoinTable (name="Addresses", joinColumns = @JoinColumn(name="user_id")
    ) // you can have multiple columns by containning them in {}(specify as a object)
    
    List<Address> addresses;
}
@Embeddable
class Address {
    String City;
    String Country;
}
```

If you have more than one key as primary key you have to define each key along with a name for it. So if you have more than one key inside the embedded id then we have to define the @JoinColumn annotation inside each one using the `{@JoinColumn(key_1),@JoinColumn(key_2)..}`

Now here we are creating a new table for the collection created so we can add the a primary key to this collection. For this purpose we can use the annotation `@CollectionId` which is a <b>hibernate annotation</b> So it is only present in the Hibernate. So if we want to move to another JPA provider we must change this annotation as per the annotation in other implementation.

The annotaion `@CollectionId` comes with three fields: 
`columns` = it will specify the columns to be added as the primary key here we can use one or more columns as primary key

`generator` = specifies the gernerator which the hibernate will use to create the values of the primary key

`type` = Specifies the type of the key, can be int, long etc.

### Lazy and Eager loading in the Hibernate

#### Lazy Loading: 

This is the default behaviour of the hibernate while loading a entity. For this consider a person class with a different addresses that we used previously :

```java
@Entity
class Person {
    @Id
    int id;
    @ElementCollection
    List<Address> addresses;
}

class AtSomeTimeInCode {
    List<UserLazy> users = sessionLazy.createQuery("SELECT * FROM Person").list();// loads the addresses here while eager

    Person userLazyLoaded = users.get(3);
    return (userLazyLoaded.getAddresses()); // loads the addresses here while lazy
}
```

So when we load the entity at first we only load the `id` and do not load the addresses(here a new table for the addresses is created) list. 

It improves the loading time as not all info is needs to be loaded at the initialization. 

For this purpose hibernate uses the proxy objects.

#### Eager Loading

As opposed to the lazy loading we can load the entire object at the time of loading. As mentioned in above example we will load the addresses at the time of there definition only. 

We can set this behaviour using the `@ElementCollection(fetch = FetchType.EAGER)` in case of loading a collection

### Types of mappings

#### OneToOne

When we say the mapping is one to one we are showing a relationship between two entities which relate on each other in a way that they have exactly one instance referring the other entities one instance. For e.g. A person can only have one passport. 

We can define in hibernate as follows:

```java
@Entity
class Person {
    private int id;
    private String name;
    @OneToOne
    private Passport passport;
}

@Entity
class Passport {
    int passport_id;
    Address address;
    String name;
    /*...*/ 
}
```

