# Spring Boot 2 - ElasticSearch with Data Rest, JPA and MySQL as DB

## Documentation Coming Soon

### [Download ElasticSearch](https://www.elastic.co/downloads/elasticsearch)

### Import DB [schema.sql](src/main/resources/schema.sql)

## Use

To test it I used [HTTPie](https://httpie.org/). It's similar to CURL.

```
http "localhost:8080/users/query?q=profile.birthDate:>1990-01-01 OR profile.points > 50"

http "localhost:8080/users/queryProjection?q=profile.birthDate:>1990-01-01 OR profile.points > 50"
```

```
http "localhost:8080/users/query?q=-_exists_:profile.birthDate"

http "localhost:8080/users/queryProjection?q=-_exists_:profile.birthDate"
```

```
http "localhost:8080/users/query?q=username:*sa*"

http "localhost:8080/users/queryProjection?q=username:*sa*"
```

```
http "localhost:8080/users/query?q=profile.\*(lisabell sama*)"

http "localhost:8080/users/queryProjection?q=profile.\*(lisabell sama*)"
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.