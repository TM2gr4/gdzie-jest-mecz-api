package server.queries;

import org.springframework.data.repository.CrudRepository;

public interface ActionOnDatabase<T, K extends CrudRepository> {
    T handle(Object... args);
}
