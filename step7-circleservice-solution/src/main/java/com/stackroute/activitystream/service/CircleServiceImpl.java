package com.stackroute.activitystream.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.repository.CircleRepository;

/*
* Service classes are used here to implement additional business logic/validation. 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn’t currently 
* provide any additional behavior over the @Component annotation, but it’s a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
@Service("CircleService")
public class CircleServiceImpl implements CircleService {

	/*
	 * Autowiring should be implemented for the CircleRepository and UserRepository.
	 * Please note that we should not create any object using the new keyword
	 */

	/*
	 * A circle should only be created if the circle does not already exist or the
	 * creatorId is a valid username.
	 */
	@Autowired
	private CircleRepository circleRepository;

	public boolean save(Circle circle) {
		if (circleRepository.findOne(circle.getCircleName()) != null) {
			return false;
		} else {
			return (circleRepository.save(circle) != null);
		}
	}

	public List<Circle> getAllCircles() {
		return circleRepository.findAll();
	}

	public List<Circle> getAllCircles(String searchString) {
		return circleRepository.findAll(searchString);
	}

	public Circle get(String circleName) {
		return circleRepository.findOne(circleName);
	}

	public boolean delete(Circle circle) {
		if (circleRepository.findOne(circle.getCircleName()) != null) {
			return false;
		} else {
			circleRepository.delete(circle);
			return true;
		}
	}
}