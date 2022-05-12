# Topology-API
> A full API (JSON file) that has the data about topologies that consists of electronic components.

[![](http://img.shields.io/badge/buildTool-maven-blue.svg?style=flat)](https://maven.apache.org/)
[![](http://img.shields.io/badge/language-Java-brightgreen.svg?color=orange)](https://www.oracle.com/java/technologies/downloads/)
![](https://img.shields.io/github/last-commit/kareem983/Topology-API)

## About
A topology api is a set of electronic components that are connected together. Each topology consists of electronic components with netlists.
Applying a set of functionality such as (Read, Write, Delete, Queies, ... ) Json File.

## ⚡ Features

- [1] Read a topology from a given JSON file and store it in the memory.
- [2] Write a given topology from the memory to a JSON file.
- [3] Query about which topologies are currently in the memory.
- [4] Delete a given topology from memory.
- [5] Query about which devices are in a given topology.
- [6] Query about which devices are connected to a given netlist node in a given topology.

## 🔸 Json File Example

<details>
  
 <summary>Topology File</summary>
  
  ```
  {
  "id": "top1",
  "components": [
    {
      "type": "resistor",
      "id": "res1",
      "resistance": {
        "default": 100,
        "min": 10,
        "max": 1000
      },
      "netlist": {
        "t1": "vdd",
        "t2": "n1"
      }
    },
    {
      "type": "nmos",
      "id": "m1",
      "m(l)": {
        "default": 1.5,
        "min": 1,
        "max": 2
      },
      "netlist": {
        "drain": "n1",
        "gate": "vin",
        "source": "vss"
      }
    }
  ]
} 
  ```  
</details>

## Techniques
- The app implementation consists of:<br>
  1- Object Oriented Programming concepts.<br>
  2- Design Patterns `Singleton`.<br>
  3- Solid Principles Design Patterns `Single Responsibility`, `Interface Segregation`.<br>
  4- Well documentation code using `JavaDoc`.<br> 
  5- Automated unit testing using `Junit`.

## Prerequisites

1- Install Java programming language with IDE preferred `IntelliJ`.<br/>
2- Install Maven managed build tool.<br/>
3- Install Junit automated testing.<br/>

## Libraries

```
 <!-- jackson JSON Dependency-->
      <dependency>
          <groupId>com.fasterxml.jackson.core</groupId>
          <artifactId>jackson-databind</artifactId>
          <version>2.12.5</version>
      </dependency>

 <!-- Unit Testing Dependency-->
      <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-engine</artifactId>
          <version>5.7.0</version>
          <scope>test</scope>
      </dependency>

```

## Working Screenshots
 
<details>
  <summary>Test Cases</summary>
<p>
  
- **API Tests**<BR>
![1- API Test](https://user-images.githubusercontent.com/52586356/168179176-9b60050d-6836-48fa-a9d6-2c0138ab845d.png)

- **Classes Tests**<BR>
![class test](https://user-images.githubusercontent.com/52586356/168179264-1b90c3be-a064-4ea4-8fc1-02d3d27fe666.png)

  
</p>
</details>


<details>
  <summary>Valid Input</summary>
<p>

- **User box input choices**<BR>
![1- input choice](https://user-images.githubusercontent.com/52586356/168177904-1710c8f5-b766-4f28-ac67-05e2d343f3d7.png)

- **Read Topology from Json file**<BR>
![2- read topology](https://user-images.githubusercontent.com/52586356/168178237-61d76bcd-19e3-4bb4-95a9-ea4db04a55f8.png)
  
- **Write Topology to a Json file**<BR>
![3- write topology](https://user-images.githubusercontent.com/52586356/168178476-6d465d46-f2d1-43f2-80c0-2611885914f8.png)
 
- **Query all Topologies**<BR>
![4- query topologies](https://user-images.githubusercontent.com/52586356/168178601-00ef34c1-41d5-4544-86fb-cca8612bd548.png)

- **Delete Topology from memory**<BR>
![5- Delete a topology](https://user-images.githubusercontent.com/52586356/168178745-b7c7c46b-08c5-41f3-8c0b-e93057dbe396.png)

- **Query all Decvices from a topology**<BR>
![6- query devices](https://user-images.githubusercontent.com/52586356/168178870-48c2a209-473c-4744-b0b7-12dc74b0af2e.png)

- **Query all Decvices with netlist id from a topology**<BR>
![7- query devices with netlist](https://user-images.githubusercontent.com/52586356/168178955-98c2b31e-3c68-47b9-9ebf-6daf9b88cf94.png)

</p>
</details>

 
<details>
  <summary>Invalid Input</summary>
<p>

- **Invalid choice**<BR>
![1- invalid](https://user-images.githubusercontent.com/52586356/168179526-3df04cb2-5a92-4d9d-8f68-0fd94083b875.png)
  
- **Apply operation when memory is Empty**<BR>
![2- invalid](https://user-images.githubusercontent.com/52586356/168179688-d7a422cb-cbed-4609-9a76-4992769c385c.png)
![3- invalid](https://user-images.githubusercontent.com/52586356/168179746-b11a388c-9c22-4317-a3f8-e70a6e34242a.png)

- **Wrong Json file name**<BR>
 ![4- invalid](https://user-images.githubusercontent.com/52586356/168179924-bdcacd17-ad96-41f6-a533-49662fc73564.png)

- **Wrong topology ID**<BR>
![5- invalid](https://user-images.githubusercontent.com/52586356/168180044-daa6bd8b-df99-48a5-bdae-9fc0c843efc2.png)
![6- invalid](https://user-images.githubusercontent.com/52586356/168180194-2200c8e0-7032-4aa6-bbb9-f12cb64e2fac.png)
![7- invalid](https://user-images.githubusercontent.com/52586356/168180303-6c470b76-bf50-4275-84c2-90bfd4aae8ba.png)
![8- invalid](https://user-images.githubusercontent.com/52586356/168180360-b669ab54-a317-42bf-92cd-d4662a25c1a9.png)

</p>
</details>



## References
- [IntelliJ IDE](https://www.jetbrains.com/idea/) <br>
- [Maven Repository](https://mvnrepository.com/) <br>
- [Junit Testing](https://junit.org/junit5/docs/current/user-guide/) <br>
- [JavaDoc](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html) <br>
