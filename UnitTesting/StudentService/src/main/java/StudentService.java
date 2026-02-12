public class StudentService {
	public int calculateTotal(Student student) {
		return student.getMark1()+student.getMark2()+student.getMark3();
	}
	public double calculateAverage(Student student) {
		double total=calculateTotal(student);
		return total/3.0;
	}
	public boolean isPassed(Student student){
		return calculateAverage(student)>=40;
	}
}
