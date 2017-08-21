package task;

import java.util.Arrays;

public class Group extends Student {

	private Student group[] = new Student[10];

	private String groupName;

	public Group(String groupName) {
		super();
	}

	public Group() {
		super();
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addStudent(Student student, int place) {

		try {
			if (!(place <= group.length - 1 && place >= 0))
				throw new GroupOutOfBoundsException();
			if (group[place] == null) {
				group[place] = student;
			} else
				throw new BusyGroupPlaceException();
		} catch (BusyGroupPlaceException | GroupOutOfBoundsException ex) {
			ex.printStackTrace();

		}

	}

	public void removeStudent(int place) {
		if (place >= 0 && place < group.length) {
			if (group[place] != null) {
				group[place] = null;
			} else {
				System.out.println("There is no figure in this part of board");
			}
		}
	}

	public void searchStudent(String surname) {
		boolean b = false;
		for (int place = 0; place < group.length; place++) {

			if (group[place] != null && surname == group[place].getSurname()) {
				b = true;
				System.out.println("This student is already on " + place + " position");
			}

		}
		if (!b) {
			System.out.println("There isn`t such student");
		}

	}

	public static int compareStudent(Student a, Student b) {

		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b != null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return a.getSurname().compareTo(b.getSurname());
	}

	public void sort() {
		for (int i = 0; i < group.length - 1; i++) {
			for (int j = i + 1; j < group.length; j++) {
				if (compareStudent(group[i], group[j]) > 0) {
					Student temp = group[i];
					group[i] = group[j];
					group[j] = temp;
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		sort();
		for (Student student : group) {
			if (student != null) {
				sb.append((++i) + ") ").append(student);
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

}
