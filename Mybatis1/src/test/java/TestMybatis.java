import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.young.entity.Student;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

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
		String statement = "org.young.entity.studentMapper.queryByStuId";
		Student student = sqlSession.selectOne(statement,10011);
		System.out.println(student);
		sqlSession.close();
	}

	//查询全部学生
	public static void queryAllStudents() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.young.entity.studentMapper."+"queryAllStudents";
		List<Student> students = sqlSession.selectList(statement);
		System.out.println(students);
		sqlSession.close();
	}

	//增加学生
	public static void addStudent() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.young.entity.studentMapper."+"addStudent";
		Student student = new Student(100836,"wtw","2345");
		int count = sqlSession.insert(statement,student);//改成对应的操作
		sqlSession.commit();//提交事务
		System.out.println("add "+count+" students");
		sqlSession.close();
	}

	//删除学生
	public static void deleteStudent() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.young.entity.studentMapper."+"deleteStudentByStuId";
		int count = sqlSession.delete(statement,100836);//改成对应的操作
		sqlSession.commit();//提交事务
		System.out.println("delete "+count+" students");
		sqlSession.close();
	}

	//修改学生学生
	public static void updateStudentByStuIdAndStuPw() throws IOException {
		//加载mybatis配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//可以手工指定数据库环境
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.young.entity.studentMapper.updateStudentByStuIdAndStuPw";

		//修改后的学生参数
		Student student = new Student();
		//根据id和pw
		student.setStuId(10011);
		student.setStuName("chenkun");
		student.setStuPw("234");
		int count = sqlSession.update(statement,student);
		sqlSession.commit();
		System.out.println("update success "+count);
		System.out.println(student);
		sqlSession.close();
	}

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();    //获取开始时间
		//addStudent();

		//queryAllStudents();
		//updateStudentByStuIdAndStuPw();
		//deleteStudent();
		queryAllStudents();
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
	}
}
