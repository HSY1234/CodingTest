# Compare 인터페이스

출처: https://st-lab.tistory.com/243  
출처: https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html

## Comparable

- 자기 자신과 매개변수 객체를 비교

- Arrays.sort(array)

- Collections.sort(list)

- 대소비교(정석)

```java
class Student implements Comparable<Student> {

	int age;

	Student(int age) {
		this.age = age;
	}

	@Override // 오버라이드
	public int compareTo(Student o) {

		// 양수
		if(this.age > o.age) {
			return 1;
		}
		// 0
		else if(this.age == o.age) {
			return 0;
		}
		// 음수
		else {
			return -1;
		}
	}
}
```

- 한번에 (덧,뺄셈시 오버라이드 발생 가능성 염두! 위가 정석)

```java
class Student implements Comparable<Student> {

	int age;


	Student(int age) {
		this.age = age;

	}

	@Override // 오버라이드
	public int compareTo(Student o) {

		return this.age - o.age;
	}
}
```

- 실제 사용

```java
// x좌표가 증가하는 순, x좌표가 같으면 y좌표가 감소하는 순으로 정렬
class Point implements Comparable<Point> {
    int x, y;

    @Override
    public int compareTo(Point p) {
        if(this.x > p.x) {
            return 1; // x에 대해서는 오름차순
        }
        else if(this.x == p.x) {
            if(this.y < p.y) { // y에 대해서는 내림차순
                return 1;
            }
        }
        return -1;
    }
}

// main에서 사용
List<Point> list = new ArrayList<>();
list.add(new Point(x, y));
Collections.sort(list);

```

## Comparator

- 두 매개변수 객체를 비교
- import 필요( java.util.Comparator)
- Comparator를 주로 쓰는경우

  - 이미 구현된 Class(Api등)를 쓰기 때문에 Class에 Comparable 사용이 불가능
  - 이미 구현된 Class의 Comparable이 내가 원하는 기준과 다른 경우

- Arrays.sort(array, customComparator)

- Collections.sort(list, customComparator)

- 클래스 내부에 선언 타입

```java
import java.util.Comparator;

public static void main(String[] args)  {

		StudentComparator studentComparator = new StudentComparator();
		Student a = new Student(18);
    Student b = new Student(15);

		int isBig = studentComparator.compare(a,b);


	}

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {


		if(o1.age > o2.age) {
			return 1;
		}

		else if(o1.age == o2.age) {
			return 0;
		}

		else {
			return -1;
		}
	}
}
```

- 예시

```java

// x좌표가 증가하는 순, x좌표가 같으면 y좌표가 감소하는 순으로 정렬
class CustomComparator implements Comparator<Point> {
  @Override
  public int compare(Point p1, Point p2) {
    if (p1.x > p2.x) {
      return 1; // x에 대해서는 오름차순
    }
    else if (p1.x == p2.x) {
      if (p1.y < p2.y) { // y에 대해서는 내림차순
        return 1;
      }
    }
    return -1;
  }
}

// main에서 사용
List<Point> list = new ArrayList<>();
list.add(new Point(x, y));
CustomComparator customComparator = new CustomComparator();
Collections.sort(list, customComparator);

```

- 익명 클래스

```java
// main 안에서 선언 따로 뺼필요가 없다.
Comparator<Point> customComparator = new Comparator<Point>() {
  @Override
  public int compare(Point p1, Point p2) {
    if (p1.x > p2.x) {
      return 1; // x에 대해서는 오름차순
    }
    else if (p1.x == p2.x) {
      if (p1.y < p2.y) { // y에 대해서는 내림차순
        return 1;
      }
    }
    return -1; }
};

List<Point> list = new ArrayList<>();
list.add(new Point(x, y));
Collections.sort(list, customComparator);
```

- 익명 클래스 2

```java
import java.util.Comparator;

public class Test {
	public static void main(String[] args)  {

		Student a = new Student(17, 2);	// 17살 2반
		Student b = new Student(18, 1);	// 18살 1반
		Student c = new Student(15, 3);	// 15살 3반

		// 학급 기준 익명객체를 통해 b와 c객체를 비교한다.
		int classBig = comp.compare(b, c);

		if(classBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		}
		else if(classBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}

		// 나이 기준 익명객체를 통해 b와 c객체를 비교한다.
		int ageBig = comp2.compare(b, c);

		if(ageBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		}
		else if(ageBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}

	}

	// 학급 대소 비교 익명 객체
	public static Comparator<Student> comp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.classNumber - o2.classNumber;
		}
	};

	// 나이 대소 비교 익명 객체
	public static Comparator<Student> comp2 = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}
	};
}

class Student {

	int age;			// 나이
	int classNumber;	// 학급

	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}

}

```
