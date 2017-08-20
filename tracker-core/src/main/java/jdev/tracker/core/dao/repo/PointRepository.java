package jdev.tracker.core.dao.repo;

import jdev.tracker.core.dao.Point;
import org.springframework.data.repository.CrudRepository;

public interface PointRepository extends CrudRepository<Point, Integer> {
}
