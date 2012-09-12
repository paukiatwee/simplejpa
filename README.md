Simple JPA
==========
Simple JPA is the lightweight Java JPA2 framework that simplify the usage of JPA2.
This framework is mavenized as well. :)


JPA2 Implementation Used
------------------------
Hibernate 4.1.7.Final

Usage
-----
Sample usage with Spring

```java
    @Inject
    private DefaultRepository repository;
    @Inject
    private PasswordEncoder passwordEncoder;
    
    @Transactional(readOnly = false)
    @Override
    public User add(User user) throws UsernameInUsedException {
        // simple and strong typing to count where username is user.getUsername()
        if(repository.getCount(User_.username, user.getUsername()) != 0) {
            throw new UsernameInUsedException("Username " + user.getUsername() + " is in use, please use other username");            
        }
        user.setPassword(passwordEncoder.encodePassword(user.getUsername(), null));
        return repository.create(user);
    }
```

Author
------
Pau Kiat Wee (paukiatwee@gmail.com)

