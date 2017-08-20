package jdev.server.core.dao.repo;

import jdev.server.core.dao.Point;
import org.springframework.data.repository.CrudRepository;

public interface PointRepository extends CrudRepository<Point, Integer> {
}
