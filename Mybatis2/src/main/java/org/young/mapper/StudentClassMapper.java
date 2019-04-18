package org.young.mapper;

import org.young.entity.StudentClass;

import java.util.List;

/**
 * @author Young
 * @version1.0
 */
public interface StudentClassMapper {
	List<StudentClass> queryStusAClaByClaIdLazyLoad();
}
