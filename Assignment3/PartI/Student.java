
public class Student {
	private String name;
	private int age;
	private String major;
	private static int nextId =1;
	private int id;
	public Student(){
        this.id = Student.nextId;
        Student.nextId++;
    }

	public Student(String name,int age,String major){
		this();
		this.name=name;
		this.age= age;
		this.major= major;
	}
	public static boolean hasSameMajor(Student s1, Student s2) {
		if(s1.major.equals(s2.major))return true;
		else return false;
	}
	public static double avgAg(Student[]ex) {
		int n = ex.length;
		double sum =0;
		for(int i=0;i<n;i++) {
			sum = sum+ ex[i].age;
		}
		double avg = sum/n;
		return avg;
		
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age= age;
	}
	public String getMajor() {
		return this.major;
	}
	public void SetMajor(String major) {
		this.major=major;
	}
	public int getID() {
		return this.id;
	}
	public String toString() {
		return name+":"+age+","+major;
	}
	
	public static void main(String[] args) {
		
		Student[] students = new Student[5];
		students[0] = new Student("John", 20, "English");
		students[1] = new Student("Alex", 24, "Computer Science");
		students[2] = new Student("Amy", 19, "Geography");
		students[3] = new Student("Queens", 22, "English");
		students[4] = new Student("Rivers", 25, "Math");
		double n = avgAg(students);
		boolean a = hasSameMajor(students[0],students[2]);
		boolean b = hasSameMajor(students[0],students[3]);
		System.out.println("this five student get the average age:"+n);
		System.out.println("John and Amy has the same major? "+ a);
		System.out.println("John and Queens has the same major? "+ b);
		System.out.println(students[0].getAge()+students[0].getMajor()+students[0].getID()
				+students[0].getName());
		System.out.println(students[1].getAge()+students[1].getMajor()+students[1].getID()
				+students[1].getName());
		
		System.out.println(students[0].toString());
		
	}
}
