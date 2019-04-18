import org.young.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.young.mapper.StudentMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Young
 * @version1.0
 */
public class TestMybatis {
	//查询单个学生
	public static void queryStudentByStuId() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.queryStudentByStuId(10010);
		System.out.println(student);
		sqlSession.close();
	}

	//查询单个学生
	public static void queryStuByIdWithOne1() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//		StudentBusiness studentBusiness = studentMapper.queryStuByIdWithOne(10011);
		Student student = studentMapper.queryStuByIdWithOne1(10010);
		System.out.println(student);
	}

	//查询全部学生
	public static void queryAllStudents() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.queryAllStudents();
		System.out.println(students);
		sqlSession.close();
	}

	//增加学生
	public static void addStudent() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student student = new Student(1108365,"wttw","23645");
		student.setStuSex(true);
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
		studentMapper.addStudent(student);
		sqlSession.commit();//提交事务
		System.out.println("add students");
		sqlSession.close();
	}

	//删除学生
	public static void deleteStudent() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
		studentMapper.deleteStudentByStuId(1008365);//改成对应的操作
		sqlSession.commit();//提交事务
		System.out.println("delete students");
		sqlSession.close();
	}

	//修改学生学生
	public static void updateStudentByStuIdAndStuPw() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);

		//修改后的学生参数
		Student student = new Student();
		//根据id和pw
		student.setStuId(10011);
		student.setStuName("qchenkun");
		student.setStuPw("234");
		studentMapper.updateStudentByStuIdAndStuPw(student);
		sqlSession.commit();
		System.out.println("update success ");
		System.out.println(student);
		sqlSession.close();
	}

	//查询学生-转换器
	public static void queryStudentByStuIdWithConverter() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.queryStudentByStuId(10010);
		System.out.println(student);
		sqlSession.close();
	}
	//查询学生-IdAndPw
	public static void queryStudentByIdAndPw() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setStuId(10010);
		student.setStuPw("123456");
		student = studentMapper.queryStudentByIdAndPw(student);
		System.out.println(student);
		sqlSession.close();
	}

	//地址查询全部学生
	public static void queryStudentByAddress() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
		Address address = new Address("1","南宁");
		List<Student> students = studentMapper.queryStudentByAddress(address);
		System.out.println(students);
		sqlSession.close();
	}
	//学生地址查询全部学生
	public static void queryStudentByStuAddress() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
		Student student = new Student();
		Address address = new Address("重庆","22");
		student.setAddress(address);
		List<Student> students = studentMapper.queryStudentByStuAddress(student);
		System.out.println(students);
		sqlSession.close();
	}

	//查询学生hashMap-IdAndPw
	public static void queryStudentByIdAndPwWithMap() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Map<String,Object> stuMap = new HashMap<>();
		stuMap.put("stuId",10010);
		stuMap.put("stuPw",123456);
		Student student = studentMapper.queryStudentByIdAndPwWithMap(stuMap);
		System.out.println(student);
		sqlSession.close();
	}

	//根据年级查询学生hashMap 存储过程
	public static void queryCountByGnameWithProcedure() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Map<String,Object> params = new HashMap<>();
		params.put("gName",16);

		studentMapper.queryCountByGnameWithProcedure(params);
		//获取输出参数
		Object count = params.get("scount");
				System.out.println(count);
		sqlSession.close();
	}

	//hashMap作为别名
	public static void queryAllStudentByMapKey() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


		List<HashMap<String, Object>> stuMap = studentMapper.queryAllStudentByMapKey();

		System.out.println(stuMap);
		sqlSession.close();
	}

	//sql标签查询
	public static void queryStudentSqlTap() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
		Student student = new Student();
//		Address address = new Address("重庆","22");
//		student.setAddress(address);
		student.setStuId(10086);
		List<Student> students = studentMapper.queryStudentSqlTap(student);
		System.out.println(students);
		sqlSession.close();
	}

	//集合-年级查学生
	public static void queryStuWithNosInGrade() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
//		Student student = new Student();
//		Address address = new Address("重庆","22");
//		student.setAddress(address);
//		student.setStuId(10086);
		Grade grade = new Grade();
		List<Integer> stuIds = new ArrayList<>();
		stuIds.add(10010);
		stuIds.add(10086);
//		stuIds.add(3);

		grade.setStuIds(stuIds);
		System.out.println(stuIds);
		List<Student> students = studentMapper.queryStuWithNosInGrade(grade);
		System.out.println(students);
		sqlSession.close();
	}

	//数组-年级查学生
	public static void queryStuWithArray() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
//		Student student = new Student();
//		Address address = new Address("重庆","22");
//		student.setAddress(address);
//		student.setStuId(10086);
		Grade grade = new Grade();
		int[] nums = {10010,10086};
//		List<Integer> stuIds = new ArrayList<>();
//		stuIds.add(10010);
//		stuIds.add(10086);
//		stuIds.add(3);

//		grade.setStuIds(stuIds);
//		System.out.println(stuIds);
		List<Student> students = studentMapper.queryStuWithArray(nums);
		System.out.println(students);
		sqlSession.close();
	}

	//list-年级查学生
	public static void queryStuWithList() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
//		Student student = new Student();
//		Address address = new Address("重庆","22");
//		student.setAddress(address);
//		student.setStuId(10086);
		Grade grade = new Grade();
		int[] nums = {10010,10086};
		List<Integer> stuIds = new ArrayList<>();
		stuIds.add(10010);
//		stuIds.add(10086);
//		stuIds.add(3);

//		grade.setStuIds(stuIds);
//		System.out.println(stuIds);
		List<Student> students = studentMapper.queryStuWithList(stuIds);
		System.out.println(students);
		sqlSession.close();
	}

	//Object[]-年级查学生
	public static void queryStuWithObjectAray() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
//		Student student = new Student();
//		Address address = new Address("重庆","22");
//		student.setAddress(address);
//		student.setStuId(10086);
		Grade grade = new Grade();
		int[] nums = {10010,10086};
		List<Integer> stuIds = new ArrayList<>();
		stuIds.add(10010);
//		stuIds.add(10086);
//		stuIds.add(3);

//		grade.setStuIds(stuIds);
//		System.out.println(stuIds);

		Student stu1 = new Student();
		Student stu2 = new Student();
		stu1.setStuId(10010);
		stu2.setStuId(10086);
		Student[] stus = new Student[]{stu1,stu2};

		List<Student> students = studentMapper.queryStuWithObjectAray(stus);
		System.out.println(students);
		sqlSession.close();
	}

	//根据班级查学生和班级
	public static void queryStusAClaByClaId() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);


		StudentClass studentClass = studentMapper.queryStusAClaByClaId(151);
		System.out.println(studentClass.getClassId()+"-"+studentClass.getClassName());
		//班级对应学生
		List<Student> students = studentClass.getStudents();
		for (Student student:students) {
			System.out.println(student);
		}
		sqlSession.close();
	}



	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();    //获取开始时间
		//addStudent();
		//queryStudentByStuId();
		//queryAllStudents();
		//updateStudentByStuIdAndStuPw();
		//deleteStudent();
		//queryStudentByStuIdWithConverter();
		//queryStudentByIdAndPw();
		//queryAllStudents();
		//queryCountByGnameWithProcedure();
//		queryAllStudentByMapKey();
		//queryStudentSqlTap();
		//queryStudentByStuAddress();
//		queryStuWithNosInGrade();
//		queryStuWithArray();
//		queryStuWithList();
//		queryStuWithObjectAray();
//		queryStuByIdWithOne1();
		queryStusAClaByClaId();
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
	}
}
